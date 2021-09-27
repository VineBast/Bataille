package Bataille;

public class Bataille {
	boolean stop;
	int position;
	int tour;
	int carteJ1;
	int carteJ2;
	
	public Bataille() {
		partie();
	}
	
	//Algorithme du jeu de bataille lancé par un objet Bataille au-dessus
	public void partie() {
		Paquet p = new Paquet();
		Joueur j1 = new Joueur("Héphaistos", 1, p);
		Joueur j2 = new Joueur("Arès", 2, p);
		
		stop = false;
		position = 0;
		tour = 1;
		
		while(stop == false) {
			carteJ1 = j1.tireCarte(position).getValeur();
			carteJ2 = j2.tireCarte(position).getValeur();
			
			if(carteJ1 > carteJ2) {
				if(position == 0) {
					j1.ajouterCartes(j1.tireCarte(position), j2.tireCarte(position));
					j1.supprimerCarte(position);
					j2.supprimerCarte(position);
				}
				else {
					while(position > -1) {
						j1.ajouterCartes(j1.tireCarte(position), j2.tireCarte(position));
						j1.supprimerCarte(position);
						j2.supprimerCarte(position);
						position = position - 1;
					}					
				}
				System.out.println(j1.gagneLePli());
				position = 0;
			}
			else if(carteJ1 < carteJ2) {
				if(position == 0) {
					j2.ajouterCartes(j1.tireCarte(position), j2.tireCarte(position));
					j1.supprimerCarte(position);
					j2.supprimerCarte(position);
				}
				else {
					while(position > -1) {
						j2.ajouterCartes(j1.tireCarte(position), j2.tireCarte(position));
						j1.supprimerCarte(position);
						j2.supprimerCarte(position);
						position = position - 1;
					}
				}
				System.out.println(j2.gagneLePli());
				position = 0;
			}
			else {
				if((j1.nombreDeCartes() <= 2)||(j2.nombreDeCartes() <= 2)) {
					System.out.println("Il y a un pat, c'est une fin de partie sur égalité !");
					break;
				}
				else {
					System.out.println("Egalité temporaire, c'est la bataille !");
					position = position + 2;
				}
			}
			tour = tour + 1;
			System.out.println("\n"+"Tour "+tour+" :");
			System.out.println(j1.score());
			System.out.println(j2.score());
			
			if(j1.perdant() == true) {
				System.out.println(j2.gagant());
				break;
			}
			else if(j2.perdant() == true) {
				System.out.println(j1.gagant());
				break;
			}
		}
	}	

	public static void main(String[] args) {
		Bataille partie1 = new Bataille();
	}
}
