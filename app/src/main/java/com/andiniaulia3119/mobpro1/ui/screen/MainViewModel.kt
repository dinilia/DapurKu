package com.andiniaulia3119.mobpro1.ui.screen

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andiniaulia3119.mobpro1.model.ImageData
import com.andiniaulia3119.mobpro1.model.Resep
import com.andiniaulia3119.mobpro1.model.ResepCreate
import com.andiniaulia3119.mobpro1.network.Api
import com.andiniaulia3119.mobpro1.network.ApiStatus
import com.andiniaulia3119.mobpro1.network.ImageApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream

class MainViewModel : ViewModel() {

    var data = mutableStateOf(emptyList<Resep>())

    var status = MutableStateFlow(ApiStatus.LOADING)

    var errorMessage = mutableStateOf<String?>(null)

    var querySuccess = mutableStateOf(false)

    fun retrieveData(userId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            status.value = ApiStatus.LOADING
            try {
                data.value = Api.userService.getAllData(userId)
                Log.d("MainVM", "data: ${data.value}")
                status.value = ApiStatus.SUCCESS
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.value = ApiStatus.FAILED
            }
        }
    }

    fun saveData(email: String, nama: String, deskripsi: String, bitmap: Bitmap) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val upload = ImageApi.imgService.uploadImg(
                    image = bitmap.toMultipartBody()
                )

                if (upload.success) {
                    Api.userService.addData(
                        ResepCreate(email, nama, deskripsi, "", transformImageData(upload.data), upload.data.deletehash!!)
                    )
                    status.value = ApiStatus.LOADING
                    retrieveData(email)
                    querySuccess.value = true
                }
            } catch (e: Exception) {
                Log.d("MainVM", "${e.message}")
                if (e.message == "HTTP 500 ") {
                    errorMessage.value = "Error: Database Idle. Harap eksekusi data kembali."
                } else {
                    errorMessage.value = "Error: ${e.message}"
                    Log.d("MainViewModel", "Failure: ${e.message}")
                }
            }
        }
    }

    fun deleteData(email: String, anjingId: Int, deleteHash: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val upload = ImageApi.imgService.deleteImg(
                    deleteHash = deleteHash
                )
                if (upload.success) {
                    Api.userService.deleteData(anjingId, email)
                    querySuccess.value = true
                    retrieveData(email)
                }
            } catch (e: Exception) {
                if (e.message == "HTTP 500 ") {
                    errorMessage.value = "Error: Database Idle, harap eksekusi data kembali."
                } else {
                    errorMessage.value = "Error: ${e.message}"
                    Log.d("MainViewModel", "Failure: ${e.message}")
                }
            }
        }
    }

    private fun Bitmap.toMultipartBody(): MultipartBody.Part {
        val stream = ByteArrayOutputStream()
        compress(Bitmap.CompressFormat.JPEG, 80, stream)
        val byteArray = stream.toByteArray()
        val requestBody = byteArray.toRequestBody(
            "image/jpg".toMediaTypeOrNull(), 0, byteArray.size
        )
        return MultipartBody.Part.createFormData("image", "image.jpg", requestBody)
    }

    private fun transformImageData(imageData: ImageData): String {
        val extension = when (imageData.type) {
            "image/png" -> "png"
            "image/jpeg" -> "jpg"
            "image/gif" -> "gif"
            else -> throw IllegalArgumentException("Unsupported image type")
        }
        return "${imageData.id}.$extension"
    }

    fun clearMessage() {
        errorMessage.value = null
        querySuccess.value = false
    }

}