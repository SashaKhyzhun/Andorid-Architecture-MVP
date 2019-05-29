package com.alexanderkhyzhun.data

import com.alexanderkhyzhun.data.models.UserAuth
import com.alexanderkhyzhun.data.models.request.NWUserAuth
import com.alexanderkhyzhun.data.models.response.RPUser

/**
 * @author Alexander Khyzhun
 * Created on 29 May, 2019
 */

fun NWUserAuth.toRPUser(login: Boolean): RPUser = RPUser(this.firstName!!, this.lastName!!, login)


fun RPUser.toUserAuth(): UserAuth = UserAuth(this.firstName, this.lastName)


