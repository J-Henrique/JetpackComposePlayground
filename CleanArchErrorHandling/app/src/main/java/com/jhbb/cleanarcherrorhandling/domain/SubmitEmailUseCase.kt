package com.jhbb.cleanarcherrorhandling.domain

import com.jhbb.cleanarcherrorhandling.data.MyRepositoryImpl
import com.jhbb.cleanarcherrorhandling.util.Resource

class SubmitEmailUseCase(
    private val repositoryImpl: MyRepository = MyRepositoryImpl(),
) {

    suspend fun execute(email: String): Resource<Unit> {
        if (!email.contains("@")) {
            return Resource.Error("That is not a valid email")
        }
        return repositoryImpl.submitEmail(email)
    }
}