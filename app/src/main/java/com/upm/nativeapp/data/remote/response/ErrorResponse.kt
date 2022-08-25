package com.upm.nativeapp.data.remote.response

import com.google.gson.annotations.SerializedName
import com.upm.nativeapp.domain.model.BaseModel

data class ErrorResponse(
    @SerializedName("error_id") val errorId: Int = 0,
    @SerializedName("error_message") val errorMessage: String? = null,
    @SerializedName("error_name") val errorName: String? = null
) : BaseModel()