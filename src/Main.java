import java.io.IOException;
import java.util.List;

public class Main {

    /**
     * The main method serves as the entry point for the application.
     * It loads players from a CSV file, selects a team based on a specified formation,
     * and prints the selected team to the console.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if an I/O error occurs while loading players
     */

    public static void main(String[] args) throws IOException {

        List<Player> players = PlayerLoader.loadPlayers("players.csv");
        Formation formation = new Formation(4, 4, 2);   //selecting our formation
        TeamSelector selector = new TeamSelector();
        Team egypt = selector.selectTeam(players, formation);
        System.out.println("Egyptian National Team:\n" + egypt);
    }
}