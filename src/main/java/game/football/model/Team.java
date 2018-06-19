package game.football.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Team {

    private boolean professional = false;
    private double handicap;

    private String name;

    public Team(String name, Boolean professional) {
        this.setName(name);
        this.setProfessional(professional);
        this.setHandicap();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isProfessional() {
        return professional;
    }

    public void setProfessional(boolean professional) {
        this.professional = professional;
        this.setHandicap();
    }

    private void setHandicap(){
        if (professional) {
            this.handicap = 0.9;
        } else {
            this.handicap = 0.7;
        }
    }

    public double getHandicap() {
        return handicap;
    }
}
