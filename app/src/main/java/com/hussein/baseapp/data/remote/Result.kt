package com.hussein.baseapp.data.remote
import kotlinx.serialization.Serializable
import com.hussein.baseapp.data.remote.data.Error
/*@Serializable
sealed class Result<out T>  {

    @Serializable
    data class Success<out T>(val data: T) : Result<T>()

    @Serializable
    data class SuccessData<out T>(val data: List<T>) : Result<T>()

    @Serializable
    data class Error(val msg: String, val code: Int? = null) : Result<Nothing>()

    @Serializable
    object Loading : Result<Nothing>()
}*/
@Serializable
sealed interface Result<out D, out E: Error> {
    data class Success<out D>(val data: D): Result<D, Nothing>
    data class Error<out E:  com.hussein.baseapp.data.remote.data.Error>(val error: E):
        Result<Nothing, E>
    data object Loading : Result<Nothing,Nothing>
}

inline fun <T, E: Error, R> Result<T, E>.map(map: (T) -> R): Result<R, E> {
    return when(this) {
        is Result.Error -> Result.Error(error)
        is Result.Success -> Result.Success(map(data))
        is Result.Loading -> Result.Loading
    }
}

fun <T, E: Error> Result<T, E>.asEmptyDataResult(): EmptyResult<E> {
    return map {  }
}

inline fun <T, E: Error> Result<T, E>.onSuccess(action: (T) -> Unit): Result<T, E> {
    return when(this) {
        is Result.Error -> this
        is Result.Success -> {
            action(data)
            this
        }

        is Result.Loading -> this
    }
}
inline fun <T, E: Error> Result<T, E>.onError(action: (E) -> Unit): Result<T, E> {
    return when(this) {
        is Result.Error -> {
            action(error)
            this
        }
        is Result.Success -> this
        is Result.Loading -> this
    }
}
inline fun <T, E: Error> Result<T, E>.onLoading(action: () -> Unit): Result<T, E> {
    return when(this) {
        is Result.Error ->this
        is Result.Success -> this
        is Result.Loading -> {
            action()
            this
        }
    }
}

typealias EmptyResult<E> = Result<Unit, E>