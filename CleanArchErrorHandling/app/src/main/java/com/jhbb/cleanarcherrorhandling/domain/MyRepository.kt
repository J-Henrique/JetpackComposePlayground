package com.jhbb.cleanarcherrorhandling.domain

import com.jhbb.cleanarcherrorhandling.util.Resource

interface MyRepository {
    suspend fun submitEmail(email: String): Resource<Unit>
}