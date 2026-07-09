import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for loading players from a CSV file.
 */

public class PlayerLoader {

    /**
     * Loads players from a CSV file and returns a list of Player objects.
     *
     * @param filename the path to the CSV file containing player data
     * @return a list of Player objects loaded from the CSV file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static List<Player> loadPlayers(String filename) throws IOException {
        List<Player> players = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        reader.readLine(); // Skip header line
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            Player player = new Player(
                    data[0],
                    Player.Position.valueOf(data[1]),
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3]),
                    Integer.parseInt(data[4]),
                    Integer.parseInt(data[5]),
                    Integer.parseInt(data[6]),
                    Integer.parseInt(data[7]),
                    Integer.parseInt(data[8]),
                    Integer.parseInt(data[9]),
                    Integer.parseInt(data[10]),
                    Integer.parseInt(data[11])
            );  //convert a CSV record into a Player object
            players.add(player);
        }
        reader.close();
        return players;
    }
}