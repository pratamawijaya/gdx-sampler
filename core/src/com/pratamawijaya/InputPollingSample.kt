package com.pratamawijaya

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport

class InputPollingSample : ApplicationListener {

    lateinit var camera: OrthographicCamera
    lateinit var viewport: Viewport
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont

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
        // mouse touch x/y
        val mouseX = Gdx.input.x
        val mouseY = Gdx.input.y

        // arrow
        val leftPressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT)
        val rightPressed = Gdx.input.isButtonPressed(Input.Buttons.RIGHT)

        font.draw(batch,
                "Mouse/Touch x=$mouseX y=$mouseY",
                20f,
                720 - 20f)

        font.draw(batch,
                if (leftPressed) "left button pressed" else "left button not pressed",
                20f,
                720 - 50f)

        font.draw(batch,
                if (rightPressed) "right button pressed" else "right button not pressed",
                20f,
                720 - 80f)

        // keys
        val wKeyPressed = Gdx.input.isKeyPressed(Input.Keys.W)
        val aKeyPressed = Gdx.input.isKeyPressed(Input.Keys.A)
        val sKeyPressed = Gdx.input.isKeyPressed(Input.Keys.S)
        val dKeyPressed = Gdx.input.isKeyPressed(Input.Keys.D)


        font.draw(batch,
                if (wKeyPressed) "w key button pressed" else "w key button not pressed",
                20f,
                720 - 110f)
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun dispose() {
        batch.dispose()
        font.dispose()
    }
}