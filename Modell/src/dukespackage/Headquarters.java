package dukespackage;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Headquarters {
	private Person owner;
	private FrontDoor frontdoor;
	private HashMap<String,Room> rooms = new HashMap<>();
	public Person getOwner() {	return owner;	}
	public void setOwner(Person owner) { this.owner = owner; }
	
	/*Konstruktor: Die Teile des Headquarters werden hier im Konstruktor
	 * zusammengebaut. Das Headquarter: Bei einer Aggregation, wuerden alle 
	 * Werte und Objekte dem Konstruktor uebergeben werden,
	 * dann w�rde der Zusammenbau au�erhalb z.B. in der Klasse Story erfolgen.
	 * Wegen der zahlreichen Objekte wird hier anders vorgegangen. Das Headquarter 
	 * ist also eher eine Komposition. (Komposition, wenn die Objekte im Konstruktor 
	 * selbst erstellt oder die Attribute im Konstruktor mit Werten belegt werden)
	 * 
	 */
	
	public Headquarters(Person owner) {
		//super(); wird impliziz durchgef�hrt
		this.owner = owner;
		
		//die Eingangst�r erstellen (ist eine Sicherheitst�r,
		//der ein Code als Passwort �bergeben werden muss
		frontdoor = new FrontDoor("evilEike");
		
		//normale Zimmert�ren aus Holz erstellen (hier im normalen Array, 
		//vielleicht besser als ArrayList)
		NormalDoor[] normalDoors = new NormalDoor[2];
		NormalDoor normalWoodDoor_01 = new NormalDoor("wood");
		NormalDoor normalWoodDoor_02 = new NormalDoor("wood");
		normalDoors[0] = normalWoodDoor_01;
		normalDoors[1] = normalWoodDoor_02;
		
		ArrayList<Door> kitchenDoors = new ArrayList<>();
		kitchenDoors.add(normalDoors[0]);
		
		ArrayList<Door> bedroomDoors = new ArrayList<>();
		bedroomDoors.add(normalDoors[1]);
		
		//eine blaue 12 qm gro�e K�che mit..
		Room kitchen = new Kitchen(12.0, new Color(0,0,255), kitchenDoors);
		Room bedroom = new Bedroom(14.0, new Color(255, 100, 200), bedroomDoors);
		
		//die R�ume der hashMap rooms hinzuf�gen:
		rooms.put("kitchen", kitchen);
		rooms.put("Bedroom", bedroom);
	}
	
	//das �berwachte intelligente Hauptquartier kann eine Auflistung aller R�ume zur�ckgeben
	public void printRoomList(){
		//�ber die Eintr�ge im HashMap iterieren
		Room room;
		//nur eine Referenz auf einen Raum
		for (Entry<String, Room> e : rooms.entrySet()){
			room = e.getValue();
			System.out.println("Raum: " + e.getKey() + " " + room.toString());
		}
	}
	
	//das �berwachte intelligente Hauptquartier kann den Zustand aller T�ren zur�ckgeben
	//to do
	
	//das �berwachte intelligente Hauptquartier kann die Daten aller Sensoren zur�ckgeben
	//to do 
}
