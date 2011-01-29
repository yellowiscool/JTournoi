package polytech.stock;

import java.util.ArrayList;
import java.util.List;

import polytech.personnes.Arbitre;
import polytech.personnes.Joueur;
import polytech.personnes.Organisateur;

import polytech.jtournoi.Equipe;
import polytech.jtournoi.TypeEpreuve;
import polytech.jtournoi.Match;

import polytech.stock.SQL.ArbitreSQL;
import polytech.stock.XML.ArbitreXML;
import polytech.stock.SQL.JoueurSQL;
import polytech.stock.XML.JoueurXML;
import polytech.stock.SQL.OrganisateurSQL;
import polytech.stock.XML.OrganisateurXML;
import polytech.stock.SQL.EquipeSQL;
import polytech.stock.XML.EquipeXML;
import polytech.stock.SQL.MatchSQL;
import polytech.stock.XML.MatchXML;

public abstract class Stock
{
	protected static List<Arbitre> arbitres;
	protected static List<Joueur> joueurs;
	protected static List<Organisateur> organisateurs;
	protected static List<TypeEpreuve> typesEpreuves;
	protected static List<Equipe> equipes;
	protected static List<Match> matchs;

	public static void initialiserStockVide()
	{
		arbitres = new ArrayList<Arbitre>();
		joueurs = new ArrayList<Joueur>();
		organisateurs = new ArrayList<Organisateur>();
		equipes = new ArrayList<Equipe>();
		matchs = new ArrayList<Match>();
		
		typesEpreuves = CatalogueEpreuves.recupererTypesEpreuves();
	}

	public static void chargerStock(TypeChargement mode)
	{
		GestionnaireDeStock gestionArbitres = null;
		GestionnaireDeStock gestionJoueurs = null;
		GestionnaireDeStock gestionOrganisateurs = null;
		GestionnaireDeStock gestionEquipes = null;
		GestionnaireDeStock gestionMatchs = null;

		switch (mode)
		{
			case SQL:
				gestionArbitres = new ArbitreSQL(); 
				gestionJoueurs = new JoueurSQL(); 
				gestionOrganisateurs = new OrganisateurSQL(); 
				gestionEquipes = new EquipeSQL();
				gestionMatchs = new MatchSQL();
				break;
			case XML:
				gestionArbitres = new ArbitreXML(); 
				gestionJoueurs = new JoueurXML(); 
				gestionOrganisateurs = new OrganisateurXML(); 
				gestionEquipes = new EquipeXML();
				gestionMatchs = new MatchXML();
				break;
		}

		typesEpreuves = CatalogueEpreuves.recupererTypesEpreuves();
		
		arbitres = gestionArbitres.recupererStock();
		joueurs = gestionJoueurs.recupererStock();
		organisateurs = gestionOrganisateurs.recupererStock();
		
		equipes = gestionEquipes.recupererStock();

		matchs = gestionMatchs.recupererStock();
	}

	public static void enregistrerStock()
	{
		new ArbitreXML().enregistrerStock(arbitres);
		new JoueurXML().enregistrerStock(joueurs);
		new OrganisateurXML().enregistrerStock(organisateurs);
		new EquipeXML().enregistrerStock(equipes);
		new MatchXML().enregistrerStock(matchs);
		
		/*new ArbitreSQL().enregistrerStock(arbitres);
		new JoueurSQL().enregistrerStock(joueurs);
		new OrganisateurSQL().enregistrerStock(organisateurs);
		new EquipeSQL().enregistrerStock(equipes);
		new MatchSQL().enregistrerStock(matchs);*/
	}

	public static List<Arbitre> getArbitres()
	{
		return arbitres;
	}
	public static void setArbitres(List<Arbitre> arbitres)
	{
		Stock.arbitres = arbitres;
	}
	public static List<Joueur> getJoueurs()
	{
		return joueurs;
	}
	public static void setJoueurs(List<Joueur> joueurs)
	{
		Stock.joueurs = joueurs;
	}

	public static void addJoueur(Joueur j)
	{
		if (!joueurs.contains(j))
		{
			joueurs.add(j);
		}
	}

	public static List<Organisateur> getOrganisateurs()
	{
		return organisateurs;
	}
	public static void setOrganisateurs(List<Organisateur> organisateurs)
	{
		Stock.organisateurs = organisateurs;
	}
	
	public static void addOrganisateur(Organisateur o)
	{
	    if (!organisateurs.contains(o))
	    {
	        organisateurs.add(o);
	    }
	}
	
	public static List<Arbitre> getArbitresLibres()
	{
		List<Arbitre> arbitresLibres = new ArrayList<Arbitre>();
		
		for (Arbitre a : arbitres)
		{
			if (a.getBusy())
			{
				arbitresLibres.add(a);
			}
		}
		
		return arbitresLibres;
	}
	
	public static Arbitre getRandomArbitreLibre(){
		List<Arbitre> arbitresLibres = getArbitresLibres();
		int i = (int)Math.random()*(arbitresLibres.size()-1);
		return arbitresLibres.get(i);
	}

	public static List<TypeEpreuve> getTypesEpreuves()
	{
		return typesEpreuves;
	}

	public static void setTypesEpreuves(List<TypeEpreuve> typesEpreuves)
	{
		Stock.typesEpreuves = typesEpreuves;
	}
	
	public static List<Equipe> getEquipes()
	{
		return equipes;
	}

	public static void setEquipes(List<Equipe> equipes)
	{
		Stock.equipes = equipes;
	}
	
	public static List<Match> getMatchs()
	{
		return matchs;
	}

	public static void setMatchs(List<Match> matchs)
	{
		Stock.matchs = matchs;
	}

	public static void addEquipe(Equipe e)
	{
		if (!equipes.contains(e))
		{
			equipes.add(e);
		}
	}

	protected static <CLASS_TYPE> CLASS_TYPE getById(List<CLASS_TYPE> liste, int id)
	{
		if (liste != null)
		{
			for (CLASS_TYPE t : liste)
			{
				if (((TupleAvecID) t).getId() == id)
				{
					return t;
				}
			}
		}
		return null;
	}

	public static TypeEpreuve getTypeEpreuveParId(int id)
	{
		return getById(typesEpreuves, id);
	}
	
	public static Joueur getJoueurParId(int id)
	{
		return getById(joueurs, id);
	}
	
	public static Equipe getEquipeParId(int id)
	{
		return getById(equipes, id);
	}
	
	public static Arbitre getArbitreParId(int id)
	{
		return getById(arbitres, id);
	}
}
