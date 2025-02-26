package com.hussein.baseapp.data.remote
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
class ApiService {
    private val client = HttpClient(CIO) {
        /* val properties = loadProperties()
         val privateKey = properties.getProperty("PRIVATE_KEY")*/
        expectSuccess = true
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        defaultRequest {
           // header("private-key", PRIVATE_KEY)
        }
    }

  /*  suspend fun getCategories(): BaseResponse<Category> {
        // Replace with your actual API endpoint
        val response:BaseResponse<Category> =client.get(BASE_URL + CATEGORY_ENDPOINT).body()
        return response
    }
    suspend fun getProperities(id:String): ArrayBaseResponse<Properity> {
        // Replace with your actual API endpoint
        val response:ArrayBaseResponse<Properity> =client.get("$BASE_URL$PROPERITIES_ENDPOINT?cat=$id").body()
        return response
    }
    suspend fun getOptions(id:String): ArrayBaseResponse<Option> {
        // Replace with your actual API endpoint
        val response:ArrayBaseResponse<Option> =client.get(BASE_URL + OPTIONS_ENDPOINT + id).body()
        return response
    }*/
}