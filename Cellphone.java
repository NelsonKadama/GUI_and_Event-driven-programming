/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// Question 1, Assignment 6
// Name: Nelson Kadama
// Student Number: NLSANG001
// Date: 15/08/13
// Cellphone gui
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cellphone extends JFrame implements ActionListener{
   
    private static final int WIDTH = 300;
    private static final int HEIGHT = 500;
    private JPanel numpad;
    private JPanel screen_panel;
    private JLabel text_;
    private String number;
    
    public Cellphone(){
        // Create the frame
        setTitle("Cellphone");
        setSize(WIDTH, HEIGHT);
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        setLayout(new BorderLayout());
      
        // creates top panel
        JPanel top = new JPanel();
        top.setBackground(Color.LIGHT_GRAY);
        top.setLayout(new BorderLayout());
        
        text_ = new JLabel();
        text_.setForeground(Color.RED);
        
        JLabel cell_name = new JLabel("KONIA");
        
        top.add(cell_name, BorderLayout.EAST);
        
        
        add(top, BorderLayout.NORTH);       // adds a 'top' panel to the frame
        
        
        screen_panel = new JPanel();            // creates a panel to represent the screen 
        screen_panel.setBackground(Color.BLACK);
        screen_panel.setLayout(new BorderLayout());
        
        screen_panel.add(text_, BorderLayout.CENTER);
        
        add(screen_panel, BorderLayout.CENTER);
        
        // adds buttons and creates a panel for them (loops and arrays of type JButton could of been used)
        JPanel button_panel = new JPanel();
        button_panel.setBackground(Color.LIGHT_GRAY);
        button_panel.setLayout(new FlowLayout());
 
        JButton button_call = new JButton("Call");
        button_panel.add(button_call);
        button_call.setActionCommand("call");
        button_call.addActionListener(this);
        
        JButton button_menu = new JButton("Menu");
        button_panel.add(button_menu);
        button_menu.setActionCommand("menu");
        button_menu.addActionListener(this);
        
        JButton button_end = new JButton("End");
        button_panel.add(button_end);
        button_end.setActionCommand("end");
        button_end.addActionListener(this);
        
        add(button_panel, BorderLayout.SOUTH);
        
        numpad = new JPanel();
        numpad.setBackground(Color.CYAN);
        numpad.setLayout(new GridLayout(4,3));
        numpad.setVisible(false);
        
        JButton button_one = new JButton("1");
        numpad.add(button_one);
        button_one.setActionCommand("1");
        button_one.addActionListener(this);
        
        JButton button_two = new JButton("2");
        numpad.add(button_two);
        button_two.setActionCommand("2");
        button_two.addActionListener(this);
        
        JButton button_three = new JButton("3");
        numpad.add(button_three);
        button_three.setActionCommand("3");
        button_three.addActionListener(this);
        
        JButton button_four = new JButton("4");
        numpad.add(button_four);
        button_four.setActionCommand("4");
        button_four.addActionListener(this);
        
        JButton button_five = new JButton("5");
        numpad.add(button_five);
        button_five.setActionCommand("5");
        button_five.addActionListener(this);
        
        JButton button_six = new JButton("6");
        numpad.add(button_six);
        button_six.setActionCommand("6");
        button_six.addActionListener(this);
        
        JButton button_seven = new JButton("7");
        numpad.add(button_seven);
        button_seven.setActionCommand("7");
        button_seven.addActionListener(this);
        
        JButton button_eight = new JButton("8");
        numpad.add(button_eight);
        button_eight.setActionCommand("8");
        button_eight.addActionListener(this);
        
        JButton button_nine = new JButton("9");
        numpad.add(button_nine);
        button_nine.setActionCommand("9");
        button_nine.addActionListener(this);
        
        JButton button_star = new JButton("*");
        numpad.add(button_star);
        button_star.setActionCommand("*");
        button_star.addActionListener(this);
        
        JButton button_zero = new JButton("0");
        numpad.add(button_zero);
        button_zero.setActionCommand("0");
        button_zero.addActionListener(this);
        
        JButton button_hash = new JButton("#");
        numpad.add(button_hash);
        button_hash.setActionCommand("#");
        button_hash.addActionListener(this);
        
        screen_panel.add(numpad, BorderLayout.SOUTH);
        
        
        
        
    }
    
    
    public static void main(String [] args){
        Cellphone create = new Cellphone();
        create.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {    // Accompanying buttons get their commands
        
        String command = e.getActionCommand();
        
        
        if (command == "call"){
            number ="";
            numpad.setVisible(true);
            text_.setText("CALL");
        }
            
        else if (command.equals("menu") ){
            numpad.setVisible(false);
            text_.setText("MENU");
        }
            
        else if (command == "end"){
            numpad.setVisible(false);
            text_.setText("END");
        }  
        
        char num = command.charAt(0);
        switch(num){
            case '1':
                number +="1";
                text_.setText(number);
                break;
            case '2':
                number+="2";
                text_.setText(number);
                break;
            case '3':
                number+="3";
                text_.setText(number);
                break;
            case '4':
                number+="4";
                text_.setText(number);
                break;
            case '5':
                number+="5";
                text_.setText(number);
                break;
            case '6':
                number+="6";
                text_.setText(number);
                break;
            case '7':
                number+="7";
                text_.setText(number);
                break;
            case '8':
                number+="8";
                text_.setText(number);
                break;
            case '9':
                number+="9";
                text_.setText(number);
                break;
            case '0':
                number+="0";
                text_.setText(number);
                break;
            case '*':
                number+="*";
                text_.setText(number);
                break;
            case '#':
                number+="#";
                text_.setText(number);
                break;
        }
        
        
                
        
    }
    

}
