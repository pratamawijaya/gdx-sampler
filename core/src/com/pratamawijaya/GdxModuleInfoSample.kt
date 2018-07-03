package com.pratamawijaya

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.Logger

class GdxModuleInfoSample : ApplicationListener {

    companion object {
        val log = Logger(GdxModuleInfoSample::class.simpleName, Logger.DEBUG)
    }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
    }

    override fun render() {

    }

    override fun pause() {

    }

    override fun resume() {
    }

    override fun resize(width: Int, height: Int) {
    }


    override fun dispose() {
    }
}