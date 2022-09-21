package com.neudesic.module.core.network

/**
 * Network results
 */
sealed interface NetworkResult<T : Any>
/**
 * Represents a network result that successfully received a response containing body data.
 */
class NetworkSuccess<T : Any>(val data: T) : NetworkResult<T>

/**
 * Represents a network result that successfully received a response containing an error message.
 */
class NetworkError<T : Any>(val code: Int, val message: String?) : NetworkResult<T>

/**
 * Represents a network result that faced an unexpected exception before getting a response from the network
 */
class NetworkException<T : Any>(val e: Throwable) : NetworkResult<T>