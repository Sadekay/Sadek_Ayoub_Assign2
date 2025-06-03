package Assign2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeamManager {
    private List<Team> teams;
    
    public TeamManager() {
        teams = new ArrayList<>();
    }
    
    public void loadTeamsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String teamName = data[0].trim();
                    String city = data[1].trim();
                    String coachName = data[2].trim();
                    int yearsExp = Integer.parseInt(data[3].trim());
                    
                    // Create coach and team
                    Coach coach = new Coach("", coachName, teamName, yearsExp);
                    Team team = new Team(teamName, city, coach);
                    teams.add(team);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading teams: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing years of experience: " + e.getMessage());
        }
    }
    
    public void displayTeams() {
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-12s %-15s %-30s %s%n", "Team", "City", "Coach", "Players");
        System.out.println("-------------------------------------------------------------------");
        
        for (Team team : teams) {
            System.out.println(team);
        }
    }
    
    public Team findTeam(String teamName) {
        for (Team team : teams) {
            if (team.getTeamName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        return null;
    }
    
    public void addTeam(String teamName, String city, String coachName, int yearsOfExperience) {
        Coach coach = new Coach("", coachName, teamName, yearsOfExperience);
        Team team = new Team(teamName, city, coach);
        teams.add(team);
    }
    
    public List<Team> getTeams() {
        return teams;
    }
}
