/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import tetris15.Block;
import tetris15.Grid;

/**
 *
 * @author Sewagodimo
 */
public class Shape {

    long lastFallTime;
    Block[][] blocks = new Block[3][3];
    boolean falling = true;

    public Block[][] getBlocks() {
        return blocks;
    }

    public void setBlocks(Block[][] blocks) {
        this.blocks = blocks;
    }

    public Color getCol() {
        return col;
    }

    public void setCol(Color col) {
        this.col = col;
    }
    Color col;

    public Shape() {
        col = this.chooseColor(col);

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                Block blob = new Block(new Vector2(200 - x * 50, 675 - y * 50));
                blob.recolor(Color.CLEAR);

                blocks[x][y] = (blob);
            }
        }
        blocks[0][0].recolor(col);
        blocks[0][1].recolor(col);
        blocks[0][2].recolor(col);
    }

    public void fall(Grid grid) {
     ///   if(blocks[1][2].getPos().y>=25){
        for (Block[] blob : blocks) {
            for (Block blo : blob) {
                //     if(grid.getBlock(blob)!=Color.BLACK)
                blo.fall();
            }
        }
    //    }
        //      lastFallTime = TimeUtils.millis();
    }

    public void leftClick() {
        for(int y = 0;y<3;y++){
            for(int x = 0;x<3;x++){
                blocks[x][y].getPos().x-=10;
            }
        }
    }

    public void rightClick() {
        for(int y = 0;y<3;y++){
            for(int x = 0;x<3;x++){
                blocks[x][y].getPos().x+=10;
            }
        }
    }

    public boolean landed(Grid grid) {
        //    boolean falling =true;
        //       if(Grid.)
        //  only need to check if the bottom part is filled out
      if(blocks[1][2].getPos().y <=25)
          return false;
      else   return  true; //  grid.addShape(this);
       // return landed;
    }

    public boolean canMoveRight() {
        boolean bo = true;
        for (Block[] blob : blocks) {
            for (Block blo : blob) {
                if (blo.getColor() != Color.CLEAR) {
                    if (blo.getPos().x >= 400) {
                        bo = false;
                    }
                }
            }
        }
        return bo;//dont give up!!
    }

    public boolean canMoveLeft() {
        boolean bo = true;
        for (Block[] blob : blocks) {
            for (Block blo : blob) {
                if (blo.getColor() != Color.CLEAR) {
                    if (blo.getPos().x <= 50) {
                        bo = false;
                    }
                }
            }
        }
        return bo;//dont give up!!
    }

    public Color chooseColor(Color color) {
        int nr = (int) (Math.random() * 10);
        if (nr > 5) {
            nr = 10 - nr;
        }
        if (nr == 1) {
            color = new Color(Color.GREEN);
        } else if (nr == 2) {
            color = new Color(Color.GRAY);
        } else if (nr == 3) {
            color = new Color(Color.PINK);
        } else if (nr == 4) {
            color = new Color(Color.RED);
        } else if (nr == 5) {
            color = new Color(Color.YELLOW);
        } else {
            color = new Color(Color.PURPLE);
        }
        return color;
    }
//           public void mergeInto(Grid grid){
//               for(Block blob: blocks){
//                  
//                   grid.addBlock(blob);
//               }
//           }
    int rotate = 0;
//getting the x and y on the grid
    //50 + 50 * x, 25 + y * 50)
    public void rotate() {
        if (rotate == 0) {
            //   for(int x = 0;x<3;x++){
            blocks[0][0].recolor(Color.CLEAR);
            blocks[0][1].recolor(Color.CLEAR);
            blocks[0][2].recolor(Color.CLEAR);

            blocks[0][2].recolor(col);
            blocks[1][2].recolor(col);
            blocks[2][2].recolor(col);
            //    }
            rotate++;
            // rotate++;
        } else if (rotate == 1) {
            blocks[0][2].recolor(Color.CLEAR);
            blocks[1][2].recolor(Color.CLEAR);
            blocks[2][2].recolor(Color.CLEAR);

            blocks[0][0].recolor(col);
            blocks[0][1].recolor(col);
            blocks[0][2].recolor(col);

            rotate=0;}
//        } else if (rotate == 2) {
//         //   if(blocks[0][0].getPos().x<=50 |(blocks[1][0].getPos().x>=400)){
//            blocks[0][2].recolor(Color.CLEAR);
//            blocks[1][2].recolor(Color.CLEAR);
//            blocks[2][2].recolor(Color.CLEAR);
//
//            blocks[0][0].recolor(col);
//            blocks[0][1].recolor(col);
//            blocks[0][2].recolor(col);
//      //      }
//            rotate++;
//        } else if (rotate == 3) {
//    //          if(blocks[0][0].getPos().x<=50 |(blocks[1][0].getPos().x>=400)){
//            blocks[0][0].recolor(Color.CLEAR);
//            blocks[0][1].recolor(Color.CLEAR);
//            blocks[0][2].recolor(Color.CLEAR);;
//            blocks[0][0].recolor(col);
//            blocks[1][0].recolor(col);
//            blocks[2][0].recolor(col);
//         //     }
//            rotate = 0;
//        }
        }
    }

     
    

//grid of 8 by 15
