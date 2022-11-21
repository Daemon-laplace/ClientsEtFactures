package metier;

import java.time.LocalDate;


public class Facture
{
	private Client client;
	private int montant;
	private boolean estReglee;
	private LocalDate date;
	
	public Facture(int montant) {
		this.montant = montant;
	}

	public Facture(int montant, boolean reglee) {
		this.montant = montant;
		this.estReglee = reglee;
	}
	
	public Facture(Client client,int montant, boolean reglee,LocalDate date) {
		this.client = client;
		this.montant = montant;
		this.estReglee = reglee;
		this.date = date;
	}
	/**
	 * Retourne le client à qui est adressée la facture..
	 * @return le client.
	 */
	
	public Client getClient()
	{
		return this.client;
	}

	/**
	 * Retourne le montant de la facture.
	 * @return le montant de la facture.
	 */
	
	public int getMontant()
	{
		return this.montant;
	}

	/**
	 * Retourne vrai si la facture est reglée.
	 * @return vrai ssi la facture est reglée.
	 */
	
	public boolean estReglee(boolean estReglee)
	{
		return this.estReglee;
	}

	/**
	 * Retourne la date de la facture.
	 * @return la date de la facture.
	 */
	
	public LocalDate getDate()
	{
		return this.date;
	}

	/**
	 * Supprime la facture
	 */
	
	public void delete()
	{
		this.client.listeFacture.remove(this);
	}
	
	/**
	 * Duplique la facture.
	 * @return une copie de la facture.
	 */
	
	public Facture copie()
	{
		Facture factureCopie = new Facture(this.client,this.montant,this.estReglee,this.date) ;
	}
}