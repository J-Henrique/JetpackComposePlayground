package com.plcoding.jetpackcomposepokedex.repository

import com.plcoding.jetpackcomposepokedex.data.remote.PokeApi
import com.plcoding.jetpackcomposepokedex.data.remote.response.Pokemon
import com.plcoding.jetpackcomposepokedex.data.remote.response.PokemonList
import com.plcoding.jetpackcomposepokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi,
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        return try {
            Resource.Success(api.getPokemonList(limit, offset))
        } catch (e: Exception) {
            Resource.Error("An unknown error occurred: ${e.message}")
        }
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return try {
            Resource.Success(api.getPokemonInfo(pokemonName))
        } catch (e: Exception) {
            Resource.Error("An unknown error occurred: ${e.message}")
        }
    }
}