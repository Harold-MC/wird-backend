package com.wird.service

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.gson.*
import kotlinx.coroutines.delay
import redis.clients.jedis.Jedis
import java.time.Instant
import kotlin.random.Random

class WeatherService(private val redisClient: Jedis) {

    private val client = HttpClient {
        install(ContentNegotiation) {
            gson()
        }
        install(Logging) {
            level = LogLevel.INFO
        }
    }

    private val apiKey = System.getenv("OPENWEATHER_API_KEY")
    private val locations = listOf(
        "Santiago,CL", "Zurich,CH", "Auckland,NZ",
        "Sydney,AU", "London,UK", "Georgia,USA"
    )

    suspend fun fetchWeatherData() {
        for (location in locations) {
            try {
                if (Random.nextFloat() < 0.2) throw Exception("API Request Failed")
                val weatherData = getWeatherFromAPI(location)
                redisClient.set(location, weatherData)
            } catch (e: Exception) {
                redisClient.set("log:${location}:${Instant.now()}", "Error: ${e.message}")
            }
        }
    }

    private suspend fun getWeatherFromAPI(location: String): String {
        val (city, country) = location.split(",")
        val url = "https://api.openweathermap.org/data/2.5/weather?q=$city,$country&appid=$apiKey&units=metric"
        
        return try {
            val response: HttpResponse = client.get(url)
            if (response.status.value == 200) {
                response.bodyAsText()
            } else {
                throw Exception("Failed to fetch data for $location: ${response.status}")
            }
        } catch (e: Exception) {
            delay(1000)
            throw e
        }
    }
}
