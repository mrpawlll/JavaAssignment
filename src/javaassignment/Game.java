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

public class Game{
    private final String Player1Name,Player2Name;
    private int totalScoreTeam1, totalScoreTeam2, scoreTeam1, scoreTeam2, maxRound;
    private int []scoreP1;
    private int []scoreP2;
    public Game(String player1, String player2){
        this.maxRound = 0;
        this.totalScoreTeam1 = 0;
        this.totalScoreTeam2 = 0;
        this.Player1Name = player1;
        this.Player2Name = player2;
    }
    public String getPlayer1Name(){
        return this.Player1Name;
    }
    public String getPlayer2Name(){
        return this.Player2Name;
    }
    public int[] getScorePlayer1(){
        return this.scoreP1;
    }
    public int[] getScorePlayer2(){
        return this.scoreP2;
    }
    public int getTotalScoreTeam1(){
        return this.totalScoreTeam1;
    }
    public int getTotalScoreTeam2(){
        return this.totalScoreTeam2;
    }
    public int getMaxRound(){
        return this.maxRound;
    }
    public int getScoreTotal1(){
        return this.scoreTeam1;
    }
    public int getScoreTotal2(){
        return this.scoreTeam2;
    }
    public void setScorePlayer1(int currentRound, int score){
        scoreP1[currentRound] = score;
    }
    public void setScorePlayer2(int currentRound, int score){
        scoreP2[currentRound] = score;
    }
    public void incrementTotalScoreTeam1(){
        this.totalScoreTeam1++;
    }
    public void incrementTotalScoreTeam2(){
        this.totalScoreTeam2++;
    }
    public void setMaxRound(int max){
        this.maxRound = max;
        this.scoreP1 = new int[maxRound];
        this.scoreP2 = new int[maxRound];
    }
    public void setScoreTotal1(int num){
        this.scoreTeam1 = num;
    }
    public void setScoreTotal2(int num){
        this.scoreTeam2 = num;
    }
}