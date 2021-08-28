package com.e.data.mapper

import com.e.data.entity.remote.News
import com.e.domain.models.NewsModel
import javax.inject.Inject

class NewsMapper @Inject constructor(){
    fun toMapper(news: News): NewsModel {
        return NewsModel(
            news.id ?: 0,
            news.changed ?: "",
            news.created ?: "",
            news.description ?: "",
            news.expiry ?: "",
            news.ids ?: "",
            news.status ?: "",
            news.type ?: "",
            news.uid ?: "",
        )
    }
}