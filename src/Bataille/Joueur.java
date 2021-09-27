package Bataille;

import java.util.ArrayList;

public class Joueur {
	ArrayList<Carte> paquet;
	private String pseudo;
	private int numero;
	
	public Joueur(String pseudo, int numero, Paquet paquetEntier) {
		this.pseudo = pseudo;
		this.numero = numero;
		initPaquet(paquetEntier, numero);
	}
	
	//Met en place un paquet de 26 cartes (sous forme d'ArrayList) déjà mélangé en tant qu'objet Paquet
	public void initPaquet(Paquet paquetEntier, int numero) {
		paquet = new ArrayList<Carte>();		
		if (numero == 1) {
			int i = 0;
			while (i < 26) {
				paquet.add(paquetEntier.getCarte(i));
				i=i+1;
			}
		}
		else {
			int i = 26;
			while (i < 52) {
				paquet.add(paquetEntier.getCarte(i));
				i=i+1;
			}			
		}
	}
	
	public Carte tireCarte(int position) {
		return this.paquet.get(position);
	}
	
	public void ajouterCartes(Carte carte1, Carte carte2) {
		this.paquet.add(carte1);
		this.paquet.add(carte2);
	}
	
	public void supprimerCarte(int position) {
		this.paquet.remove(position);
	}
	
	public String score() {
		return("Il reste "+this.paquet.size()+ " carte(s) à "+this.pseudo+ " (joueur "+this.numero+").");
	}
	
	public String gagneLePli() {
		return(this.pseudo +" a gagné le pli.");
	}
	
	public int nombreDeCartes() {
		return(this.paquet.size());
	}
	
	public boolean perdant() {
		return(this.paquet.isEmpty());
	}
	
	public String gagant() {
		return(this.pseudo+" (joueur "+this.numero+") a gagné la partie !");
	}
	
	public String afficherPseudo() {
		return("Le psuedo du joueur est : "+this.pseudo);
	}

}
