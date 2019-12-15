/**
 * CS1131 Final Project
 * 
 * Last edited on 12/10/19
 * 
 * @author Ryan Miller, Chris Haueisen, Ethan Brinks, Kirk Macquarrie
 */

public class TechAdventure implements ConnectionListener{
    AdventureServer adventureServer = null;

    public static void main(String[] args) {
        AdventureServer adventureServer = new AdventureServer();
        int port;
        if (args[0] == null){
            port = 2112;
        } else {
            port = Integer.parseInt(args[0]); 
        }
        adventureServer.setOnTransmission ( e -> System.out.println(e.getData()) );
        adventureServer.startServer ( port );
        
    }

    public void port( int port ){
        adventureServer.startServer ( port );
    }

    public void TechAdventureServer ( ) {
		adventureServer = new AdventureServer ( );
		adventureServer.setOnTransmission ( this );
    }
    

    public void handle ( ConnectionEvent e ) {
		System.out.println( "EVENT RECEIVED - YOU MUST PARSE THE DATA AND RESPOND APPROPRIATELY");
		System.out.println( String.format ( "connectionId=%d, data=%s", e.getConnectionID (), e.getData() ));
		try {
			switch ( e.getCode ( ) ) {
				case CONNECTION_ESTABLISHED:
					System.out.println("CONNECTION ESTABLISHED");
					break;
				case TRANSMISSION_RECEIVED:
					adventureServer.sendMessage ( e.getConnectionID ( ), String.format (
							  "MESSAGE RECEIVED: connectionId=%d, data=%s", e.getConnectionID ( ), e.getData ( ) ) );
					// BEWARE - if you keep this, any user can shutdown the server
					if ( e.getData ( ).equals ( "SHUTDOWN" ) ) {
						adventureServer.stopServer ( );
					}
					break;
				case CONNECTION_TERMINATED:
					// Cleanup when the connection is terminated.
					break;
				default:
					// What is a reasonable default?
			}
		} catch ( UnknownConnectionException unknownConnectionException ) {
			unknownConnectionException.printStackTrace ( );
		}
	}
    
}