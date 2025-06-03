package Assign2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Team implements Serializable {
    private static final long serialVersionUID = 1L;
    private String teamName;
    private String city;
    private Coach coach;
    private List<Player> players;
    
    public Team(String teamName, String city, Coach coach) {
        this.teamName = teamName;
        this.city = city;
        this.coach = coach;
        this.players = new ArrayList<>();
    }
    
    public void addPlayer(Player player) {
        players.add(player);
    }
    
    public List<Player> getPlayers() {
        return players;
    }
    
 
    public String getTeamName() {
    	return teamName; }
    
    public String getCity() {
    	return city; }
    
    public Coach getCoach() {
    	return coach; }
    
    @Override
    public String toString() {
        return String.format("%-12s %-15s %-30s %d", 
                teamName, city, coach.toString(), players.size());
    }
}