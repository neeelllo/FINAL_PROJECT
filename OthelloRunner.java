import java.awt.Color;          // to change frame color
import java.awt.event.*;        // actionlistnenters for the buttons
import java.awt.*;              // for layout, insets
import javax.swing.ImageIcon;   // change image icon of buttons
import javax.swing.JButton;     // JFrame UI
import javax.swing.JFrame;
import javax.swing.JPanel;  
import java.io.*;   //file reading
/**
 * Leonelle Lerios :: Period 1/5 :: 5.8.17(Restart)
 * Final Project (Othello)
 * This is going to be the Othello game a.k.a. Reversi
 */
public class OthelloRunner extends JFrame
{
    // instance variables
    // Jpanel object that you put containers in
    JPanel myPanel = new JPanel();   

    int [][] board = new int [8][8];
    boolean gridFull = false;

    // constructors
    OthelloRunner()
    {

    }//Ends OthelloRunner() constructor

    // methods
    /**
     * Method checkGrid
     *
     */
    public void checkWin()
    {
        int gOpen = 64;
        for(int row = 0; row <= board.length; row++)
        {
            for(int col = 0; col <= board.length; col++)
            {
                if(board[row][col] != 0)
                {
                    gOpen--;
                }//Ends if statement
            }//Ends for loop
        }//Ends for loop
        
        if(gOpen >= 1)
        {
            gridFull = false;
        }//Ends if statement
        else
        {
            gridFull = true;
        }//Ends else statement
    }//Ends checkWin() method

    public void start()
    {
        // set four peices in middle to start pos
        while(true)
        {
            // set four peices in middle to start pos
            board[4][4] = 1;    //Places white piece
            board[4][5] = 2;    //Places red piece
            board[5][4] = 1;    //Places while piece
            board[5][5] = 2;    //Places red piece
            
            // update for blacks potential moves
            possible();
            
            // update potential flips
            sandwich(); //Recieves the current move made

            // check win state
            checkWin();
            //Update for reds potential
            
            //Reds turn
            
            //Update again
            checkWin();
        }//Ends while loop
    }//Ends start() method
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void possible()
    {
        
    }//Ends possible() method

    /**
     * Sandwich - Scans the grid for all possible affected pieces and changes 
     * them if all apply to the requirments
     *
     * @param - recieves the coordinates of the placed piece
     * @return - changes all affected pieces
     */
    public void sandwich(int x, int y)
    {
        int currentColor = 1;
        board[x][y] = currentColor;
        while(gridFull == false)
        {
            for(int c = -1; c <= 1; c++)
            {
                for(int r = -1; r <= 1; r++)
                {
                    if(board[x + c][y + r] == 0)
                    {

                    }//Ends if statement
                }//Ends for loop
            }//Ends for loop
        }//Ends while loop
    }//Ends () method
}// ends OthelloRunner class