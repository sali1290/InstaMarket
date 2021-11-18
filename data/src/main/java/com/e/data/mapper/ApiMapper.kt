package com.e.data.mapper

import com.e.data.entity.Api
import com.e.domain.models.ApiModel
import javax.inject.Inject

class ApiMapper @Inject constructor(){

    fun toMapper(api: Api): ApiModel {
        return ApiModel(
            api.id?:0,
            api.balance?:"",
            api.changed?:"",
            api.created?:"",
            api.currencyCode?:"",
            api.description?:"",
            api.email?:"",
            api.ids?:"",
            api.key?:"",
            api.name?:"",
            api.status?:"",
            api.type?:"",
            api.uid?:"",
            api.url?:""

        )
    }

}