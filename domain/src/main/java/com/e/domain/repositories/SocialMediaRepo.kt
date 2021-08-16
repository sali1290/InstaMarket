package com.e.domain.repositories

import com.e.domain.models.SocialMediaModel

interface SocialMediaRepo {

    suspend fun getSocialMedia(): MutableList<SocialMediaModel>

}