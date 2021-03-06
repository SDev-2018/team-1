package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Audio.AudioPlayer;
import TileMap.Background;
import TileMap.TileMap;
import main.GamePanel;
import GameState.DifficultyState;
import Entity.*;
import Entity.Enemies.Chicken;
<<<<<<< HEAD

// this is the state that brings in all the objects and entities for the level one map
public class Level1State extends GameState {

	private TileMap tileMap;		// bring in the tile map to be used
	private Background bg;			// need a background image 
	
	private Player player;			// create a new player object to be used
	
	private ArrayList<Enemy> enemies;		// create the enemies
	private ArrayList<Explosion> explosions;	// create the explosions for when the enemies die

	private AudioPlayer bgMusic;		// create the various musics that play throughout
	private AudioPlayer nuke;
	private AudioPlayer punchsound;
	
	private HUD hud;					// create the hud to be used
=======
public class Level1State extends GameState {

	private TileMap tileMap;
	private Background bg;
	
	private Player player;
	
	private ArrayList<Enemy> enemies;
	private ArrayList<Explosion> explosions;

	private AudioPlayer bgMusic;
	private AudioPlayer nuke;
	private AudioPlayer punchsound;
	
	private HUD hud;
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
	
	
	public Level1State(GameStateManager gsm){
		
		this.gsm = gsm;
		init();
	}
	
<<<<<<< HEAD
	public void init( ) {								
	  tileMap = new TileMap( 30 );							// initialize the tile map to 30 pixels at a time
      tileMap.loadTiles( "/Tilesets/grasstileset.gif" );	// bring in the tile set to be used
      tileMap.loadMap( "/Maps/level1-1.map" );				// loads a . map file with values to populate the map
	  tileMap.setPosition( 0, 0 );							// set the initial position for the map to populate
	  tileMap.setTween( 1 );								// the tween is a class that helps the camera follow the player around
      
      bg = new Background ("/Backgrounds/grassbg1.gif",1 );	// import the background image
      
      player = new Player(tileMap);							// create the new player to be used and set them at 100,200
      player.setPosition(100,200);
      
	  populateEnemies();									// function created to populate the enemies needed
	  
	  
	  explosions = new ArrayList <Explosion>();				// initializes the explosion array
	  
	  hud = new HUD( player );								// initializes the hud and bases position off the player 
	  
	  bgMusic = new AudioPlayer("/Music/bgmusic.wav");		// initializes the main backround music that will play the whole time
	  bgMusic.play();										// start the music
	  nuke = new AudioPlayer("/Music/nuke.wav");			// initializes the nuke sound effect for when enemies die
	  punchsound = new AudioPlayer("/Music/punch.wav");		// initializes the punch sound effect for when player is punching
	}
	// function created to make an array of enemies and populate the map bases on the value of difficulty in the txt document
	private void populateEnemies(){
		
		int difficultyLVL=1;
		File file3 = new File("difficulty.txt");	// check and see which difficulty is selected
		BufferedReader reader3 = null;
		try{
			reader3 = new BufferedReader(new FileReader(file3));
			String text = null;
			text = reader3.readLine();
			difficultyLVL = Integer.parseInt(text);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(reader3 != null){
					reader3.close();
				}
			}
			catch (IOException e){
				
			}
		}
		
											// populate enemies for easy peasy
		enemies = new ArrayList<Enemy>();
		Chicken s;
		Point[] points;
		if(difficultyLVL==1){
		points = new Point[] {
			new Point(200,200),
			new Point(860,200),
			new Point(975,200),
			new Point(1525, 200),
			new Point(1680,200),
			new Point(1800, 200),
			new Point(2350,200),
			new Point(2800,200),
			new Point(2850,200),
			new Point(3030,200),
			new Point(3060,200)};
		}									// populate enemies for mediocricy is best
		else if(difficultyLVL==2){
			points = new Point[] {
					new Point(150,200),
					new Point(210,200),
					new Point(250,200),
					new Point(815,200),
					new Point(850,200),
					new Point(970,200),
					new Point(995,200),
					new Point(1525, 200),
					new Point(1550,200),
					new Point(1650,200),
					new Point(1670,200),
					new Point(1790, 200),
					new Point(1820,200),
					new Point(2350,200),
					new Point(2375,200),
					new Point(2800,200),
					new Point(2850,200),
					new Point(3030,200),
					new Point(3060,200)
					};
				}
		else{								// populate enemies for youre crazy
			points = new Point[] {
					new Point(125,40),
					new Point(190,200),
					new Point(200,200),
					new Point(210,200),
					new Point(850,200),
					new Point(870,200),
					new Point(890,200),
					new Point(965,200),
					new Point(995,200),
					new Point(1015,200),
					new Point(1525, 200),
					new Point(1540,200),
					new Point(1550,200),
					new Point(1670,200),
					new Point(1690,200),
					new Point(1705,200),
					new Point(1800, 200),
					new Point(1810,200),
					new Point(2350,200),
					new Point(2340,175),
					new Point(2375,200),
					new Point(2400,200),
					new Point(2650,200),
					new Point(2800,200),
					new Point(2850,200),
					new Point(2875,200),
					new Point(3030,200),
					new Point(3060,200),
					};
			}
		
		for(int i = 0; i < points.length; i++){
			s = new Chicken(tileMap, difficultyLVL);
			s.setPosition(points[ i ].x ,points[ i ].y);
			enemies.add(s);
		}
		
		
	}
	
	// update makes sure everything in the map runs smoothly from updating xp to destroying enemies
	public void update( ) {
		player.update();						//keep updating the player on the screen
		if( player.isDead( ) ){
			BufferedWriter out = null;
			try{
				FileWriter fstream = new FileWriter("xp.txt");	// update the xp earned by player
=======
	public void init( ) {
	  tileMap = new TileMap( 30 );
      tileMap.loadTiles( "/Tilesets/grasstileset.gif" );
      tileMap.loadMap( "/Maps/level1-1.map" );
	  tileMap.setPosition( 0, 0 );
	  tileMap.setTween( 1 );
      
      bg = new Background ("/Backgrounds/grassbg1.gif",1 );
      
      player = new Player(tileMap);
      player.setPosition(100,200);
      
	  populateEnemies();
	  
	  
	  explosions = new ArrayList <Explosion>();
	  
	  hud = new HUD( player );
	  
	  bgMusic = new AudioPlayer("/Music/bgmusic.wav");
	  bgMusic.play();
	  nuke = new AudioPlayer("/Music/nuke.wav");
	  punchsound = new AudioPlayer("/Music/punch.wav");
	}
	
	private void populateEnemies(){
		
		int difficultyLVL=1;
		File file3 = new File("difficulty.txt");
		BufferedReader reader3 = null;
		try{
			reader3 = new BufferedReader(new FileReader(file3));
			String text = null;
			text = reader3.readLine();
			difficultyLVL = Integer.parseInt(text);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(reader3 != null){
					reader3.close();
				}
			}
			catch (IOException e){
				
			}
		}
		
		
		enemies = new ArrayList<Enemy>();
		Chicken s;
		Point[] points;
		if(difficultyLVL==1){
		points = new Point[] {
			new Point(200,200),
			new Point(860,200),
			new Point(975,200),
			new Point(1525, 200),
			new Point(1680,200),
			new Point(1800, 200),
			new Point(2350,200),
			new Point(2800,200),
			new Point(2850,200),
			new Point(3030,200),
			new Point(3060,200)};
		}
		else if(difficultyLVL==2){
			points = new Point[] {
					new Point(150,200),
					new Point(210,200),
					new Point(250,200),
					new Point(815,200),
					new Point(850,200),
					new Point(970,200),
					new Point(995,200),
					new Point(1525, 200),
					new Point(1550,200),
					new Point(1650,200),
					new Point(1670,200),
					new Point(1790, 200),
					new Point(1820,200),
					new Point(2350,200),
					new Point(2375,200),
					new Point(2800,200),
					new Point(2850,200),
					new Point(3030,200),
					new Point(3060,200)
					};
				}
		else{
			points = new Point[] {
					new Point(125,40),
					new Point(190,200),
					new Point(200,200),
					new Point(210,200),
					new Point(850,200),
					new Point(870,200),
					new Point(890,200),
					new Point(965,200),
					new Point(995,200),
					new Point(1015,200),
					new Point(1525, 200),
					new Point(1540,200),
					new Point(1550,200),
					new Point(1670,200),
					new Point(1690,200),
					new Point(1705,200),
					new Point(1800, 200),
					new Point(1810,200),
					new Point(2350,200),
					new Point(2340,175),
					new Point(2375,200),
					new Point(2400,200),
					new Point(2650,200),
					new Point(2800,200),
					new Point(2850,200),
					new Point(2875,200),
					new Point(3030,200),
					new Point(3060,200),
					};
			}
		
		for(int i = 0; i < points.length; i++){
			s = new Chicken(tileMap, difficultyLVL);
			s.setPosition(points[ i ].x ,points[ i ].y);
			enemies.add(s);
		}
		
		
	}
	
	
	public void update( ) {
		player.update();
		if( player.isDead( ) ){
			BufferedWriter out = null;
			try{
				FileWriter fstream = new FileWriter("xp.txt");
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
				out = new BufferedWriter(fstream);
				out.write(player.getXP());
			}
			catch(IOException e){
				e.printStackTrace();
			}
			finally{
				if(out!=null){
					try{
						out.close();
					}
					catch(IOException e){
						
					}
				}
			}
<<<<<<< HEAD
			gsm.setState( 0 );									
		}	
		tileMap.setPosition( GamePanel.WIDTH / 2 - player.getx( ),		// makes sure the tile map is updated based on player position
			                 GamePanel.HEIGHT / 2 - player.gety( ));
		
		//set background 
																	
		bg.setPosition( tileMap.getx( ), tileMap.gety( ));				// make sure the background moves and is continuous
		
		player.checkAttack(enemies);									// see if the enemies are being attacked
		Enemy e;
		//update all enemies
		for( int i = 0; i < enemies.size( ); i++ ) {					// update the enemies array and removes when they die
=======
			gsm.setState( 0 );
		}
		tileMap.setPosition( GamePanel.WIDTH / 2 - player.getx( ),
			                 GamePanel.HEIGHT / 2 - player.gety( ));
		
		//set background 

		bg.setPosition( tileMap.getx( ), tileMap.gety( ));
		
		player.checkAttack(enemies);
		Enemy e;
		//update all enemies
		for( int i = 0; i < enemies.size( ); i++ ) {
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
			e = enemies.get(i);
			e.update();
			if(e.isDead()){
				player.incrXP( 5 );
				nuke.play();
				enemies.remove(i);
				i--;
				explosions.add(new Explosion (e.getx(),e.gety()));
			}
		}
		
		//update explosoins
		for(int i =0;i<explosions.size();i++){
			explosions.get(i).update();
			if(explosions.get(i).shouldRemove()){
				explosions.remove(i);
				i--;
			}
		}
		
	}
	public void draw(Graphics2D g ) {
		
      //clear screen
	  bg.draw(g);
	  
      
      //draw tilemap
      tileMap.draw( g );
      
      player.draw(g);
	 
	  //draw enemies
	  for( int i = 0; i < enemies.size( ); i++ )
		enemies.get( i ).draw( g );
	  
	  // draw enemy explosions
	  for (int i = 0; i<explosions.size();i++){
		  explosions.get(i).setMapPosition((int)tileMap.getx(),(int)tileMap.gety());
		  explosions.get(i).draw(g);
	  }
	  
	  //draw hud
	  hud.draw( g );
	}
	public void keyPressed( int k ) {
		if(k == KeyEvent.VK_LEFT) player.setLeft(true);
		if(k == KeyEvent.VK_RIGHT) player.setRight(true);
		if(k == KeyEvent.VK_UP) player.setJumping(true);
		if(k == KeyEvent.VK_DOWN) player.setDown(true);
		if(k == KeyEvent.VK_SPACE) {
			punchsound.play();
			player.setPunching();
		}
			
		
	}
	public void keyReleased( int k ) {
		if(k == KeyEvent.VK_LEFT) player.setLeft(false);
		if(k == KeyEvent.VK_RIGHT) player.setRight(false);
		if(k == KeyEvent.VK_UP) player.setJumping(false);
		if(k == KeyEvent.VK_DOWN) player.setDown(false);
	}
}