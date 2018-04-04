package GameState;

import TileMap.Background;
import java.awt.*;
import java.awt.event.KeyEvent;

public class ControlState extends GameState {
   
   private Background bg;
   
   private int currentChoice = 0;
   private String [] options = {"Right Arrow - Move right","Left Arrow - Move left","Down Arrow - defend","Up Arrow - Jump",
		   					    "Space Bar - attack","Go Back"};
   private Color titleColor;
   private Font titleFont;
   private Font font;
   
   public ControlState( GameStateManager gsm ) {
      this.gsm = gsm;
      
      try{
    	 bg = new Background("/Backgrounds/chickenMBG.jpg",1); 
    	 bg.setVector(0,0);
    	 titleColor = new Color(0,0,0);
    	 titleFont = new Font("Helvetica", Font.PLAIN,45);
    	 font = new Font("Arial",Font.PLAIN,18);
      }
       catch(Exception e){
    	   e.printStackTrace();
       }
      
   }
   
   public void init( ){ 
   }
   public void update( ){
	   bg.update();
   }
   public  void draw( java.awt.Graphics2D g ){
	   bg.draw(g);
	   g.setColor(titleColor);
	   g.setFont(titleFont);
	   g.drawString("Controls", 150, 130);
	   
	   g.setFont(font);
	   for(int i =0; i<options.length; i++){
		   if(i == currentChoice) {
			   g.setColor(Color.RED);
		   }
		   else {
			   g.setColor(Color.BLUE);
		   }
		   g.drawString(options[i],160,170 + i * 20);
	   }
   }
   
   private void select(){
	   if(currentChoice == 0){
		   
	   }
	   if(currentChoice == 1){
		   //difficulty
	   }
	   if(currentChoice == 2){
		   //store
	   }
	   if(currentChoice == 3){
		   //controls
	   }
	   if(currentChoice == 4){
		   
	   }
	   if(currentChoice == 5){
		   gsm.setState(GameStateManager.MENUSTATE);
	   }
	  
   }
   
   public void keyPressed( int k ){
	   if(k == KeyEvent.VK_ENTER){
		   select();
	   }
	   if(k == KeyEvent.VK_UP){
		   currentChoice--;
		   if(currentChoice == -1){
			   currentChoice = options.length - 1;
		   }
	   }
	   if(k == KeyEvent.VK_DOWN){
		   currentChoice++;
		   if(currentChoice == options.length){
			   currentChoice = 0;
		   }
	   }
   }
   public void keyReleased( int k ){
	   
   }
   
}