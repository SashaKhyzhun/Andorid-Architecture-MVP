package com.alexanderkhyzhun.domain

/**
 * @author Alexander Khyzhun
 * Created on 30 May, 2019
 */
interface LoginUseCase {

    fun createUserSession(firstName: String, lastName: String)

}