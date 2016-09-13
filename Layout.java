package noughtsandcrosses;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class QuitGame extends JFrame
{
    Container contentPane = getContentPane();
    JButton quit = new JButton("Close");
    JButton restart = new JButton("Restart");
    JButton message = new JButton("");
}

/**
 *
 * @author cmills
 */
public class Layout extends JFrame implements ActionListener
{  
    Container contentPane = getContentPane();
    JPanel grid = new JPanel(new GridLayout(4,4));
    
    JButton btn1 = new JButton("");
    JButton btn2 = new JButton("");
    JButton btn3 = new JButton("");
    JButton btn4 = new JButton("");
    JButton btn5 = new JButton("");
    JButton btn6 = new JButton("");
    JButton btn7 = new JButton("");
    JButton btn8 = new JButton("");
    JButton btn9 = new JButton("");
    
    JButton quit = new JButton("Quit");
    JButton message = new JButton("");
    JButton restart = new JButton("Restart");
    
    byte p1Turns = 0;
    byte rounds = 0;
    boolean cont = true;
    boolean turn = true;
    int turns = 0;
    public static boolean single1;
    
    
    public void SinglePlayer()
    {
        Random rand = new Random();
        
        boolean repeat = true;
        while (repeat == true)
        {
            int pcRand = rand.nextInt(9) + 1;
              
            switch(pcRand)
            {
                case 1: if ("".equals(btn1.getText()))
                        {
                            btn1.setText("O"); 
                            repeat = false;                                
                        } break;
                case 2: if ("".equals(btn2.getText()))
                        {
                            btn2.setText("O"); 
                            repeat = false;
                        } break;
                case 3: if ("".equals(btn3.getText()))
                        {
                            btn3.setText("O"); 
                            repeat = false;
                        } break;
                case 4: if ("".equals(btn4.getText()))
                        {
                            btn4.setText("O"); 
                            repeat = false;
                        } break;
                case 5: if ("".equals(btn5.getText()))
                        {
                            btn5.setText("O"); 
                            repeat = false;
                        } break;
                case 6: if ("".equals(btn6.getText()))
                        {
                            btn6.setText("O"); 
                            repeat = false;
                        } break;
                case 7: if ("".equals(btn7.getText()))
                        {
                            btn7.setText("O"); 
                            repeat = false;
                        } break;
                case 8: if ("".equals(btn8.getText()))
                        {
                            btn8.setText("O"); 
                            repeat = false;
                        } break;
                case 9: if ("".equals(btn9.getText()))
                        {
                            btn9.setText("O"); 
                            repeat = false;
                        } break;      
            } 
        }
    }
    
    public void Quit()
    {
        message.setText("You Win");
        restart.setText("Restart");
        grid.add(quit);
        grid.add(restart);
        grid.add(message);
        restart.addActionListener(this);       
        quit.addActionListener(this);
        quit.setVisible(true);
        restart.setVisible(true); 
        message.setVisible(true);
    }
    
    public Layout(boolean single)
    {
        super("Noughts and Crosses");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        single1 = single;
        
        grid.add(btn1);
        btn1.addActionListener(this);
        
        grid.add(btn2);
        btn2.addActionListener(this);
        
        grid.add(btn3);
        btn3.addActionListener(this);
        
        grid.add(btn4);
        btn4.addActionListener(this);
        
        grid.add(btn5);
        btn5.addActionListener(this);
        
        grid.add(btn6);
        btn6.addActionListener(this);
        
        grid.add(btn7);
        btn7.addActionListener(this);
        
        grid.add(btn8);
        btn8.addActionListener(this);
        
        grid.add(btn9);
        btn9.addActionListener(this);
       
        contentPane.add("Center",grid);
        setVisible(true);
    }
    
    public void reset()
    {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        turns = 0;
        turn = true;
        single1 = true;
        message.setText("");
        restart.setText("Restart");
        quit.setVisible(false);
        restart.setVisible(false);
        Choice gui = new Choice();
    }
    
    public void actionPerformed(ActionEvent event)
    {
        Object button = event.getSource();
        JButton btnC= (JButton) button;

        if (event.getSource() == quit)
        {
            System.exit(0);
        }
        
        if(event.getSource() == restart)
        {
            reset();      
        }
        
        {
            if(single1 == true)
            {
                if(btnC.getText() == "")
                {
                    btnC.setText("X");
                    turns = (byte) (turns +1);
                    rounds = (byte) (rounds +1);
                    p1Turns = (byte) (p1Turns +1);
                }
                else
                {
                    System.out.println("Please choose a space which has not already been chosen");
                    p1Turns = (byte) (p1Turns -1);
                }  
            }
        }
        
        if(turn == true && single1 == false)
        {
            if(btnC.getText() == "X" || btnC.getText() == "O")
            {
                System.out.println("Please choose a space which has not already been chosen");
            }
            else
            {
            btnC.setText("X");
            turn = false;
            turns = (byte) (turns +1);
            }            
        }
        else if(turn == false && single1 == false)
        {
            if(btnC.getText() == "X" || btnC.getText() == "O")
            {
                System.out.println("Please choose a space which has not already been chosen");
                
            }
            else
            {
            btnC.setText("O");
            turn = true;
            turns = (byte) (turns +1);
            }
        }

        if(btn1.getText() == "X" && btn2.getText() == "X" && btn3.getText() == "X")
        {
            Quit();
            message.setText("X Wins!");
        }
        else if(btn4.getText() == "X" && btn5.getText() == "X" && btn6.getText() == "X")
        {
            Quit();
            message.setText("X Wins!");
        }
        else if(btn7.getText() == "X" && btn8.getText() == "X" && btn9.getText() == "X")
        {
            Quit();
            message.setText("X Wins!");
        }
        else if(btn1.getText() == "X" && btn4.getText() == "X" && btn7.getText() == "X")
        {
            Quit();
            message.setText("X Wins!");
        }
        else if(btn2.getText() == "X" && btn5.getText() == "X" && btn8.getText() == "X")
        {
            Quit();
            message.setText("X Wins!");
        }
        else if(btn3.getText() == "X" && btn6.getText() == "X" && btn9.getText() == "X")
        {
            Quit();
            message.setText("X Wins!");
        }
        else if(btn1.getText() == "X" && btn5.getText() == "X" && btn9.getText() == "X")
        {
            Quit();
            message.setText("X Wins!");
        }
        else if(btn3.getText() == "X" && btn5.getText() == "X" && btn7.getText() == "X")
        { 
            Quit();
            message.setText("X Wins!");
        }
        else if(turns == 9)
        {
            Quit();
            message.setText("Draw!");
        }
        else if(single1 == true)
        {
            if(rounds == p1Turns)
            {
               SinglePlayer();
               turns = (byte) (turns +1);  
            }
            else if(rounds != p1Turns)
            {
                p1Turns = (byte) (p1Turns +1);        
            }
        }
        if(btn1.getText() == "O" && btn2.getText() == "O" && btn3.getText() == "O")
        {
            Quit();
            message.setText("O Wins!");
        }
        else if(btn4.getText() == "O" && btn5.getText() == "O" && btn6.getText() == "O")
        {
            Quit();
            message.setText("O Wins!");
        }
        else if(btn7.getText() == "O" && btn8.getText() == "O" && btn9.getText() == "O")
        {
            Quit();
            message.setText("O Wins!");
        }
        else if(btn1.getText() == "O" && btn4.getText() == "O" && btn7.getText() == "O")
        {
            Quit();
            message.setText("O Wins!");
        }
        else if(btn2.getText() == "O" && btn5.getText() == "O" && btn8.getText() == "O")
        {
            Quit();
            message.setText("O Wins!");
        }
        else if(btn3.getText() == "O" && btn6.getText() == "O" && btn9.getText() == "O")
        {
            Quit();
            message.setText("O Wins!");
        }
        else if(btn1.getText() == "O" && btn5.getText() == "O" && btn9.getText() == "O")
        {
            Quit();
            message.setText("O Wins!");
        }
        else if(btn3.getText() == "O" && btn5.getText() == "O" && btn7.getText() == "O")
        {
            Quit();
            message.setText("O Wins!");
        }
    }
}