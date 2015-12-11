/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris15;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
//import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import shapes.TShape;
import shapes.LShape;

import shapes.Shape;
import shapes.SqrShape;

/**
 *
 * @author Sewagodimo
 */
public class GridRenderer {
long time = TimeUtils.nanoTime();
    Grid grid = new Grid();
    Array<Block> shapeList = new Array<Block>();
    private OrthographicCamera cam;
    ShapeRenderer debug = new ShapeRenderer();
    ShapeRenderer shapedraw = new ShapeRenderer();
    SpriteBatch batch = new SpriteBatch();
Shape tetris = new Shape();
    public GridRenderer() {
      //  this.grid = grid;
    //         this.cam = new OrthographicCamera(450,800);
        //         this.cam.position.set(25, 50f, 0);
//             this.cam.update();
    }
 //   SpriteBatch batch = new SpriteBatch();
    
    Texture image;

    public void render() throws InterruptedException {
   //  cam.update();
        //      debug.setProjectionMatrix(cam.combined);

      //   debug.begin(ShapeType.Line);
        //  debug.begin(ShapeType.Filled);
        
        for (Block[] blocks : grid.getGridBlocks()) {
            for (Block block : blocks) {
             Rectangle rect = block.getRect();
              float x1 = block.getPos().x + rect.x;
            float y1 = block.getPos().y + rect.y;
            //debug.begin();
             // Color check = block.col;
            
//           if(block.getColor()==Color.GRAY | block.getColor()==Color.PURPLE
//                |   block.getColor()==Color.PINK | block.getColor()==Color.YELLOW
//                      |   block.getColor()==Color.RED | block.getColor()==Color.GREEN)
           if(block.getColor()!= Color.CLEAR)
           {
                debug.begin(ShapeType.Filled);
              debug.setColor(block.getColor());
              debug.rect(x1, y1, rect.width, rect.height);
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
              debug.rect(x1, y1, rect.width, rect.height);
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
                 Rectangle  rect = blob.getRect();
                    float x1 = blob.getPos().x + rect.x;
            float y1 = blob.getPos().y + rect.y;
             //   shapedraw.begin();
            
               shapedraw.begin(ShapeType.Filled);
            
              shapedraw.setColor(blob.getColor());
             // debug.setColor(block.col);
            shapedraw.rect(x1, y1, rect.width, rect.height);
                   shapedraw.end();
             }
           }
           }
  //      long   timeBefore = TimeUtils.nanoTime();
       
           Gdx.input.getInputProcessor();
           if(Gdx.input.isKeyPressed(Keys.LEFT)){
               if(tetris.canMoveLeft())
               tetris.leftClick();}
           else if (Gdx.input.isKeyPressed(Keys.RIGHT)){
               if(tetris.canMoveRight())//check if it is allowed to move first
               tetris.rightClick();}
           else if (Gdx.input.isKeyPressed(Keys.UP))
          tetris.rotate();
            else if (Gdx.input.isKeyPressed(Keys.Q)){
                grid = new Grid();
                tetris = newShape();
            } else if (Gdx.input.isKeyPressed(Keys.ENTER)){
           //     Gdx.graphics.
               
            }
            else if (Gdx.input.isKeyPressed(Keys.DOWN))
            //    if(canFall()==true)
          tetris.fall(grid);
            else  if(canFall()==false){
                   intoGrid();
                  
                       tetris =  newShape(); 
//                for(Block[] blob: tetris.getBlocks()){
          }
          else if(TimeUtils.nanoTime()-time>1000000000){  
         tetris.fall(grid);
         time = TimeUtils.nanoTime();
   //       tetris.wait((long) 0.03);
    //     ssss
          }
      
        }
      
   //     if(TimeUtils.nanoTime()-timeBefore>1000000)
  
  public Shape newShape(){
      int shape = (int) (Math.random()*10);
      if(shape>=5)
          shape = 10-shape;
      if(shape ==1|shape==0)
          return new Shape();
      if(shape ==2|shape==5)
          return new SqrShape();
      if(shape ==3)
          return new LShape();
      if(shape ==4)
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
       grid.removeFullLevels((int)ybottom/50,(int)top/50);
       if(grid.gameOver()){
           grid = new Grid();
           tetris = newShape();
    }
  }
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