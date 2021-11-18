package com.e.data.mapper

import com.e.data.entity.Banner
import com.e.domain.models.BannerModel
import javax.inject.Inject

class BannerMapper @Inject constructor(){
    fun toMapper(banner: Banner): BannerModel {
        return BannerModel(
            banner.id ?: 0,
            banner.h ?: "",
            banner.name ?: "",
            banner.src ?: "",
            banner.w ?: ""
        )
    }
}