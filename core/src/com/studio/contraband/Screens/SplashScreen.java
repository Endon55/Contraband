package com.studio.contraband.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.studio.contraband.AndroidCamera;

public class SplashScreen implements Screen
{
    private int WIDTH;
    private int HEIGHT;
    private Texture splashTexture;
    private Image splashImage;

    Stage splashStage;

    @Override
    public void show()
    {

        WIDTH = 1280;
        HEIGHT = 720;

        splashTexture = new Texture(Gdx.files.internal("ContrabandLogo.png"));
        splashTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        splashImage = new Image(splashTexture);
        splashImage.setSize(1280,720);

        splashStage = new Stage(new FitViewport(WIDTH, HEIGHT, new AndroidCamera(WIDTH, HEIGHT)));
        splashStage.addActor(splashImage);

        splashImage.addAction(Actions.sequence(Actions.alpha(0.0F), Actions.fadeIn(1.25F),Actions.delay(1F), Actions.fadeOut(0.75F), Actions.run(new Runnable() {
            @Override
            public void run() {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenuScreen());
            }
        })));
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        splashStage.act();
        splashStage.draw();
    }

    @Override
    public void resize(int width, int height)
    {
        splashStage.getViewport().update(width, height, true);
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {

    }
}
