package com.example.dazninterview.interfaces

import com.example.dazninterview.models.NasaModel

interface MainActivityInterface {
    fun initViews()
    fun observeData()
    fun setGalleryAdapter(dataModels:ArrayList<NasaModel>)
}