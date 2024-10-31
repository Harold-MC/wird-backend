package com.wird

import com.wird.plugins.configureRouting
import com.wird.service.WeatherService

import io.ktor.server.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.coroutines.runBlocking
import redis.clients.jedis.Jedis
import kotlin.concurrent.fixedRateTimer

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}

fun Application.module() {
    val redisClient = Jedis("localhost", 6379)

    weatherScheduler(redisClient)

    configureRouting(redisClient)
}

fun weatherScheduler(redisClient: Jedis) {
    fixedRateTimer("WeatherUpdater", initialDelay = 0, period = 300000) {
        runBlocking {
            val weatherService = WeatherService(redisClient)
            weatherService.fetchWeatherData()
        }
    }
}
