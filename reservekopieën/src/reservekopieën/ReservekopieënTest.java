package reservekopieën;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ReservekopieënTest {
	
	ReservekopieVanBestand datum = new ReservekopieVanBestand(new byte[] {2, 0, 2, 4, 0, 8, 2, 4});
	ReservekopieVanMap wiskunde = new ReservekopieVanMap(Map.of(
			"priem", new ReservekopieVanBestand(new byte[] {2, 3, 5, 7, 11, 13}),
			"fac", new ReservekopieVanBestand(new byte[] {2, 6, 24, 120})));	

	@Test
	void testReservekopieVanBestandConstructor() {
		assertArrayEquals(new byte[] {2, 0, 2, 4, 0, 8, 2, 4}, datum.getInhoud());
	}
	
	@Test
	void testReservekopieVanMapConstructor() {
		assertEquals(Map.of(
				"priem", new ReservekopieVanBestand(new byte[] {2, 3, 5, 7, 11, 13}),
				"fac", new ReservekopieVanBestand(new byte[] {2, 6, 24, 120})),
			wiskunde.getIngangen());
	}
	
	@Test
	void testEquals() {
		assertEquals(new ReservekopieVanBestand(new byte[] {2, 0, 2, 4, 0, 8, 2, 4}), datum);
		assertNotEquals(new ReservekopieVanBestand(new byte[] {2, 0, 2, 4, 0, 9, 0, 9}), datum);
		assertNotEquals(new ReservekopieVanMap(Map.of()), datum);
		
		assertEquals(new ReservekopieVanMap(Map.of(
				"priem", new ReservekopieVanBestand(new byte[] {2, 3, 5, 7, 11, 13}),
				"fac", new ReservekopieVanBestand(new byte[] {2, 6, 24, 120}))),
			wiskunde);
	    assertNotEquals(new ReservekopieVanMap(Map.of()), wiskunde);
	    assertNotEquals(datum, wiskunde);
	}
	
	@Test
	void testVerhoogMetAantalMappen() {
	    ReservekopieVanMap alles = new ReservekopieVanMap(Map.of(
	    		"datum", datum,
	    		"wiskunde", wiskunde));
	    int[] array = {0};
	    alles.verhoogMetAantalMappen(array);
	    assertEquals(2, array[0]);
	}
	
	@Test
	void testItereerAchterwaartsOverBytesOpEvenIndices() {
	    {
		    ArrayList<Byte> iteratorResult = new ArrayList<>();
		    for (Iterator<Byte> i = datum.itereerAchterwaartsOverBytesOpEvenIndices(); i.hasNext(); )
		    	iteratorResult.add(i.next());
		    assertEquals(List.of((byte)2, (byte)0, (byte)2, (byte)2), iteratorResult);
	    }
	    
	    {
	    	ReservekopieVanBestand priem = new ReservekopieVanBestand(new byte[] {2, 3, 5, 7, 11, 13, 17});
		    ArrayList<Byte> iteratorResult = new ArrayList<>();
		    for (Iterator<Byte> i = priem.itereerAchterwaartsOverBytesOpEvenIndices(); i.hasNext(); )
		    	iteratorResult.add(i.next());
		    assertEquals(List.of((byte)17, (byte)11, (byte)5, (byte)2), iteratorResult);
	    }
	}
	
	@Test
	void testForEachByteVerschillendVanNul() {
    	ArrayList<Byte> forEachResult = new ArrayList<>();
    	datum.forEachByteVerschillendVanNul(b -> forEachResult.add(b));
    	assertEquals(List.of((byte)2, (byte)2, (byte)4, (byte)8, (byte)2, (byte)4), forEachResult);
	}

}
