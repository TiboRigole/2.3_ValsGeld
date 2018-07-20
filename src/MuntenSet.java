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
		
		//misschien hier een error, want de muntenset wordt groter tijdens het doorlopen
		}
		
		//zelfde als vorige , maar voor rechterdeel
		for(int i =0; i<rechterDeel.length(); i++) {
			c = linkerDeel.charAt(i);
			
		bevatMunt = bevatMuntReeds(muntenSet, c);
		
		//als de munt niet in de hashset zit, voeg ze dan nog toe
		if(!bevatMunt) {muntenSet.add(new Munt(c));}
		
		//misschien hier een error, want de muntenset wordt groter tijdens het doorlopen
		}
		
	}

	private Boolean bevatMuntReeds(HashSet<Munt> muntenSet2, char c) {
		boolean b = false;
		for(Munt m : muntenSet2) {
			if(m.getId() == c) {b = true;}
		}
		return b;
	}
	
	
	
	

}
