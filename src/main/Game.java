package main;

import javax.swing.JFrame;
//Sets the game up to allow it to be visible
public class Game {
   //Opens the window and starts the Game Panel
   public static void main( String args[ ] ) {
   
<<<<<<< HEAD
	   
=======
	   //Open the window
>>>>>>> 75c1e0c616a4ee39d25b8d870b84f2b4d438c345
      JFrame window = new JFrame( "" );
      //Put a Game Panel in the window
      window.setContentPane( new GamePanel( ) );
      //Make the window closeable
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      //Make the window closable
      window.setVisible( true );
      //Set the size of the window
      window.pack( );
      //Not allow the window to be resized
      window.setResizable( false );
      //Set the window loaction to not be realtive 
      //to anything 
      window.setLocationRelativeTo( null );
      
      
   }//end main
}//end class
      
