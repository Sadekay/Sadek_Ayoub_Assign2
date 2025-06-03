package Assign2;

import java.util.Scanner;

public class NFLManagementSystem {
    private TeamManager teamManager;
    private PlayerManager playerManager;
    private GameManager gameManager;
    private Scanner scanner;
    
    public NFLManagementSystem() {
        teamManager = new TeamManager();
        playerManager = new PlayerManager(teamManager);
        gameManager = new GameManager();
        scanner = new Scanner(System.in);
        
       
        try {
            teamManager.loadTeamsFromFile("src/teams.csv");
            playerManager.loadPlayersFromFile("src/players.csv");
            gameManager.loadGamesFromFile("src/games.csv");
        } catch (Exception e) {
            System.out.println("Error loading data files: " + e.getMessage());
        }
        
        System.out.println("\nNote: The 'coaches.csv' file was not used because all coach information");
        System.out.println("is already included in the 'teams.csv' file.\n");
        
        System.out.println("Serializable Interface Explanation:");
        System.out.println("The Serializable interface allows objects to be converted to a byte stream");
        System.out.println("for storage or transmission. The serialVersionUID is a version control number");
        System.out.println("that ensures compatibility when deserializing objects in a distributed system.");
    }
    
    public void showMenu() {
        while (true) {
            System.out.println("\nNFL Operations Management System");
            System.out.println("1. Display Teams");
            System.out.println("2. Display Players");
            System.out.println("3. Display Scheduled Games");
            System.out.println("4. Add Team");
            System.out.println("5. Add Player to Team");
            System.out.println("6. Find Team");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("***Error: Choice cannot be empty. Please try again.***");
                    continue;
                }
                
                int choice = Integer.parseInt(input);
                
                switch (choice) {
                    case 1:
                        teamManager.displayTeams();
                        break;
                    case 2:
                        playerManager.displayPlayers();
                        break;
                    case 3:
                        gameManager.displayGames();
                        break;
                    case 4:
                        addTeamInteractive();
                        break;
                    case 5:
                        addPlayerInteractive();
                        break;
                    case 6:
                        findTeamInteractive();
                        break;
                    case 7:
                        System.out.println("\n*****************************************************");
                        System.out.println("  Programmed By Sadek");
                        System.out.println("  ...Exiting the program...");
                        System.out.println("*****************************************************");
                        return;
                    default:
                        System.out.println("***Invalid choice. Please enter a number between 1-7.***");
                }
            } catch (NumberFormatException e) {
                System.out.println("***Invalid input. Please enter a numeric value.***");
            }
        }
    }
    
    private void addTeamInteractive() throws NumberFormatException {
        while (true) {
            try {
                System.out.print("Enter team name: ");
                String teamName = scanner.nextLine().trim();
                if (teamName.isEmpty()) {
                    throw new IllegalArgumentException("Team name cannot be empty");
                }
                
                System.out.print("Enter city: ");
                String city = scanner.nextLine().trim();
                if (city.isEmpty()) {
                    throw new IllegalArgumentException("City cannot be empty");
                }
                
                System.out.print("Enter coach name: ");
                String coachName = scanner.nextLine().trim();
                if (coachName.isEmpty()) {
                    throw new IllegalArgumentException("Coach name cannot be empty");
                }
                
                System.out.print("Enter coach years of experience: ");
                String yearsExpInput = scanner.nextLine().trim();
                if (yearsExpInput.isEmpty()) {
                    throw new IllegalArgumentException("Years of experience cannot be empty");
                }
                
                int yearsExp = Integer.parseInt(yearsExpInput);
                if (yearsExp < 0) {
                    throw new IllegalArgumentException("Years of experience cannot be negative");
                }
                
                // Check if team already exists
                if (teamManager.findTeam(teamName) != null) {
                    throw new IllegalArgumentException("Team '" + teamName + "' already exists");
                }
                
                teamManager.addTeam(teamName, city, coachName, yearsExp);
                System.out.println("Team added successfully!");
                break;
                
            } catch (IllegalArgumentException e) {
                System.out.println("***Error: " + e.getMessage() + ". Please try again.***");
            }
        }
    }
    
    private void addPlayerInteractive() throws NumberFormatException {
        while (true) {
            try {
                System.out.print("Enter player ID: ");
                String playerId = scanner.nextLine().trim();
                if (playerId.isEmpty()) {
                    throw new IllegalArgumentException("Player ID cannot be empty");
                }
                
             
                System.out.print("Enter player name: ");
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Player name cannot be empty");
                }
                
                System.out.print("Enter player age: ");
                String ageInput = scanner.nextLine().trim();
                if (ageInput.isEmpty()) {
                    throw new IllegalArgumentException("Age cannot be empty");
                }
                
                int age = Integer.parseInt(ageInput);
                if (age < 18 || age > 60) {
                    throw new IllegalArgumentException("Age must be between 18 and 60");
                }
                
                System.out.print("Enter team name: ");
                String teamName = scanner.nextLine().trim();
                if (teamName.isEmpty()) {
                    throw new IllegalArgumentException("Team name cannot be empty");
                }
                
               
                if (teamManager.findTeam(teamName) == null) {
                    throw new IllegalArgumentException("Team '" + teamName + "' does not exist");
                }
                
                System.out.print("Enter player position: ");
                String position = scanner.nextLine().trim();
                if (position.isEmpty()) {
                    throw new IllegalArgumentException("Position cannot be empty");
                }
                
                playerManager.addPlayer(playerId, name, age, teamName, position);
                System.out.println("Player added successfully!");
                break;
                
            } catch (IllegalArgumentException e) {
                System.out.println("***Error: " + e.getMessage() + ". Please try again.***");
            }
        }
    }
    
    private void findTeamInteractive() {
        while (true) {
            try {
                System.out.print("Enter team name to search: ");
                String teamName = scanner.nextLine().trim();
                if (teamName.isEmpty()) {
                    throw new IllegalArgumentException("Team name cannot be empty");
                }
                
                Team team = teamManager.findTeam(teamName);
                if (team != null) {
                    System.out.println("Team found: " + team);
                } else {
                    System.out.println("Team '" + teamName + "' not found.");
                }
                break;
                
            } catch (IllegalArgumentException e) {
                System.out.println("***Error: " + e.getMessage() + ". Please try again.***");
            }
        }
    }
    
    public static void main(String[] args) {
        NFLManagementSystem system = new NFLManagementSystem();
        system.showMenu();
    }
}
