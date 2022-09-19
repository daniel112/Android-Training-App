package com.neudesic.myapplication.ui.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neudesic.myapplication.domain.model.DadJoke
import com.neudesic.myapplication.domain.useCase.GetDadJokesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getDadJokesUseCase: GetDadJokesUseCase): ViewModel() {
    private val _dadJoke = MutableLiveData<DadJoke>(null)
    val dadJoke: LiveData<DadJoke> = _dadJoke
    private val _dataLoading = MutableLiveData<Boolean>(false)
    val dataLoading: LiveData<Boolean> = _dataLoading

    fun getJoke() {
        // Show loading indicator
        _dataLoading.value = true

//        wrapEspressoIdlingResource {
            viewModelScope.launch {
                getDadJokesUseCase.getSingleDadJoke().let { result ->
                    // safe casting
                    if (result.isSuccessful) {
                        val test = result.body() as DadJoke
                        _dadJoke.value = test
                    } else {
                        // unsuccessful
                    }
                }
                _dataLoading.value = false
            }
//        }
    }
}