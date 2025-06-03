package Assign2;

import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    private String playerId;
    private String name;
    private int age;
    private String teamName;
    private String position;
    
    public Player(String playerId, String name, int age, String teamName, String position) {
        this.playerId = playerId;
        this.name = name;
        this.age = age;
        this.teamName = teamName;
        this.position = position;
    }
    
    // Getters
    public String getPlayerId() {
    	return playerId; }
    
    public String getName() {
    	return name; }
    
    public int getAge() { 
    	return age; }
    
    public String getTeamName() {
    	return teamName; }
    
    public String getPosition() {
    	return position; }
    
    @Override
    public String toString() {
        return String.format("%-5s %-18s %-4d %-12s %-18s", 
                playerId, name, age, teamName, position);
    }
}