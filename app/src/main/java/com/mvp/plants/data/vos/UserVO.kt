package com.mvp.plants.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName


data class UserVO(

    @SerializedName("name")
     val name: String,

    @SerializedName("user_photo")
     val user_photo:String,

    @SerializedName("uploaded_time")
     val uploaded_time:String,

    @SerializedName("user_rank")
     val user_rank : String) {
}