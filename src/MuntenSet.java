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
	
	
	
	

}
