package com.example.dazninterview.interfaces

import com.example.dazninterview.models.NasaModel

interface ViewImageActivityInterface {
    fun getNasaModelFromExtras(): ArrayList<NasaModel>?
    fun initView(nasaModel: ArrayList<NasaModel>)
}