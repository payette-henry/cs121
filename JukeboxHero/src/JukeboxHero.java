import java.util.Scanner;

public class JukeboxHero
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String command = new String();
		command = null;
		System.out.println("*****************************\r\n" + 
				"*      Program Menu         *\r\n" + 
				"*****************************\r\n" + 
				"(L)oad catalog\r\n" + 
				"(S)earch catalog\r\n" + 
				"(A)nalyse catalog\r\n" + 
				"(P)rint catalog\r\n" + 
				"(Q)uit\r\n" + 
				"\r\n"
				);
		while(command == null)
		{
			System.out.println("Please enter a command (press 'm' for Menu):");
			command = scan.nextLine();
		}

		System.out.println(command);
		scan.close();
	}
}
