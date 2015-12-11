/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris15;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Shape;
import sun.util.logging.PlatformLogger.Level;

/**
 *
 * @author Sewagodimo
 */
public class Block {
    Vector2 pos = new Vector2();
   Rectangle   rect = new Rectangle();;
 public Color col = (Color.CLEAR);
 public void recolor(Color col){
     this.col = col;
 }
 public Color getColor(){
     return col;
 }
    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public Rectangle getRect() {
        return rect;
    }
//public void setCol(Color col){
//    
//}
    //pos.x
    public void setRect(Rectangle rect) {
        this.rect = rect;
    }
   public final static float size = 50f;
   public Block(Vector2 v){
       pos= v;
 //      rect = new Rectangle();
//       rect.x = pos.x;
//       rect.y = pos.y;
  // col;
       this.rect.height = size;
       this.rect.width = size;//we do not know the position yet
   }
   
     //defualt moves for a block// for those that have actionListener
        public void moveLeft(){
          //take the element, check to see if there is space and move it width-1;
         
      //   if(pos.x+50<=450)
             pos.x -=size;
           //  System.out.println(pos.x);
      }
         public void moveRight(){
          //take the element, check to see if there is space and move it width+1;
      //       s = new Rectangle(x, y, width, height)
    //   if(pos.x-50>=50)
             this.pos.x +=size;
      }
         public void fall(){
         //decrease the s.y value
             if(pos.y>50)
             pos.y = pos.y-50;
        
         }
       
     public  void rotate(){
            //what is the logic behind rotation???
        //can we atually rotate blocks
         }
}
