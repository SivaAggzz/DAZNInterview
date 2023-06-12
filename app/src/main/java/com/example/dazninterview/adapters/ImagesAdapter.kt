package com.example.dazninterview.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dazninterview.databinding.ImageItemBinding
import com.example.dazninterview.models.NasaModel
import com.example.dazninterview.views.activities.ViewImageActivity
import com.example.dazninterview.views.viewholders.ImagesViewHolder

class ImagesAdapter(
    private val context: Context,
    private val dataItems: ArrayList<NasaModel>
) : RecyclerView.Adapter<ImagesViewHolder>() {
    private val layoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        return ImagesViewHolder(ImageItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun getItemCount(): Int {
        return dataItems.size
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bindView(dataItems[position]) {
            val viewImageIntent = Intent(context, ViewImageActivity::class.java)
            viewImageIntent.putParcelableArrayListExtra(ViewImageActivity.MODEL_EXTRA_NAME, dataItems)
            viewImageIntent.putExtra(ViewImageActivity.MODEL_POSITION_NAME,position)
            context.startActivity(viewImageIntent)
        }
    }
}