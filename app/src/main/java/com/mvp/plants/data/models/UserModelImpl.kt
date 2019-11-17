package com.mvp.plants.data.models

import com.mvp.plants.data.vos.LoginUserVO
import com.mvp.plants.network.responses.LoginUserResponse

object UserModelImpl : BaseModel(), UserModel {

    override fun logout() {
        mDatabase.UserDao().logOutUser()
    }

    override fun checkUser(): Boolean {
        return mDatabase.areUserLogin()
    }


    override fun loginUser(
        email: String,
        password: String,
        onSuccess: (LoginUserVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mDataAgent.loginUser(
            email, password, {
                if (mDatabase.areUserLogin()) {
                    onSuccess(mDatabase.UserDao().getUser())
                } else {
                    mDatabase.UserDao().insertUser(it)
                    onSuccess(it)
                }
            }, {
                onFailure(it)
            }
        )
    }


}