package com.e.domain.usecase.socialMediaUseCase

import com.e.domain.repositories.SocialMediaRepo

class GetSocialMediaUseCase (private val socialMedialRepo : SocialMediaRepo){

    suspend fun execute() = socialMedialRepo.getSocialMedia()

}