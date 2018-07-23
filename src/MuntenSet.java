import java.util.ArrayList;
import java.util.HashSet;

public class MuntenSet {
	
	private HashSet<Munt> muntenSet;
	
	//constructor
	public MuntenSet() {
		muntenSet = new HashSet<Munt>();
	}
	
	//wissen (bij begin van een nieuw spel)
	public void clear() {
		muntenSet.clear();
	}

	public void voegNieuweMuntenToe(String linkerDeel, String rechterDeel) {
		char c;
		Boolean bevatMunt = null;
		
		for(int i =0; i<linkerDeel.length(); i++) {
			
			c = linkerDeel.charAt(i);
			bevatMunt = bevatMuntReeds(muntenSet, c);
			//als de munt niet in de hashset zit, voeg ze dan nog toe
			if(!bevatMunt) {muntenSet.add(new Munt(c));}
		
			//zelfde voor rechterdeel
			c = rechterDeel.charAt(i);
			bevatMunt = bevatMuntReeds(muntenSet, c);
			if(!bevatMunt) {muntenSet.add(new Munt(c));}
		
		}
		
	}

	private Boolean bevatMuntReeds(HashSet<Munt> muntenSet2, char c) {
		boolean b = false;
		for(Munt m : muntenSet2) {
			if(m.getId() == c) {b = true;}
		}
		return b;
	}

	public void print() {
		for(Munt m : muntenSet) {
			System.out.println(m.getId());
			System.out.println("echt: "+m.getEcht());
			System.out.println("zwaar: "+m.getMisschienTeZwaar());
			System.out.println("licht: "+m.getMisschienTeLicht());
			System.out.println();
		}
		System.out.println();
		
	}

	public void markeerAlsEchte(String deel) {
		char c;
		
		Munt m = new Munt();
		for(int i=0 ; i<deel.length(); i++) {
			
			c = deel.charAt(i);
			m = this.removeMuntMetChar(c);
			m.setEchteMunt(true);			
			this.voegMuntToe(m);
			
		}
	}
	
	public void markeerAlsTeZwaar(String deel) {
		char c;
		Munt m = new Munt();
		
		for(int i=0 ; i<deel.length(); i++) {
			c = deel.charAt(i);
			m = this.removeMuntMetChar(c);
			m.setMisschienTeZwaar(true);
			this.voegMuntToe(m);
			
		}
	}
	
	public void markeerAlsTeLicht(String deel) {
		char c;
		Munt m = new Munt();
		
		for(int i=0 ; i<deel.length(); i++) {
			c = deel.charAt(i);
			m = this.removeMuntMetChar(c);
			m.setMisschienTeLicht(true);
			this.voegMuntToe(m);
			
		}
		
	}
	
	private void voegMuntToe(Munt m) {
		muntenSet.add(m);
	}

	public Munt removeMuntMetChar(char c) {
		for(Munt m : muntenSet) {
			if (m.getId() == c) {
				//verwijder deze munt
				muntenSet.remove(m);
				return m;
			}
		}
		System.out.println("we graken in removeMuntMetChar foute lijn");
		return null;
	}

	public String specialeGevallen(ArrayList<String> valseMinstensEen) {
		
		if(valseMinstensEen.size() == 1) {return "Te weinig gegevens";}
		
		//als geen enkele munt te licht of te zwaarbooleans heeft, dan zijn er te weinig gegevens
		if(this.geenEnkeleLichtOfZwaar()) {
			//System.out.println("geen enkele munt te licht of te zwaar");
			return "Te weinig gegevens";}
		
		//als geen enkele munt als echte munt
		if(this.geenEnkeleEchteMunt()) {
			if (tweeValseMuntenCheck(valseMinstensEen)) {
				return "Inconsistente gegevens";
				}
			
			
			 // EN er een munt te licht EN te zwaar is
			else if (this.eenMuntLichtEnZwaar()) {
				 //System.out.println("geen enkele echte munt + 1 munt te licht en te zwaar");
				 return "Inconsistente gegevens";}
			 
			 //dan is er dus geen munt te licht en te zwaar
			 else {
				 //System.out.println("geen enkele echte munt + geen enkele munt te licht en te zwaar");
				 return "Te weinig gegevens";}
		}
		
		
		//als geen enkel speciaal geval van kracht is
		else{
			//System.out.println("deze set van wegingen is geen speciaal geval");
			return "noSpecialGeval";}
	}
	
	//in elke weging met onevenwicht moet hetzelfde karakter voorkomen.
	//indien dit niet het geval is dan returnen we true, dan zijn de gegevens inconsistent
	//de methode returnt true als er 2 valse munten in
	//er moet minstens 1 munt van de eerste weging aanwezig zijn in alle andere karakters
	private boolean tweeValseMuntenCheck(ArrayList<String> valseMinstensEen) {
		//moet waarschijnlijk ook met de gewichten gedaan worden
		
		//aanmaak en invullen van een booleanlijst
		Boolean[] booleanLijst = new Boolean[valseMinstensEen.get(0).length()];
		
		for(int i=0 ; i<booleanLijst.length; i++) {
			booleanLijst[i] =true;
		}//overal aanwezig = true
		
		//overlopen van alle munten in de eerste set
		for(int i=0; i<valseMinstensEen.get(0).length(); i++) {
			
			CharSequence munt = valseMinstensEen.get(0).charAt(i)+"";
			
			//overopen van alle andere wegingen
			for(int j=1 ; j<valseMinstensEen.size(); j++) {
				
				String weging = valseMinstensEen.get(j);
				
				//als de weging de munt niet bevat
				if(!weging.contains(munt)){
					//zet zijn boolean op false
					booleanLijst[i] = false;
				}
			}
			
		}
		
		Boolean returner =true;
		
		for(Boolean b : booleanLijst) {
			if( b == false) {returner = false;}
		}
		
		//System.out.println("er zitten minstens 2 foute munten in!!!");
		return !returner;
		
	}

	private boolean eenMuntLichtEnZwaar() {
		Boolean lichtEnZwaar = false;
		
		for(Munt m : muntenSet) {
			if( (m.getMisschienTeLicht()!=null) && (m.getMisschienTeZwaar()!=null)) {lichtEnZwaar = true;}
		}
		
		return lichtEnZwaar;
	}

	//als geen enkele munt te licht of te zwaarbooleans heeft --> true
	private boolean geenEnkeleLichtOfZwaar() {
		Boolean teLicht = false;
		Boolean teZwaar = false;
		
		for(Munt m : muntenSet) {
			if(m.getMisschienTeLicht() != null) {teLicht = true;}
			if(m.getMisschienTeZwaar() != null) {teZwaar = true;}
		}
		
		//als er minstens 1 munt te licht of te zwaar is
			//return het false
		if(teLicht || teZwaar) {return false;}
		else {return true;}
		
	}
	
	private boolean geenEnkeleEchteMunt() {
		Boolean eenEchteMunt = false;
		
		for(Munt m : muntenSet) {
			if(m.getEcht() != null) {eenEchteMunt = true;}
		}
		
		return !eenEchteMunt;
	}

	public String haalMuntenOp() {
		
		StringBuilder echte = new StringBuilder();
		StringBuilder lichte = new StringBuilder();
		StringBuilder zware = new StringBuilder();
		
		for(Munt m : muntenSet) {
			if(m.getEcht() != null) {echte.append(m.getId());}
			if(m.getMisschienTeLicht() != null) {lichte.append(m.getId());}
			if(m.getMisschienTeZwaar() != null) {zware.append(m.getId());}
		}
		
		return echte.toString()+" "+lichte.toString()+" "+zware.toString();

	}
	
	
	
	

}
