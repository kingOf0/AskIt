package com.kingOf0.hellospring.core.utilities.results

class SuccessDataResult<T>(data: T, message: String? = null) : DataResult<T>(true, message, data)