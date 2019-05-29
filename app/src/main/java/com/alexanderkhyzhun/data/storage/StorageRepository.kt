package com.alexanderkhyzhun.data.storage

/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 */
interface StorageRepository {

    fun setFirstName(first: String)
    fun setLastName(last: String)
    fun setLoginStatus(login: Boolean)

    fun getFirstName(): String?
    fun getLastName(): String?
    fun getLoginStatus(): Boolean

}