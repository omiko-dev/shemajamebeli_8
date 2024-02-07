package com.example.shemajamebeli_8.data.common

sealed class Resource<out T> {
    data class Success<out T>(val success: T) : Resource<T>()
    class Error(val error: String) : Resource<Nothing>()
    data class Loader(val loader: Boolean) : Resource<Nothing>()
}