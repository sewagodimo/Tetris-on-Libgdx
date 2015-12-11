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
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import shapes.LShape;
import shapes.Shape;
import shapes.SqrShape;
import shapes.TShape;
import tetris15.Block;
import tetris15.Grid;
import tetris15.GridRenderer;
import tetris15.Tetris15;

/**
 * * @author Sewagodimo
 */
public class PlayScreen implements Screen{
    long time = TimeUtils.nanoTime();
    Grid grid = new Grid();
    Array<Block> shapeList = new Array<Block>();
    private OrthographicCamera cam;
    ShapeRenderer debug = new ShapeRenderer();
    ShapeRenderer shapedraw = new ShapeRenderer();
  //  SpriteBatch batch;// = new SpriteBatch();
Shape tetris = new Shape();
    Tetris15 game;
    Array<Rectangle> shape;
    int score;
 //   SpriteBatch batch = new SpriteBatch();
    Rectangle rect;
  //  Stage playStage, controlStage;
    Sprite splashSprite;
    Texture splashTexture;
    ShapeRenderer gridx;
 //   Grid grid=new Grid();
    GridRenderer grider= new GridRenderer();
    public PlayScreen(Tetris15 game){
        this.game = game;
    }
    public void dispose(){
    }

    @Override
    public void show() {
         splashTexture = new Texture(Gdx.files.internal("tetris.jpeg" ));//else png
		splashTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		splashSprite = new Sprite(splashTexture);
                splashSprite.setColor(1, 1, 1, 0);
		splashSprite.setOrigin(splashSprite.getWidth()/2, splashSprite.getHeight()/2);
		splashSprite.setPosition(500, 750);//put image in the center ofscreen
		//batch  = new SpriteBatch();
 
    }

    @Override
    public void render(float delta) {
     //   throw new UnsupportedOperationException("Not supported yet.");
        //To change bwody of generated methods, choose Tools | Templates.
         Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       
     //   batch.begin();
      
       int y = 700;
     
    //  batch = new SpriteBatch();
      //  game.font.draw(game.batch,"you are not playing tetris : ", 500,700);
     //batch.end();
      game.batch.begin();
          game.font.setColor(tetris.getCol());
          game.batch.draw(new Texture(Gdx.files.internal("home.jpeg")),500,y );
     game.font.draw(game.batch,"Score : "+grid.getScore(), 500,y-250);
     game.font.draw(game.batch,"ROTATE : UP_ARROW", 500,y-300);
      game.font.draw(game.batch,"MOVE LEFT : LEFT_ARROW", 500,y-350);
       game.font.draw(game.batch,"MOVE RIGHT : RIGHT_ARROW", 500,y-400);
          game.font.draw(game.batch,"NEW GAME : Q", 500,y-500);
        game.font.draw(game.batch,"INCREASE SHAPE SPEED : DOWN_ARROW", 480,y-450);
      
          game.font.draw(game.batch,"PAUSE OR MAIN MENU : ENTER", 440,y-500); 
       game.batch.end();
        //try {
              for (Block[] blocks : grid.getGridBlocks()) {
            for (Block block : blocks) {
             Rectangle rectShape = block.getRect();
              float x1 = block.getPos().x + rectShape.x;
            float y1 = block.getPos().y + rectShape.y;
            //debug.begin();
             // Color check = block.col;
            
//           if(block.getColor()==Color.GRAY | block.getColor()==Color.PURPLE
//                |   block.getColor()==Color.PINK | block.getColor()==Color.YELLOW
//                      |   block.getColor()==Color.RED | block.getColor()==Color.GREEN)
           if(block.getColor()!= Color.CLEAR)
           {
                debug.begin(ShapeType.Filled);
              debug.setColor(block.getColor());
              debug.rect(x1, y1, rectShape.width, rectShape.height);
                   debug.end();
                 //System.out.println("rect width: "+rect.height);
               //Shape. 
         //       if(   Gdx.input.isKeyPressed())
                //   Gdx.input.getInputProcessor();
          //         if(Gdx.input.isKeyPressed(keys.LEFT))s
           }
           else {
                debug.begin(ShapeType.Line);
             
              debug.setColor(block.getColor());
             // debug.setColor(block.col);
              debug.rect(x1, y1, rectShape.width, rectShape.height);
                   debug.end();
               //
           }
           }}
//        //Draw that shapes that have been taken
//        for(Block shaper: shapeList){
//             Rectangle  rect = shaper.getRect();
//               float x1 = shaper.getPos().x + rect.x;
//            float y1 = shaper.getPos().y + rect.y;
//             shapedraw.begin(ShapeType.Filled);
//             
//              shapedraw.setColor(shaper.getColor());
//             // debug.setColor(block.col);
//            shapedraw.rect(x1, y1, rect.width, rect.height);
//                   shapedraw.end();
     //   }
      //s     START RENDERING SHAPES
          
           for(Block[] block: tetris.getBlocks()){
               for(Block blob: block){
                    if(blob.getColor()!=Color.CLEAR){
                 Rectangle  rectShape = blob.getRect();
                    float x1 = blob.getPos().x + rectShape.x;
            float y1 = blob.getPos().y + rectShape.y;
             //   shapedraw.begin();
            
               shapedraw.begin(ShapeType.Filled);
            
              shapedraw.setColor(blob.getColor());
             // debug.setColor(block.col);
            shapedraw.rect(x1, y1, rectShape.width, rectShape.height);
                   shapedraw.end();
             }
           }
           }
  //      long   timeBefore = TimeUtils.nanoTime();
       
           Gdx.input.getInputProcessor();
           if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
               if(tetris.canMoveLeft())
               tetris.leftClick();}
           else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
               if(tetris.canMoveRight())//check if it is allowed to move first
               tetris.rightClick();}
           else if (Gdx.input.isKeyPressed(Input.Keys.UP))
          tetris.rotate();
            else if (Gdx.input.isKeyPressed(Input.Keys.Q)){
                grid = new Grid();
                tetris = newShape();
            }else    if (Gdx.input.isKeyPressed(Input.Keys.ENTER)){
           //     Gdx.graphics.
              game.setScreen(new MainMenu(game));
         // super.pause();
            dispose();
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.ENTER)){
           //     Gdx.graphics.
               
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            //    if(canFall()==true)
          tetris.fall(grid);
            else  if(canFall()==false){
                   intoGrid();
                  
                       tetris =  newShape(); 
//                for(Block[] blob: tetris.getBlocks()){
          }
          else 
               if(TimeUtils.nanoTime()-time>1000000000){  
         tetris.fall(grid);
         time = TimeUtils.nanoTime();
   //       tetris.wait((long) 0.03);
    //     ssss
          }
      
        
      
   //     if(TimeUtils.nanoTime()-timeBefore>1000000)
  
        }
      
      

    @Override
    public void resize(int width, int height) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hide() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
   public Shape newShape(){
      int shapeInt= (int) (Math.random()*10);
      if(shapeInt>=5)
          shapeInt = 10-shapeInt;
      if(shapeInt ==1|shapeInt==0)
          return new Shape();
      if(shapeInt ==2|shapeInt==5)
          return new SqrShape();
      if(shapeInt ==3)
          return new LShape();
      if(shapeInt ==4)
          return new TShape();
      else
          return new LShape();
      
  }
//  public boolean onfloor(Shape tetr){
//      boolean here = true;
//      //takes the shaper, check if its point below the shape is busy
//      for(Block blo: tetr.getBlocks()){
//          if(shapeList.contains(blo, true)){
//          }
//      }
//      return here;
 // }
        // return image;
  public void intoGrid(){
      for( Block[] blocks: tetris.getBlocks()){
         for(Block blob : blocks){
             if(blob.getColor()!= Color.CLEAR){
             int x = ((int)blob.getPos().x)-50;
             x= (int)x/50;
               int y =((int)blob.getPos().y)-25;
               y = (int)y/50;
          //       System.out.println("trying to add at x: "+ x+" and y: "+y);
               grid.getGridBlocks()[x][y].recolor(blob.getColor());
         }
     }
//check if a grid level is full
      grid.score+=10;   
     }
      int ybottom = (int)tetris.getBlocks()[0][2].getPos().y-25;
        int top = (int)tetris.getBlocks()[0][0].getPos().y-25;
       grid.removeFullLevels((int)ybottom/50,(int)top/50+1);
       if(grid.gameOver()){
           Long time = TimeUtils.nanoTime();
                   while(TimeUtils.nanoTime()-time<1000000000){
                       Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
           game.batch.begin();
           game.font.draw(game.batch, "GAME OVER! GAME OVER!", 540, 300);
           game.batch.end();
      //     time = TimeUtils.nanoTime();
                   }
               
                   if (score>1000){
                       //add to hall of fame
                       TextField text = new TextField("Enter your name",new TextField.TextFieldStyle());
text.setTextFieldListener(new TextFieldListener() {

            @Override
            public void keyTyped(TextField textField, char key) {
                    txtVal= textField.getText();
            }
        });
game.addToHall(txtVal, score);
                   }
           grid = new Grid();
           tetris = newShape();
    }
  }
     String txtVal = "newby1";
public boolean canFall(){//it 
  //  boolean landed = false;
    if(tetris.getBlocks()[1][2].getPos().y <=25)
        return false;
      for( Block[] blocks: tetris.getBlocks()){
         for(Block blob : blocks){
             if(blob.getColor()!= Color.CLEAR){
             int x = ((int)blob.getPos().x)-50;
             x= (int)x/50;
               int y =((int)blob.getPos().y)-25;
               y = (int)y/50;
          //       System.out.println("trying to add at x: "+ x+" and y: "+y);
               if(grid.getGridBlocks()[x][y-1].getColor()!=Color.CLEAR){
                   return false;
               }
             //ssss  grid.getGridBlocks()[x][y].recolor(blob.getColor());
         }
     }
       

     }
        return true;//permission to fall granted
}  

 

 
}
