package com.example.database.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.database.domain.models.WeatherFromDb

@Dao
interface WeatherDao {
    @Upsert
    suspend fun upsertWeather(weatherFromDb: WeatherFromDb)

    @Query("select * from WeatherFromDb")
    fun getList(): List<WeatherFromDb>

    @Query("select * from WeatherFromDb where id = :id")
    suspend fun getWeatherById(id: Int): WeatherFromDb
}