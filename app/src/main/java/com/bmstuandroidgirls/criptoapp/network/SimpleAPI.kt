package com.bmstuandroidgirls.criptoapp.network

import com.fasterxml.jackson.annotation.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface SimpleAPI {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder("USD", "JPY", "EUR")
    class Example {
        @get:JsonProperty("USD")
        @set:JsonProperty("USD")
        @JsonProperty("USD")
        var uSD = 0f

        @get:JsonProperty("JPY")
        @set:JsonProperty("JPY")
        @JsonProperty("JPY")
        var jPY = 0f

        @get:JsonProperty("EUR")
        @set:JsonProperty("EUR")
        @JsonProperty("EUR")
        var eUR = 0f

        @JsonIgnore
        private val additionalProperties: MutableMap<String, Any> = HashMap()
        @JsonAnyGetter
        fun getAdditionalProperties(): Map<String, Any> {
            return additionalProperties
        }

        @JsonAnySetter
        fun setAdditionalProperty(name: String, value: Any) {
            additionalProperties[name] = value
        }
    }

    @GET("/data/price")
    fun getCurrencies(
        @Query("fsym") fsym: String?, @Query("tsyms") tsym: String?,
        @Query("api_key") apiKey: String?
    ): Call<SimpleAPI.Example>
}