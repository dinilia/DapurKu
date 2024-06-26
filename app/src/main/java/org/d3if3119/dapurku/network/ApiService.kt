package org.d3if3119.dapurku.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3119.dapurku.model.MessageResponse
import org.d3if3119.dapurku.model.ResepCreate
import org.d3if3119.dapurku.model.Resep
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://dapur-ku.vercel.app/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()



private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface UserApi {
    @POST("recipes/")
    suspend fun addData(
        @Body data: ResepCreate
    ): MessageResponse

    @GET("recipes/")
    suspend fun getAllData(
        @Query("email") email: String,
    ): List<Resep>

    @DELETE("recipes/{recipe_id}")
    suspend fun deleteData(
        @Path("recipe_id") id: Int,
        @Query("email") email: String
    ): MessageResponse
}


object Api {
    val userService: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }

}

enum class ApiStatus { LOADING, SUCCESS, FAILED }