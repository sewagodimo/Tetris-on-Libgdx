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
public class TShape extends Shape {

    //this is actually a t

    int rotation = 0;

    public TShape() {
        col = this.chooseColor(col);

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                Block blob = new Block(new Vector2(200 - x * 50, 675 - y * 50));
                blob.recolor(Color.CLEAR);

                blocks[x][y] = (blob);
            }
        }
            blocks[0][1].recolor(col);
        blocks[1][1].recolor(col);
        blocks[2][1].recolor(col);
        blocks[1][2].recolor(col);//center
    }

//           public void mergeInto(Grid grid){
//               for(Block blob: blocks){
//                  
//                   grid.addBlock(blob);
//               }
//           }
    static int rotateT = 0;

    @Override
    public void rotate() {
        if (rotateT == 0) {
            //   for(int x = 0;x<3;x++){
            blocks[0][1].recolor(Color.CLEAR);
            blocks[1][1].recolor(Color.CLEAR);
            blocks[2][1].recolor(Color.CLEAR);
            blocks[1][2].recolor(Color.CLEAR);
            blocks[2][0].recolor(col);
            blocks[2][1].recolor(col);
            blocks[2][2].recolor(col);
            blocks[1][1].recolor(col);
            //    }
            rotateT++;
            // rotateT++;
        } else if (rotateT == 1) {
            blocks[2][0].recolor(Color.CLEAR);
            blocks[2][1].recolor(Color.CLEAR);
            blocks[2][2].recolor(Color.CLEAR);

            blocks[0][2].recolor(col);
            blocks[1][2].recolor(col);
            blocks[2][2].recolor(col);

            rotateT++;
        } else if (rotateT == 2) {
            blocks[0][2].recolor(Color.CLEAR);
            blocks[1][2].recolor(Color.CLEAR);
            blocks[2][2].recolor(Color.CLEAR);;

            blocks[0][0].recolor(col);
            blocks[0][1].recolor(col);
            blocks[0][2].recolor(col);

            rotateT++;
        } else if (rotateT == 3) {
            blocks[0][0].recolor(Color.CLEAR);
            blocks[0][1].recolor(Color.CLEAR);
            blocks[0][2].recolor(Color.CLEAR);;
          //   blocks[1][1].recolor(col);
        blocks[0][1].recolor(col);
        blocks[2][1].recolor(col);
        blocks[1][2].recolor(col);//center
            rotateT = 0;
        }

    }
}
 //   default shape is L!s

