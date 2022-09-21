package com.neudesic.myapplication.di

import com.neudesic.myapplication.domain.network.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.Timeout
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import javax.inject.Qualifier

/**
 * Example of setting up multiple injection bindings for the same type
 * ref: https://developer.android.com/training/dependency-injection/hilt-android#inject-provides
 */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrlOther

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrlDadJoke

@InstallIn(SingletonComponent::class)
@Module
object NetworkingModule {

    @BaseUrlDadJoke
    @Provides
    fun provideBaseUrlDadJoke(): String {
        return "https://icanhazdadjoke.com"
    }

    /**
     * NOTE: this isn't used, it's just here for an example of
     * multiple injection bindings
     */
    @BaseUrlOther
    @Provides
    fun provideBaseUrlOther(): String {
        return "https://someotherurl.com"
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .build()
    }

    @Provides
    fun provideRetrofitClient(@BaseUrlDadJoke baseUrl: String,
                              okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(NetworkResultCallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideRestApiService(retrofit: Retrofit): DadJokeAPIService {
        return retrofit.create(DadJokeAPIService::class.java)
    }
}

/**
 * Helper to convert Retrofit Response object to one of our valid [NetworkResult] Class
 * Will return one of the following: [NetworkSuccess], [NetworkError], [NetworkException]
 */
fun <T : Any> handleApiResponse(
    response: Response<T>
): NetworkResult<T> {
    return try {
        val body = response.body()
        if (response.isSuccessful && body != null) {
            NetworkSuccess(body)
        } else {
            NetworkError(code = response.code(), message = response.message())
        }
    } catch (e: HttpException) {
        NetworkError(code = e.code(), message = e.message())
    } catch (e: Throwable) {
        NetworkException(e)
    }
}

class NetworkResultCall<T : Any>(
    private val proxy: Call<T>
) : Call<NetworkResult<T>> {

    override fun enqueue(callback: Callback<NetworkResult<T>>) {
        proxy.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val networkResult = handleApiResponse(response)
                callback.onResponse(this@NetworkResultCall, Response.success(networkResult))
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                val networkResult = NetworkException<T>(t)
                callback.onResponse(this@NetworkResultCall, Response.success(networkResult))
            }
        })
    }

    override fun execute(): Response<NetworkResult<T>> = throw NotImplementedError()
    override fun clone(): Call<NetworkResult<T>> = NetworkResultCall(proxy.clone())
    override fun request(): Request = proxy.request()
    override fun timeout(): Timeout = proxy.timeout()
    override fun isExecuted(): Boolean = proxy.isExecuted
    override fun isCanceled(): Boolean = proxy.isCanceled
    override fun cancel() { proxy.cancel() }
}

class NetworkResultCallAdapter(
    private val resultType: Type
) : CallAdapter<Type, Call<NetworkResult<Type>>> {

    override fun responseType(): Type = resultType

    override fun adapt(call: Call<Type>): Call<NetworkResult<Type>> {
        return NetworkResultCall(call)
    }
}

class NetworkResultCallAdapterFactory private constructor() : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java) {
            return null
        }

        val callType = getParameterUpperBound(0, returnType as ParameterizedType)
        if (getRawType(callType) != NetworkResult::class.java) {
            return null
        }

        val resultType = getParameterUpperBound(0, callType as ParameterizedType)
        return NetworkResultCallAdapter(resultType)
    }

    companion object {
        fun create(): NetworkResultCallAdapterFactory = NetworkResultCallAdapterFactory()
    }
}