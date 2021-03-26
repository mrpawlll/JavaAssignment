/**
* Class Section: TT5V
* Trimester 2 2020/21
* Members:
* Yew Ee Jet Emmanuel       1181203540 +60 19-283 8311
* Paul John C. Escobia      1171103354 +60 11-5630 9196
* Yoong Yu Hong             1181203116 +60 14-337 8434
* Ting Siong Hock           1181203305 +60 11-2502 2950
* Lum Kar Yu                1191202435 +60 10-208 4816
*/
package javaassignment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Screen2 extends JFrame implements ActionListener{
    private final Team T1,T2;  // make a object for class Team
    private final String currentBackground;
    private final JLabel gameTitle, 
            labelTitle1, labelName1, labelAskTeam1Player1, labelAskTeam1Player2,
            labelTitle2, labelName2, labelAskTeam2Player1, labelAskTeam2Player2;
    private final JTextField textTeam1Name1, textTeam1Name2,
                       textTeam2Name1, textTeam2Name2;
    private final JButton btnTeam1, btnTeam2, btnProceed;
    private final JPanel panelTitle, panelCenter, panelBtm,
            panelTeam1, panelTitleTeam1, panelLabelTeam1, panelTeam1Player1, panelTeam1Player2, panelBtnTeam1,
            panelTeam2, panelTitleTeam2, panelLabelTeam2, panelTeam2Player1, panelTeam2Player2, panelBtnTeam2;
 
    public Screen2(String BackgroundColor){
        this.currentBackground = BackgroundColor;
        setSize(800,450);
        setResizable(false);
        setTitle("Rock-Paper-Scissors-Lizard-Spock");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        T1 = new Team();
        T2 = new Team();
        
        gameTitle = new JLabel("Rock-Paper-Scissors-Lizard-Spock");
        gameTitle.setFont(new Font("Arial", Font.PLAIN, 22));
        
        // Team 1
        labelTitle1 = new JLabel("Team 1");
        labelTitle1.setFont(new Font("Arial", Font.PLAIN, 32));
        labelName1 = new JLabel("Enter player names: ");  // ask for player name in Team 1
        labelName1.setFont(new Font("Arial", Font.PLAIN, 22));
        labelAskTeam1Player1 = new JLabel("Player 1: ");
        labelAskTeam1Player2 = new JLabel("Player 2: ");
        textTeam1Name1 = new JTextField();
        textTeam1Name2 = new JTextField();
        btnTeam1 = new JButton("Enter");
        
        // Team 2
        labelTitle2 = new JLabel("Team 2");  
        labelTitle2.setFont(new Font("Arial", Font.PLAIN, 32));
        labelName2 = new JLabel("Enter player names: ");    // ask for player name in Team 2
        labelName2.setFont(new Font("Arial", Font.PLAIN, 22));
        labelAskTeam2Player1 = new JLabel("Player 1: ");
        labelAskTeam2Player2 = new JLabel("Player 2: ");
        textTeam2Name1 = new JTextField();
        textTeam2Name2 = new JTextField();
        btnTeam2 = new JButton("Enter");
        
        //button to proceed to next screen
        btnProceed = new JButton("Proceed");

        panelTitle = new JPanel();
        panelTitle.add(gameTitle);
        panelTitle.setBackground(Color.orange);
        
        panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(2,2));
        
        panelTeam1 = new JPanel();
        panelTeam1.setLayout(new GridLayout(4,1));
        
        panelTitleTeam1 = new JPanel();
        panelTitleTeam1.add(labelTitle1);
        panelTeam1.add(panelTitleTeam1);
        
        panelLabelTeam1 = new JPanel();
        panelLabelTeam1.add(labelName1);
        panelTeam1.add(panelLabelTeam1);
        
        panelTeam1Player1 = new JPanel();
        panelTeam1Player1.setLayout(new GridLayout(1,2));
        panelTeam1Player1.add(labelAskTeam1Player1);panelTeam1Player1.add(textTeam1Name1);
        panelTeam1.add(panelTeam1Player1);
        
        panelTeam1Player2 = new JPanel();
        panelTeam1Player2.setLayout(new GridLayout(1,2));
        panelTeam1Player2.add(labelAskTeam1Player2);panelTeam1Player2.add(textTeam1Name2);
        panelTeam1.add(panelTeam1Player2);
        
        panelBtnTeam1 = new JPanel();
        panelBtnTeam1.add(btnTeam1);
        panelCenter.add(panelTeam1);
        
        panelTeam2 = new JPanel();
        panelTeam2.setLayout(new GridLayout(4,1));
        
        panelTitleTeam2 = new JPanel();
        panelTitleTeam2.add(labelTitle2);
        panelTeam2.add(panelTitleTeam2);
        
        panelLabelTeam2 = new JPanel();
        panelLabelTeam2.add(labelName2);
        panelTeam2.add(panelLabelTeam2);
        
        panelTeam2Player1 = new JPanel();
        panelTeam2Player1.setLayout(new GridLayout(1,2));
        panelTeam2Player1.add(labelAskTeam2Player1);panelTeam2Player1.add(textTeam2Name1);
        panelTeam2.add(panelTeam2Player1);
        
        panelTeam2Player2 = new JPanel();
        panelTeam2Player2.setLayout(new GridLayout(1,2));
        panelTeam2Player2.add(labelAskTeam2Player2);panelTeam2Player2.add(textTeam2Name2);
        panelTeam2.add(panelTeam2Player2);
        
        panelBtnTeam2 = new JPanel();
        panelBtnTeam2.add(btnTeam2);
        panelCenter.add(panelTeam2);
        
        panelCenter.add(panelBtnTeam1);
        panelCenter.add(panelBtnTeam2);
        
        panelBtm = new JPanel();
        panelBtm.add(btnProceed);
        
        add(panelTitle,BorderLayout.NORTH);
        add(panelCenter,BorderLayout.CENTER);
        add(panelBtm,BorderLayout.SOUTH);
        
        currentBackground();
        
        btnTeam1.addActionListener(this);
        btnTeam2.addActionListener(this);
        btnProceed.addActionListener(this);
    }
    
    public void currentBackground(){
        switch(this.currentBackground){
            case "Red":// set the background color red
                panelCenter.setBackground(Color.red);
                panelBtm.setBackground(Color.red);
                panelTeam1.setBackground(Color.red);
                panelTitleTeam1.setBackground(Color.red);
                panelLabelTeam1.setBackground(Color.red);
                panelTeam1Player1.setBackground(Color.red);
                panelTeam1Player2.setBackground(Color.red);
                panelBtnTeam1.setBackground(Color.red);
                panelTeam2.setBackground(Color.red);
                panelTitleTeam2.setBackground(Color.red);
                panelLabelTeam2.setBackground(Color.red);
                panelTeam2Player1.setBackground(Color.red);
                panelTeam2Player2.setBackground(Color.red);
                panelBtnTeam2.setBackground(Color.red);
                break;
            case "Green"://set the background color green
                panelCenter.setBackground(Color.green);
                panelBtm.setBackground(Color.green);
                panelTeam1.setBackground(Color.green);
                panelTitleTeam1.setBackground(Color.green);
                panelLabelTeam1.setBackground(Color.green);
                panelTeam1Player1.setBackground(Color.green);
                panelTeam1Player2.setBackground(Color.green);
                panelBtnTeam1.setBackground(Color.green);
                panelTeam2.setBackground(Color.green);
                panelTitleTeam2.setBackground(Color.green);
                panelLabelTeam2.setBackground(Color.green);
                panelTeam2Player1.setBackground(Color.green);
                panelTeam2Player2.setBackground(Color.green);
                panelBtnTeam2.setBackground(Color.green);
                break;
            case "Blue": // set the background color blue
                panelCenter.setBackground(Color.blue);
                panelBtm.setBackground(Color.blue);
                panelTeam1.setBackground(Color.blue);
                panelTitleTeam1.setBackground(Color.blue);
                panelLabelTeam1.setBackground(Color.blue);
                panelTeam1Player1.setBackground(Color.blue);
                panelTeam1Player2.setBackground(Color.blue);
                panelBtnTeam1.setBackground(Color.blue);
                panelTeam2.setBackground(Color.blue);
                panelTitleTeam2.setBackground(Color.blue);
                panelLabelTeam2.setBackground(Color.blue);
                panelTeam2Player1.setBackground(Color.blue);
                panelTeam2Player2.setBackground(Color.blue);
                panelBtnTeam2.setBackground(Color.blue);
                break;
            case "Yellow":// set the background color yellow
                panelCenter.setBackground(Color.yellow);
                panelBtm.setBackground(Color.yellow);
                panelTeam1.setBackground(Color.yellow);
                panelTitleTeam1.setBackground(Color.yellow);
                panelLabelTeam1.setBackground(Color.yellow);
                panelTeam1Player1.setBackground(Color.yellow);
                panelTeam1Player2.setBackground(Color.yellow);
                panelBtnTeam1.setBackground(Color.yellow);
                panelTeam2.setBackground(Color.yellow);
                panelTitleTeam2.setBackground(Color.yellow);
                panelLabelTeam2.setBackground(Color.yellow);
                panelTeam2Player1.setBackground(Color.yellow);
                panelTeam2Player2.setBackground(Color.yellow);
                panelBtnTeam2.setBackground(Color.yellow);
                break;
            case "Gray": // set the background color gray
                panelCenter.setBackground(Color.gray);
                panelBtm.setBackground(Color.gray);
                panelTeam1.setBackground(Color.gray);
                panelTitleTeam1.setBackground(Color.gray);
                panelLabelTeam1.setBackground(Color.gray);
                panelTeam1Player1.setBackground(Color.gray);
                panelTeam1Player2.setBackground(Color.gray);
                panelBtnTeam1.setBackground(Color.gray);
                panelTeam2.setBackground(Color.gray);
                panelTitleTeam2.setBackground(Color.gray);
                panelLabelTeam2.setBackground(Color.gray);
                panelTeam2Player1.setBackground(Color.gray);
                panelTeam2Player2.setBackground(Color.gray);
                panelBtnTeam2.setBackground(Color.gray);
                break;  
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnTeam1){ // if the Team 1 enter button is pressed
            // set player 1 and player 2 name into Team 1
            String Player1, Player2;
            Player1 = (String)textTeam1Name1.getText();
            Player2 = (String)textTeam1Name2.getText();
            T1.setPlayer1Name(Player1);
            T1.setPlayer2Name(Player2);
        }
         if(e.getSource() == btnTeam2){
             //set player 1 and player 2 name into Team 2
            String Player1, Player2;
            Player1 = (String)textTeam2Name1.getText();
            Player2 = (String)textTeam2Name2.getText();
            T2.setPlayer1Name(Player1);
            T2.setPlayer2Name(Player2);
        }
        if(e.getSource() == btnProceed){ // if proceed button is clicked
            if((T1.isPlayer1Null()&&T1.isPlayer2Null())&&(T2.isPlayer1Null()&&T2.isPlayer2Null())) // if players in Team 1 and players in Team 2 is null
                JOptionPane.showMessageDialog(new JFrame(),"Please Enter Team 1 and Team 2's Member Name!","Warning",JOptionPane.WARNING_MESSAGE);
            else if(T1.isPlayer1Null()&&T1.isPlayer2Null()) // if players in Team 1 is null
                JOptionPane.showMessageDialog(new JFrame(),"Please Enter Team 1's Member Name!","Warning",JOptionPane.WARNING_MESSAGE);
            else if(T2.isPlayer1Null()&&T2.isPlayer2Null()) // if players in Team 2 is null
                JOptionPane.showMessageDialog(new JFrame(),"Please Enter Team 2's Member Name!","Warning",JOptionPane.WARNING_MESSAGE);
            else{
                new Screen3(this.currentBackground,T1,T2); // call for next frame and passing variables and teams
                this.dispose(); // dispose the current frame
            }
        }
    }
}