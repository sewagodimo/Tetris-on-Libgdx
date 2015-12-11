/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris15.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import java.util.HashMap;
import tetris15.Grid;
import tetris15.Tetris15;

/**
 *
 * @author Sewagodimo
 */
public class Settings implements Screen{
     Tetris15 game;
    public Settings(Tetris15 game){
        this.game = game;
    }

    @Override
    public void show() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(float delta) {
           Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       
     //   batch.begin();
      
       int y = 800;
     
    //  batch = new SpriteBatch();
      //  game.font.draw(game.batch,"you are not playing tetris : ", 500,700);
     //batch.end();
      game.batch.begin();
          game.font.setColor(Color.PURPLE);
       //   game.batch.draw(new Texture(Gdx.files.internal("settings.jpeg")),500,y );
            game.font.draw(game.batch,"TETRIS SETTINGS", 300,450);
     game.font.draw(game.batch,"SOUND: Press  V(on) and X(mute)", 300,400);
     game.font.draw(game.batch,"CHANGE LEVEL: L", 300,350);
      game.font.draw(game.batch,"Extend HALL OF FAME: H", 300,300);
         game.font.draw(game.batch,"NEW GAME : Q", 300,250);
         //  game.font.draw(game.batch,"CHANGE BACKGROUND: B", 550,y-500); 
          game.font.draw(game.batch,"MAIN MENU : M", 300,200); 
       game.batch.end();
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   //what to do with user input
            Gdx.input.getInputProcessor();
           if(Gdx.input.isKeyPressed(Input.Keys.V)){
              game.themeSong.play();
              // tetris.leftClick();
           }
           else if (Gdx.input.isKeyPressed(Input.Keys.X)){
               game.themeSong.pause();
           }
           else if (Gdx.input.isKeyPressed(Input.Keys.L)){}
        //  recieve user input;
            else if (Gdx.input.isKeyPressed(Input.Keys.H)){
                game.famers = new HashMap();//cleared hall of fame
                 TextField text = new TextField("Enter size of hall of fame",new TextField.TextFieldStyle());
text.setTextFieldListener(new TextField.TextFieldListener() {

            @Override
            public void keyTyped(TextField textField, char key) {
                    game.hallSize=Integer.parseInt(textField.getText());
            }
        });
            }else    if (Gdx.input.isKeyPressed(Input.Keys.M)){
           //     Gdx.graphics.
              game.setScreen(new MainMenu(game));
         // super.pause();
            dispose();
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.Q)){
           game.setScreen(new PlayScreen(game));
         // super.pause();
               
            }
      
    }

    @Override
    public void resize(int width, int height) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pause() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume() {
  //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hide() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose() {
        game.batch.dispose();
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
