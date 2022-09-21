package com.neudesic.module.core.network

import retrofit2.CallAdapter

interface CoreNetworkModule {
    fun networkResultCallAdapterFactory(): CallAdapter.Factory
}