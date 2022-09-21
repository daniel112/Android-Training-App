package com.neudesic.myapplication.domain.model

/**
 * Used as the result object for Repository data fetching
 */
class DataResult<T:Any>(var data: T? = null, var message: String? = null, var success: Boolean = true)