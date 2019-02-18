package game;

import base.User;

public class GameUser extends User {
    private String enemyName;
    private int myScore = 0;
    private int enemyScore = 0;

    public GameUser(String myName) { super(myName); }

    public String getEnemyName() { return enemyName; }

    public int getMyScore() { return myScore; }

    public int getEnemyScore() { return  enemyScore; }

    public void incrementMyScore() { myScore++; }

    public void incrementEnemyScore() { enemyScore++; }

    public void setEnemyName(String enemyName) { this.enemyName = enemyName; }
}
