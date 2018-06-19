package game.football;

import game.football.controller.TournamentController;


public class App 
{
    public static void main( String[] args )
    {
        TournamentController tournament = new TournamentController();
        tournament.run();
    }
}
