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
    int currentColor = 2;

    Insets noMargin = new Insets(0, 0, 0, 0);

    // constructors
    OthelloRunner()
    {
        myPanel.setLayout(null);
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

        myPanel.setSize(600, 660);

        createGrid();   // method creates the grid and adds the square objects to the panel

        myPanel.setBackground(Color.blue);
        add(myPanel);           // adds the panel to the frame
        add(myMenu);            // ands the menuBar to the frame
        myPanel.setVisible(true);   // makes the panel visble
        setVisible(true);
    }//Ends OthelloRunner() constructor

    // methods
    /**
     * Method checkGrid
     *
     */
    public void checkWin()
    {
        //Traverses through the 2D Array
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

        //Checks for any open spaces
        if(gOpen >= 1)
        {
            gridFull = false;
        }//Ends if statement
        else
        {
            gridFull = true;
        }//Ends else statement
    }//Ends checkWin() method

    /**
     * start - Makes sure that everything is passed and is displayed to the user
     *
     * @param  No parameters used
     * @return    void- does not return
     */
    public void start()
    {        
        // initilize grid of stuff
        createGrid();

        // set four peices in middle to start pos
        while(true)
        {
            // set four peices in middle to start pos
            board[4][4].changeState(2);    //Places white piece
            board[4][4].setVisible(true);
            
            board[4][5].changeState(3);    //Places red piece
            board[4][5].setVisible(true);
            
            board[5][4].changeState(2);    //Places white piece
            board[5][4].setVisible(true);
            
            board[5][5].changeState(3);    //Places red piece
            board[5][5].setVisible(true);

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
     * possible - Traverses through the grid for any spaces that are possible moves
     *
     * @param  No parameters used
     * @return    void- does not return
     */
    public void possible()
    {
        //Checks grid
        while(gridFull == false)
        {
            //Traverses grid
            for(int x = 0; x <= 7; x++)
            {
                for(int y = 0; y <= 7; y++)
                {
                    //Checks top left corner
                    if(x == 0 && y == 0)
                    {
                        for(int c = 0; c < 2; c++)
                        {
                            for(int r = 0; r <= 1; r++)
                            {
                                if(board[x+c][y+r].isEmpty() && board[x+c][y+r].getState() != board[x+c][y+r].enemyColor())    //Checks for otherpla
                                {
                                    sandwich(x,y);
                                }//Ends if statement
                            }//Ends for loop
                        }//Ends for loop
                    }//Ends if statement

                    //Checks top row
                    else if(x == 0)
                    {
                        for(int c = 0; c < 2; c++)
                        {
                            for(int r = -1; r <= 1; r++)
                            {
                                if(y+r < 8 && board[x+c][y+r].isEmpty() && board[x+c][y+r].getState() != board[x+c][y+r].enemyColor())    //Checks for otherpla
                                {
                                    sandwich(x,y);
                                }//Ends if statement
                            }//Ends for loop
                        }//Ends for loop
                    }//Ends else if statement

                    //Checks first colomn
                    else if(y == 0)
                    {
                        for(int c = -1; c < 2; c++)
                        {
                            for(int r = 0; r <= 1; r++)
                            {
                                if(x+c < 8 && board[x+c][y+r].isEmpty() && board[x+c][y+r].getState() != board[x+c][y+r].enemyColor())    //Checks for otherpla
                                {
                                    sandwich(x,y);
                                }//Ends if statement
                            }//Ends for loop
                        }//Ends for loop
                    }//Ends else if statement

                    //Checks all around the buttons in the middle of the grid (not the edges)
                    else
                    {
                        for(int c = -1; c < 2; c++)
                        {
                            for(int r = -1; r <= 1; r++)
                            {
                                if(x+c < 8 && y+r < 8 &&board[x+c][y+r].isEmpty() && board[x+c][y+r].getState() != board[x+c][y+r].enemyColor())    //Checks for otherpla
                                {
                                    sandwich(x,y);
                                }//Ends if statement
                            }//Ends for loop
                        }//Ends for loop
                    }//Ends else
                }//Ends for loop
            }//Ends for loop
        }//Ends while loop
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
                    while((x+c) > 0 && (x+c) < 7 && (y+r) > 0 && (y+r) < 7 && board[x + c][y + r].equals(board[x + c][y + r].enemyColor()))
                    {
                        sandwich((x+c),(y+r));
                    }//Ends if statement
                }//Ends for loop
            }//Ends for loop
        }//Ends while loop
    }//Ends () method

    /**
     * createGrid - Creates a 2D array which is then displayed in the GUI
     *
     * @param  No parameters used
     * @return    void - did not return
     */
    private void createGrid()
    {
        for(int r = 0; r < board.length; r++)
        {
            for(int c = 0; c < board.length; c++)
            {
                board[r][c] = new Square(0);
                board[r][c].changeState(3);
                board[r][c].setBounds((60*r)+60,(60*c)+120,60,60);
                board[r][c].setMargin(noMargin);                

                myPanel.add(board[r][c]);
                board[r][c].setVisible(true);
            }//Ends for loop
        }//Ends for loop
    }//Ends createGrid() method
}// ends OthelloRunner class