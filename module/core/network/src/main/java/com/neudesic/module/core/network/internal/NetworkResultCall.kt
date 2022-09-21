package com.neudesic.module.core.network.internal

import com.neudesic.module.core.network.NetworkError
import com.neudesic.module.core.network.NetworkException
import com.neudesic.module.core.network.NetworkResult
import com.neudesic.module.core.network.NetworkSuccess
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

internal class NetworkResultCall<T : Any>(
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

/**
 * Private Helper to convert Retrofit Response object to one of our valid [NetworkResult] Class
 * Will return one of the following: [NetworkSuccess], [NetworkError], [NetworkException]
 */
private fun <T : Any> handleApiResponse(
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