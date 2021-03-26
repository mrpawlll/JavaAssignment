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

public class Team {
    protected String Player1Name, Player2Name;
    public Team(){
        this.Player1Name = "Null";
        this.Player2Name = "Null";
    }
    public void setPlayer1Name(String name){
        this.Player1Name = name;
    }
    public void setPlayer2Name(String name){
        this.Player2Name = name;
    }
    public String getPlayer1Name(){
        return this.Player1Name;
    }
    public String getPlayer2Name(){
        return this.Player2Name;
    }
    public boolean isPlayer1Null(){
        if(Player1Name == "Null")
            return true;
        else
            return false;
    }
    public boolean isPlayer2Null(){
        if(Player2Name == "Null")
            return true;
        else
            return false;
    }
}