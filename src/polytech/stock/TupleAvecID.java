package polytech.stock;

/**
 * @author Antoine Pultier
 * 
 *         Un tuple est un élément qui peut être insérer en stock. Il contient
 *         un identificateur unique qui est toujours identique.
 */
public abstract class TupleAvecID {
	/**
	 * L'identificateur du tuple.
	 */
	protected int id;

	/**
	 * Nombre d'instances de Tuples. Cela permet d'obtenir un identificateur
	 * unique.
	 */
	private static int nbInstances = 1;

	/**
	 * Constructeur qui se charge de trouver un identificateur unique.
	 */
	public TupleAvecID() {
		this.id = nbInstances++;
	}

	/**
	 * Accesseur en lecture.
	 * 
	 * @return L'ID du tuple.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Mutateur Modifie l'ID du tuple par l'ID donne.
	 * 
	 * @param id
	 *            Nouvel ID du tuple.
	 */

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TupleAvecID))
			return false;
		TupleAvecID other = (TupleAvecID) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
