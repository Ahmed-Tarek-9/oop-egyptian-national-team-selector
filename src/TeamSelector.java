import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Responsible for selecting the best possible team
 * according to a given formation.
 */


public class TeamSelector {

    /**
     * Selects the best possible team from a list of players according to a given formation.
     *
     * @param players the full list of avaialable players
     * @param formation the desired formation for the team
     * @return the best possible team according to the given formation
     * @throws IllegalArgumentException if there are not enough players to satisfy the formation
     */
    public Team selectTeam(List<Player> players, Formation formation) {

        List<Player> goalkeepers = new ArrayList<>();
        List<Player> defenders = new ArrayList<>();
        List<Player> midfielders = new ArrayList<>();
        List<Player> strikers = new ArrayList<>();

        for (Player p : players) {      // separate the players into their respective positions
            switch (p.getPosition()) {
                case GOALKEEPER:
                    goalkeepers.add(p);
                    break;
                case DEFENDER:
                    defenders.add(p);
                    break;
                case MIDFIELDER:
                    midfielders.add(p);
                    break;
                case STRIKER:
                    strikers.add(p);
                    break;
            }
        }

        // sort each position list by overall rating in descending order
        goalkeepers.sort(Comparator.comparingDouble(Player::getOverallRating).reversed());
        defenders.sort(Comparator.comparingDouble(Player::getOverallRating).reversed());
        midfielders.sort(Comparator.comparingDouble(Player::getOverallRating).reversed());
        strikers.sort(Comparator.comparingDouble(Player::getOverallRating).reversed());


        if (goalkeepers.isEmpty() ||
                defenders.size() < formation.defenders() ||
                midfielders.size() < formation.midfielders() ||
                strikers.size() < formation.strikers()) {

            throw new IllegalArgumentException(
                    "Not enough players to satisfy formation."
            );
        }


        Team team = new Team(formation);

        team.addPlayer(goalkeepers.getFirst()); // Add the best goalkeeper

        for (int i = 0; i < formation.defenders(); i++) {
            team.addPlayer(defenders.get(i));
        }

        for (int i = 0; i < formation.midfielders(); i++) {
            team.addPlayer(midfielders.get(i));
        }

        for (int i = 0; i < formation.strikers(); i++) {
            team.addPlayer(strikers.get(i));
        }

        return team;
    }
}