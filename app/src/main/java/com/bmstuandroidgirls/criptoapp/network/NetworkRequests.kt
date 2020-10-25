package com.bmstuandroidgirls.criptoapp.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


class NetworkRequests {
    companion object {
        private const val CONNECTION = "https"
        private const val NETWORK_HOST = "min-api.cryptocompare.com"
        private const val API_KEY =
            "600bf09ff8d82df6383db691c3873eb7fa6ea91651f8a33bfbd90dd2ddafcf4a"
    }

    val currenciesMutableLiveData: MutableLiveData<List<CurrencyAPI.Datum>? > =
        MutableLiveData<List<CurrencyAPI.Datum>?>()
    private var currencyApi: CurrencyAPI? = null
    private var simpleApi: SimpleAPI? = null
    private val okHttpClient: OkHttpClient = OkHttpClient()
        .newBuilder()
        .build()

    fun getCurrencies() {
        currencyApi?.getCurrencies(  API_KEY, "BTC", "USD")?.enqueue(object : Callback<CurrencyAPI.Example> {
                override fun onResponse(
                    call: Call<CurrencyAPI.Example>,
                    response: Response<CurrencyAPI.Example>
                ) {
                    Log.d("request", call.request().url().toString())
                    currenciesMutableLiveData.postValue(response.body()?.data?.data)
                    Log.d("response", response.body()?.data?.data.toString())
                }

                override fun onFailure(call: Call<CurrencyAPI.Example>, t: Throwable) {
                    Log.d("response", t.message.toString())
                }
            })
    }

    fun getSimple() {
        simpleApi?.getCurrencies(  API_KEY, "BTC", "USD,JPY,EUR")?.enqueue(object : Callback<SimpleAPI.Example> {
            override fun onResponse(
                call: Call<SimpleAPI.Example>,
                response: Response<SimpleAPI.Example>
            ) {
                Log.d("request", call.request().url().toString())
                Log.d("response", response.raw().body().toString())
            }

            override fun onFailure(call: Call<SimpleAPI.Example>, t: Throwable) {
                Log.d("response", t.message.toString())
            }
        })
    }


    init {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create())
            .baseUrl(
                HttpUrl.Builder().scheme(CONNECTION)
                    .host(NETWORK_HOST)
                    .build()
            )
            .client(okHttpClient)
            .build()
        currencyApi = retrofit.create<CurrencyAPI>(CurrencyAPI::class.java)
        simpleApi = retrofit.create(SimpleAPI::class.java)
    }
}