import java.awt.Color;          // to change frame color
import java.awt.event.*;        // actionlistnenters for the buttons
import java.awt.*;              // for layout, insets
import javax.swing.*;           // for a lot of things, mostly JFrame UI stuff
import java.io.*;   //file reading
/**
 * Leonelle Lerios :: Period 1/5 :: 5.8.17(Restart)
 * Final Project (Othello)
 * This is going to be the Othello game a.k.a. Reversi
 */
public class OthelloRunner extends JFrame
{    
    // Jpanel object that you put containers in, like buttons and stuff
    JPanel myPanel = new JPanel();
    JMenuBar myMenu = new JMenuBar();

    // 2D array of the Square objects, Square objects are basically JButtons but specific to the class
    Square [][] board = new Square [8][8];
    boolean gridFull = false;   // win condition to end game

    // constructors
    OthelloRunner()
    {
        // sets size of the window
        setSize(600, 660);
        // sets the Title at the top of the window
        setTitle("Othello Java");
        // sets the frame to not be resizeable by the user
        setResizable(false);
        // puts the frame to the top left of the screen
        setLocationRelativeTo(null);
        // makes the close oporation when you press the red X to close the program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // makes the window visable
        setVisible(true);
        
        createGrid();   // method creates the grid and adds the square objects to the panel
        
        myPanel.setVisible(true);   // makes the panel visble
        add(myPanel);           // adds the panel to the frame
        add(myMenu);            // ands the menuBar to the frame
        
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
                if(board[row][col].equals(0))
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
            board[4][4].changeState(2);    //Places white piece
            board[4][5].changeState(3);    //Places red piece
            board[5][4].changeState(2);    //Places while piece
            board[5][5].changeState(3);    //Places red piece
            
            // update for blacks potential moves
            possible();
            
            // update potential flips
             //Recieves the current move made

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
        board[x][y].changeState(currentColor);
        while(gridFull == false)
        {
            for(int c = -1; c <= 1; c++)
            {
                for(int r = -1; r <= 1; r++)
                {
                    if(board[x + c][y + r].equals(0))
                    {
                        
                    }//Ends if statement
                }//Ends for loop
            }//Ends for loop
        }//Ends while loop
    }//Ends () method
    
    private void createGrid()
    {
        for(int r = 0; r <= board.length; r++)
        {
            for(int c = 0; c <= board.length; r++)
            {
                board[r][c] = new Square(0);
                //board[r][c].setBounds();
            }
        }
    }
}// ends OthelloRunner class