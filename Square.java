import javax.swing.JButton;
import java.awt.event.*;
import java.io.*;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.JOptionPane;
/**
 * Leonelle Lerios <3 David Corona :: Period 1/3/5 :: 5.8.17
 * Square class
 * This class is an object that extends JButton to have the game board sections
 */
public class Square extends JButton
{
    // variables
    int state;  // 0 none, 1 possible, 2 black, 3 red

    // images for the buttons, icons in the folder of projectfile
    static ImageIcon redCircle = new ImageIcon("images/redCircle.jpg", "Red");
    static ImageIcon blackCircle = new ImageIcon("images/blackCircle.jpg", "Black");
    static ImageIcon noCircle = new ImageIcon("images/noCircle.jpg", "No");
    static ImageIcon possibleCircle = new ImageIcon("images/possibleCircle.jpg", "Possible");

    private JButton button;

    Insets noMargin;

    // sonstructor
    /**
     * Square constructor
     * @param: (int) s - this determins what state the button is
     */
    public Square(int s)
    {
        state = s;        
        switch(state)
        {
            // for each case it creates the button in different states
            case 0:
            this.button = new JButton("Empty Square",noCircle);
            // this is suppose to change the background of the button to blue
            button.setBackground(Color.blue);
            // adds an ActionListener and constructs it
            button.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        // if someone presses this it will show a message panel that says invalid move
                        JOptionPane.showMessageDialog(null, "INVALID MOVE", "INVALID MOVE", JOptionPane.ERROR_MESSAGE);
                    }//Ends actionPerformed() method
                });// ends action listenter constructor
            break;

            case 1:
            this.button = new JButton("Possible Square", possibleCircle);
            button.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        // insert code for changing values
                    }//Ends actionPerformed() method
                });// ends action listenter constructor
            break;

            case 2:
            this.button = new JButton("Black Square", blackCircle);
            button.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        JOptionPane.showMessageDialog(null, "INVALID MOVE", "INVALID MOVE", JOptionPane.ERROR_MESSAGE);
                    }//Ends actionPerformed() method
                });// ends action listenter constructor
            break;

            case 3:
            this.button = new JButton("Red Square", redCircle);
            button.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        JOptionPane.showMessageDialog(null, "INVALID MOVE", "INVALID MOVE", JOptionPane.ERROR_MESSAGE);
                    }//Ends actionPerformed() method
                });// ends action listenter constructor
            break;
        }// ends switch

        noMargin = new Insets(0, 0, 0, 0);
        button.setMargin(noMargin);
    }// constructor

    // method
    /**
     * changeState() method
     * changes the state of the method
     * @param: (int) s      - determins the state to change to
     */
    public void changeState(int s)
    {
        if(s < 0 || s > 3)
        {
            System.out.println("STATE CHANGE INVALID");
        }         
        else
        {
            state = s;
        }
    }// ends changeState method

    /**
     * getState() method
     * @return: returns the state of the Square
     */
    public int getState()
    {
        return state;
    }// ends getState method

    public boolean equals(int i)
    {
        if(state == i)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isRed()
    {
        if(state == 3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }// ends isRed method

    public boolean isBlack()
    {
        if(state == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }// ends isBlack method

    public boolean isEmpty()
    {
        if(state == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }// ends isEmpty method

    public boolean isPossible()
    {
        if(state == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }// ends isPossible method

    public int enemyColor()
    {
        int enemy = 0;
        if(isBlack())
        {
            enemy = 3;
        }
        else if(isRed())
        {
            enemy = 2;
        }
        return enemy;
    }//ends enemyColor
}// ends Square class