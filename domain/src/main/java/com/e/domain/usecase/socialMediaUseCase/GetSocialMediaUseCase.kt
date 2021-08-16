package com.e.domain.usecase.socialMediaUseCase

import com.e.domain.repository.SocialMediaRepo

class GetSocialMediaUseCase (private val socialMedialRepo : SocialMediaRepo){

    suspend fun execute() = socialMedialRepo.getSocialMedia()

}