package com.example.shemajamebeli_8.data.common

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class HandleResource {
    fun <T: Any> handleResource(call: suspend () -> Response<T>): Flow<Resource<T>> =
        flow {
            try {
                emit(Resource.Loader(loader = true))
                val data = call()
                Log.i("omiko", data.body().toString())
                if(data.isSuccessful){
                    emit(Resource.Success(success = data.body()!!))
                }else{
                    emit(Resource.Error(error = data.errorBody()?.string() ?: ""))
                }
            }catch (e: Throwable){
                emit(Resource.Error(error = e.message ?: ""))
            }finally {
                emit(Resource.Loader(loader = false))
            }
        }
}