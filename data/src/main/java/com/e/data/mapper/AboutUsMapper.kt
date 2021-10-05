package com.e.data.mapper

import com.e.data.entity.AboutUsResult
import com.e.domain.models.AboutUsModel
import javax.inject.Inject

class AboutUsMapper @Inject constructor() {

    fun toMapper(aboutUs: AboutUsResult): AboutUsModel {

        return AboutUsModel(
            aboutUs.text ?: "",
            aboutUs.result ?: true
        )
    }


}