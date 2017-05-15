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
    public Square(int s)
    {
        state = s;        
        switch(state)
        {
            case 0:
                this.button = new JButton("Empty Square", noCircle);
                button.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent e)
                   {
                       JOptionPane.showMessageDialog(null, "INVALID MOVE", "INVALID MOVE", JOptionPane.ERROR_MESSAGE);
                   }
                });// ends action listenter constructor
            break;
            case 1:
                this.button = new JButton("Possible Square", possibleCircle);
                button.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent e)
                   {
                       // insert code for changing values
                   }
                });// ends action listenter constructor
            break;
            case 2:
                this.button = new JButton("Black Square", blackCircle);
                button.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent e)
                   {
                       JOptionPane.showMessageDialog(null, "INVALID MOVE", "INVALID MOVE", JOptionPane.ERROR_MESSAGE);
                   }
                });// ends action listenter constructor
            break;
            case 3:
                this.button = new JButton("Red Square", redCircle);
                button.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent e)
                   {
                       JOptionPane.showMessageDialog(null, "INVALID MOVE", "INVALID MOVE", JOptionPane.ERROR_MESSAGE);
                   }
                });// ends action listenter constructor
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
        if(state == 2)
        {
            return 3;
        }
        else
        {
            return 2;
        }
    }//ends enemyColor
    
}// ends Square class