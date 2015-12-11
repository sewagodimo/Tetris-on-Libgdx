/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris15.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tetris15.Tetris15;

/**
 *
 * @author Sewagodimo
 */
public class HallOfFame implements Screen {
     Tetris15 game;
    public HallOfFame(Tetris15 game){
        this.game = game;
    }

    @Override
    public void show() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(float delta) {
           Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       
     //   batch.begin();
      
       int y = 400;
     
    //  batch = new SpriteBatch();
      //  game.font.draw(game.batch,"you are not playing tetris : ", 500,700);
     //batch.end();
      game.batch.begin();
          game.font.setColor(Color.PURPLE);
        //  game.batch.draw(new Texture(Gdx.files.internal("leaderboard.jpg")),300,y );
     game.font.draw(game.batch,"THE HALL OF FAME", 250,450);
   //  game.font.draw(game.batch,"CHANGE LEVEL: L", 300,y-300);
   //   for( int i = 0;i<game.famers.size();i++){
        //  y-=300;
          int yummy =0;
        //  for (Map.Entry<Integer, String> entry : game.famers.entrySet()) {
          Scanner scF;
         try {
             scF = new Scanner(new FileReader("famers.txt"));
                while(scF.hasNextLine()){
              game.font.draw(game.batch,  scF.next()
                                      + " : " + scF.next(), 300,y);
                        y-=50;
              if(yummy>=game.hallSize){
                break;}
		yummy++;	
      }
         } catch (FileNotFoundException ex) {
             Logger.getLogger(HallOfFame.class.getName()).log(Level.SEVERE, null, ex);
         }
       
       game.batch.end();
          Gdx.input.getInputProcessor();
                if (Gdx.input.isTouched()) {
            game.setScreen(new MainMenu(game));
          
            dispose();
	}
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resize(int width, int height) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pause() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hide() {
  //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
