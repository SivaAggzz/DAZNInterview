package com.example.dazninterview.views.activities

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dazninterview.R
import com.example.dazninterview.adapters.ImageViewerAdapter
import com.example.dazninterview.databinding.ActivityViewImageBinding
import com.example.dazninterview.interfaces.ViewImageActivityInterface
import com.example.dazninterview.models.NasaModel
import com.example.dazninterview.utils.loadImage
import com.example.dazninterview.utils.toast

class ViewImageActivity : AppCompatActivity(), ViewImageActivityInterface {
    private lateinit var viewBinding: ActivityViewImageBinding
    private var currentPosition=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityViewImageBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        window?.statusBarColor= Color.BLACK
        window?.navigationBarColor=Color.BLACK


        val nasaModels: ArrayList<NasaModel>? = getNasaModelFromExtras()

        nasaModels?.apply {
            currentPosition=intent.extras?.getInt(MODEL_POSITION_NAME)?:0
            initView(nasaModels)
        } ?: kotlin.run {
            getString(R.string.no_extra_detected_msg).toast(this)
            finish()
        }
    }

    override fun getNasaModelFromExtras(): ArrayList<NasaModel>? {

        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.extras?.getParcelableArrayList(MODEL_EXTRA_NAME, ArrayList::class.java) as ArrayList<NasaModel>?
        }
        else{
            intent.extras?.getParcelableArrayList(MODEL_EXTRA_NAME)
        }
    }

    override fun initView(nasaModel: ArrayList<NasaModel>) {
        val adapter= ImageViewerAdapter(this,nasaModel)
        viewBinding.imageViewPager.adapter=adapter
        viewBinding.imageViewPager.currentItem=currentPosition
    }


    companion object {
        const val MODEL_EXTRA_NAME = "nasaModels"
        const val MODEL_POSITION_NAME = "position"
    }
}