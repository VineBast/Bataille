package Bataille;

public class Carte {
	int valeur;
	String couleur;
	
	public Carte(int valeur, String couleur) {		
		this.couleur = couleur;
		this.valeur = valeur;
	}
	
	public String getCouleur() {
		return this.couleur;
	}
	
	public int getValeur() {
		return this.valeur;
	}	
}
