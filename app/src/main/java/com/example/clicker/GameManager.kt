package com.example.clicker

import android.content.Context

class GameManager(val context: Context) {
    private val prefs = context.getSharedPreferences("game_prefs", Context.MODE_PRIVATE)
}