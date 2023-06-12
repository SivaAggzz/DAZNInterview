package com.example.dazninterview.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dazninterview.adapters.ImagesAdapter
import com.example.dazninterview.databinding.ActivityMainBinding
import com.example.dazninterview.interfaces.MainActivityInterface
import com.example.dazninterview.models.NasaModel
import com.example.dazninterview.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainActivityInterface {
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var imagesAdapter: ImagesAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initViews()
        observeData()
    }

    override fun initViews() {
        viewModel.retrieveDataModelsFromAssets()
    }


    override fun observeData(){
        viewModel.dataModelsMutableLiveData.observe(this){dataModels->
            setGalleryAdapter(dataModels)
        }
    }


    override fun setGalleryAdapter(dataModels:ArrayList<NasaModel>) {
        imagesAdapter= ImagesAdapter(this,dataModels)
        viewBinding.recyclerView.adapter=imagesAdapter
    }
}