package com.example.pokedexapp.worker

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.pokedexapp.R
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

    private fun showNotification(context: Context, title: String, message: String) {
        // Отримати менеджер нотифікацій
        val notificationManager = NotificationManagerCompat.from(context)

        // Перевірити, чи необхідно створити канал нотифікацій (тільки для API 26+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "my_channel_id"
            val channelName = "My Channel Name"
            val channelDescription = "My Channel Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = channelDescription
            }
            notificationManager.createNotificationChannel(channel)
        }

        // Створити об'єкт NotificationCompat.Builder
        val builder = NotificationCompat.Builder(context, "my_channel_id")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Показати нотифікацію за допомогою менеджера нотифікацій
        if (ActivityCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        notificationManager.notify(123, builder.build())
    }


    override suspend fun doWork(): Result {
        Log.i("Hello", "Oleksandr")
       return try {

           showNotification(applicationContext, "Hello", "Please open Pokemon App")

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
