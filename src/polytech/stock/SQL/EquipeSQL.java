package polytech.stock.SQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import polytech.jtournoi.Equipe;
import polytech.jtournoi.TypeEpreuve;
import polytech.personnes.Joueur;
import polytech.stock.Stock;

/**
 * @author Antoine Pultier
 * Gestion SQL d'une équipe.
 */
public class EquipeSQL extends GestionSQL
{

	@Override
	protected String structureTable()
	{
		return "ID, NOM, SCORE";
	}

	@Override
	protected String structureTableTypee()
	{
		return "ID INTEGER PRIMARY KEY, NOM TEXT, SCORE INTEGER";
	}

	@Override
	protected String nomTable()
	{
		return "equipes";
	}

	@Override
	protected int nbChamps()
	{
		return 3;
	}

	@Override
	public Object construireDepuisStock(Object element)
	{
		ResultSet rs = (ResultSet) element;

		Equipe a = new Equipe();
	
		try
		{
			a.setId(rs.getInt(1));
			a.setNom(rs.getString(2));
			a.setScore(rs.getInt(3));
		} catch (SQLException e)
		{
			System.out.println("Impossible de charger un élément : " + e.getMessage());
		}
		
		// Récupération de la liste des membres de l'équipe
		EquipeMembresREL emr = new EquipeMembresREL();
		emr.setIdRelation(a.getId());
		
		List<Integer[]> membres =  emr.recupererStock();
		
		if (membres != null)
		{
			for (Integer[] e : membres)
			{
				Joueur j = Stock.getJoueurParId(e[1]);

				if (j != null)
				{
					a.ajouterParticipant(j);
				}
			}
		}
		
		// Récupération du parcours d'épreuves de l'équipe
		EquipeEpreuvesREL eer = new EquipeEpreuvesREL();
		eer.setIdRelation(a.getId());
		List<Integer[]> epreuves =  eer.recupererStock();
		
		if (epreuves != null)
		{
			ArrayList<TypeEpreuve> tabCompetences = new ArrayList<TypeEpreuve>();
			for (Integer[] e : epreuves)
			{
				TypeEpreuve t = Stock.getTypeEpreuveParId(e[1]);

				if (t != null)
				{
					tabCompetences.add(t);
				}
			}

			// TODO Dès que la méthode ne fait plus d'exceptions, c'est à décommenter
			//a.setEpreuves(tabCompetences);
		}
		return a;
	}

	@Override
	public Object construirePourStock(Object element)
	{
		Equipe a = (Equipe) element;

		try
		{
			declarationPreparee.setInt(1, a.getId());
			declarationPreparee.setString(2, a.getNom());
			declarationPreparee.setInt(3, a.getScore());
		} catch (SQLException e)
		{
			System.out.println("Impossible de créer un élement du stock : "+e.getMessage());
			return null;
		}

		// Création de la liste des membres de l'équipe
		List<Integer[]> membres = new ArrayList<Integer[]>();
		
		for (Joueur j : a.getMembres())
		{
			Integer[] couple = new Integer[2];

			couple[0] = a.getId();
			couple[1] = j.getId();

			membres.add(couple);
		}

		new EquipeMembresREL().enregistrerStock(membres);
		
		// Création du parcours d'épreuve de l'équipe
		List<Integer[]> epreuves = new ArrayList<Integer[]>();
		
		for (TypeEpreuve te : a.getEpreuves())
		{
			Integer[] couple = new Integer[2];

			couple[0] = a.getId();
			couple[1] = te.getId();

			epreuves.add(couple);
		}

		new EquipeEpreuvesREL().enregistrerStock(epreuves);

		return declarationPreparee;
	}

}
