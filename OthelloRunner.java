import java.awt.Color;          // to change frame color
import java.awt.event.*;        // actionlistnenters for the buttons
import java.awt.*;              // for layout, insets
import javax.swing.ImageIcon;   // change image icon of buttons
import javax.swing.JButton;     // JFrame UI stuff
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

    // images for the buttons, icons in the folder of projectfile
    static ImageIcon redCircle = new ImageIcon("images/redCircle.jpg", "Red");
    static ImageIcon blackCircle = new ImageIcon("images/blackCircle.jpg", "Black");
    static ImageIcon noCircle = new ImageIcon("images/noCircle.jpg", "No");
    // constructors
    OthelloRunner()
    {
        System.out.println("daad? or nah");
    }
    // methods
    /**
     * An example of a method - replace this comment with your own
     *
     * @param 
     * @return 
     */
    public void sampleMethod()
    {
        // put your code here
    }
}// ends OthelloRunner class