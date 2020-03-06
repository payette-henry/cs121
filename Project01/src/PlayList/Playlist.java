package PlayList;


import java.util.Scanner;
import java.text.DecimalFormat;
import PlayList.Song;



/**
 * Project 1: PlayList
 * 
 * @author CS121 Instructors
 * @author Henry Goetsch
 */
public class PlayList
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		//First song
		System.out.print("Enter First Song Title:");
		String songTitle = scan.nextLine();
		System.out.print("Enter First Song Artist:");
		String songArtist = scan.nextLine();
		System.out.print("Enter First Song Album:");
		String songAlbum = scan.nextLine();
		System.out.print("Enter First Song Length (mm:ss):");
		String songTime = scan.nextLine();
		int songMins = Integer.parseInt(songTime.substring(0, songTime.indexOf(":")));
		int songSecs = Integer.parseInt(songTime.substring((songTime.indexOf(":")+1)));		
		int songTotalSecs = (songMins*60)+songSecs;
		Song song1 = new Song(songTitle, songArtist, songAlbum, songTotalSecs);
		
		//Second song
		System.out.print("Enter Second Song Title:");
		songTitle = scan.nextLine();
		System.out.print("Enter Second Song Artist:");
		songArtist = scan.nextLine();
		System.out.print("Enter Second Song Album:");
		songAlbum = scan.nextLine();
		System.out.print("Enter Second Song Length (mm:ss):");
		songTime = scan.nextLine();
		songMins = Integer.parseInt(songTime.substring(0, songTime.indexOf(":")));
		songSecs = Integer.parseInt(songTime.substring((songTime.indexOf(":")+1)));		
		songTotalSecs = (songMins*60)+songSecs;
		Song song2 = new Song(songTitle, songArtist, songAlbum, songTotalSecs);
		
		//Third Song
		System.out.print("Enter Third Song Title:");
		songTitle = scan.nextLine();
		System.out.print("Enter Third Song Artist:");
		songArtist = scan.nextLine();
		System.out.print("Enter Third Song Album:");
		songAlbum = scan.nextLine();
		System.out.print("Enter Third Song Length (mm:ss):");
		songTime = scan.nextLine();
		songMins = Integer.parseInt(songTime.substring(0, songTime.indexOf(":")));
		songSecs = Integer.parseInt(songTime.substring((songTime.indexOf(":")+1)));		
		songTotalSecs = (songMins*60)+songSecs;
		Song song3 = new Song(songTitle, songArtist, songAlbum, songTotalSecs);
				
		scan.close();
		
		double totalPlayTime = (song1.getPlayTime() + song2.getPlayTime() + song3.getPlayTime());
		double averagePlayTime = totalPlayTime/3;
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		System.out.println("Average Play Time: " + df.format(averagePlayTime) + " secs");
		
		int song1Check = Math.abs(song1.getPlayTime()-240);
		int song2Check = Math.abs(song2.getPlayTime()-240);
		int song3Check = Math.abs(song3.getPlayTime()-240);
		//nested ternary operators (cuz they're cool)
		int closestTime = ((song1Check < song2Check && song1Check < song3Check) ? song1Check : (song2Check < song3Check) ? song2Check : song3Check);
		Song closestSong = ((closestTime == song1Check) ? song1 : (closestTime == song2Check) ? song2 : song3);

		System.out.println("Song with play time closest to 240 secs is: " + closestSong.getTitle());
		
		Song shortestSong = ((song1.getPlayTime() < song2.getPlayTime() && song1.getPlayTime() < song3.getPlayTime()) ? song1 : (song2.getPlayTime() < song3.getPlayTime()) ? song2 : song3);
		Song longestSong = ((song1.getPlayTime() > song2.getPlayTime() && song1.getPlayTime() > song3.getPlayTime()) ? song1 : (song2.getPlayTime() > song3.getPlayTime()) ? song2 : song3);
		Song midSong = new Song("","","",0);
		if(shortestSong.equals(song1))
		{
			if(longestSong.equals(song2))
			{
				midSong = song3;
			}
			else
			{
				midSong = song2;
			}
		}
		else if (shortestSong.equals(song2))
		{
			if(longestSong.equals(song1))
			{
				midSong = song3;
			}
			else
			{
				midSong = song1;
			}
		}
		else if(shortestSong.equals(song3))
			if(longestSong.equals(song1))
			{
				midSong = song2;
			}
			else
			{
				midSong = song1;
			}
				
		System.out.println("========================================================================================");
		System.out.println("Title                          Artist               Album                      Play Time");
		System.out.println("========================================================================================");
		System.out.println(shortestSong.toString());
		System.out.println(midSong.toString());
		System.out.println(longestSong.toString());
		System.out.println("========================================================================================");
		
		/* We can't use Loops for this :'(
		 * 
		Scanner scan = new Scanner(System.in);
		String songNumber = new String();
		String songTitle = new String();
		String songArtist = new String();
		String songAlbum = new String();
		int songTime = 0;
		//create our song objects and fill them with nothing, they'll be populated later
		Song song1 = new Song(songTitle, songArtist, songAlbum, songTime);
		Song song2 = new Song(songTitle, songArtist, songAlbum, songTime);
		Song song3 = new Song(songTitle, songArtist, songAlbum, songTime);
		
		System.out.println("Hello, Welcome to PlayList Generator 9000.");
		//three songs
		for(int i = 0; i < 3; i++)
		{
			if(i == 0)
			{
				songNumber = "first";
			}
			else if(i == 1)
			{
				songNumber = "second";
			}
			else
			{
				songNumber = "third";
			}
			System.out.println("Please enter the " + songNumber +" song's title:");
			songTitle = scan.nextLine();
			System.out.println(songTitle);
			System.out.println("Please enter the " + songNumber + " song's artist:");
			songArtist = scan.nextLine();
			System.out.println(songArtist);
			System.out.println("Please enter the " + songNumber + " song's album:");
			songAlbum = scan.nextLine();
			System.out.println(songAlbum);
			System.out.println("Please enter the " + songNumber + " song's playtime (sec):");
			songTime = scan.nextInt();
			//this fixes the bug of pulling in the current line for both the songTime and the next song title:
			String scanline = scan.nextLine();
			System.out.println(songTime);
			if(i == 3)
			{
				System.out.println("All Songs are entered.");
			}
			//now populate the song objects with their data.
			if(i == 0)
			{
				song1.setTitle(songTitle);
				song1.setArtist(songArtist);
				song1.setAlbum(songAlbum);
				song1.setPlayTime(songTime);
			}
			else if (i == 1)
			{
				song2.setTitle(songTitle);
				song2.setArtist(songArtist);
				song2.setAlbum(songAlbum);
				song2.setPlayTime(songTime);
			}
			else
			{
				song3.setTitle(songTitle);
				song3.setArtist(songArtist);
				song3.setAlbum(songAlbum);
				song3.setPlayTime(songTime);
			}
		}
		System.out.println(song1.getTitle());
		scan.close();
		*/
	}
}
