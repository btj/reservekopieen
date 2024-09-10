package reservekopieën;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

public class ReservekopieVanBestand extends Reservekopie {

	/**
	 * @invar | inhoud != null
	 * 
	 * @representationObject
	 */
	private byte[] inhoud;
	
	/**
	 * @creates | result
	 * @post | result != null
	 */
	public byte[] getInhoud() { return inhoud.clone(); }
	
	/**
	 * @pre | inhoud != null
	 * @post | Arrays.equals(getInhoud(), inhoud)
	 */
	public ReservekopieVanBestand(byte[] inhoud) {
		this.inhoud = inhoud.clone();
	}
	
	// De specificatie hieronder impliceert dat de array geheel ongewijzigd blijft, wat
	// strenger is dan de postconditie van de overschreven methode.
	
	/**
	 * @inspects nothing |
	 */
	public void verhoogMetAantalMappen(int[] array) {}
	
	@Override
	public boolean equals(Object object) {
		return object instanceof ReservekopieVanBestand r && Arrays.equals(inhoud, r.inhoud); 
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(inhoud);
	}
	
	public Iterator<Byte> itereerAchterwaartsOverBytesOpEvenIndices() {
		return new Iterator<>() {
			int count = 0;
			@Override
			public boolean hasNext() {
				return 2 * count < inhoud.length;
			}
			@Override
			public Byte next() {
				return inhoud[(inhoud.length - 1) - (inhoud.length - 1) % 2 - 2 * count++];
			}
		};
	}
	
	public void forEachByteVerschillendVanNul(Consumer<? super Byte> consumer) {
		for (byte b : inhoud)
			if (b != 0)
				consumer.accept(b);
	}
	
}
