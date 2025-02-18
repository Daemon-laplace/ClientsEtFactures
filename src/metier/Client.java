package metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client
{
	String nom;
	ArrayList<Facture>listeFacture = new ArrayList<Facture>();
	ArrayList<Facture>listeFactureReglee = new ArrayList<Facture>();
	static ArrayList<Client>listeClient = new ArrayList<Client>();
	int sommeFacture = 0;
	
	/** 
	 * Crée un client.
	 * @param nom le nom du client. 
	 */
	
	public Client(String nom)
	{
		listeClient.add(this);
		this.nom = nom;
	}

	/**
	 * Retourne le nom du client.
	 * @return le nom du client.
	 */
	
	public String getNom()
	{
		return this.nom;
	}
	
	/**
	 * Modifie le nom du client.
	 * @param nom le nom du client.
	 */
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	/**
	 * Créé une facture.
	 * @param montant Le montant de la facture.
	 * @return la facture créée.
	 */
	
	public Facture createFacture(int montant)
	{
		Facture f1 = new Facture (this,montant,false,LocalDate.now());
		listeFacture.add(f1);
		sommeFacture += montant;
		return f1;
	}
	
	/**
	 * Retourne une copie de la liste des factures du client.  
	 * @return une copie de la liste des factures du client.
	 */

	public List<Facture> getFactures()
	{
		return new ArrayList<Facture>(listeFacture);
	}
	
	/**
	 * Retourne la somme des montants des factures.
	 * @return la somme des montants des factures.
	 */
	
	public int sommeMontants()
	{
		return sommeFacture;
	}

	/**
	 * Créé une facture en précisant si elle est reglée.
	 * @param montant Le montant de la facture.
	 * @param reglée Vrai si la facture est reglée.
	 * @return la facture créée.
	 */
	
	public Facture createFacture(int montant, boolean reglee)
	{
		Facture f1 = new Facture (this,montant,reglee,LocalDate.now());
		if(reglee) {
			listeFactureReglee.add(f1);
		}
		return f1;
	}	
	
	/**
	 * Retourne la liste des factures reglées. 
	 * @return la liste des factures reglées.
	 */

	public List<Facture> facturesReglees()
	{
		return new ArrayList<Facture>(listeFactureReglee);
	}
	

	/**
	 * Retourne tous les clients créés.
	 * @return une copie de la liste de tous les clients.
	 */
	public static List<Client> tous()
	{
		return new ArrayList<Client>(listeClient);
	}
	
	/**
	 * Supprime le client.
	 */
	
	public void delete()
	{
		listeClient.remove(this);
	}
}
