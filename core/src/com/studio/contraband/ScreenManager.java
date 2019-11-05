package com.studio.contraband;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;


public class ScreenManager implements Screen
{
    protected Contraband game;
    protected Stage stage;
    protected Table table;
    protected Skin skin;



    public ScreenManager(Contraband game)
    {

        this.game = game;
        stage = new Stage();
        table = new Table();
        table.setFillParent(true);

        //TODO DEBUG
        table.setDebug(true);

        stage.addActor(table);
        skin = new Skin(Gdx.files.internal("GlassySkinUI/glassy-ui.json"));
    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
        stage.draw();
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height)
    {

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
        stage.dispose();
    }




}
