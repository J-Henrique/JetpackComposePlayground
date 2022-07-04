package com.jhbb.cleanarcherrorhandling.data

import com.jhbb.cleanarcherrorhandling.domain.MyRepository
import com.jhbb.cleanarcherrorhandling.util.Resource
import kotlinx.coroutines.delay
import kotlin.random.Random

class MyRepositoryImpl : MyRepository {

    override suspend fun submitEmail(email: String): Resource<Unit> {
        delay(500L)
        return if (Random.nextBoolean()) {
            Resource.Success(Unit)
        } else {
            return if (Random.nextBoolean()) {
                Resource.Error("Server error")
            } else {
                Resource.Error("Not authenticated")
            }
        }
    }
}