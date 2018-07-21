import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//reserveren van variabelenruimen
		Scanner sc = new Scanner(System.in);
		
		MuntenSet muntenSet = new MuntenSet();
		
		int aantalWegingen;
		
		String weging;
		
		String linkerDeel;
		String rechterDeel;
		String resultaat;
		
		//inlezen van alle gegevens
		int aantalMuntenSets = Integer.parseInt(sc.nextLine());
		System.out.println(aantalMuntenSets);
		//voor iedere set van munten
		for(int geldZak=0; geldZak<aantalMuntenSets; geldZak++) {
			
			aantalWegingen = Integer.parseInt(sc.nextLine());
			//hier mss nog een weggooilijn
			
			//wissen van de gegevens van de vorige zak geld
			muntenSet.clear();
			
			//voor iedere weging
			for(int wegingId=0; wegingId<aantalWegingen; wegingId++) {
			
				//inlezen van de weging
				weging = sc.nextLine();
				String[] wegingDelen = weging.split(" ");
				linkerDeel = wegingDelen[0];
				rechterDeel = wegingDelen[1];
				resultaat = wegingDelen[2];
				
				//voegt nieuwe munten toe aan de set, als ze nog niet in de set bestaan
				muntenSet.voegNieuweMuntenToe(linkerDeel, rechterDeel);
				
				/*System.out.println(linkerDeel + " " + rechterDeel +" "+ resultaat);
				System.out.println();
				muntenSet.print();
				System.out.println();*/
				
				//implementeren van algoritme
				//als er evenwicht staat, mag de munt niet als te licht of te zwaar staan
				
				if(resultaat.equals("evenwicht")) {
					//System.out.println("we graken in evenwicht");
					
					//alle munten van deze weging markeren als echte munten
					muntenSet.markeerAlsEchte(linkerDeel);
					muntenSet.markeerAlsEchte(rechterDeel);
					
				}
				else if(resultaat.equals("omhoog")) {
					//System.out.println("we graken in omhoog");
					//linkerdeel is misschientezwaar
					muntenSet.markeerAlsTeZwaar(linkerDeel);
					
					//rechterdeel is misschientelicht
					muntenSet.markeerAlsTeLicht(rechterDeel);
					
				}
				
				else {
					//System.out.println("we graken in omlaag");
					//linkderdeel is misschienteLicht
					muntenSet.markeerAlsTeZwaar(rechterDeel);
					
					//rechterdeel is misschienteZwaar
					muntenSet.markeerAlsTeLicht(linkerDeel);
				}
				

			}
			
			//nu is alle input gebeurd
			//controle als de input correct verloopt :
			//System.out.println("munten na invoer");
			//muntenSet.print();
			
			//verdere verwerking van het algoritme
			
			//misschien een tweede set maken
			
				// 1) speciale gevallen testen
					//als geen enkele munt te licht of te zwaarbooleans heeft --> te weinig gegevens
				String antwoord = muntenSet.specialeGevallen();
				
				if(!antwoord.equals("noSpecialGeval")) {
					//dan is het antwoord reeds gevonden, het zit in de string speciaalGeval
					System.out.println("//////////////////////////");
					System.out.println(antwoord);
				}
				else {
					
					//hieruit volgt een concreet antwoord welke munt te zwaar of te licht is,
					//ofwel een inconsistente gegevens, als een echte munt ook te licht is
						//bvb bij	abc efg evenwicht
						//			a e omhoog
					System.out.println("//////////////////////////");
					System.out.println("valse munt kan bepaald worden algo starten");
					//hier na gaan we over op sets
				
					//enkel nodig voor als het geen speciaal geval is
						//daarom niet bovenaan gedefinieerd
					
					//hoogst wss is de echtemunten set niet nodig
					HashSet lichteMunten = new HashSet<Character>();
					HashSet zwareMunten = new HashSet<Character>();
					
					//itereren over elke munt 1x
					//eerst de echte, dan de lichte, dan de zware
					String muntenSorteerd = muntenSet.haalMuntenOp();
					
					String[] muntenDelen = muntenSorteerd.split(" ");
					
					//de lichte munten toevoegen aan de set
					for(int i=0; i<muntenDelen[1].length() ; i++) {
						lichteMunten.add(muntenDelen[1].charAt(i));
					}
					
					//de zware munten toevoegen aan de set
					for(int i=0; i<muntenDelen[2].length() ; i++) {
						zwareMunten.add(muntenDelen[2].charAt(i));
					}
					
					//karakters toegevoegd aan de set
					
					//alle echte munten overlopen
					for(int i=0; i<muntenDelen[0].length() ; i++) {
						
						//de echte munten uit de set met lichte munten halen
						//de echte munten uit de set met zware munten halen
						Character c = muntenDelen[0].charAt(i);
						
						if (lichteMunten.contains(c)) {
							lichteMunten.remove(c);
						}
						if (zwareMunten.contains(c)) {
							zwareMunten.remove(c);
						}
						
					}
					
					if(lichteMunten.size()==1 && zwareMunten.size()==0) {
						Character deMunt;
						
						//itereren over de lichte munten , het element eruit halen
						for(Character x : lichteMunten) {deMunt = x;}
						antwoord = "Het valse geldstuk "+ deMunt +" is lihcter";
					}
					else if (zwareMunten.size()==1 && lichteMunten.size()==0) {
						Character deMunt;
						
						//itereren over de lichte munten , het element eruit halen
						for(Character x : zwareMunten) {deMunt = x;}
						antwoord = "Het valse geldstuk "+ deMunt +" is zwaarder";
					}
					else {antwoord = "Inconsistente gegevens"}
					
					
				
				}
				
					
					
				
				
			
				// 2) antwoord zoeken
				//als er een resultaat is, dan volstaat het om alle munten uit de set te halen die true zijn
				//dan blijft er 1 munt over
			
				//als deze munt enkel misschien te zwaar OF misschientelicht is, dan kunnen we zeggen dat
				//ze effectief te zwaar of te licht is
			
				//als deze munt te zwaar EN te licht boolean heeft, dan zijn er tegensprekende gegevens
			
				//als er meer dan 1 munt overblijft, dan zijn er onvoldoende gegevens, maar mss ook tegensprekende gegevens
			

			
		//einde van 1 spelletje	
		}

		
	}

	
}
