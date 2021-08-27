package com.e.data.mapper

import com.e.data.entity.remote.Banner
import com.e.data.entity.remote.Service
import com.e.domain.models.BannerModel
import com.e.domain.models.ServiceModel

class BannerMapper {
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