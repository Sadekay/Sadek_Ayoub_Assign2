package Assign2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private List<Player> players;
    private TeamManager teamManager;
    
    public PlayerManager(TeamManager teamManager) {
        this.players = new ArrayList<>();
        this.teamManager = teamManager;
    }
    
    public void loadPlayersFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String playerId = data[0].trim();
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    String teamName = data[3].trim();
                    String position = data[4].trim();
                    
                    Player player = new Player(playerId, name, age, teamName, position);
                    players.add(player);
                    
                    // Add player to team
                    Team team = teamManager.findTeam(teamName);
                    if (team != null) {
                        team.addPlayer(player);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading players: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing player age: " + e.getMessage());
        }
    }
    
    public void displayPlayers() {
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-5s %-18s %-4s %-12s %-18s%n", "ID", "Player", "Age", "Team", "Position");
        System.out.println("-------------------------------------------------------------------");
        
        for (Player player : players) {
            System.out.println(player);
        }
    }
    
    public void addPlayer(String playerId, String name, int age, String teamName, String position) {
        Player player = new Player(playerId, name, age, teamName, position);
        players.add(player);
        
       
        Team team = teamManager.findTeam(teamName);
        if (team != null) {
            team.addPlayer(player);
        }
    }
    
    public List<Player> getPlayers() {
        return players;
    }
}