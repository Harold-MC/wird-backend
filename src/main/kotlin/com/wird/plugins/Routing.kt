package com.wird.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.HttpStatusCode
import redis.clients.jedis.Jedis

fun Application.configureRouting(redisClient: Jedis) {
    routing {
        get("/weather/{location}") {
            val location = call.parameters["location"] ?: return@get call.respondText(
                "Invalid location",
                status = HttpStatusCode.BadRequest
            )
            val cachedData = redisClient.get(location)
            if (cachedData != null) {
                call.respondText(cachedData, status = HttpStatusCode.OK)
            } else {
                call.respondText("No data found for $location", status = HttpStatusCode.NotFound)
            }
        }
    }
}
