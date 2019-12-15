import java.util.Vector;

//
//
// Location - represents a gaming location
//
// Last modification date : October 08, 1997
//

public class Location {
    // Member variables
    private String roomTitle;
    private String roomDescription;
    private Vector<Exit> exits;

    private Vector<GameEvent> events;
    /**
     * Instantiates a new Location.
     */
// Blank constructor
    public Location() {
        // Blank title + description
        roomTitle = "";
        roomDescription = "";
        exits = new Vector<>();
    }


    /**
     * Instantiates a new Location.
     *
     * @param title the name of the room
     */
// Partial constructor
    public Location(String title) {
        // Assign title
        roomTitle = title;

        // Blank description
        roomDescription = "";

        // Blank exits
        exits = new Vector<>();
    }

    /**
     * Instantiates a new Location.
     *
     * @param title       the title of the room
     * @param description the description of the room
     */
// Full constructor
    public Location(String title, String description) {
        // Assign title + description
        roomTitle = title;
        roomDescription = description;

        // Blank exits
        exits = new Vector<>();
    }

    /**
     * Returns the string equivalent of the Location. Produces the same response as getTitle()
     *
     * @return The location's title.
     */
    // toString method
    public String toString() {
        return roomTitle;
    }

    /**
     * Add an exit point to this Location. It is good practice to specify a direction for the Exit prior to adding it. This way, it is easy to find using getExit() later on.
     *
     * @param exit The exit to add.
     */
// Adds an exit to this location
    public void addExit(Exit exit) {
        exits.add(exit);
    }

    /**
     * Remove an exit from this Location.
     *
     * @param exit the exit to remove
     * @return True if the exit point was removed from the list. False if the exit point was not found in the list.
     */
    public boolean removeExit(Exit exit) {
        return exits.remove(exit);
    }

    /**
     * Gets the exit vector for this Location.
     *
     * @return The exit vector for this Location
     */
    public Vector<Exit> getAllExits() {
        return exits;
    }

    /**
     * Get a specific exit for the Location based on a direction code
     *
     * @param i The direction code, specified in the Exit class.
     * @return The exit that resides in that direction. If no direction is found, returns null.
     */
    public Exit getExit(int i){
        for (Exit e: exits) {
            if(e.getDirectionName().equals(Exit.dirName[i])){
                return e;
            }
        }
        return null;
    }

    /**
     * Gets the Location title.
     *
     * @return The Location title
     */
    public String getTitle() {
        return roomTitle;
    }
    /**
     * Sets the Location title.
     *
     * @param title The new Location title
     */
    public void setTitle(String title) {
        roomTitle = title;
    }

    /**
     * Gets the Location description.
     *
     * @return The Location description
     */
    public String getDescription() {
        return roomDescription;
    }

    /**
     * Sets the Location description.
     *
     * @param description The new Location description
     */
    public void setDescription(String description) {
        roomDescription = description;
    }

    public void setOnEnter(GameEvent e){
        onEnter = e;
    }

    public void enter(int hand){
        onEnter.react(hand);
    }
}
