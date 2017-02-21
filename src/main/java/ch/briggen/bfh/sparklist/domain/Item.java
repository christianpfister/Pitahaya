package ch.briggen.bfh.sparklist.domain;


/**
 * Einzelner Eintrag in der Liste mit Name und Menge (und einer eindeutigen Id)
 * @author Marcel Briggen
 *
 */
public class Item {
	
	private long id;
	private String name;
	private int quantity;
	
	/**
	 * Defaultkonstruktor für die Verwendung in einem Controller
	 */
	public Item()
	{
		
	}
	
	/**
	 * Konstruktor
	 * @param id Eindeutige Id
	 * @param name Name des eintrags in der Liste
	 * @param quantity Menge
	 */
	public Item(long id, String name, int quantity)
	{
		this.id = id;
		this.name = name;
		this.quantity =quantity;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("Item:{id: %d; name: %s; quantity: %d;}", id, name, quantity);
	}
	

}
