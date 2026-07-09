/**
 * Represents a football formation.
 * Goalkeepers are implicit and always equal to one.
 */

public record Formation(int defenders, int midfielders, int strikers) {
    public Formation {

        // A valid formation must contain exactly
        // ten outfield players plus one goalkeeper.
        if (defenders + midfielders + strikers != 10) {
            throw new IllegalArgumentException("The total number of outfield players must be 10.");
        }
    }

    @Override
    public String toString() {
        return defenders + "-" + midfielders + "-" + strikers;
    }
}