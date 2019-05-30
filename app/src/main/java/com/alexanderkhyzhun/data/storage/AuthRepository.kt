package com.alexanderkhyzhun.data.storage

/**
 * @author Alexander Khyzhun
 * Created on 30 May, 2019
 */
interface AuthRepository {

    fun signIn()
    fun signUp()
    fun logout()
    fun isUserAuthorized(): Boolean

}