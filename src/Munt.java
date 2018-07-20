
public class Munt {
	
	private char id;
	private Boolean echteMunt;
	private Boolean teZwaar;
	private Boolean teLicht;
	
	//constructor
	public Munt(char id) {
		this.id = id;
		echteMunt = null;
		teZwaar = null;
		teLicht = null;
	}
	
	//setters
	public void setId(char c) { id = c; }
	
	//getters
	public char getId() {return id;}
	public void setEchteMunt(boolean b) {
		echteMunt = false;
	}
	
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
			if(c == 'Z') {teZwaar = true;}
			else if(c =='L') {teLicht = true;}
			return true;
		}
		else {return false;}
	}
	
}
