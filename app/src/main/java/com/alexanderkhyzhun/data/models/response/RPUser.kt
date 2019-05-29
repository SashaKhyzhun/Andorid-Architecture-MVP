package com.alexanderkhyzhun.data.models.response

import com.google.gson.annotations.SerializedName

/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 *
 * RP means Response (it's just for example)
 */
data class RPUser(

    @SerializedName("firstName")
    val firstName: String,

    @SerializedName("lastName")
    val lastName: String,

    @SerializedName("registered")
    val registered: Boolean

)