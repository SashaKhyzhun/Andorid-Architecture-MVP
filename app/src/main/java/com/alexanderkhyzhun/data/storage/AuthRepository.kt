package com.alexanderkhyzhun.data.storage

/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 */
interface AuthRepository {

    fun signIn()

    fun isUserAuthorized(): Boolean

}