package com.example.dazninterview.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NasaModel(
    var copyright:String="",
    var date:String="",
    var explanation:String="",
    var hdurl:String="",
    var media_type:String="",
    var service_version:String="",
    var title:String="",
    var url:String=""
    ):Parcelable