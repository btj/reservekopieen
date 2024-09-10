package reservekopieën;

import java.util.Arrays;

/**
 * @immutable
 */
public abstract class Reservekopie {

	/*
	 * Behavioral subtyping (gedragssubtypering) is het principe dat een subklasse een gedragssubtype moet zijn van haar superklasse.
	 * Dat betekent dat de specificatie van elke overschrijvende methode strenger moet zijn dan (of equivalent aan) de specificatie
	 * van de overschreven methode. Dit is voldaan als de preconditie zwakker is (of equivalent) en de postconditie strenger
	 * (of equivalent).  
	 */
	
	/**
	 * @pre | array != null
	 * @pre | 1 <= array.length
	 * @inspects | this
	 * @mutates | array
	 * @post | array[0] >= old(array[0])
	 * @post | Arrays.equals(array, 1, array.length, old(array.clone()), 1, array.length)
	 */
	public abstract void verhoogMetAantalMappen(int[] array);
	
}
