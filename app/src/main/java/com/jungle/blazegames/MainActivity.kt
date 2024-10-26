package com.jungle.blazegames

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jungle.blazegames.ui.theme.JungleBlazeTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Prefs.init(application)
        SoundManager.init(application)
        setContent {
            JungleBlazeTheme {
                val navController = rememberNavController()
                MainNavHost(navController)
            }
        }
    }

    @Composable
    fun MainNavHost(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "loading") {
            composable("loading") {
                LoadingScreen {
                    navController.navigate("menu") {
                        popUpTo("loading") {
                            inclusive = true
                        }
                    }
                }
            }
            composable("menu") {
                MenuScreen(
                    onPlay = {
                        navController.navigateSound("level/${Prefs.lastLevel}")
                    },
                    onLevels = {
                        navController.navigateSound("levels")
                    },
                    onSettings = {
                        navController.navigateSound("settings")
                    },
                    onAchievements = {
                        navController.navigateSound("achievements")
                    },
                    onExit = {
                        navController.navigateSound("exit")
                    }
                )
            }
            composable("levels") {
                LevelsScreen(
                    onBack = {
                        navController.popSound()
                    },
                    onLevel = { level ->
                        navController.navigateSound("level/$level")
                    }
                )
            }
            composable("level/{level}") {
                val level = it.arguments?.getString("level")!!.toInt()
                GameScreen(level = level,
                    onBackClick = {
                        navController.popSound()
                    },
                    onHomeClick = {
                        navController.navigateSound("menu") {
                            popUpTo("levels") {
                                inclusive = true
                            }
                        }
                    },
                    onLevel = {
                        navController.navigateSound("level/$it") {
                            popUpTo("levels/$level") {
                                inclusive = true
                            }
                        }
                    }
                )
            }
            composable("settings") {
                SettingsScreen(
                    onBack = {
                        navController.popSound()
                    }
                )
            }
            composable("achievements") {
                DragonAchievementsGrid {
                    navController.popSound()
                }
            }
            composable("exit") {
                ExitScreen(
                    onBack = {
                        navController.popSound()
                    }
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        SoundManager.resumeMusic()
    }

    override fun onPause() {
        super.onPause()
        SoundManager.pauseMusic()
    }

    override fun onDestroy() {
        super.onDestroy()
        SoundManager.onDestroy()
    }
}


fun NavHostController.navigateSound(route: String, block: NavOptionsBuilder.() -> Unit = {}) {
    SoundManager.playSound()
    navigate(route) {
        block()
    }
}

fun NavHostController.popSound() {
    SoundManager.playSound()
    popBackStack()
}

@Composable
fun LoadingScreen(
    onBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(2000)
        onBack()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.loading),
                contentScale = ContentScale.Crop
            )
    )
}