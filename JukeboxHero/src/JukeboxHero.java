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
				System.out.println("insert filename:");
				
				String filename =  scan.nextLine();
				
				File songfile = new File(filename);
				if(songfile.exists() && songfile.isFile())
				{
				    try {
				        Scanner fileScan = new Scanner(songfile);
				        while(fileScan.hasNextLine())
				        {
				            // Iterate through every line of the file
				        }
				    } catch (FileNotFoundException e) {
				        // Print and/or handle error
				    }
				}
				
				//System.out.println(fileScan);
				
				break;
			case "s":
			case "S":
			case "search":
			case "Search":
				System.out.println("test:search");
				break;
			case "a":
			case "A":
			case "analyze":
			case "Analyze":
				System.out.println("test:analyze");
				break;
			case "p":
			case "P":
			case "print":
			case "Print":
				System.out.println("test:print");
				break;
			default:
				System.out.println("Invalid selection!");
			}
		}
		scan.close();
	}
}