package com.e.data.repository

import com.e.domain.models.SocialMediaModel
import com.e.domain.repository.SocialMediaRepo

class SocialMediaRepoImpl : SocialMediaRepo {
    override suspend fun getSocialMedia(): MutableList<SocialMediaModel> {
        TODO("Not yet implemented")
    }
}