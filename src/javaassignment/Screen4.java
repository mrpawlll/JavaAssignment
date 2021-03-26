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

public class Screen4 extends JFrame implements ActionListener{
    private String currentBackground;
    private int maxRound1, maxRound2, totalTeam1Score,totalTeam2Score;
    private int []game1Team1Result, game1Team2Result, game2Team1Result, game2Team2Result;
    private JLabel gameTitle, labelCelebrate, labelCelebrateLeft, labelCelebrateRight, labelTeam1Score, labelTeam2Score, labelAnnounce,
                labelPlayer,labelRound,labelTotal,
                labelPlayerName,labelPlayerResult,labelGameTotalScore;
    private final JPanel panelTitle, panelMain, panelTeamScore, panelBtn, panelGame, panelGame1, panelGame2;
    private ImageIcon iconCelebrate, iconCelebrateLeft, iconCelebrateRight;
    private Image imageCelebrate, imageCelebrateLeft, imageCelebrateRight;
    private final JButton btnExit;
    
    Screen4(String currentBackground, Game G1, Game G2){
        setSize(800,450);
        setResizable(false);
        setTitle("Rock-Paper-Scissors-Lizard-Spock");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        init(currentBackground,G1,G2);
        gameTitle = new JLabel("Rock-Paper-Scissors-Lizard-Spock");
        gameTitle.setFont(new Font("Arial", Font.PLAIN, 22));
        
        labelTeam1Score = new JLabel("Team 1: "+ totalTeam1Score);
        labelTeam2Score = new JLabel("Team 2: "+ totalTeam2Score);
        
        labelCelebrate = new JLabel();
        labelCelebrateLeft = new JLabel();
        labelCelebrateRight = new JLabel();
        if(totalTeam1Score>totalTeam2Score){ // if the total score of Team 1 is greater than Team 2
            // set the celebration image at the Team 1 side
            imageCelebrate = (iconCelebrateLeft.getImage()).getScaledInstance(100,100,(iconCelebrateLeft.getImage()).SCALE_SMOOTH);
            iconCelebrate = new ImageIcon(imageCelebrate);
            labelCelebrate.setIcon(iconCelebrate);
            labelAnnounce = new JLabel("Congratulation!! Team1"); // to announce congratulation
        }
        else if(totalTeam1Score<totalTeam2Score){ // if the total score of Team 2 is greater than Team 1
            // set the celebration image at the Team 2 side
            imageCelebrate = (iconCelebrateRight.getImage()).getScaledInstance(100,100,(iconCelebrateRight.getImage()).SCALE_SMOOTH);
            iconCelebrate = new ImageIcon(imageCelebrate);
            labelCelebrate.setIcon(iconCelebrate);
            labelAnnounce = new JLabel("Congratulation!! Team2"); // to announce congratulation
        }
        else{ // if the total score for both Team is equal
            // set the celebration on both side
            imageCelebrateLeft = (iconCelebrateLeft.getImage()).getScaledInstance(100,100,(iconCelebrateLeft.getImage()).SCALE_SMOOTH);
            iconCelebrateLeft = new ImageIcon(imageCelebrateLeft);
            labelCelebrateLeft.setIcon(iconCelebrateLeft);
            
            imageCelebrateRight = (iconCelebrateRight.getImage()).getScaledInstance(100,100,(iconCelebrateRight.getImage()).SCALE_SMOOTH);
            iconCelebrateRight = new ImageIcon(imageCelebrateRight);
            labelCelebrateRight.setIcon(iconCelebrateRight);
            labelAnnounce = new JLabel("Its a tie!!"); // to announce congratulation
        }
        // create a new button called Exit
        btnExit = new JButton("Exit");
        panelBtn = new JPanel();
        panelBtn.add(btnExit);
        
        if((totalTeam1Score>totalTeam2Score)||(totalTeam1Score<totalTeam2Score)){ // if its not a tie for both Team 1 and Team 2
            // set usual panel
            panelTitle = new JPanel();
            panelTitle.setBackground(Color.orange);
            panelTitle.add(gameTitle);

            panelMain = new JPanel();
            panelMain.setLayout(new GridLayout(2,1));

            panelTeamScore = new JPanel();
            panelTeamScore.setLayout(new GridLayout(1,2));
            panelTeamScore.add(labelTeam1Score);panelTeamScore.add(labelTeam2Score);
            panelMain.add(panelTeamScore);
            panelMain.add(labelAnnounce);
        }
        else{// if it is a tie
            // set the button in the between of the panel
            panelTitle = new JPanel();
            panelTitle.setBackground(Color.orange);
            panelTitle.add(gameTitle);

            panelMain = new JPanel();
            panelMain.setLayout(new GridLayout(3,1));

            panelTeamScore = new JPanel();
            panelTeamScore.setLayout(new GridLayout(1,2));
            panelTeamScore.add(labelTeam1Score);panelTeamScore.add(labelTeam2Score);
            panelMain.add(panelTeamScore);
            panelMain.add(labelAnnounce);
            panelMain.add(panelBtn);
            
        }
        
        // Display result for Game 1
        labelPlayer = new JLabel("Player 1");
        labelTotal = new JLabel("Total");
        
        panelGame1 = new JPanel();
        panelGame1.setLayout(new GridLayout(3,(maxRound1+2)));
        panelGame1.setBorder(BorderFactory.createLineBorder(Color.black));
        panelGame1.add(labelPlayer);
        for(int i=0; i<maxRound1;i++){
            labelRound = new JLabel("Round "+ (maxRound1+1));
            panelGame1.add(labelRound);
        }
        panelGame1.add(labelTotal);
        for(int i=0;i<2;i++){
            if(i==0){
                labelPlayerName = new JLabel("Team 1:"+ G1.getPlayer1Name());
                panelGame1.add(labelPlayerName);
                for(int j=0;j<maxRound1;j++){
                    labelPlayerResult = new JLabel(Integer.toString(game1Team1Result[j]));
                    panelGame1.add(labelPlayerResult);
                }
                labelGameTotalScore = new JLabel(Integer.toString(G1.getScoreTotal1()));
                panelGame1.add(labelGameTotalScore);
            }
            else if(i==1){
                labelPlayerName = new JLabel("Team 1:"+ G1.getPlayer2Name());
                panelGame1.add(labelPlayerName);
                for(int j=0;j<maxRound1;j++){
                    labelPlayerResult = new JLabel(Integer.toString(game1Team2Result[j]));
                    panelGame1.add(labelPlayerResult);
                }
                labelGameTotalScore = new JLabel(Integer.toString(G1.getScoreTotal2()));
                panelGame1.add(labelGameTotalScore);
            }
        }
        
        //Display result for Game 2
        labelPlayer = new JLabel("Player 2");
        labelTotal = new JLabel("Total");
        
        panelGame2 = new JPanel();
        panelGame2.setLayout(new GridLayout(3,(maxRound2+2)));
        panelGame2.setBorder(BorderFactory.createLineBorder(Color.black));
        panelGame2.add(labelPlayer);
        for(int i=0; i<maxRound2;i++){
            labelRound = new JLabel("Round "+ (maxRound2+1));
            panelGame2.add(labelRound);
        }
        panelGame2.add(labelTotal);
        for(int i=0;i<2;i++){
            if(i==0){
                labelPlayerName = new JLabel("Team 1:"+ G2.getPlayer1Name());
                panelGame2.add(labelPlayerName);
                for(int j=0;j<maxRound2;j++){
                    labelPlayerResult = new JLabel(Integer.toString(game2Team1Result[j]));
                    panelGame2.add(labelPlayerResult);
                }
                labelGameTotalScore = new JLabel(Integer.toString(G2.getScoreTotal1()));
                panelGame2.add(labelGameTotalScore);
            }
            else if(i==1){
                labelPlayerName = new JLabel("Team 1:"+ G2.getPlayer2Name());
                panelGame2.add(labelPlayerName);
                for(int j=0;j<maxRound2;j++){
                    labelPlayerResult = new JLabel(Integer.toString(game2Team2Result[j]));
                    panelGame2.add(labelPlayerResult);
                }
                labelGameTotalScore = new JLabel(Integer.toString(G2.getScoreTotal2()));
                panelGame2.add(labelGameTotalScore);
            }
        }
        
        panelGame = new JPanel();
        panelGame.setLayout(new GridLayout(2,1));
        panelGame.add(panelGame1);
        panelGame.add(panelGame2);
        
        add(panelTitle,BorderLayout.NORTH);
        add(panelMain,BorderLayout.CENTER);
        if(totalTeam1Score>totalTeam2Score){
            add(labelCelebrate,BorderLayout.WEST);
            add(panelBtn,BorderLayout.EAST);
        }
        else if(totalTeam1Score<totalTeam2Score){
            add(labelCelebrate,BorderLayout.EAST);
            add(panelBtn,BorderLayout.WEST);
        }
        else{
            add(labelCelebrateLeft,BorderLayout.EAST);
            add(labelCelebrateRight,BorderLayout.WEST);
        }
        add(panelGame,BorderLayout.SOUTH);
        btnExit.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnExit){ // if the exit button is clicked
            System.exit(0); // close the program
        }
    }
    
    public void init(String currentBackground, Game G1, Game G2){ // initialize the variable based on the background color and the previous Game 1 and Game 2
        this.currentBackground = currentBackground;
        this.totalTeam1Score = G1.getTotalScoreTeam1()+G2.getTotalScoreTeam1();
        this.totalTeam2Score = G1.getTotalScoreTeam2()+G2.getTotalScoreTeam2();
        
        // First Game
        this.maxRound1 = G1.getMaxRound();
        this.game1Team1Result = G1.getScorePlayer1(); // Result of Team 1 in Game 1
        this.game1Team2Result = G1.getScorePlayer2(); // Result of Team 2 in Game 1
        // Second Game
        this.maxRound2 = G2.getMaxRound();
        this.game2Team1Result = G2.getScorePlayer1(); // Result of Team 1 in Game 2
        this.game2Team2Result = G2.getScorePlayer2(); // Result of Team 2 in Game 2
        // preset the image
        this.iconCelebrateLeft = new ImageIcon("src/resources/celebrateLeft.jpg");
        this.iconCelebrateRight = new ImageIcon("src/resources/celebrateRight.jpg");
    }
    
    public void currentBackground(){ // set the background color
        switch(this.currentBackground){  // based on the background color
            case "Red": // set the background color red
                panelMain.setBackground(Color.red);
                panelTeamScore.setBackground(Color.red);
                panelBtn.setBackground(Color.red);
                panelGame.setBackground(Color.red);
                panelGame1.setBackground(Color.red);
                panelGame2.setBackground(Color.red);
                break;
            case "Green": // set the background color green
                panelMain.setBackground(Color.green);
                panelTeamScore.setBackground(Color.green);
                panelBtn.setBackground(Color.green);
                panelGame.setBackground(Color.green);
                panelGame1.setBackground(Color.green);
                panelGame2.setBackground(Color.green);
                break;
            case "Blue": // set the background color blue
                panelMain.setBackground(Color.blue);
                panelTeamScore.setBackground(Color.blue);
                panelBtn.setBackground(Color.blue);
                panelGame.setBackground(Color.blue);
                panelGame1.setBackground(Color.blue);
                panelGame2.setBackground(Color.blue);
                break;
            case "Yellow": // set the background color yellow
                panelMain.setBackground(Color.yellow);
                panelTeamScore.setBackground(Color.yellow);
                panelBtn.setBackground(Color.yellow);
                panelGame.setBackground(Color.yellow);
                panelGame1.setBackground(Color.yellow);
                panelGame2.setBackground(Color.yellow);
                break;
            case "Gray": // set the background color gray
                panelMain.setBackground(Color.gray);
                panelTeamScore.setBackground(Color.gray);
                panelBtn.setBackground(Color.gray);
                panelGame.setBackground(Color.gray);
                panelGame1.setBackground(Color.gray);
                panelGame2.setBackground(Color.gray);
                break;  
        }
    }
}