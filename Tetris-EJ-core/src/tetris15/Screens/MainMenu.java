/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris15.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import tetris15.Tetris15;

/**
 *
 * @author Sewagodimo
 */
public class MainMenu implements Screen{

	Tetris15 game;
	Stage stage;
	BitmapFont black;
	BitmapFont white;
	TextureAtlas atlas;
	Skin skin;
	SpriteBatch batch;
	Texture play, settings,HallOfFame,   splashTexture;
       ImageButton playb, settingsb,HallOfFameb;
	Table table;
        Texture texure;
       // private Stage stage;
    private Object GL10;
    
  //  private Object camera;
    //  final Tetris15 game;
//sIsha
    OrthographicCamera camera;

    public MainMenu(final Tetris15 gam) {
        game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
//Isha
    }
  
 
 @Override
    public void render(float delta) {
           Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
//int width = Gdx.graphics.getWidth();
//int height = Gdx.graphics.getHeight();
        game.batch.begin();
        for(int i = 0;i<3;i++){
            
                     int x = (int)(Math.random()*100);
                  int y =    (int)(Math.random()*8);
                  
                 game.batch.draw(splashTexture,x,y );
                   game.batch.draw(splashTexture,x,y );
                    game.batch.draw(splashTexture,  x,y*100);
                 }
       // game.font.draw(game.batch, "Welcome to Tetris!!! ", width/4,height- height/8);
       
      //  batch.draw(Ishape,);
        game.batch.end();
        stage.draw();
           Gdx.input.setInputProcessor(stage);
if(Gdx.input.isTouched())
  game.setScreen(new SplashScreen(game));
          
            dispose();
        }
    
    

    @Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
        //     Texture     splashHome = new Texture(Gdx.files.internal("home.jpeg" ));
            //adding the listeners
         splashTexture = new Texture(Gdx.files.internal("black.jpg" ));
    
            skin = new Skin();
            skin.add("Welcome", new Texture("home.jpeg"));
            skin.add("play", new Texture( Gdx.files.internal("play.jpg")));
             skin.add("settings", new Texture( Gdx.files.internal("setting.png")));
              skin.add("hall", new Texture( Gdx.files.internal("leaderboard.jpg")));
            play = new Texture(Gdx.files.internal("play.jpg"));
       // ActionListener    playlisten = new Action
         //  playb.addListener(new ActionListener);
                settings = new Texture(Gdx.files.internal("setting.png"));
                HallOfFame = new Texture(Gdx.files.internal("leaderboard.jpg"));
                TextureRegion playimage = new TextureRegion(play);
                TextureRegion setimage = new TextureRegion(settings);
                TextureRegion hallimage = new TextureRegion(HallOfFame);
                stage = new Stage(new ScreenViewport());
             //   Gdx.input.setInputProcessor(stage);
               // NinePatch playpatch = new NinePatch(play);
               //  playstyle.imageUp = new TextureRegionDrawable(playimage);
                ImageButtonStyle playstyle = new ImageButtonStyle( new TextureRegionDrawable(playimage), 
                        new TextureRegionDrawable(playimage), new TextureRegionDrawable(playimage), new TextureRegionDrawable(playimage)
                        , new TextureRegionDrawable(playimage), new TextureRegionDrawable(playimage));
                ImageButtonStyle settingstyle = new ImageButtonStyle(new TextureRegionDrawable(setimage),
                        new TextureRegionDrawable(setimage), new TextureRegionDrawable(setimage), 
                        new TextureRegionDrawable(setimage), new TextureRegionDrawable(setimage), 
                        new TextureRegionDrawable(setimage));
                ImageButtonStyle hallstyle = new ImageButtonStyle(new TextureRegionDrawable(hallimage),
                        new TextureRegionDrawable(hallimage), new TextureRegionDrawable(hallimage), 
                        new TextureRegionDrawable(hallimage), new TextureRegionDrawable(hallimage), 
                        new TextureRegionDrawable(hallimage));
            
//               settingstyle.imageUp = new TextureRegionDrawable(setimage);
//                 hallstyle.imageUp = new TextureRegionDrawable(hallimage);
                 playb = new ImageButton(playstyle);
                  settingsb = new ImageButton(settingstyle);
                   HallOfFameb = new ImageButton(hallstyle);
                   playb.setName("play");
                    settingsb.setName("setting");
                     HallOfFameb.setName("hall of fame");
                      playb.addListener(new ClickListener() {

                 public void clicked(InputEvent event, float x, float y) {
        game.setScreen( new PlayScreen(game) );
			}
		});
              settingsb.addListener(new ClickListener() {

                 public void clicked(InputEvent event, float x, float y) {
        game.setScreen( new Settings(game) );
		dispose();
                 }
		});
                HallOfFameb.addListener(new ClickListener() {

                 public void clicked(InputEvent event, float x, float y) {
        game.setScreen( new HallOfFame(game) );
			}
		});
              //       Gdx.graphics.
                     //you can resize the buttons using size(x,)
               
                int x = Gdx.graphics.getWidth()/3;
                int y = Gdx.graphics.getHeight()/5;
                 table = new Table();
                stage = new Stage();
                   table.add(playb).size(x,y).padBottom(20).row();
                   table.add(settingsb).size(x,y).padBottom(20).row();
                   table.add(HallOfFameb).size(x,y).align(x).padBottom(20).row();//to create even spaces btn the uttons
                 table.setFillParent(true);
                   stage.addActor(table);
                      //now we have 3 clickable buttons
	}
        public void dispose(){}
		
}
