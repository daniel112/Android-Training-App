package com.neudesic.module.core.network
import com.neudesic.module.core.network.internal.NetworkResultCallAdapterFactory
import retrofit2.CallAdapter

class CoreNetworkModuleImpl():CoreNetworkModule {
    override fun networkResultCallAdapterFactory(): CallAdapter.Factory = NetworkResultCallAdapterFactory.create()
}