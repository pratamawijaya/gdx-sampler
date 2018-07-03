package com.pratamawijaya.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.pratamawijaya.GdxModuleInfoSample
import com.pratamawijaya.GdxSamplerGame

object DesktopLauncherGdxModuleInfoSample {

    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        LwjglApplication(GdxModuleInfoSample(), config)
    }
}
