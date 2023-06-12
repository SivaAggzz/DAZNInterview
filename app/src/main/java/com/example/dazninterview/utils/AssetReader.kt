package com.example.dazninterview.utils

import com.example.dazninterview.interfaces.AssetDataProvider
import com.example.dazninterview.models.NasaModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.reflect.Type

class AssetReader(private val assetDataProvider: AssetDataProvider) {
    fun readModelsFromAssets(fileName:String): ArrayList<NasaModel>  {
        try {
            val inputStream = assetDataProvider.getAssetDataStream(fileName)
            val reader =  BufferedReader(InputStreamReader(inputStream))

            val gson =  Gson()
            val modelListType: Type = object : TypeToken<List<NasaModel?>?>() {}.type
            val modelList : ArrayList<NasaModel> = gson.fromJson(reader, modelListType)

            reader.close()
            inputStream?.close()

            return modelList
        } catch (e: IOException) {
            e.printStackTrace()
            return ArrayList()
        }
    }
    

}