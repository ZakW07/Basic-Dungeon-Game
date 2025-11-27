import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DungeonPractice {
	
	static HashMap<String, String> dungeonMap = new HashMap<String, String>();
	
	public static void main(String[] args) {
		loadDungeon("dungeon.txt");
		Scanner input = new Scanner(System.in);
		
		System.out.println("Rooms available: "+dungeonMap.keySet());
		
		boolean gameLoop = false;
		
		while (gameLoop == false) {
			System.out.println("Which room do you wanna see? ");
			String room = input.nextLine();
			
			if (room.equalsIgnoreCase("exit"))
				break;
			
			else if (dungeonMap.get(room) == null) {
				System.out.println("Room not found");
			}
			
			else
				System.out.println(dungeonMap.get(room));
		}
		
		input.close();
	}
	
	//bla bla bla
	public static void loadDungeon(String filename) {
	    File file = new File(filename);

	    try {
	        // RISKY CODE: Trying to open the file
	        Scanner scanner = new Scanner(file);
	        System.out.println("Success! File found.");
	        
	        while(scanner.hasNextLine()) {
	        	String line = scanner.nextLine();
	        	String[] parts = line.split(":");
	        	dungeonMap.put(parts[0], parts[1]);
	        }
	    
	    scanner.close();
	        
	    } catch (FileNotFoundException e) {
	        // SAFETY NET: What to do if file is missing
	        System.out.println("Error: " + e.getMessage());
	    }
	}

}
