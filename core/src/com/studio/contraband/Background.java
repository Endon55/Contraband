package com.studio.contraband;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background
{

    Texture backgroundTexture;

    public Background()
    {
        backgroundTexture = new Texture("basicBackground.png");
    }

    public void draw(Batch batch)
    {

    }

}
