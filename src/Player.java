/**
 * Represents a football player and stores all attributes
 * used to evaluate their suitability for their position
*/

public class Player {

    private final String name;

    private final int height, reflexes, strength, speed, passing, finishing, stamina, tackling, dribbling, skills;

    public enum Position {  // Enum to represent the position of a player. Better than using strings to avoid typos and ensure type safety.
        GOALKEEPER, DEFENDER, MIDFIELDER, STRIKER
    }

    private final Position position;

    public Player(String name, Position position, int height, int reflexes, int strength, int speed, int passing, int finishing, int stamina, int tackling, int dribbling, int skills) {
        this.name = name;
        this.position = position;
        this.height = height;
        this.reflexes = reflexes;
        this.strength = strength;
        this.speed = speed;
        this.passing = passing;
        this.finishing = finishing;
        this.stamina = stamina;
        this.tackling = tackling;
        this.dribbling = dribbling;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public int getHeight() {
        return height;
    }

    public int getReflexes() {
        return reflexes;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPassing() {
        return passing;
    }

    public int getFinishing() {
        return finishing;
    }

    public int getStamina() {
        return stamina;
    }

    public int getTackling() {
        return tackling;
    }

    public int getDribbling() {
        return dribbling;
    }

    public int getSkills() {
        return skills;
    }


    /**
     * Calculates the player's overall rating using a
     * position-specific weighted formula.
     *
     * @return overall rating of the player
     */

    public double getOverallRating() {
        return switch (position) {
            case GOALKEEPER ->
                    (reflexes * 0.4 + strength * 0.15 + speed * 0.1 + passing * 0.1 + height * 0.25);
            case DEFENDER ->
                    (tackling * 0.3 + strength * 0.25 + height * 0.2 + stamina * 0.1 + speed * 0.1+ passing * 0.05);
            case MIDFIELDER ->
                    (passing * 0.25 + dribbling * 0.2 + skills * 0.2 + stamina * 0.15 + speed * 0.1 + strength * 0.1);
            case STRIKER ->
                    (finishing * 0.35 + speed * 0.2 + strength * 0.15 + dribbling * 0.15 + skills * 0.1 + stamina * 0.05);
            default -> 0.0;
        };
    }

    @Override
    public String toString() {
        return name + " (" + position + ") is rated " + String.format("%.0f", this.getOverallRating()) + " overall.";
    }
}