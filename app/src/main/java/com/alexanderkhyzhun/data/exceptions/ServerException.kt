package com.alexanderkhyzhun.data.exceptions

open class ServerException(
    val httpCode: Int,
    val errorMessage: String?
) : Throwable(errorMessage)