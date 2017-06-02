import javax.swing.*;
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
    JPanel myPanel = new JPanel();
    int state;  // 0 none, 1 possible, 2 black, 3 red

    // images for the buttons, icons in the folder of projectfile
    static ImageIcon redCircle = new ImageIcon("J:\\school\\Computer Science\\CS III H P3\\Programs\\finalProject\\images");
    static ImageIcon blackCircle = new ImageIcon("J:\\school\\Computer Science\\CS III H P3\\Programs\\finalProject\\images");
    static ImageIcon noCircle = new ImageIcon("J:\\school\\Computer Science\\CS III H P3\\Programs\\finalProject\\images");
    static ImageIcon possibleCircle = new ImageIcon("J:\\school\\Computer Science\\CS III H P3\\Programs\\finalProject\\images", "Possible");

    private JButton button;

    Insets noMargin;

    // sonstructor
    /**
     * Square constructor
     * @param: (int) s - this determins what state the button is
     */
    public Square()
    {    
        button = new JButton();
        button.setBackground(Color.white);
        button.setIcon(noCircle);
        myPanel.add(button);
        add(myPanel);
        // adds an ActionListener and constructs it
        button.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    // if someone presses this it will show a message panel that says invalid move
                    JOptionPane.showMessageDialog(null, "INVALID MOVE", "INVALID MOVE", JOptionPane.ERROR_MESSAGE);
                }//Ends actionPerformed() method
            });// ends action listenter constructor
        validate();
        noMargin = new Insets(0, 0, 0, 0);

    }// constructor

    // method
    /**
     * changeState() method
     * changes the state of the method
     * @param: (int) s      - determins the state to change to
     */
    public void changeState(int s)
    {
        if(s < 1 || s > 3)
        {
            System.out.println("STATE CHANGE INVALID");
        }         
        else
        {
            state = s;
            switch(state)
            {
                // for each case it creates the button in different states
                case 1:
                System.out.println("1");
                button.setBackground(Color.gray);
                button.setIcon(possibleCircle);
                button.setSize(60,60);
                myPanel.add(button);
                add(myPanel);
                // adds an ActionListener and constructs it
                button.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            // if someone presses this it will show a message panel that says invalid move
                            JOptionPane.showMessageDialog(null, "IS POSSIBLE", "INVALID MOVE", JOptionPane.ERROR_MESSAGE);
                        }//Ends actionPerformed() method
                    });// ends action listenter constructor
                button.setVisible(true);
                validate();
                break;

                case 2:

                System.out.println("2");
                button.setBackground(Color.black);
                button.setIcon(blackCircle);
                button.setSize(60,60);
                myPanel.add(button);
                add(myPanel);
                // adds an ActionListener and constructs it
                button.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            // if someone presses this it will show a message panel that says invalid move
                            JOptionPane.showMessageDialog(null, "IS Black", "INVALID MOVE", JOptionPane.ERROR_MESSAGE);
                        }//Ends actionPerformed() method
                    });// ends action listenter constructor
                button.setVisible(true);
                validate();
                break;

                case 3:
                System.out.println("3");
                button.setBackground(Color.red);
                button.setIcon(redCircle);
                button.setSize(60,60);
                myPanel.add(button);
                add(myPanel);
                // adds an ActionListener and constructs it
                button.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            // if someone presses this it will show a message panel that says invalid move
                            JOptionPane.showMessageDialog(null, "IS RED", "INVALID MOVE", JOptionPane.ERROR_MESSAGE);
                        }//Ends actionPerformed() method
                    });// ends action listenter constructor
                button.setVisible(true);
                validate();
                break;
            }// ends switch
        }
        button.setMargin(noMargin);
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