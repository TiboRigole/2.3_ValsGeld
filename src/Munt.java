
public class Munt {
	
	private char id;
	private Boolean echteMunt;
	private Boolean misschienTeZwaar;
	private Boolean misschienTeLicht;
	
	//default constructor
	public Munt() {
		id = ' ';
		echteMunt = null;
		misschienTeZwaar = null;
		misschienTeLicht = null;
	}
	
	//constructor
	public Munt(char id) {
		this.id = id;
		echteMunt = null;
		misschienTeZwaar = null;
		misschienTeLicht = null;
	}
	
	//setters
	public void setId(char c) { id = c; }
	
	public void setEchteMunt(boolean b) {
		echteMunt = b;
	}
	
	public void setMisschienTeZwaar(boolean b) {
		misschienTeZwaar = b;
	}
	
	public void setMisschienTeLicht(boolean b) {
		misschienTeLicht = b;
	}
	
	//getters
	public char getId() {return id;}
	public Boolean getEcht() {return echteMunt;}
	public Boolean getMisschienTeLicht() {return misschienTeLicht;}
	public Boolean getMisschienTeZwaar() {return misschienTeZwaar;}

	
	/**
	 *  als het om een valse munt gaat, kunnen we de booleans zetten zodat 
	 *  het duidelijk is als de munt te licht of te zwaar is
	 *  
	 *  
	 * @param c = 'Z' als de munt te zwaar is
	 * 			= 'L' als de munt te licht is
	 * @return true als het effectief een zware munt is,
	 * @return false als deze munt al geclassifieerd is als een valse munt
	 * 			 dan moet er opgeroepen worden dat het om inconsistente gegevens gaat
	 */
	public boolean setValseMunt(char c) {
		if(echteMunt == false) {
			if(c == 'Z') {misschienTeZwaar = true;}
			else if(c =='L') {misschienTeLicht = true;}
			return true;
		}
		else {return false;}
	}
	
}
