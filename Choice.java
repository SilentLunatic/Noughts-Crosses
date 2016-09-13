package noughtsandcrosses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author cmills
 */
public class Choice extends JFrame implements ActionListener
{
    Container contentPane = getContentPane();
    JPanel grid1 = new JPanel(new GridLayout(2,2));
    
    JButton singleP = new JButton("Single Player");
    JButton multiP = new JButton("Multiplayer");
    JButton question= new JButton("Would you like to play SinglePlayer or Multiplayer?");
    JButton annotation = new JButton("Click one of the Buttons below");
    
    private boolean single;
    
    public Choice()
    {
        setSize(1000,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        grid1.add(question);
        grid1.add(annotation);
        
        grid1.add(singleP);
        singleP.addActionListener(this);
        
        grid1.add(multiP);
        multiP.addActionListener(this);
       
        this.single = single;
        
        contentPane.add("Center",grid1);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == singleP)
        {
            single = true;
            Layout gui = new Layout(single);
        }
        else if(event.getSource() == multiP)
        {
            single = false;
            Layout gui = new Layout(single);
        }
    }
}