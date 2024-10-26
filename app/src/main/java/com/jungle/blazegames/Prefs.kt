package com.jungle.blazegames

object Prefs {
    private lateinit var sharedPrefs: android.content.SharedPreferences

    fun init(context: android.content.Context) {
        sharedPrefs = context.getSharedPreferences("gamee", android.content.Context.MODE_PRIVATE)
    }

    var musicVolume: Float
        get() = sharedPrefs.getFloat("musicVolume", 0.5f)
        set(value) = sharedPrefs.edit().putFloat("musicVolume", value).apply()
    var soundVolume: Float
        get() = sharedPrefs.getFloat("soundVolume", 0.3f)
        set(value) = sharedPrefs.edit().putFloat("soundVolume", value).apply()

    // Прохождение уровня
    fun passLevel(level: Int, onUnlockAchievement: (String) -> Unit) {
        sharedPrefs.edit().putBoolean("level$level", true).apply()
        unlockAchievements(level, onUnlockAchievement) // Открытие ачивок при прохождении уровня
    }

    // Проверка доступности уровня
    fun isLevelAvailable(level: Int): Boolean {
        if (level == 1) return true
        return sharedPrefs.getBoolean("level${level - 1}", false)
    }

    // Последний пройденный уровень
    val lastLevel: Int
        get() {
            for (i in 1..43) {
                if (!isLevelAvailable(i)) {
                    return i - 1
                }
            }
            return 43
        }

    // Логика для открытия ачивок
    private fun unlockAchievements(level: Int, onUnlockAchievement: (String) -> Unit) {
        when (level) {
            1 -> unlockAchievement("Jungle Explorer", onUnlockAchievement)
            10 -> unlockAchievement("Dragon Slayer", onUnlockAchievement)
            15 -> unlockAchievement("Keeper of the Flame", onUnlockAchievement)
            20 -> unlockAchievement("Wild Tamer", onUnlockAchievement)
            25 -> unlockAchievement("Scale Collector", onUnlockAchievement)
            30 -> unlockAchievement("King of the Canopy", onUnlockAchievement)
            35 -> unlockAchievement("Dragon's Hoard", onUnlockAchievement)
            43 -> unlockAchievement("Leafy Lurker", onUnlockAchievement)
            // Добавьте другие уровни и ачивки по мере необходимости
        }
    }

    // Открытие ачивки
    private fun unlockAchievement(achievementName: String, onUnlockAchievement: (String) -> Unit) {
        if (!isAchievementUnlocked(achievementName)){
            onUnlockAchievement(achievementName)
            sharedPrefs.edit().putBoolean(achievementName, true).apply()
        }
    }

    // Проверка, открыта ли ачивка
    fun isAchievementUnlocked(achievementName: String): Boolean {
        return sharedPrefs.getBoolean(achievementName, false)
    }
}
