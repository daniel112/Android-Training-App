package com.neudesic.myapplication.domain.network

/**
 * Used as the result object for Repository data fetching
 */
class DataResult<T:Any>(var data: T? = null, var message: String? = null, var success: Boolean = true)

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

/**
 * TODO: Local DB Results
 */