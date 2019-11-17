package com.mvp.plants.data.vos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "plants")
data class PlantVO(
        @SerializedName("plant_id")
        @ColumnInfo(name="plant_id")
        @PrimaryKey
        val plantId:String,

        @SerializedName("plant_name")
        @ColumnInfo(name="plant_name")
        val name:String,

        @SerializedName("plant_type")
        @ColumnInfo(name="plant_type")
        val plantType:List<String>,

        @SerializedName("description")
        @ColumnInfo(name="description")
        val description:String,

        @SerializedName("top_tip")
        @ColumnInfo(name = "top_tip")
        val topTip:String,

        @SerializedName("tips")
        @Embedded(prefix="tip_vo_")
        val tips:TipVO,

        @SerializedName("uploaded_user")
        @Embedded(prefix = "user_vo_")
        val uploadedUsr:UserVO,

        @SerializedName("plant_photo")
        @ColumnInfo(name="plant_photo")
        val plantPhoto:String
){
}