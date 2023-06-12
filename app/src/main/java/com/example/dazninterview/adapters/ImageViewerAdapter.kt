package com.example.dazninterview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import com.example.dazninterview.R
import com.example.dazninterview.databinding.ViewImageItemBinding
import com.example.dazninterview.models.NasaModel
import com.example.dazninterview.utils.loadImage
import java.util.Objects


class ImageViewerAdapter(
    private val context: Context,
    private var images: ArrayList<NasaModel>
) : PagerAdapter() {
    private val layoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView: View = layoutInflater.inflate(R.layout.view_image_item, container, false)
        val itemViewBinding= ViewImageItemBinding.bind(itemView)
        setMedaData(itemViewBinding,images[position])
        container.addView(itemView)
        return itemView
    }

    private fun setMedaData(viewBinding:ViewImageItemBinding, nasaModel: NasaModel) {
        viewBinding.imageView.loadImage(nasaModel.hdurl)
        viewBinding.titleTxt.text = nasaModel.title
        viewBinding.dateTxt.text = nasaModel.date
        viewBinding.copyrightTxt.text = nasaModel.copyright
        viewBinding.mediaTypeTxt.text = "("+nasaModel.media_type+")"
        viewBinding.serviceVersionTxt.text=nasaModel.service_version

        //handling explanationTxt view

        viewBinding.explanationTxt
            .setAnimationDuration(200)
            .setReadMoreText("View More")
            .setReadLessText("View Less")
            .setCollapsedLines(2)
            .setIsExpanded(true)
            .setIsUnderlined(true)
            .setEllipsizedTextColor(ContextCompat.getColor(context, R.color.purple_200))

        viewBinding.explanationTxt.text = nasaModel.explanation
        viewBinding.explanationTxt.setOnClickListener {
            viewBinding.explanationTxt.toggle()
        }
    }


    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as ConstraintLayout?)
    }
}