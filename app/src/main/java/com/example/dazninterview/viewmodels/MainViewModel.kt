package com.example.dazninterview.viewmodels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dazninterview.interfaces.AssetDataProvider
import com.example.dazninterview.models.NasaModel
import com.example.dazninterview.utils.AssetManagerDataProvider
import com.example.dazninterview.utils.AssetReader
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val app: Application,
    private val errorHandler: CoroutineExceptionHandler
) : ViewModel() {

    val dataModelsMutableLiveData: MutableLiveData<ArrayList<NasaModel>> = MutableLiveData()

    fun retrieveDataModelsFromAssets() {
        viewModelScope.launch(errorHandler + Dispatchers.IO) {
            val assetDataProvider: AssetDataProvider = AssetManagerDataProvider(app)
            val assetReader = AssetReader(assetDataProvider)
            val dataModels = assetReader.readModelsFromAssets("nasa_details.json")
            dataModelsMutableLiveData.postValue(dataModels)
        }
    }
}