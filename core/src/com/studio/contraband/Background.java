package com.studio.contraband;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background
{

    Texture backgroundTexture;

    public Background()
    {
        backgroundTexture = new Texture("ankheg.jpg");
    }

    public void draw(SpriteBatch batch)
    {
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

}
