package com.kingOf0.hellospring.core.utilities.results

open class DataResult<T>(
    success: Boolean,
    message: String? = null,
    val data: T,
) : Result(success, message)