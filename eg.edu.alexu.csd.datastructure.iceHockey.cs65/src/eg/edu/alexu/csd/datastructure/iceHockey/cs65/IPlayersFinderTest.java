package eg.edu.alexu.csd.datastructure.iceHockey.cs65;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import eg.edu.alexu.csd.datastructure.iceHockey.cs65.PlayersFinder;

class IPlayersFinderTest {

	String[] enterting;
	Point[] results ;
	@Test
	void testIceHockeyTest() {
	PlayersFinder test = new PlayersFinder();
	 enterting=new String[] {
			"33JUBU33",
			"3U3O4433",
			"O33P44NB",
			"PO3NSDP3",
			"VNDSD333",
			"OINFD33X"
	};
	
	 results = new Point[] {
		 new Point(14,2),new Point(4,5), new Point(13,9)
	};
	
	 assertArrayEquals(results,test.findPlayers(enterting, 3, 16));
	
	enterting=new String[] {
			"44444H44S4",
			"K444K4L444",
			"4LJ44T44XH",
			"444O4VIF44",
			"44C4D4U444",
			"4V4Y4KB4M4",
			"G4W4HP4O4W",
			"4444ZDQ4S4",
			"4BR4Y4A444",
			"4G4V4T4444"};
	
	 results = new Point[] {
		 new Point(5,4),new Point(16,3), new Point(3,8),new Point(17,9),new Point(4,16),new Point(16,17)
	};
	
	 assertArrayEquals(results,test.findPlayers(enterting, 4, 16));
	
	
	enterting=new String[] {""};//case empty image
	 assertArrayEquals(null,test.findPlayers(enterting, 4, 16));
	 
	 
	 
	 enterting=new String[] {
			 "11111",
			 "1AAA1",
			 "1A1A1",
			 "1AAA1",
			 "11111"};
		
		 results = new Point[] {
			 new Point(5,5),new Point(5,5)		};
		
		 assertArrayEquals(results,test.findPlayers(enterting, 1, 3));
		}

}
