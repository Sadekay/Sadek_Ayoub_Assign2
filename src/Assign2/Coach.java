package Assign2;

import java.io.Serializable;

public class Coach implements Serializable {
    private static final long serialVersionUID = 1L;
    private String coachId;
    private String name;
    private String teamName;
    private int yearsOfExperience;
    
    public Coach(String coachId, String name, String teamName, int yearsOfExperience) {
        this.coachId = coachId;
        this.name = name;
        this.teamName = teamName;
        this.yearsOfExperience = yearsOfExperience;
    }
    
    
    public String getCoachId() {
    	return coachId; }
    
    public String getName() {
    	return name; }
    
    public String getTeamName() {
    	return teamName; }
    
    public int getYearsOfExperience() {
    	return yearsOfExperience; }
    
    @Override
    public String toString() {
        return name + " (" + yearsOfExperience + " years)";
    }
}