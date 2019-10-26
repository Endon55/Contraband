package com.studio.contraband.Screens;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.studio.contraband.AndroidCamera;

public class MainMenuScreen implements Screen
{

    private Stage mainMenuStage;
    private Skin mainMenuSkinPlay;
    private ImageButton mainMenuImageButtonPlay;
    private Table mainMenuTablePlay;
    private Texture BackgroundTexture;
    private Image BackgroundImage;
    private float WIDTH;
    private float HEIGHT;

    public MainMenuScreen()
    {
    }


    @Override
    public void show()
    {
        WIDTH = 1280;
        HEIGHT = 720;

        BackgroundTexture = new Texture("ContrabandLogo.png");
        BackgroundTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        BackgroundImage = new Image(BackgroundTexture);
        BackgroundImage.setSize(WIDTH, HEIGHT);

        mainMenuStage = new Stage(new FitViewport(WIDTH, HEIGHT, new AndroidCamera(WIDTH, HEIGHT)));
        mainMenuTablePlay = new Table();
        mainMenuSkinPlay = new Skin(Gdx.files.internal("play.json"), new TextureAtlas(Gdx.files.internal("mainMenuPack.atlas")));

        mainMenuImageButtonPlay = new ImageButton(mainMenuSkinPlay);
        mainMenuTablePlay.bottom().add(mainMenuImageButtonPlay).size(152f, 164f).padBottom(20f);

        mainMenuStage.addActor(BackgroundImage);
        mainMenuStage.addActor(mainMenuTablePlay);

        Gdx.input.setInputProcessor(mainMenuStage);

        mainMenuTablePlay.addAction(Actions.sequence(Actions.moveBy(0.0f, -250.0f), Actions.delay(1.0f), Actions.moveBy(0.0f, 250.0f, 1.0f, Interpolation.swing)));
        BackgroundImage.addAction(Actions.sequence(Actions.alpha(0.0f), Actions. fadeIn(1.0f)));

        mainMenuImageButtonPlay.addListener(new ClickListener()
        {
           public void clicked(InputEvent event, float x, float y)
           {
               ((Game)Gdx.app.getApplicationListener()).setScreen((new SplashScreen()));
           }
        });
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mainMenuStage.act();
        mainMenuStage.draw();
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

    }
}
