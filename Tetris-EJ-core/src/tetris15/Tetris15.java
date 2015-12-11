package tetris15;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.utils.Array;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import tetris15.Screens.MainMenu;
import tetris15.Screens.PlayScreen;

import tetris15.Screens.SplashScreen;
//import 
public class Tetris15 extends Game  {
	//Game manages screens
public	SpriteBatch batch;
	Texture img;
        public int hallSize=5;
         public BitmapFont font;
	public static final String VERSION = "CSC2003S-2015 Tetris Elite Edition";
	public static final String LOG = "Tetris Revolution";
	public Music themeSong;
     public  HashMap<Integer,String> famers = new HashMap();
        public OrthographicCamera camera;
     // private  Rectangle rect;
      ShapeRenderer shape ;
      Array<Vector2> vect;//a 2d of vectors
      public int level;
//      private Square sqr;
       public void setHallSize(int ext){
            hallSize = ext;}
      // public int getHallSize(){
      
        @Override
       
	public void create () {
         //   batch = new SpriteBatch();
        //Use LibGDX's default Arial font.
            camera = new OrthographicCamera();
   camera.setToOrtho(false, 800, 480);
        font = new BitmapFont();
		//setScreen(new SplashScreen(this));
        setScreen(new SplashScreen(this));
		batch = new SpriteBatch();
                img = new Texture(Gdx.files.internal("tetris.jpeg"));
      themeSong = Gdx.audio.newMusic(Gdx.files.internal("tetrissong.mp3"));
      themeSong.setLooping(true);
      themeSong.play();
		
	}
       
        public void addToHall(String name, int score){
         //   if(famers.isEmpty()| famers.size() <5)
            //    famers.put( score,name);
            try{
             FileWriter writer = new FileWriter("famers.txt");
               writer.append(score+" "+name);}
            catch(IOException e){
            }
          //  else{ for(int i = 0;i<famers.size();i++){
               
         //   }}
        }
        public HashMap<Integer,String> intitialiseFamers(){
    try {
        Scanner sc = new Scanner(new FileReader("famers.txt"));
        while(sc.hasNextLine()){
            famers.put(sc.nextInt(), sc.next());
        }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Tetris15.class.getName()).log(Level.SEVERE, null, ex);
    }
//            //convert to list
//            LinkedList<Map.Entry<String, Integer>> list = 
//                    new LinkedList<Map.Entry<String,Integer>>(famers.entrySet());
//            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
//                public int compare(Map.Entry<String, Integer>o1,
//                        Map.Entry<String,Integer>o2){
//                    return (o1.getValue()).compareTo(o2.getValue());
//                }
//                }
//                    //convert sorted map back to a map
            Map<Integer,String> treeMap = new TreeMap<Integer,String>(
			new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}

		});
		treeMap.putAll(famers);
//treeMap.
		return (HashMap<Integer, String>) (treeMap);

                    
            }
        
   public void dispose() {
        batch.dispose();
        font.dispose();
    }
//	public void render () {
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
//	}
	public void resize(int w, int h){}
	public void pause(){}
	public void resume(){}
//        public void spawnBlock(float delta) {
//
//       rect = new Rectangle();
//        rect.width = 40f;
//        rect.height = 40f;
//        this.setPosition(1000 / 2 - rect.width / 2, rect.height);
//
//        boolean isFalling = true;
//
//       // for(int i = Tetris15.HEIGHT; i > 0; --i) {
//            rect.y -= (fallSpeed * delta);
//
//            if(Gdx.input.isKeyJustPressed(Keys.LEFT) && isFalling) {
//                stepLeft();
//            }
//            if(Gdx.input.isKeyJustPressed(Keys.RIGHT) && isFalling) {
//                stepRight();
//            } 
//            if(Gdx.input.isKeyPressed(Keys.DOWN)) {
//                setDown();
//            }
//
//            if(rect.x < 0) rect.x = 0;
//            if(rect.x > Tetris15.WIDTH - box.width) box.x = Tetris15.WIDTH - rect.width;
//            if(rect.y < 0) {
//                rect.y = 0;
//                isFalling = false;
//                blocks.add(box); 
//
//
//
//            
//        }
//       }
          
    

    private void stepRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void stepLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
