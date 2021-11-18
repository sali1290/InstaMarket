package com.e.data.mapper

import com.e.data.entity.Site
import com.e.domain.models.SiteModel
import javax.inject.Inject

class SiteMapper @Inject constructor(){
    fun toMapper(site: Site): SiteModel {
        return SiteModel(
            site.day ?: "",
            site.des ?: "",
            site.flag ?: "",
            site.id ?: 0,
            site.name ?: "",
            site.num ?: "",
            site.permition ?: "",
            site.price ?: "",
            site.subject ?: "",
        )
    }
}