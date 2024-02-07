package com.example.shemajamebeli_8.presentation.screen.place

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shemajamebeli_8.data.common.Resource
import com.example.shemajamebeli_8.domain.usecase.GetAllPlaceUseCase
import com.example.shemajamebeli_8.presentation.mapper.toPresenter
import com.example.shemajamebeli_8.presentation.screen.place.event.PlaceEvent
import com.example.shemajamebeli_8.presentation.state.PlaceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaceViewModel @Inject constructor(
    private val getAllPlaceUseCase: GetAllPlaceUseCase
): ViewModel() {
    private var _placeListStateFlow = MutableStateFlow(PlaceState())
    val placeListStateFlow get() = _placeListStateFlow.asStateFlow()

    fun onEvent(event: PlaceEvent) {
        when (event) {
            is PlaceEvent.GetPlaceList -> getPlaceList()
        }
    }

    private fun getPlaceList(){
        viewModelScope.launch {
            getAllPlaceUseCase().collect {resource ->
                when(resource){
                    is Resource.Success -> {
                        _placeListStateFlow.update {
                            PlaceState().copy(
                                success = resource.success.map { it.toPresenter() }
                            )
                        }
                    }
                    is Resource.Error -> {
                        _placeListStateFlow.update {
                            PlaceState().copy(
                                error = resource.error
                            )
                        }
                    }
                    is Resource.Loader -> {
                        _placeListStateFlow.update {
                            PlaceState().copy(
                                loader = resource.loader
                            )
                        }
                    }
                }
            }
        }
    }
}