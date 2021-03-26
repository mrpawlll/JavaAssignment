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
import java.util.Random; 
    
public class Screen3 extends JFrame implements ActionListener{
    private String currentBackground;
    private final String player1, player2;
    private final JLabel gameTitle, labelCurrentRound, labelPlayer1, labelPlayer2, labelDefaultIcon1, labelDefaultIcon2,
            labelGame1,labelGameRound1,labelGameRound2,labelGameRound3,labelGameTotal,
            labelGamePlayer1, labelGameScore1P1, labelGameScore2P1, labelGameScore3P1, labelScoreTotalP1,
            labelGamePlayer2, labelGameScore1P2, labelGameScore2P2, labelGameScore3P2, labelScoreTotalP2;
    private final JPanel panelTitle, panelRound, panelPlayer1, panelPlayer2, panelPlayerInfo1, panelPlayerInfo2, panelBtm, panelResult ,panelBtn, panelBtnNext, panelBtnProceed;
    private int currentGame, maxGame, currentRound, maxRound, nextPlayerTurn, currentPlayerTurn, randomResult1, randomResult2, upperBoundary, currentTotal1, currentTotal2;
    private Random rand;
    private final JButton btnBoom1, btnBoom2, btnNextGame, btnProceed;
    private ImageIcon iconDefault1, iconDefault2, rockImage, paperImage, scissorsImage, lizardImage, spockImage;
    private Image imageDefault1, imageDefault2;
    private Game G1,G2; // create the objects for the game
     
   public Screen3(String backgroundColor,Team T1,Team T2){
        setSize(800,450);
        setResizable(false);
        setTitle("Rock-Paper-Scissors-Lizard-Spock");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        init(backgroundColor,T1,T2); //initialize the variables according to the background color and teams passed previously
        if(currentGame == 1){ // if the current game is the first
            // initialize the players name based on each team
            player1 = G1.getPlayer1Name();
            player2 = G1.getPlayer2Name();
        }
        else{ // if the current game is the second or others
            player1 = G2.getPlayer1Name();
            player2 = G2.getPlayer2Name();
        }
        
        gameTitle = new JLabel("Rock-Paper-Scissors-Lizard-Spock");
        gameTitle.setFont(new Font("Arial", Font.PLAIN, 22));
       
        labelCurrentRound = new JLabel("Round "+ (currentRound+1));
        labelCurrentRound.setFont(new Font("Arial", Font.PLAIN, 22));
       
        labelPlayer1 = new JLabel(player1);
        labelPlayer1.setFont(new Font("Arial", Font.PLAIN, 12));
        labelPlayer1.setVerticalAlignment(JLabel.TOP);
        labelPlayer1.setHorizontalAlignment(JLabel.CENTER);
        imageDefault1 = (rockImage.getImage()).getScaledInstance(100,100,(rockImage.getImage()).SCALE_SMOOTH);
        iconDefault1 = new ImageIcon(imageDefault1);
        labelDefaultIcon1 = new JLabel(iconDefault1);
        btnBoom1 = new JButton("Boom");
       
        labelPlayer2 = new JLabel(player2);
        labelPlayer2.setFont(new Font("Arial", Font.PLAIN, 12));
        labelPlayer2.setVerticalAlignment(JLabel.TOP);
        labelPlayer2.setHorizontalAlignment(JLabel.CENTER);
        imageDefault2 = (rockImage.getImage()).getScaledInstance(100,100,(rockImage.getImage()).SCALE_SMOOTH);
        iconDefault2 = new ImageIcon(imageDefault2);
        labelDefaultIcon2 = new JLabel(iconDefault2);
        btnBoom2 = new JButton("Boom");
        
        labelGame1 = new JLabel("Player1");
        labelGameRound1 = new JLabel("Round 1");
        labelGameRound2 = new JLabel("Round 2");
        labelGameRound3 = new JLabel("Round 3");
        labelGameTotal = new JLabel("Total");
        
        labelGamePlayer1 = new JLabel("Team 1: "+T1.getPlayer1Name());
        labelGameScore1P1 = new JLabel();
        labelGameScore2P1 = new JLabel();
        labelGameScore3P1 = new JLabel();
        labelScoreTotalP1 = new JLabel(Integer.toString(currentTotal1));
        
        labelGamePlayer2 = new JLabel("Team 2: "+T2.getPlayer2Name());
        labelGameScore1P2 = new JLabel();
        labelGameScore2P2 = new JLabel();
        labelGameScore3P2 = new JLabel();
        labelScoreTotalP2 = new JLabel(Integer.toString(currentTotal2));
        
        btnNextGame = new JButton("Next Game");
        btnProceed = new JButton("Proceed");
        
        panelTitle = new JPanel();
        panelTitle.setBackground(Color.orange);
        panelTitle.add(gameTitle);
        
        panelRound = new JPanel();
        panelRound.add(labelCurrentRound);
        
        panelPlayer1 = new JPanel();
        panelPlayer1.setLayout(new GridLayout(1,2));
        panelPlayerInfo1 = new JPanel();
        panelPlayerInfo1.setLayout(new GridLayout(2,1));
        panelPlayerInfo1.add(labelPlayer1);
        panelPlayerInfo1.add(btnBoom1);
        panelPlayer1.add(panelPlayerInfo1);
        panelPlayer1.add(labelDefaultIcon1);
        
        panelPlayer2 = new JPanel();
        panelPlayer2.setLayout(new GridLayout(1,2));
        panelPlayerInfo2 = new JPanel();
        panelPlayerInfo2.setLayout(new GridLayout(2,1));
        panelPlayerInfo2.add(labelPlayer2);
        panelPlayerInfo2.add(btnBoom2);
        panelPlayer2.add(labelDefaultIcon2);
        panelPlayer2.add(panelPlayerInfo2);
        
        panelBtm = new JPanel();
        panelBtm.setLayout(new GridLayout(2,1));
        
        panelResult = new JPanel();
        panelResult.setLayout(new GridLayout(3,5));
        panelResult.setBorder(BorderFactory.createLineBorder(Color.black));
        //Row 1
        panelResult.add(labelGame1);
        panelResult.add(labelGameRound1);
        panelResult.add(labelGameRound2);
        panelResult.add(labelGameRound3);
        panelResult.add(labelGameTotal);
        //Row 2
        panelResult.add(labelGamePlayer1);
        panelResult.add(labelGameScore1P1);
        panelResult.add(labelGameScore2P1);
        panelResult.add(labelGameScore3P1);
        panelResult.add(labelScoreTotalP1);
        //Row 3
        panelResult.add(labelGamePlayer2);
        panelResult.add(labelGameScore1P2);
        panelResult.add(labelGameScore2P2);
        panelResult.add(labelGameScore3P2);
        panelResult.add(labelScoreTotalP2);
        panelBtm.add(panelResult);
        
        panelBtn = new JPanel();
        panelBtn.setLayout(new GridLayout(1,2));
        panelBtnNext = new JPanel();
        panelBtnNext.add(btnNextGame);
        panelBtnProceed = new JPanel();
        panelBtnProceed.add(btnProceed);
        panelBtn.add(panelBtnNext);panelBtn.add(panelBtnProceed);
        panelBtm.add(panelBtn);
        
        add(panelTitle,BorderLayout.NORTH);
        add(panelRound,BorderLayout.CENTER);
        add(panelPlayer1,BorderLayout.WEST);
        add(panelPlayer2,BorderLayout.EAST);
        add(panelBtm,BorderLayout.SOUTH);
       
        currentBackground(); // set the background color
        //register components
        btnBoom1.addActionListener(this);
        btnBoom2.addActionListener(this);
        btnNextGame.addActionListener(this);
        btnProceed.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(currentGame<=maxGame){ // if the current game is less than or equal to the maximum game available
            if(e.getSource() == btnBoom1 && currentRound<maxRound){ // if button is clicked for Player 1 and the ongoing round is less than the maximum round allowed
                currentPlayerTurn = nextPlayerTurn; // current turn for the players
                if(nextPlayerTurn == 1){ // if the next turn is player 1
                    //get random number representing the player's output
                    rand = new Random();
                    randomResult1 = rand.nextInt(upperBoundary);
                    labelCurrentRound.setText("Round "+ (currentRound+1)); // display the current round
                    setLabelDecaultIcon();
                    nextPlayerTurn = 2; // the next turn is for player 2
                }
                else
                    JOptionPane.showMessageDialog(new JFrame(),(player2 +" is supposed to take turn this round"),"Warning",JOptionPane.WARNING_MESSAGE);
            }
            else if(e.getSource() == btnBoom2 && currentRound<maxRound){
                currentPlayerTurn = nextPlayerTurn; // current turn for the players
                if(nextPlayerTurn == 2){ // if the next turn is player 2
                    //get random number representing the player's output
                    rand = new Random();
                    randomResult2 = rand.nextInt(upperBoundary);
                    setLabelDecaultIcon(); // reset the image
                    if(randomResult1 == randomResult2) // if the result of current round is a tie
                        JOptionPane.showMessageDialog(new JFrame(),"Its a Tie"); // show warning of the game is a tie, no result will display
                    else{
                        getResult(); // to get the result of the current round
                        currentRound++;  // going to next round
                    }
                    nextPlayerTurn = 1; // the next turn is for player 1
                }
                else
                    JOptionPane.showMessageDialog(new JFrame(),(player1 +" is supposed to take turn this round"),"Warning",JOptionPane.WARNING_MESSAGE);
            }
            else if(e.getSource() == btnNextGame){  // if the button for the next game is clicked
                if(currentRound>=maxRound){  // if the current round is greater and equal to the maximum round available
                    if(currentGame<maxGame){  // if the current game is less than the maximum game available
                        saveTotalTeamScore();  //save the total score for both team into the Game class
                        clearResult(); // reset the image and score to default
                        currentGame++; // entering the next game
                    }
                    else{
                        saveTotalTeamScore(); //save the total score of the last game for both team into the Game class
                        JOptionPane.showMessageDialog(new JFrame(),"Congratz, you have finished the game, please proceed to scoreboard.","Warning",JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(),"You must proceed this game before next game.","Warning",JOptionPane.WARNING_MESSAGE);
                }
            }
            else if(e.getSource() == btnProceed){ // if the proceed button is clicked
                saveTotalTeamScore(); //save the total score of the last game for both team into the Game class
                new Screen4(currentBackground,G1,G2); //calling for next frame and passing backgroundcolor and games
                this.dispose(); // delete the current frame
            }
            else if(currentRound>=maxRound){ // if the current round is greater than and equal to the maximum game available
                if(currentGame==maxGame) // if it is the last game
                    JOptionPane.showMessageDialog(new JFrame(),"Congratz, you have finished the game, please proceed to scoreboard.","Warning",JOptionPane.WARNING_MESSAGE);
                else
                    JOptionPane.showMessageDialog(new JFrame(),"Please proceed to next game.","Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    private void init(String backgroundColor,Team T1,Team T2){
        this.currentBackground = backgroundColor;
        //set the game according to the player in Team 1 versus player in Team 2
        G1 = new Game(T1.getPlayer1Name(),T2.getPlayer1Name());
        G2 = new Game(T1.getPlayer2Name(),T2.getPlayer2Name());
        
        currentGame = 1;
        maxGame = 2;
        currentRound = 0;
        //set the maximum round available per game
        maxRound = 3;
        G1.setMaxRound(maxRound); 
        G2.setMaxRound(maxRound);
        
        nextPlayerTurn = 1; // the next turn is for player 1
        upperBoundary = 4; // upperboundary for the random
        randomResult1 = 0;
        randomResult2 = 0;
        currentTotal1 = 0;
        currentTotal2 = 0;
        
        //preset the image
        rockImage = new ImageIcon("src/resources/rock.gif");
        paperImage = new ImageIcon("src/resources/paper.gif"); 
        scissorsImage = new ImageIcon("src/resources/scissors.gif");
        lizardImage = new ImageIcon("src/resources/lizard.gif");
        spockImage = new ImageIcon("src/resources/spock.gif");
    }
    
    public void setLabelDecaultIcon(){
        //0 is rock
        //1 is paper
        //2 is scissor
        //3 is lizard
        //4 is spock
        if(currentPlayerTurn == 1){ // if the current turn is player 1
            switch(randomResult1){  // based on the random number
                case 0: // set the image to rock
                    imageDefault1 = (rockImage.getImage()).getScaledInstance(100,100,(rockImage.getImage()).SCALE_SMOOTH);
                    iconDefault1 = new ImageIcon(imageDefault1);
                    labelDefaultIcon1.setIcon(iconDefault1);
                    break;
                case 1: // set the image to paper
                    imageDefault1 = (paperImage.getImage()).getScaledInstance(100,100,(paperImage.getImage()).SCALE_SMOOTH);
                    iconDefault1 = new ImageIcon(imageDefault1);
                    labelDefaultIcon1.setIcon(iconDefault1);
                    break;
                case 2: // set the image to scissor
                    imageDefault1 = (scissorsImage.getImage()).getScaledInstance(100,100,(scissorsImage.getImage()).SCALE_SMOOTH);
                    iconDefault1 = new ImageIcon(imageDefault1);
                    labelDefaultIcon1.setIcon(iconDefault1);
                    break;
                case 3: // set the image to lizard
                    imageDefault1 = (lizardImage.getImage()).getScaledInstance(100,100,(lizardImage.getImage()).SCALE_SMOOTH);
                    iconDefault1 = new ImageIcon(imageDefault1);
                    labelDefaultIcon1.setIcon(iconDefault1);
                    break;
                case 4: // set the image to spock
                    imageDefault1 = (spockImage.getImage()).getScaledInstance(100,100,(spockImage.getImage()).SCALE_SMOOTH);
                    iconDefault1 = new ImageIcon(imageDefault1);
                    labelDefaultIcon1.setIcon(iconDefault1);
                    break;
                default: // show warning if random logic error
                    JOptionPane.showMessageDialog(new JFrame(),"Random logic error for player1","Warning",JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
        else if(currentPlayerTurn == 2){ // if the current turn is player 2
            switch(randomResult2){ // based on the random number
                case 0: // set the image to rock
                    imageDefault2 = (rockImage.getImage()).getScaledInstance(100,100,(rockImage.getImage()).SCALE_SMOOTH);
                    iconDefault2 = new ImageIcon(imageDefault2);
                    labelDefaultIcon2.setIcon(iconDefault2);
                    break;
                case 1: // set the image to paper
                    imageDefault2 = (paperImage.getImage()).getScaledInstance(100,100,(paperImage.getImage()).SCALE_SMOOTH);
                    iconDefault2 = new ImageIcon(imageDefault2);
                    labelDefaultIcon2.setIcon(iconDefault2);
                    break;
                case 2: // set the image to scissor
                    imageDefault2 = (scissorsImage.getImage()).getScaledInstance(100,100,(scissorsImage.getImage()).SCALE_SMOOTH);
                    iconDefault2 = new ImageIcon(imageDefault2);
                    labelDefaultIcon2.setIcon(iconDefault2);
                    break;
                case 3: // set the image to lizard
                    imageDefault2 = (lizardImage.getImage()).getScaledInstance(100,100,(lizardImage.getImage()).SCALE_SMOOTH);
                    iconDefault2 = new ImageIcon(imageDefault2);
                    labelDefaultIcon2.setIcon(iconDefault2);
                    break;
                case 4: // set the image to spock
                    imageDefault2 = (spockImage.getImage()).getScaledInstance(100,100,(spockImage.getImage()).SCALE_SMOOTH);
                    iconDefault2 = new ImageIcon(imageDefault2);
                    labelDefaultIcon2.setIcon(iconDefault2);
                    break;
                default: // show warning if random logic error
                    JOptionPane.showMessageDialog(new JFrame(),"Random logic error for player1","Warning",JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
        else // if the current turn is not for player 1 or player 2, show warning
            JOptionPane.showMessageDialog(new JFrame(),"Unable to set Icon for player.","Warning",JOptionPane.ERROR_MESSAGE);
    }
    
    public void currentBackground(){ // set background color
        switch(this.currentBackground){ // based on the background color
            case "Red": // set background color to red
                panelRound.setBackground(Color.red);
                panelPlayer1.setBackground(Color.red);
                panelPlayer2.setBackground(Color.red);
                panelPlayerInfo1.setBackground(Color.red);
                panelPlayerInfo2.setBackground(Color.red);
                panelBtm.setBackground(Color.red);
                panelResult.setBackground(Color.red);
                panelBtn.setBackground(Color.red);
                panelBtnNext.setBackground(Color.red);
                panelBtnProceed.setBackground(Color.red);
                break;
            case "Green": // set background color to green
                panelRound.setBackground(Color.green);
                panelPlayer1.setBackground(Color.green);
                panelPlayer2.setBackground(Color.green);
                panelPlayerInfo1.setBackground(Color.green);
                panelPlayerInfo2.setBackground(Color.green);
                panelBtm.setBackground(Color.green);
                panelResult.setBackground(Color.green);
                panelBtn.setBackground(Color.green);
                panelBtnNext.setBackground(Color.green);
                panelBtnProceed.setBackground(Color.green);
                break;
            case "Blue": // set background color to blue
                panelRound.setBackground(Color.blue);
                panelPlayer1.setBackground(Color.blue);
                panelPlayer2.setBackground(Color.blue);
                panelPlayerInfo1.setBackground(Color.blue);
                panelPlayerInfo2.setBackground(Color.blue);
                panelBtm.setBackground(Color.blue);
                panelResult.setBackground(Color.blue);
                panelBtn.setBackground(Color.blue);
                panelBtnNext.setBackground(Color.blue);
                panelBtnProceed.setBackground(Color.blue);
                break;
            case "Yellow": // set background color to yellow
                panelRound.setBackground(Color.yellow);
                panelPlayer1.setBackground(Color.yellow);
                panelPlayer2.setBackground(Color.yellow);
                panelPlayerInfo1.setBackground(Color.yellow);
                panelPlayerInfo2.setBackground(Color.yellow);
                panelBtm.setBackground(Color.yellow);
                panelResult.setBackground(Color.yellow);
                panelBtn.setBackground(Color.yellow);
                panelBtnNext.setBackground(Color.yellow);
                panelBtnProceed.setBackground(Color.yellow);
                break;
            case "Gray": // set background color to gray
                panelRound.setBackground(Color.gray);
                panelPlayer1.setBackground(Color.gray);
                panelPlayer2.setBackground(Color.gray);
                panelPlayerInfo1.setBackground(Color.gray);
                panelPlayerInfo2.setBackground(Color.gray);
                panelBtm.setBackground(Color.gray);
                panelResult.setBackground(Color.gray);
                panelBtn.setBackground(Color.gray);
                panelBtnNext.setBackground(Color.gray);
                panelBtnProceed.setBackground(Color.gray);
                break;  
        }
    }
    
    public void getResult(){
        //0 is rock
        //1 is paper
        //2 is scissor
        //3 is lizard
        //4 is spock
        
//        Scissors cuts Paper
//        Paper covers Rock
//        Rock crushes Lizard
//        Lizard poisons Spock
//        Spock smashes Scissors
//        Scissors decapitates Lizard
//        Lizard eats Paper
//        Paper disproves Spock
//        Spock vaporizes Rock
//        Rock crushes Scissors

        if(
        ((randomResult1 == 2)&&(randomResult2 == 1)) || 
        ((randomResult1 == 1)&&(randomResult2 == 0)) || 
        ((randomResult1 == 0)&&(randomResult2 == 3)) || 
        ((randomResult1 == 3)&&(randomResult2 == 4)) || 
        ((randomResult1 == 4)&&(randomResult2 == 2)) || 
        ((randomResult1 == 2)&&(randomResult2 == 3)) || 
        ((randomResult1 == 3)&&(randomResult2 == 1)) || 
        ((randomResult1 == 1)&&(randomResult2 == 4)) || 
        ((randomResult1 == 4)&&(randomResult2 == 0)) || 
        ((randomResult1 == 0)&&(randomResult2 == 2)))
            setResult(1); // set result as player 1 winning
        else if(
        ((randomResult2 == 2)&&(randomResult1 == 1)) || 
        ((randomResult2 == 1)&&(randomResult1 == 0)) || 
        ((randomResult2 == 0)&&(randomResult1 == 3)) || 
        ((randomResult2 == 3)&&(randomResult1 == 4)) || 
        ((randomResult2 == 4)&&(randomResult1 == 2)) || 
        ((randomResult2 == 2)&&(randomResult1 == 3)) || 
        ((randomResult2 == 3)&&(randomResult1 == 1)) || 
        ((randomResult2 == 1)&&(randomResult1 == 4)) || 
        ((randomResult2 == 4)&&(randomResult1 == 0)) || 
        ((randomResult2 == 0)&&(randomResult1 == 2)))
            setResult(2); // set result as player 2 winning
        else // to handle error
            JOptionPane.showMessageDialog(new JFrame(),"Unable to get result.","Warning",JOptionPane.ERROR_MESSAGE);
    }
    
    public void setResult(int winningPlayer){
        if(winningPlayer == 1){ // if the winning player is player 1
            if(currentGame == 1){ // if the current game is the first game
                switch(currentRound){ // based on the current ongoing round
                    case 0:
                        // display the result
                        labelGameScore1P1.setText("1");
                        G1.setScorePlayer1(currentRound, 1); // set the player score in Team 1
                        labelGameScore1P2.setText("0");
                        G1.setScorePlayer2(currentRound, 0); // set the player score in Team 2
                        // total score for Team 1 
                        currentTotal1++; //add 1 point for Team 1 total score
                        G1.incrementTotalScoreTeam1(); // increase the Team 1 total score in G1 object by 1
                        break;
                    case 1:
                        // display the result
                        labelGameScore2P1.setText("1");
                        G1.setScorePlayer1(currentRound, 1); // set the player score in Team 1
                        labelGameScore2P2.setText("0");
                        G1.setScorePlayer2(currentRound, 0); // set the player score in Team 2
                        // total score for Team 1 
                        currentTotal1++; //add 1 point for Team 1 total score
                        G1.incrementTotalScoreTeam1(); // increase the Team 1 total score in G1 object by 1
                        break;
                    case 2:
                        // display the result
                        labelGameScore3P1.setText("1");
                        G1.setScorePlayer1(currentRound, 1); // set the player score in Team 1
                        labelGameScore3P2.setText("0");
                        G1.setScorePlayer2(currentRound, 0); // set the player score in Team 2
                        // total score for Team 1 
                        currentTotal1++; //add 1 point for Team 1 total score
                        G1.incrementTotalScoreTeam1(); // increase the Team 1 total score in G1 object by 1
                        break;
                    default:
                        JOptionPane.showMessageDialog(new JFrame(),"Unable to set result.","Warning",JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
            else if(currentGame == 2){ // if the current game is the second game
                switch(currentRound){ // based on the current ongoing round
                    case 0:
                        // display the result
                        labelGameScore1P1.setText("1");
                        G2.setScorePlayer1(currentRound, 1); // set the player score in Team 1
                        labelGameScore1P2.setText("0");
                        G2.setScorePlayer2(currentRound, 0); // set the player score in Team 2
                        // total score for Team 1 
                        currentTotal1++; //add 1 point for Team 1 total score
                        G2.incrementTotalScoreTeam1(); // increase the Team 1 total score in G2 object by 1
                        break;
                    case 1:
                        // display the result
                        labelGameScore2P1.setText("1");
                        G2.setScorePlayer1(currentRound, 1); // set the player score in Team 1
                        labelGameScore2P2.setText("0");
                        G2.setScorePlayer2(currentRound, 0); // set the player score in Team 2
                        // total score for Team 1 
                        currentTotal1++; //add 1 point for Team 1 total score
                        G2.incrementTotalScoreTeam1(); // increase the Team 1 total score in G2 object by 1
                        break;
                    case 2:
                        // display the result
                        labelGameScore3P1.setText("1");
                        G2.setScorePlayer1(currentRound, 1); // set the player score in Team 1
                        labelGameScore3P2.setText("0");
                        G2.setScorePlayer2(currentRound, 0); // set the player score in Team 2
                        // total score for Team 1 
                        currentTotal1++; //add 1 point for Team 1 total score
                        G2.incrementTotalScoreTeam1(); // increase the Team 1 total score in G2 object by 1
                        break;
                    default:
                        JOptionPane.showMessageDialog(new JFrame(),"Unable to set result.","Warning",JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        }
        else if(winningPlayer == 2){ // if the winning player is player 2
            if(currentGame == 1){ // if the current game is the first game
                switch(currentRound){ // based on the current ongoing round
                    case 0:
                        // display the result
                        labelGameScore1P1.setText("0");
                        G1.setScorePlayer1(currentRound,0); // set the player score in Team 1
                        labelGameScore1P2.setText("1");
                        G1.setScorePlayer2(currentRound,1); // set the player score in Team 2
                        // total score for Team 2
                        currentTotal2++; //add 1 point for Team 2 total score
                        G1.incrementTotalScoreTeam2(); // increase the Team 2 total score in G1 object by 1
                        break;
                    case 1:
                        // display the result
                        labelGameScore2P1.setText("0");
                        G1.setScorePlayer1(currentRound,0); // set the player score in Team 1
                        labelGameScore2P2.setText("1");
                        G1.setScorePlayer2(currentRound,1); // set the player score in Team 2
                        // total score for Team 2
                        currentTotal2++; //add 1 point for Team 2 total score
                        G1.incrementTotalScoreTeam2(); // increase the Team 2 total score in G1 object by 1
                        break;
                    case 2:
                        // display the result
                        labelGameScore3P1.setText("0");
                        G1.setScorePlayer1(currentRound,0); // set the player score in Team 1
                        labelGameScore3P2.setText("1");
                        G1.setScorePlayer2(currentRound,1); // set the player score in Team 2
                        // total score for Team 2
                        currentTotal2++; //add 1 point for Team 2 total score
                        G1.incrementTotalScoreTeam2(); // increase the Team 2 total score in G1 object by 1
                        break;
                    default:
                        JOptionPane.showMessageDialog(new JFrame(),"Unable to set result.","Warning",JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
            else if(currentGame == 2){ // if the current game is the second game
                switch(currentRound){ // based on the current ongoing round
                    case 0:
                        // display the result
                        labelGameScore1P1.setText("0");
                        G2.setScorePlayer1(currentRound,0); // set the player score in Team 1
                        labelGameScore1P2.setText("1");
                        G2.setScorePlayer2(currentRound,1); // set the player score in Team 2
                        // total score for Team 2
                        currentTotal2++; //add 1 point for Team 2 total score
                        G2.incrementTotalScoreTeam2(); // increase the Team 2 total score in G2 object by 1
                        break;
                    case 1:
                        // display the result
                        labelGameScore2P1.setText("0");
                        G2.setScorePlayer1(currentRound,0); // set the player score in Team 1
                        labelGameScore2P2.setText("1");
                        G2.setScorePlayer2(currentRound,1); // set the player score in Team 2
                        // total score for Team 2
                        currentTotal2++; //add 1 point for Team 2 total score
                        G2.incrementTotalScoreTeam2(); // increase the Team 2 total score in G2 object by 1
                        break;
                    case 2:
                        // display the result
                        labelGameScore3P1.setText("0");
                        G2.setScorePlayer1(currentRound,0); // set the player score in Team 1
                        labelGameScore3P2.setText("1");
                        G2.setScorePlayer2(currentRound,1); // set the player score in Team 2
                        // total score for Team 2
                        currentTotal2++; //add 1 point for Team 2 total score
                        G2.incrementTotalScoreTeam2(); // increase the Team 2 total score in G2 object by 1
                        break;
                    default:
                        JOptionPane.showMessageDialog(new JFrame(),"Unable to set result.","Warning",JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        }
        else
            JOptionPane.showMessageDialog(new JFrame(),"Unable to set result.","Warning",JOptionPane.ERROR_MESSAGE);
        // update the total score in the table 
        labelScoreTotalP1.setText(Integer.toString(currentTotal1));
        labelScoreTotalP2.setText(Integer.toString(currentTotal2));
    }
    
    public void clearResult(){ // reset to default
        currentRound = 0;
        maxRound = 3;
        nextPlayerTurn = 1; // the next turn is player 1
        upperBoundary = 4; // the upperboundary for random
        randomResult1 = 0;
        randomResult2 = 0;
        currentTotal1 = 0;
        currentTotal2 = 0;
        
        labelCurrentRound.setText("Round "+ (currentRound+1));
        
        // set the next player for the next game
        labelPlayer1.setText(G2.getPlayer1Name());
        labelPlayer2.setText(G2.getPlayer2Name());
        
        // set the image to rock as default
        imageDefault1 = (rockImage.getImage()).getScaledInstance(100,100,(rockImage.getImage()).SCALE_SMOOTH);
        iconDefault1 = new ImageIcon(imageDefault1);
        labelDefaultIcon1.setIcon(iconDefault1);
        
        imageDefault2 = (rockImage.getImage()).getScaledInstance(100,100,(rockImage.getImage()).SCALE_SMOOTH);
        iconDefault2 = new ImageIcon(imageDefault2);
        labelDefaultIcon2.setIcon(iconDefault2);
        
        // reset the score
        labelGamePlayer1.setText(G2.getPlayer1Name());
        labelGameScore1P1.setText("");
        labelGameScore2P1.setText("");
        labelGameScore3P1.setText("");
        labelScoreTotalP1.setText(Integer.toString(currentTotal1));
        
        labelGamePlayer2.setText(G2.getPlayer2Name());
        labelGameScore1P2.setText("");
        labelGameScore2P2.setText("");
        labelGameScore3P2.setText("");
        labelScoreTotalP2.setText(Integer.toString(currentTotal2));
    }
    
    public void saveTotalTeamScore(){
        if(currentGame == 1){ // if the ongoing game is the first game
            // save the team score into the G1 object
            G1.setScoreTotal1(currentTotal1);
            G1.setScoreTotal2(currentTotal2);
        }
        else if(currentGame == 2){ // if the ongoing game is the second game
            // sabe the team score into the G2 object
            G2.setScoreTotal1(currentTotal1);
            G2.setScoreTotal2(currentTotal2);
        }
    }
}