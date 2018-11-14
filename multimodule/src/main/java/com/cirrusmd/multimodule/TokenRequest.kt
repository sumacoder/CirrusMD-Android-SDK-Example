package com.cirrusmd.exampleapp

import com.google.gson.annotations.SerializedName

/**
 * Created by Cory Clark on 12/5/17
 */
class TokenRequest {

    @SerializedName("sdk_id")
    var sdkId : String? = null

    @SerializedName("patient_id")
    var patientId : String? = null
}