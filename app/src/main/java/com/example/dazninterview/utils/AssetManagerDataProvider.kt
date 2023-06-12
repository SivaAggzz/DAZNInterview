package com.example.dazninterview.utils

import android.content.Context
import com.example.dazninterview.interfaces.AssetDataProvider
import java.io.InputStream

class AssetManagerDataProvider(context: Context): AssetDataProvider {
    private val assetManager=context.assets

    override fun getAssetDataStream(fileName: String): InputStream {
        return assetManager.open(fileName)
    }
}