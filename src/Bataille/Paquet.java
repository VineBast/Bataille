package Bataille;

public class Paquet {
	static String[] couleurs = {"Trèfle", "Carreau", "Coeur", "Pique"};
	static int[] valeurs = new int[52];
	private Carte[] paquet;
	
	public Paquet() {
		initValeurs();
		initPaquet();
	}
	
	//Met en place le tableau de valeurs
	public void initValeurs() {
		int i = 0;
		int j = 2;
		while (i < 52) {
			if (j > 14) {
				j = 1;
			}
			valeurs[i] = j;
			System.out.println(valeurs[i]);
			j=j+1;
			i=i+1;
		}
	}
	
	//Met en place un paquet principal de 52 cartes mélangées
	public void initPaquet() {		
		paquet = new Carte[52];
		int i = 0;
		int numCarte = 0;
		int randomInt = (int)(Math.random() * 52);

		while (i < 52) {
			while (valeurs[randomInt] == 0) {
				randomInt = (int)(Math.random() * 52);
			}
			if (numCarte > 3) {
				numCarte = 0;
			}
			paquet[i] = new Carte(valeurs[randomInt], couleurs[numCarte]);
			valeurs[randomInt] = 0;
			i=i+1;
			numCarte = numCarte+1;
		}
	}
	
	public Carte getCarte(int position) {
		return paquet[position];
	}
	
	public void afficherPaquet() {
		int i = 0;		
		while (i < 52) {
			System.out.println("La " +i+" ère/ème carte du paquet est de couleur : "+ this.paquet[i].getCouleur() +" et de valeur : "+ this.paquet[i].getValeur());
			i=i+1;
		}
	}
}
