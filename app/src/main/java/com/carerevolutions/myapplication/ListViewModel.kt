package com.carerevolutions.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel: ViewModel() {
    private val _states = MutableLiveData(emptyList<CountrySubdivision>())
    val states: LiveData<List<CountrySubdivision>>
        get() = _states

    init {
        States.get {
            _states.value = it
        }
    }
}
