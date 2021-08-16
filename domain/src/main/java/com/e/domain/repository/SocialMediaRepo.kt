package com.e.domain.repository

import com.e.domain.models.SocialMediaModel

interface SocialMediaRepo {

    suspend fun getSocialMedia(): MutableList<SocialMediaModel>

}