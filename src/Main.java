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
				
				if(resultaat == "evenwicht") {
					
					//alle munten van deze weging markeren als echte munten
					muntenSet.markeerAlsEchte(linkerDeel);
					muntenSet.markeerAlsEchte(rechterDeel);
					
				}
				else if(resultaat =="omhoog"){
					
					//linkerdeel is misschientezwaar
					muntenSet.markeerAlsTeZwaar(linkerDeel);
					
					//rechterdeel is misschientelicht
					muntenSet.markeerAlsTeLicht(rechterDeel);
					
				}
				
				else {
					//linkderdeel is misschienteLicht
					muntenSet.markeerAlsTeZwaar(rechterDeel);
					
					//rechterdeel is misschienteZwaar
					muntenSet.markeerAlsTeLicht(linkerDeel);
				}
				

			}
			
			System.out.println("munten na invoer");
			muntenSet.print();
			
		}

	}

}
