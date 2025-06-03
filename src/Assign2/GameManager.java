package Assign2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Game> games;
    
    public GameManager() {
        games = new ArrayList<>();
    }
    
    public void loadGamesFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String team1 = data[0].trim();
                    String team2 = data[1].trim();
                    String date = data[2].trim();
                    String location = data[3].trim();
                    String score = data[4].trim();
                    
                    Game game = new Game(team1, team2, date, location, score);
                    games.add(game);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading games: " + e.getMessage());
        }
    }
    
    public void displayGames() {
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-12s %-12s %-12s %-18s %s%n", "Team 1", "Team 2", "Date", "Location", "Score");
        System.out.println("-------------------------------------------------------------------");
        
        for (Game game : games) {
            System.out.println(game);
        }
    }
    
    public List<Game> getGames() {
        return games;
    }
}