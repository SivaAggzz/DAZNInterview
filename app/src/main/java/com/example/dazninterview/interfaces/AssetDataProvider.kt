package com.example.dazninterview.interfaces

import java.io.IOException

import java.io.InputStream


interface AssetDataProvider {
    @Throws(IOException::class)
    fun getAssetDataStream(fileName: String): InputStream?
}