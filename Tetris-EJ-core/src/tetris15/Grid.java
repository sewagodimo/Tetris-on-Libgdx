/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris15;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import shapes.Shape;

/**
 *
 * @author Sewagodimo
 */
public class Grid {

    Block[][] gridBlocks = new Block[8][14];
    ;
    Vector2 vect;
public int score;
    public Block[][] getGridBlocks() {
        return gridBlocks;
    }

    public void setGridBlocks(Block[][] gridBlocks) {
        this.gridBlocks = gridBlocks;
    }

    public Vector2 getVect() {
        return vect;
    }

    public void setVect(Vector2 vect) {
        this.vect = vect;
    }
   
    
   Rectangle rect;
//    public Rectangle getRect() {
//        return rect;
//    }
////public void addShape(Shape shape){
//    for(Block blob: shape.getBlocks()){
//        float x = blob.getPos().x;
//        float y = blob.getPos().y;
//     //   gridBlocks.get
//        gridBlocks.add(blob);
//    }
//}
//    public void setRect(Rectangle rect) {
//        this.rect = rect;
//    }
 

    public Grid() {//screen sizes
        score=-1;
        for (int y = 0; y < 14; y++) {
            for (int x = 0; x < 8; x++) {
      Block blob = new Block(new Vector2(50 + 50 * x, 25 + y * 50));
                blob.recolor(Color.CLEAR);

               // blocks[y][x] = (blob);
                gridBlocks[x][y]=(blob);
            }
//50 + 50 * x, 25 + y * 50)
        }
    }
 public void intoGrid(Shape shape){
     for( Block[] blocks: shape.getBlocks()){
         for(Block blob : blocks){
             if(blob.getColor()!= Color.CLEAR){
             int x = ((int)blob.getPos().x)-50;
             x= (int)x/50;
               int y =((int)blob.getPos().y)-25;
               y = (int)y/50;
                 System.out.println("trying to add at x: "+ x+" and y: "+y);
               gridBlocks[x][y].recolor(blob.getColor());
               score+=5;
         }
     }

     }
 }
// public int score = 0;
 public int getScore(){
     return score;
 }
 public void removeFullLevels(int ybottom, int ytop){
     for(int y = ybottom;y<ytop;y++){//only search in areas of insertion
         boolean clear = true;
         for(int x = 0;x<8;x++){
             if(gridBlocks[x][y].getColor()== Color.CLEAR)
                clear = false;
         }
         if(clear ==true){
             //full level found, needs clearing
             score+=100;
             for(int j = y;j<14;j++){
                  for(int x = 0;x<8;x++){
                      if(j ==13){
                        //  add a clear line
                             gridBlocks[x][j].recolor(Color.CLEAR);
                      }
                      else{//need to run deep level copies
                       //   for(int i = 0;i<8;i++){
                 //gridBlocks[x][j] = gridBlocks[x][j+1];
                  gridBlocks[x][j].recolor(gridBlocks[x][j+1].getColor());
                   //   }
             }
             }
     }
      //    level= true;
      
    }    

    //    System.out.println("Block location not found");
     //   return null;
} 
 }
public boolean gameOver(){
    for(int x = 0;x<8;x++){
        if(gridBlocks[x][13].getColor()!=Color.CLEAR)
        return true;
    }
    return false;
}


}