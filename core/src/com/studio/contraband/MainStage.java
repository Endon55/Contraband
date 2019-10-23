package com.studio.contraband;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MainStage extends Stage
{

    SpriteBatch batch;
    Background background;


    public MainStage()
    {
        batch = new SpriteBatch();
        background = new Background();
    }
    public void draw()
    {
        batch.begin();
        //background.draw(batch);
        batch.end();
    }

    public void dispose()
    {
        batch.end();
        batch.dispose();
    }

}
