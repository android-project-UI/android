package com.example.ui_presence_absence.model


import android.media.Image

data class Master(
    var id: String,
    var name: String,
    var image: Image,
    var username: String,
    var password: String,
    var sessions: List<Session>
)