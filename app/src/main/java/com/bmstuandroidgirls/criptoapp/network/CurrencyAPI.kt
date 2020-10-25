package com.bmstuandroidgirls.criptoapp.network

import com.fasterxml.jackson.annotation.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface CurrencyAPI {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder("Aggregated", "TimeFrom", "TimeTo", "com.bmstuandroidgirls.criptoapp.network.Data")
    class Data {
        @get:JsonProperty("Aggregated")
        @set:JsonProperty("Aggregated")
        @JsonProperty("Aggregated")
        var isAggregated = false

        @get:JsonProperty("TimeFrom")
        @set:JsonProperty("TimeFrom")
        @JsonProperty("TimeFrom")
        var timeFrom = 0

        @get:JsonProperty("TimeTo")
        @set:JsonProperty("TimeTo")
        @JsonProperty("TimeTo")
        var timeTo = 0

        @get:JsonProperty("Data")
        @set:JsonProperty("Data")
        @JsonProperty("Data")
        var data: List<Datum>? = null

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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder(
        "time",
        "high",
        "low",
        "open",
        "volumefrom",
        "volumeto",
        "close",
        "conversionType",
        "conversionSymbol"
    )
    class Datum {
        @get:JsonProperty("time")
        @set:JsonProperty("time")
        @JsonProperty("time")
        var time = 0

        @get:JsonProperty("high")
        @set:JsonProperty("high")
        @JsonProperty("high")
        var high = 0f

        @get:JsonProperty("low")
        @set:JsonProperty("low")
        @JsonProperty("low")
        var low = 0f

        @get:JsonProperty("open")
        @set:JsonProperty("open")
        @JsonProperty("open")
        var open = 0f

        @get:JsonProperty("volumefrom")
        @set:JsonProperty("volumefrom")
        @JsonProperty("volumefrom")
        var volumefrom = 0f

        @get:JsonProperty("volumeto")
        @set:JsonProperty("volumeto")
        @JsonProperty("volumeto")
        var volumeto = 0f

        @get:JsonProperty("close")
        @set:JsonProperty("close")
        @JsonProperty("close")
        var close = 0f

        @get:JsonProperty("conversionType")
        @set:JsonProperty("conversionType")
        @JsonProperty("conversionType")
        var conversionType: String? = null

        @get:JsonProperty("conversionSymbol")
        @set:JsonProperty("conversionSymbol")
        @JsonProperty("conversionSymbol")
        var conversionSymbol: String? = null

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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder("Response", "Message", "HasWarning", "Type", "RateLimit", "Data")
    class Example {
        @get:JsonProperty("Response")
        @set:JsonProperty("Response")
        @JsonProperty("Response")
        var response: String? = null

        @get:JsonProperty("Message")
        @set:JsonProperty("Message")
        @JsonProperty("Message")
        var message: String? = null

        @get:JsonProperty("HasWarning")
        @set:JsonProperty("HasWarning")
        @JsonProperty("HasWarning")
        var isHasWarning = false

        @get:JsonProperty("Type")
        @set:JsonProperty("Type")
        @JsonProperty("Type")
        var type = 0

        @get:JsonProperty("RateLimit")
        @set:JsonProperty("RateLimit")
        @JsonProperty("RateLimit")
        var rateLimit: RateLimit? = null

        @get:JsonProperty("Data")
        @set:JsonProperty("Data")
        @JsonProperty("Data")
        var data: Data? = null

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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder
    class RateLimit {
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

    @GET("/data/v2/histoday")
    fun getCurrencies( @Query("api_key") apiKey: String?,
        @Query("fsym") fsym: String?, @Query("tsym") tsym: String?, @Query("limit") limit: Int?
    ): Call<Example>?
}


