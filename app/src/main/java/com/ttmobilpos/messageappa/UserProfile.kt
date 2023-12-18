package com.ttmobilpos.messageappa

data class UserProfile constructor(val name :String, val status : Boolean , val drawableId : Int)

val userProfileList = arrayListOf(
    UserProfile(name = "Ali Duru", status = true, drawableId = R.drawable.profile_picture),
    UserProfile(name = "Aliye Duru", status = false, drawableId = R.drawable.profile_picture_2)
)
