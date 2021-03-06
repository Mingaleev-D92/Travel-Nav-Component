package com.example.travel.ui.fragment.details

import com.airbnb.epoxy.EpoxyController
import com.example.travel.R
import com.example.travel.databinding.ModelHeaderImageBinding
import com.example.travel.ui.epoxy.ViewBindingKotlinModel
import com.squareup.picasso.Picasso

class HeaderEpoxyController(
    val imageUrls: List<String>
): EpoxyController() {

    override fun buildModels() {
        imageUrls.forEachIndexed { index, url ->
            HeaderImageEpoxyModel(url).id(index).addTo(this)
        }
    }

    inner class HeaderImageEpoxyModel(
        val imageUrl: String
    ): ViewBindingKotlinModel<ModelHeaderImageBinding>(R.layout.model_header_image) {

        override fun ModelHeaderImageBinding.bind() {
            Picasso.get().load(imageUrl).into(imageView)
        }
    }
}