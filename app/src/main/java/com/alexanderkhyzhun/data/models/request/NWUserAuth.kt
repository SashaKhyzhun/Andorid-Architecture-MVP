package com.alexanderkhyzhun.data.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 *
 * NW means Network
 */
data class NWUserAuth(
    @SerializedName("firstName")
    @Expose
    val firstName: String?,

    @SerializedName("lastName")
    @Expose
    val lastName: String?
)