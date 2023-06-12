package com.example.dazninterview.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dazninterview.databinding.ImageItemBinding
import com.example.dazninterview.models.NasaModel
import com.example.dazninterview.utils.loadImage
import com.example.dazninterview.utils.loadImageWithPlaceholder

class ImagesViewHolder(private val viewBinding: ImageItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindView(nasaModel: NasaModel, onClickListener: View.OnClickListener){
        viewBinding.imageView.loadImageWithPlaceholder(nasaModel.url)
        viewBinding.root.setOnClickListener {
            onClickListener.onClick(it)
        }
    }
}