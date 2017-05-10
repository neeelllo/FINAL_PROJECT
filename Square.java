import javax.swing.JButton;
import java.awt.event.*;
import java.io.*;
import javax.swing.ImageIcon;
import java.awt.*;
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
    public Square(int s)
    {
        state = s;        
        switch(state)
        {
            case 0:
                this.button = new JButton("Empty Square", noCircle);
                
            break;
            case 1:
                this.button = new JButton("Possible Square", possibleCircle);
            break;
            case 2:
                this.button = new JButton("Black Square", blackCircle);
            break;
            case 3:
                this.button = new JButton("Red Square", redCircle);
            break;
        }// ends switch
        
        noMargin = new Insets(0, 0, 0, 0);
        button.setMargin(noMargin);
        
    }// constructor
    
    // method
    public void changeState(int s)
    {
        if(s != 0 || s != 1 || s != 2 || s != 3)
        {
            System.out.println("STATE CHANGE INVALID");
        }         
        else
        {
            state = s;
        }
    }// ends changeState method
    
    public int getState()
    {
        return state;
    }// ends getState method
}// ends Square class