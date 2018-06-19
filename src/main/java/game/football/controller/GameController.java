package game.football.controller;

import game.football.helper.Helper;
import game.football.model.Team;

public class GameController {

    private Team homeTeam;
    private Team awayTeam;

    private Team winner;

    private int scoreHomeTeam;
    private int scoreAwayTeam;

    private Helper helper = new Helper();

    public GameController(Team homeTeam, Team awayTeam) {
        this.setAwayTeam(awayTeam);
        this.setHomeTeam(homeTeam);
    }

    public Team run() {
        this.startGame();
        this.gameProgress();
        this.isWinner();
        if(this.winner != null) {
            return this.getWinner();
        }
        this.penalties();

        return this.getWinner();

    }

    private void penalties() {
        int penHomeTeam = 0;
        int penAwayTeam = 0;

        int penScoreHomeTeam = 0;
        int penScoreAwayTeam = 0;

        boolean penWin = false;

        int i = 1;

        while (!penWin ) {
            int[] score = this.takePenalties(i);
            penHomeTeam++;
            penAwayTeam++;
            penScoreHomeTeam += score[0];
            penScoreAwayTeam += score[1];
            i++;
            penWin = this.getWinCondition( penHomeTeam, penAwayTeam, penScoreHomeTeam, penScoreAwayTeam);
            if(penWin){
                if ( penScoreHomeTeam > penScoreAwayTeam) {
                    this.setWinner(this.homeTeam);
                } else if (penScoreAwayTeam > penScoreHomeTeam){
                    this.setWinner(this.awayTeam);
                }

            }
        }


    }

    private int[] takePenalties(int i) {
        double homeTeamChance = this.homeTeam.getHandicap() * Math.random();
        double awayTeamChance = this.awayTeam.getHandicap() * Math.random();

        double measure = 0.3;

        int homeScore = 0;
        int awayScore = 0;

        if ( homeTeamChance > measure) {
            System.out.println("Round: " + i + ", "+ this.homeTeam.getName()+ " Score!");
            homeScore++;
        } else {
            System.out.println("Round: " + i + " OOOOHH, " + this.homeTeam.getName() + " missed!");
        }

        if ( awayTeamChance > measure) {
            System.out.println("Round: " + i + ", "+ this.awayTeam.getName()+ " Score!");
            awayScore++;
        } else {
            System.out.println("Round: " + i + " OOOOHH, " + this.awayTeam.getName() + " missed!");
        }
        int[] a = {homeScore, awayScore};
        return a;

    }

    private boolean getWinCondition(int penHomeTeam, int penAwayTeam, int penScoreHomeTeam, int penScoreAwayTeam) {
        if ( penHomeTeam > 5 || penAwayTeam > 5 ) {
            if( penScoreHomeTeam != penScoreAwayTeam){
                return true;
            }
        }

        return false;


    }

    private void isWinner() {
        if (this.scoreHomeTeam > this.scoreAwayTeam ) {
            System.out.println("The Winner is " + this.homeTeam.getName() +"!! with a score of " + this.scoreHomeTeam + " against " + this.scoreAwayTeam);
            this.setWinner(this.homeTeam);
        } else if (this.scoreAwayTeam > this.scoreHomeTeam) {
            System.out.println("The Winner is " + this.awayTeam.getName() +"!! with a score of " + this.scoreAwayTeam + " against " + this.scoreHomeTeam);
            this.setWinner(this.awayTeam);
        } else {
            System.out.println("No winner could be determined int he regular 90 minutes.. It's time for Penalties!");
        }
        helper.sleep(1);
    }

    private void gameProgress() {

        for (int i = 1; i < 10; i++) {
            int min = i * 10;
            System.out.println("This is an update in the " + min + " minute");
            this.events();
        }

    }

    private void events() {

        double homeTeamChance = this.homeTeam.getHandicap() * Math.random();
        double awayTeamChance = this.awayTeam.getHandicap() * Math.random();

        if (homeTeamChance > awayTeamChance && homeTeamChance > 0.6) {
            System.out.println(this.homeTeam.getName() + " SCORED!! It's an Amazing goal from the home team");
            this.scoreHomeTeam++;
            System.out.println("The score now is: " + this.homeTeam.getName() + " " + this.scoreHomeTeam + " against " +
                    this.awayTeam.getName() + " " + this.scoreAwayTeam);
        } else if (awayTeamChance > homeTeamChance && awayTeamChance > 0.6) {
            System.out.println(this.awayTeam.getName() + " SCORED!! It's an Amazing goal from the away team");
            this.scoreAwayTeam++;
            System.out.println("The score now is: " + this.homeTeam.getName() + " " + this.scoreHomeTeam + " against " +
                    this.awayTeam.getName() + " " + this.scoreAwayTeam);
        } else {
            System.out.println("It has been an exiting 10 minutes, no goals but the game continues.. ");
        }
    }

    private void startGame() {
        System.out.println("The game is starting");
        System.out.println("It's " + homeTeam.getName() + " against " + awayTeam.getName());
        System.out.println("This match is promising! ");
        this.helper.sleep(1);
    }

    public Team getHome_team() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }
}
