package polytech.stock;
import java.util.List;

import polytech.jtournoi.Equipe;
import polytech.jtournoi.TypeEpreuve;
import polytech.personnes.*;

public class GeneratePlayer {
	
	public static void main(String[] args){

		Stock.initialiserStockVide();
		
		//Création de 20 joueurs.
	Joueur j1 = new Joueur("Stinson","Barney","awesome");
	Joueur j2 = new Joueur("Mosby","Ted","12345");
	Joueur j3 = new Joueur("Eriksen","Marshall","azerty");
	Joueur j4 = new Joueur("Scherbatsky","Robin","a");
	Joueur j5 = new Joueur("Aldrin","Lily","b");
	Joueur j6 = new Joueur("Mosby","The daughter","c");
	Joueur j7 = new Joueur("Mosby","The son","d");
	Joueur j8 = new Joueur("Driver","Ranjit","e");
	Joueur j9 = new Joueur("Hofstadter","Leonard","f");
	Joueur j10 = new Joueur("Cooper","Sheldon","g");
	Joueur j11 = new Joueur("Penny","Penny","h");
	Joueur j12 = new Joueur("Wolowitz ","Howard","i");
	Joueur j13 = new Joueur("Koothrappali","Raj","j");
	Joueur j14 = new Joueur("Wolowitz","The Mother","k");
	Joueur j15 = new Joueur("Wheaton","Wil","l");
	Joueur j16 = new Joueur("Who","Bernadette","m");
	Joueur j17 = new Joueur("Harper","Charly","n");
	Joueur j18 = new Joueur("Harper","Alan","o");
	Joueur j19 = new Joueur("Harper","Jack","p");
	Joueur j20 = new Joueur("Housekeeper","Berta","q");
		
	Stock.addJoueur(j1);
	Stock.addJoueur(j2);
	Stock.addJoueur(j3);
	Stock.addJoueur(j4);
	Stock.addJoueur(j5);
	Stock.addJoueur(j6);
	Stock.addJoueur(j7);
	Stock.addJoueur(j8);
	Stock.addJoueur(j9);
	Stock.addJoueur(j10);
	Stock.addJoueur(j11);
	Stock.addJoueur(j12);
	Stock.addJoueur(j13);
	Stock.addJoueur(j14);
	Stock.addJoueur(j15);
	Stock.addJoueur(j16);
	Stock.addJoueur(j17);
	Stock.addJoueur(j18);
	Stock.addJoueur(j19);
	Stock.addJoueur(j20);

		//Ajout de compétences (sports) aux joueurs.
	List<TypeEpreuve> epreuves = Stock.getTypesEpreuves();

	j1.addCompetence(epreuves.get(1));
	j2.addCompetence(epreuves.get(2));
	j2.addCompetence(epreuves.get(3));
	j2.addCompetence(epreuves.get(4));
	j3.addCompetence(epreuves.get(5));
	j3.addCompetence(epreuves.get(6));
	j3.addCompetence(epreuves.get(7));
	j4.addCompetence(epreuves.get(8));
	j5.addCompetence(epreuves.get(9));
	j6.addCompetence(epreuves.get(0));
	j6.addCompetence(epreuves.get(1));
	j7.addCompetence(epreuves.get(1));
	j7.addCompetence(epreuves.get(2));
	j7.addCompetence(epreuves.get(7));
	j7.addCompetence(epreuves.get(8));
	j7.addCompetence(epreuves.get(3));
	j8.addCompetence(epreuves.get(1));
	j8.addCompetence(epreuves.get(3));
	j9.addCompetence(epreuves.get(1));
	j9.addCompetence(epreuves.get(2));
	j9.addCompetence(epreuves.get(3));
	j9.addCompetence(epreuves.get(4));
	j10.addCompetence(epreuves.get(3));
	j11.addCompetence(epreuves.get(4));
	j12.addCompetence(epreuves.get(5));
	j13.addCompetence(epreuves.get(6));
	j14.addCompetence(epreuves.get(7));
	j15.addCompetence(epreuves.get(8));
	j16.addCompetence(epreuves.get(9));
	j17.addCompetence(epreuves.get(0));
	j18.addCompetence(epreuves.get(1));
	j18.addCompetence(epreuves.get(2));
	j18.addCompetence(epreuves.get(3));
	j18.addCompetence(epreuves.get(4));
	j19.addCompetence(epreuves.get(5));
	j19.addCompetence(epreuves.get(6));
	j19.addCompetence(epreuves.get(7));
	j19.addCompetence(epreuves.get(8));
	j20.addCompetence(epreuves.get(2));
	j20.addCompetence(epreuves.get(3));
	j20.addCompetence(epreuves.get(4));
	j20.addCompetence(epreuves.get(5));
	
	  // Création de 4 équipes de 5 joueurs.
	Equipe e1 = new Equipe("HIMYM");
	Equipe e2 = new Equipe("TBBT");
	Equipe e3 = new Equipe("TAAHM");
	Equipe e4 = new Equipe("Mess");
	e1.ajouterParticipant(j1);
	e1.ajouterParticipant(j2);
	e1.ajouterParticipant(j3);
	e1.ajouterParticipant(j4);
	e1.ajouterParticipant(j5);
	e2.ajouterParticipant(j9);
	e2.ajouterParticipant(j10);
	e2.ajouterParticipant(j11);
	e2.ajouterParticipant(j12);
	e2.ajouterParticipant(j13);
	e3.ajouterParticipant(j17);
	e3.ajouterParticipant(j18);
	e3.ajouterParticipant(j19);
	e3.ajouterParticipant(j20);
	e3.ajouterParticipant(j6);
	e4.ajouterParticipant(j7);
	e4.ajouterParticipant(j8);
	e4.ajouterParticipant(j14);
	e4.ajouterParticipant(j15);
	e4.ajouterParticipant(j16);

	Stock.enregistrerStock();
	}
}
