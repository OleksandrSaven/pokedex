package com.example.pokedexapp.di

import com.example.pokedexapp.data.repository.PokemonRepositoryImpl
import com.example.pokedexapp.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PokemonModule {

    @Binds
    abstract fun providePokemonRepository(impl: PokemonRepositoryImpl): PokemonRepository
}