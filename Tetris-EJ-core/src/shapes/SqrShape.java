/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import tetris15.Block;

/**
 *
 * @author Sewagodimo
 */
public class SqrShape extends Shape{
    //  int rotation=0;
    public SqrShape(){
  //  public Shape(){
         blocks= new Block[3][3];
        col = this.chooseColor(col);
      
       for(int y = 0;y<3;y++){
           for(int x = 0;x<3;x++){
           Block blob = new Block(new Vector2(200-x*50,675-y*50));
             blob.recolor(col);
           if( y<1|x>1)//only the bottom blocks are colored
               blob.recolor(Color.CLEAR);
           blocks[x][y]=(blob);
           }
       }
    }
   
  //      lastFallTime = TimeUtils.millis();
    //ss  grid.addShape(this);  
       
    
     
//           public void mergeInto(Grid grid){
//               for(Block blob: blocks){
//                  
//                   grid.addBlock(blob);
//               }
//           }
         //  int rotate=0;
    @Override
           public void rotate(){
               
           }

}
