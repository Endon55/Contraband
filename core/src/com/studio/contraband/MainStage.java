package com.studio.contraband;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import javafx.stage.Stage;

public class MainStage extends Stage
{

    SpriteBatch batch;
    Texture img;


    public MainStage()
    {
        batch = new SpriteBatch();
        img = new Texture("ankheg.jpg");

        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
        batch.dispose();
        img.dispose();
    }


    public void draw()
    {


    }


}
