package game.football.controller;

import game.football.helper.Helper;
import game.football.model.Team;

import java.util.ArrayList;
import java.util.List;


public class TournamentController {

    private List<Team> initialTeams = new ArrayList<>();
    private List<Team> secondRoundTeams = new ArrayList<>();
    private List<Team> halfFinalistTeams = new ArrayList<>();
    private List<Team> finalistTeams = new ArrayList<>();

    private Helper helper = new Helper();

//    private GameController game = new GameController();

    public TournamentController() {
        this.setUp();
    }

    public void run() {
        this.startTournament();
        List[] gamesToPlay = {initialTeams, secondRoundTeams, halfFinalistTeams, finalistTeams};
        play(gamesToPlay);
    }

    private void play(List[] arr) {
        int i = 0;

        for (List<Team> tList : arr) {
            if (i < arr.length - 1) {
                List<Team> nextList = arr[++i];

                for (int a = 0; a < tList.size() / 2; a++) {
                    GameController game = new GameController(tList.get(a), tList.get(tList.size() - 1 - a));
                    nextList.add(game.run());
                }
                
                System.out.println("Whooo, that was exciting! ");

                System.out.println("Here is a list of all the remaining participants:");

                for (Team team : nextList) {
                    System.out.println("- " + team.getName());
                }

                System.out.println("Let's continue to the next round!" + i);
            } else {
                System.out.println(this.finalistTeams.get(0).getName() + "HAS WON THIS TOURNAMENT!!!!!");
            }


        }
    }

}
//
//    private void playFirstRound() {
//        for(int i = 0; i < 4; i++){
//            GameController game = new GameController(this.initialTeams.get(i), this.initialTeams.get(7-i));
//            secondRoundTeams.add(game.run());
//        }
//        System.out.println("Whooo, that was exciting! ");
//        System.out.println("Here is a list of all the remaining participants:");
//        for(Team team : secondRoundTeams) {
//            System.out.println("- " + team.getName());
//        }
//        System.out.println("Let's continue to the half finals!");
//
//    }

    private void startTournament() {
        System.out.println("Welcome to this tournament, it will be very exiting!");
        System.out.println("Here is a list of all the participants:");
        for (Team team : initialTeams) {
            System.out.println("- " + team.getName());
        }
        System.out.println("Let's get ready for the first knock out round!");
        this.helper.sleep(1);

    }

    private void setUp() {

        String profTeamNames[] = {"Ajax", "Feyenoord", "PSV", "FC Twente"};
        String amatTeamNames[] = {"FC Hoofddorp", "Alpha Boys", "Stormtroopers", "FC de Keepers"};

        for (String name : profTeamNames) {
            initialTeams.add(new Team(name, true));
        }

        for (String name : amatTeamNames) {
            initialTeams.add(new Team(name, false));
        }

    }


}
