import java.util.ArrayList;
import java.util.List;

/**
 * Represents a selected football team consisting of
 * a formation and eleven players.
 */

public class Team {
    private final List<Player> players;
    private final Formation formation;

    public Team(Formation formation) {
        this.formation = formation;
        this.players = new ArrayList<>();
    }


    /**
     * Calculates the overall rating of the team by averaging
     * the overall ratings of all players in the team.
     *
     * @return the average overall rating of the team
     */

    public double getTeamOverallRating() {
        double total = 0;
        for (Player player : players) {
            total += player.getOverallRating();
        }
        return total / players.size();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Formation: ").append(formation).append("\n");
        sb.append("Players:\n");
        for (Player player : players) {
            sb.append(player).append("\n");
        }
        sb.append("Team Overall Rating: ").append(String.format("%.0f", this.getTeamOverallRating()));
        return sb.toString();
    }
}