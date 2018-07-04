package com.pratamawijaya

import com.badlogic.gdx.*
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Logger
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport

class InputListeningSample : ApplicationListener, InputProcessor {

    companion object {
        val log = Logger(InputListeningSample::class.simpleName, Application.LOG_DEBUG)
        val MAX_MESSAGE = 15
    }

    lateinit var camera: OrthographicCamera
    lateinit var viewport: Viewport
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont
    var listMessages = mutableListOf<String>()

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG

        camera = OrthographicCamera()
        viewport = FitViewport(1080F, 720F, camera)
        batch = SpriteBatch()
        font = BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"))

    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun render() {
        // clear screen
        Gdx.gl.glClearColor(0F, 0F, 0F, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.projectionMatrix = camera.combined
        batch.begin()
        draw()
        batch.end()
    }

    private fun draw() {

    }


    override fun pause() {
    }

    override fun resume() {
    }

    override fun dispose() {
        batch.dispose()
        font.dispose()
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        return false
    }

    override fun keyTyped(character: Char): Boolean {
        log.debug("onKeyTyped $character")
        return true
    }

    override fun scrolled(amount: Int): Boolean {
        return false
    }

    override fun keyUp(keycode: Int): Boolean {
        return false
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        return false
    }

    override fun keyDown(keycode: Int): Boolean {
        val message = "key down keycode = $keycode"
        log.debug(message)
        addMessage(message)
        return true
    }

    private fun addMessage(message: String) {
        if (listMessages.size <= MAX_MESSAGE) {
            listMessages.add(message)
        } else {
            listMessages.removeAt(0)
        }
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }
}