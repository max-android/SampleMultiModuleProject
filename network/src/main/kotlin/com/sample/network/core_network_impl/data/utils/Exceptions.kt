package com.sample.network.core_network_impl.data.utils

import java.io.IOException

class NoInternetException(cause: Throwable) : IOException(cause)

class AccessDeniedException : Exception()

class NotAuthorizedException : Exception()

class ServiceUnavailable : Exception()

open class ServerProblemException(causeString: String) : Exception(causeString)

class PagesOverflowException : Exception()

class FieldException(val field: String, val fieldMessage: String) : Exception()

class ServerValidationFieldException(val fieldMessage: String) : Exception()

class ValidationException(message: String) : Exception(message)

class RequestTooLargeException : Exception()

class ObjectNotFoundException(causeString: String) : ServerProblemException(causeString)

/**
 * Неправильный ответ сервера (например, не хватает чего-либо в ответе)
 */
class InvalidResponseException(message: String = "") : Exception(message)

/**
 * Неправильный запрос на сервер
 */
class UserRequestException(message: String = "") : Exception(message)

class UserBlockedException(message: String = "") : Exception(message)

class InvalidImageException(causeString: String, val fileName: String) : Exception(causeString)

class NullException(message: String = "not found id") : Exception(message)