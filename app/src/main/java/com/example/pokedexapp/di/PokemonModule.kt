package com.example.pokedexapp.di

import android.content.Context
import com.example.pokedexapp.data.repository.PokemonRepositoryImpl
import com.example.pokedexapp.domain.repository.PokemonRepository
import com.example.pokedexapp.util.IoDispatcher
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PokemonModule {

    @Binds
    abstract fun providePokemonRepository(impl: PokemonRepositoryImpl): PokemonRepository
}

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {
    @Provides
    @IoDispatcher
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}

@Module
@InstallIn(SingletonComponent::class)
object ContextModule {

    @Provides
    @Singleton
    fun provideApplicationContext(@ApplicationContext context: Context): Context {
        return context
    }
}
