import java.util.Scanner;
import java.util.ArrayList;

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
				System.out.println("test:load");
				
				String filename =  scan.nextLine();
				
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
