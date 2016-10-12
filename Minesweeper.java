/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// Question 2, Assignment 6
// Name: Nelson Kadama
// Student Number: NLSANG001
// Date: 15/08/13
// Minesweeper program
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Minesweeper extends JFrame implements ActionListener {
    
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private JPanel board;
    private JButton buttons[][] = new JButton[10][10];  // holds all buttons on the grid
    
    
    private JPanel top_panel = new JPanel();
    private JPanel bottom_panel = new JPanel();
    private JPanel left_panel = new JPanel();
    private JPanel right_panel = new JPanel();
    private JLabel status;
    private String destiny = "";
    
    
    public Minesweeper(){
        
        // create the frame with the following attributes
        setTitle("Minesweeper");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // create a panel for the board on which the components will be placed
        board = new JPanel();
        board.setForeground(Color.LIGHT_GRAY);
        board.setLayout(new GridLayout(10,10));
        
        addPanels();
        
        placeButtons();
        
        status = new JLabel("Play");
        
        top_panel.add(status);
        
            
        add(board, BorderLayout.CENTER);    
        
       
        
        
    }
    
    public void placeButtons(){
        for (int k = 0; k < 10; k++){
            for( int l = 0; l < 10; l++){
                buttons[k][l] = addButton(k,l);     // adds a button to the array
                board.add(buttons[k][l]);
            }
        }
    }
    
    //adds panels all around the edges of the frame
    public void addPanels(){
        
        top_panel.setForeground(Color.LIGHT_GRAY);
        
        add(top_panel, BorderLayout.NORTH);
        
        bottom_panel = new JPanel();
        bottom_panel.setForeground(Color.LIGHT_GRAY);
        
        add(bottom_panel, BorderLayout.SOUTH);
        
        left_panel = new JPanel();
        left_panel.setForeground(Color.LIGHT_GRAY);
        
        add(left_panel, BorderLayout.WEST);
        
        right_panel = new JPanel();
        right_panel.setForeground(Color.LIGHT_GRAY);
        
        add(right_panel, BorderLayout.EAST);
    }
    
    public static void main (String [] args){
        Minesweeper create = new Minesweeper();
        create.setVisible(true);

    }
    
    // create and return a button for the array
    public JButton addButton(int k, int l){
        String command;
        
        int random = (int)(Math.random()*20);       // generates a random number
        
        if (random >= 10)
            command = String.valueOf(k) +" "+ String.valueOf(l)+" X";
        else
            command = String.valueOf(k) +" "+ String.valueOf(l)+" O";
        
        
        JButton temp = new JButton();
        temp.setActionCommand(command);     // sets the buttons action command to its location in the 2d array and whether it has a mine or not
        temp.addActionListener(this);
        
        return temp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        //get the buttons coordinates
        int k = Character.digit(command.charAt(0),10);
        int l = Character.digit(command.charAt(2),10);
        
        char block = command.charAt(4);
        int bombs = 0;


        switch(block){
            // if theres a mine
            case 'X':
                buttons[k][l].setText("X");
                destiny = "you hit a mine. game over";
                status.setForeground(Color.RED);
                
                // disables the buttons and exposes the location of the other mines
                for (int c = 0; c < 10; c++){
                    for (int d = 0; d < 10; d++){
                        buttons[c][d].setEnabled(false);
                        if(buttons[c][d].getActionCommand().charAt(4) == 'X'){
                            buttons[c][d].setText("X");
                        }
                            
                            
                    }
                }

                break;

            case 'O':
                buttons[k][l].setVisible(false);        // removes button from playing field

                // check for adjacent blocks
                // checking top and bottom row
                if(((k == 0) || (k == 9)) && ((l > 0) && (l < 9)) ){
                    if(k == 0){
                        if(buttons[k][l-1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k][l+1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k+1][l-1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k+1][l].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k+1][l+1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                    }
                    if(k == 9){
                        if(buttons[k][l-1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k][l+1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k-1][l-1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k-1][l].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k-1][l+1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                    }
                }
                // checking corners
                if(((k == 0) || (k == 9)) && ((l == 0) || (l == 9)) ){
                    // top left
                    if((k == 0) && (l==0)){
                        if(buttons[k][l+1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k+1][l].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k+1][l+1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                    }
                    // top right
                    if((k == 0) && (l == 9)){
                        if(buttons[k][l-1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k+1][l].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k+1][l-1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                    }
                    // bottom left
                    if((k == 9) && (l == 0)){
                        if(buttons[k][l+1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k-1][l].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k-1][l+1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                    }
                    // bottom right
                    if((k == 9) && (l == 9)){
                        if(buttons[k][l-1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k-1][l].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k-1][l-1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                    }
                }
                // checking left and right
                if(((l == 0) || (l == 9)) && ((k > 0) && (k < 9)) ){
                    // left
                    if(l == 0){
                        if(buttons[k-1][l].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k-1][l+1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k][l+1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k+1][l].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k+1][l+1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                    }
                    // right
                    if(l == 9){
                        if(buttons[k-1][l].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k-1][l-1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k][l-1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k+1][l-1].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                        if(buttons[k+1][l].getActionCommand().charAt(4) == 'X')
                            bombs += 1;
                    }
                }
                // if its in the middle
                if(((k > 0) && (k < 9)) && ((l > 0) && (l < 9)) ){

                    if(buttons[k-1][l].getActionCommand().charAt(4) == 'X')
                        bombs += 1;
                    if(buttons[k-1][l+1].getActionCommand().charAt(4) == 'X')
                        bombs += 1;
                    if(buttons[k][l+1].getActionCommand().charAt(4) == 'X')
                        bombs += 1;
                    if(buttons[k+1][l+1].getActionCommand().charAt(4) == 'X')
                        bombs += 1;
                    if(buttons[k+1][l].getActionCommand().charAt(4) == 'X')
                        bombs += 1;
                    if(buttons[k+1][l-1].getActionCommand().charAt(4) == 'X')
                        bombs += 1;
                    if(buttons[k][l-1].getActionCommand().charAt(4) == 'X')
                        bombs += 1;
                    if(buttons[k-1][l-1].getActionCommand().charAt(4) == 'X')
                        bombs += 1;
                }
                
                // show how many bombs there are in adjacent blocks
                if (bombs == 1)
                    destiny = "there is " + bombs + " mine around you";
                else
                    destiny = "there are " + bombs + " mines around you";

                break;

        }
        
        status.setText(destiny);
                
              
                        
                
    }
        
        
        
    
        
       

}
