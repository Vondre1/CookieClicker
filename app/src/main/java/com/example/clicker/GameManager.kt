package com.example.clicker

import android.content.Context

class GameManager(val context: Context) {
    private val prefs = context.getSharedPreferences("game_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_SCORE = "score"
        private const val KEY_CLICS = "clicks"
        private const val KEY_USERNAME =  "name"
    }

    fun addScore(points: Long){
        val currentScore = getScore()
        val newScore = currentScore + points
        prefs.edit()
            .putLong(KEY_SCORE, newScore)
            .apply()
    }
    fun getScore(): Long{
        return prefs.getLong(KEY_SCORE, 0L)
    }
    fun addClick(clicks: Long){
        val currentClick = getClick()
        val newClick = currentClick + clicks
        prefs.edit()
            .putLong(KEY_CLICS, newClick)
            .apply()
    }
    fun getClick(): Long{
        return prefs.getLong(KEY_CLICS, 0L)
    }
}