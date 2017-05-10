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
    void checkGrid()
    {
        for(int row = 0; row <= board.length; row++)
        {
            for(int col = 0; col <= board.length; col++)
            {
                if(board[row][col] == 0)
                {
                    gridFull = false;
                }
                else
                {
                    gridFull = true;
                }
            }
        }
    }

    public void start()
    {
        // set four peices in middle to start pos
        while(true)
        {            
            // update for blacks potential
            // lets black player go first
            // check win state
            // update for reds
            // then lets red go
            // update again
            // check win state
        }
    }
    
    /**
     * Sandwich - Scans the grid for all possible affected pieces and changes 
     * them if all apply to the requirments
     *
     * @param - recieves the coordinates of the placed piece
     * @return - changes all affected pieces
     */
    public void sandwich(int x, int y)
    {
        while(gridFull == false)
        {
            for(int c = -1; c <= 1; c++)
            {
                for(int r = -1; r <= 1; r++)
                {
                    if(board[x + c][y + r] == 0)
                    {
                    
                    }
                }
            }
        }
    }//Ends () method
}// ends OthelloRunner class