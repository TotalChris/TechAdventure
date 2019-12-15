public class Adventure {

    Location currentRoom;
    Location room1;
    Location room2;
    Location room3;
    Location room4;
    Location room5;
    Location room6;
    Location room7;
    Location room8;
    Location room9;
    int hand;
    public static void main(String[] args) {
        Adventure game = new Adventure();
        game.init();
        game.moveToRoom(game.room8);
    }
    /**
     * Moves the player to a new room using the direction specified
     *
     * @param i The integer code specifying the direction to move in. Direction codes can be used by using the notation Exit.DIRECTION
     * @return True if the player was successfully moved. False if there is no link in that direction
     */
    public boolean moveInDirection(int i){
        Location nextRoom = currentRoom.getExit(i).getLeadsTo();
        if(nextRoom == null){
            return false;
        }
        currentRoom = nextRoom;
        currentRoom.enter(hand);
        return true;
    }
    /**
     * Moves the player to the new room specified
     *
     * @param room The new room to move to. The new room must be a Location.
     * @return True if the player was successfully moved. False if there is no link in that direction
     *
     * @see Location
     */
    public boolean moveToRoom(Location room){
        currentRoom = room;
        return true;
    }
    /**
     * Creates the rooms used by the game, and links them
     * together via each room's 'exits' vector.
     */
    public void init(){
                //construct the game
                room1 = new Location("High-Value GPU Stockroom");
                room2 = new Location("GPU Stockroom");
                room3 = new Location("Motherboard/PSU Stockroom");
                room4 = new Location("CPU Stockroom");
                room5 = new Location("Main Room");
                room6 = new Location("Case/RAM Stockroom");
                room7 = new Location("High-Value CPU Stockroom");
                room8 = new Location("Entryway");
                room9 = new Location("Security Room");
        
                //room1
                room1.addExit(new Exit(Exit.EAST, room2));
        
                //room2
                room2.addExit(new Exit(Exit.WEST, room1));
                room2.addExit(new Exit(Exit.SOUTH, room5));
                
                //room3
                room3.addExit(new Exit(Exit.SOUTH, room6));
                
                //room4
                room4.addExit(new Exit(Exit.SOUTH, room7));
                room4.addExit(new Exit(Exit.EAST, room5));
                
                //room5
                room5.addExit(new Exit(Exit.NORTH, room2));
                room5.addExit(new Exit(Exit.WEST, room4));
                room5.addExit(new Exit(Exit.EAST, room6));
                room5.addExit(new Exit(Exit.SOUTH, room8));
                
                //room6
                room6.addExit(new Exit(Exit.NORTH, room3));
                room6.addExit(new Exit(Exit.WEST, room5));
                room6.addExit(new Exit(Exit.SOUTH, room9));
                
                //room7
                room7.addExit(new Exit(Exit.NORTH, room4));
                
                //room8
                room8.addExit(new Exit(Exit.NORTH, room5));
        
                //room9
                room9.addExit(new Exit(Exit.NORTH, room6));
    }
}
