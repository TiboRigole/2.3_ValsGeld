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
			
			System.out.println(linkerDeel + " " + rechterDeel +" "+ resultaat);
			
			
			
			
			
			//toevoegen van Nieuwe Munten aan de muntenSet
			
			
			
			
			
			}
			
		}

	}

}
