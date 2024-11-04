package com.example.hotmeals.core.retrofit

import org.intellij.lang.annotations.Identifier
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.converter.gson.GsonConverterFactory

interface AuthApi {

    //Login
    data class LoginRequest(
        val identifier: String,
        val password: String
    )

    data class LoginResponse(
        val token: String,
        val userId: String
    )

    @POST("auth/login")
    suspend fun loginUser(@Body body: LoginRequest): Response<LoginResponse>



    //Register
    data class RegisterRequest(
        val email: String,
        val password: String,
        val name: String,
        val phoneNumber: String
    )

    data class RegisterResponse(
        val token: String,
        val id: String
    )

    @POST("auth/register")
    suspend fun registerUser(@Body body: RegisterRequest): Response<RegisterResponse>




    companion object {
        private const val BASE_URL = "https://hotmeals-back.onrender.com/"

        fun create(): AuthApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(AuthApi::class.java)
        }
    }
}
