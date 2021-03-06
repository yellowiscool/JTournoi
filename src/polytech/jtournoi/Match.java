package polytech.jtournoi;

import polytech.personnes.Arbitre;
import polytech.stock.TupleAvecID;

/**
 * Class de Gestion de match entre deux équipes
 * 
 * @author Muller Stéphane
 * 
 */

public class Match extends TupleAvecID implements Comparable<Match> {
	Equipe e1;
	Equipe e2;
	int scE1;
	int scE2;
	Arbitre a;
	int numero;
	int tour;

	/**
	 * Constructeur qui prends en paramètre les deux équipes et sa position
	 * (tour et numéro)
	 * 
	 * @param e1
	 * @param e2
	 * @param a
	 * @param numero
	 * @param tour
	 */
	public Match(Equipe e1, Equipe e2, Arbitre a, int numero, int tour) {
		super();
		this.numero = numero;
		this.e1 = e1;
		this.e2 = e2;
		if (a.getBusy() == true) {
			throw new RuntimeException();
		} else {
			this.a = a;
			a.setBusy(true);
		}
		this.tour = tour;
	}

	public Match() {
		this.e1 = null;
		this.e2 = null;
	}

	/**
	 * Met a jour le score du match
	 * 
	 * @param sc1
	 * @param sc2
	 */
	public void setScore(int sc1, int sc2) {
		scE1 = sc1;
		scE2 = sc2;
	}

	/**
	 * Recupere le vainqueur du match
	 * 
	 * @return
	 */
	public Equipe getVainqueur() {
		if (scE1 < scE2) {
			return e2;
		} else
			return e1;
	}

	public int getNumero() {
		return numero;
	}

	public int getTour() {
		return tour;
	}

	public Arbitre getArbitre() {
		return a;
	}

	public String toString() {
		String s = "";
		s += "Bienvenue dans le match numéro : " + numero + " ou s'affronte "
				+ e1.getNom() + " et " + e2.getNom()+" arbitré par : "+a.getNom();
		return s;
	}

	@Override
	public int compareTo(Match m) {
		if (m.getNumero() == this.numero && m.getTour() == this.tour) {
			return 0;
		}
		return -1;
	}

	public Equipe getE1() {
		return e1;
	}

	public void setE1(Equipe e1) {
		this.e1 = e1;
	}

	public Equipe getE2() {
		return e2;
	}

	public void setE2(Equipe e2) {
		this.e2 = e2;
	}

	public int getScE1() {
		return scE1;
	}

	public void setScE1(int scE1) {
		this.scE1 = scE1;
	}

	public int getScE2() {
		return scE2;
	}

	public void setScE2(int scE2) {
		this.scE2 = scE2;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}
}
