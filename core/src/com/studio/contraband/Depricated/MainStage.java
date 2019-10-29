package com.studio.contraband.Depricated;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.studio.contraband.Background;

public class MainStage extends Stage
{

    SpriteBatch batch;
    Background background;
    Camera camera;
    Viewport viewport;
    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    BitmapFont font;
    ShapeRenderer shapeRenderer;


    public MainStage()
    {
        Gdx.input.setInputProcessor(this);
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        background = new Background();
        camera = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        viewport.apply();

        Vector3 world = new Vector3(0,0,0);
        System.out.println(camera.project(world));
        Vector3 screen = new Vector3(0,0,0);
        System.out.println(camera.unproject(screen));

        generator = new FreeTypeFontGenerator(Gdx.files.internal("asman.TTF"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 72;
        parameter.color = Color.BLUE;
        font = generator.generateFont(parameter);
        generator.dispose();

    }
    public void draw()
    {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        background.draw(batch);
        font.draw(batch, "yoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo", 0f, 0f);
        DrawRect(0, 0, 5, 5, Color.RED);


        batch.end();
    }

    public void dispose()
    {
        font.dispose();
        batch.dispose();
    }

    public void DrawRect(int x, int y, int width, int height, Color color)
    {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(x,y, width, height);
        shapeRenderer.end();
    }
}
