import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class JukeboxHero
{
	public static void main(String[] args)
	{
		ArrayList<Song> songList = new ArrayList<Song>();
		
		
		
		Scanner scan = new Scanner(System.in);
		String command = new String();
		String menu = "*****************************\r\n" + 
				"*      Program Menu         *\r\n" + 
				"*****************************\r\n" + 
				"(L)oad catalog\r\n" + 
				"(S)earch catalog\r\n" + 
				"(A)nalyse catalog\r\n" + 
				"(P)rint catalog\r\n" + 
				"(Q)uit\r\n"
				;
		System.out.println(menu);
			
		while(!command.equals("quit"))
		{
			System.out.println("\r\n"+"Please enter a command (press 'm' for Menu):");
			
			command = scan.nextLine();

			switch (command)
			{
			case "q":
			case "Q":
			case "quit":
			case "Quit":
				command = "quit";
				System.out.println("Goodbye!");
				break;
			case "m":
			case "M":
			case "menu":
			case "Menu":
				System.out.println(menu);
				break;
			case "l":
			case "L":
			case "load":
			case "Load":
				System.out.println("Load Catalog...");
				System.out.println("Please enter a filename:");
				
				String fileName =  scan.nextLine();
				
				File songFile = new File(fileName);
				if(songFile.exists() && songFile.isFile())
				{
				    try {
				        songList.clear();
				    	Scanner fileScan = new Scanner(songFile);
				        while(fileScan.hasNextLine())
				        {
				        	Scanner lineScan = new Scanner(fileScan.nextLine());
				        	lineScan.useDelimiter(",");
                            String artist = lineScan.next();
                            String album= lineScan.next();
                            String title = lineScan.next();
                            int duration = lineScan.nextInt();
                            Song newSong = new Song(artist, album, title, duration);
                            songList.add(newSong);
				        	
				            // Iterate through every line of the file Artist, Album, Title, Duration
				        }
				    } catch (FileNotFoundException e) {
				        // Print and/or handle error
				    }
				}
				
				System.out.println("Catalog containing " + songList.size() + " loaded successfully.");
				
				break;
			case "s":
			case "S":
			case "search":
			case "Search":
				ArrayList<Song> searchResult = new ArrayList<Song>();
				System.out.println("Search Catalog...");
				System.out.println("Please enter the search query:");
				
				String query =  scan.nextLine();
				String querylc = new String();
				querylc.equalsIgnoreCase(query);
				
				for(int i = 0; i < songList.size(); i++)
				{
					Song s = songList.get(i);
					if(s.toString().contains(querylc))
					{
						searchResult.add(s);
					}
				}
				System.out.println("Found " + searchResult.size() + " matches");
				System.out.println("---------------------------------\r\n");
				for(Song s : searchResult)
				{
					System.out.println(s);					
				}
				break;
			case "a":
			case "A":
			case "analyze":
			case "Analyze":
				System.out.println("Analyze Catalog...");
				System.out.println("test:analyze");
				ArrayList<Song> album = new ArrayList<Song>();
				for(int i = 0; i < songList.size();i++)
				{
					//incompletee
				}
				break;
			case "p":
			case "P":
			case "print":
			case "Print":
				System.out.println("Song list contains " + songList.size() + " songs...\r\n" + 
						"---------------------------------\r\n");
				for(Song s : songList)
				{
				    System.out.println(s);
				}

				break;
			default:
				System.out.println("Invalid selection!");
			}
		}
		scan.close();
	}
}