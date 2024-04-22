package com.example.pokedexapp.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.pokedexapp.data.mapper.toPage
import com.example.pokedexapp.domain.repository.PokemonRepository
import retrofit2.HttpException
import javax.inject.Inject

const val LIMIT = 10

class PokemonWorker @Inject constructor(
    private  val pokemonRepository: PokemonRepository,
    context: Context,
    params: WorkerParameters): CoroutineWorker(context, params) {

    companion object {
        const val WORK_NAME = "GetPageDataWorker"
    }

    override suspend fun doWork(): Result {
        
       return try {
           val offset = pokemonRepository.getAllPage().size
           val pages = pokemonRepository.getPokemon(offset, LIMIT).data?.results?.map { it.toPage() }
           if (pages != null) {
               pokemonRepository.savePage(pages)
           }
           Result.success()
       } catch (exception: HttpException) {
           Result.retry()
       }
    }
}
