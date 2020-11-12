package com.example.sea.data.remote

import com.example.sea.data.remote.model.LocationData
import com.example.sea.data.remote.model.OceanData
import com.example.sea.data.remote.model.SunData
import com.example.sea.data.remote.model.TextData
import com.example.sea.data.remote.model.WindData
import rx.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

// Definerer API endepunkter
interface WeatherService {
    @Headers("User-Agent: Gruppe17")
    @GET("weatherapi/oceanforecast/0.9/.json")
    fun getOceanData(@Query("lat") lat: Float,
                     @Query("lon") lon: Float) : Observable<OceanData>

    @Headers("User-Agent: Gruppe17")
    @GET("weatherapi/locationforecast/1.9/.json")
    fun getLocationData(@Query("lat") lat: Float,
                        @Query("lon") lon: Float,
                        @Query("msl") msl: Float?) : Observable<LocationData> // msl parameteret er valgfri, send inn null hvis du ikke vil sende inn msl verdi

    @Headers("User-Agent: Gruppe17")
    @GET("weatherapi/spotwind/1.0/.json")
    fun getWindData() : Call<WindData>

    @Headers("User-Agent: Gruppe17")
    @GET("weatherapi/textforecast/2.0/")
    fun getTextData(@Query("forecast") forecast: String) : Call<TextData>

    @Headers("User-Agent: Gruppe17")
    @GET("weatherapi/sunrise/2.0/")
    fun getSunData(@Query("lat") lat: Float,
                   @Query("lon") lon: Float,
                   @Query("height") height: Int?,
                   @Query("date") date: String,
                   @Query("offset") offset: String,
                   @Query("days") days: Int?) : Call<SunData>


    @Headers("User-Agent: Gruppe17")
    @GET("weatherapi/tidalwater/1.1/")
    fun getTidalWater(@Query("harbor") harbor: String) : Observable<String>
}