package com.example.pokedexapp.di

import android.content.Context
import androidx.room.Room
import com.example.pokedexapp.data.database.PokemonDatabase
import com.example.pokedexapp.data.database.dao.PokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

const val DATABASE_NAME = "pokemon_database"

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun providePokemonDatabase(@ApplicationContext context: Context): PokemonDatabase {
        return Room.databaseBuilder(
            context, PokemonDatabase::class.java,
            DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun providePokemonDao(database: PokemonDatabase): PokemonDao {
        return database.pokemonDao()
    }
}
