package com.neudesic.myapplication

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication: MultiDexApplication() // initial work is done by Dagger-Hilt
