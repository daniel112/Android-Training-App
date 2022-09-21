package com.neudesic.myapplication.ui.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neudesic.myapplication.domain.model.DadJoke
import com.neudesic.myapplication.domain.network.*
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
        // TODO: Show loading indicator
        _dataLoading.value = true
        // TODO: setup for unit test coverages
//        wrapEspressoIdlingResource {
            viewModelScope.launch {
                val response = getDadJokesUseCase.getSingleDadJoke()
                if (response.success) _dadJoke.value = response.data
                else println(response.message)

                _dataLoading.value = false
            }
//        }
    }
}