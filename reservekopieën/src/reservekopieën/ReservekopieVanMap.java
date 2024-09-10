package reservekopieën;

import java.util.Arrays;
import java.util.Map;

/**
 * @invar | getIngangen().entrySet().stream().allMatch(e -> e.getKey() != null && e.getValue() != null)
 */
public class ReservekopieVanMap extends Reservekopie {

	/**
	 * @invar | ingangen != null
	 * @invar | ingangen.entrySet().stream().allMatch(e -> e.getKey() != null && e.getValue() != null)
	 * 
	 * @representationObject
	 */
	private Map<String, Reservekopie> ingangen;
	
	/**
	 * @creates | result
	 * @post | result != null
	 */
	public Map<String, Reservekopie> getIngangen() { return Map.copyOf(ingangen); }
	
	/**
	 * @pre | ingangen != null
	 * @pre | ingangen.entrySet().stream().allMatch(e -> e.getKey() != null && e.getValue() != null)
	 * @post | getIngangen().equals(ingangen)
	 */
	public ReservekopieVanMap(Map<String, Reservekopie> ingangen) {
		this.ingangen = Map.copyOf(ingangen);
	}
	
	/**
	 * @pre | array != null
	 * @pre | 1 <= array.length
	 * @inspects | this
	 * @mutates | array
	 * @post | array[0] > old(array[0])
	 * @post | Arrays.equals(array, 1, array.length, old(array.clone()), 1, array.length)
	 */
	public void verhoogMetAantalMappen(int[] array) {
		array[0]++;
		for (Reservekopie kopie : ingangen.values())
			kopie.verhoogMetAantalMappen(array);
	}
	
	@Override
	public boolean equals(Object object) {
		return object instanceof ReservekopieVanMap r && ingangen.equals(r.ingangen);
	}
	
	@Override
	public int hashCode() {
		return ingangen.hashCode();
	}
	
}
