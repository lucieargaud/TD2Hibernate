package com.inti.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="discriminator", discriminatorType = DiscriminatorType.INTEGER)
//@DiscriminatorValue("0")
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idUtilisateur;
	private String login;
	private String mdp;
	@OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="idDetails", nullable = false)
//	@JoinTable(name="Utilisateur_UD",
//				joinColumns = @JoinColumn(name="idU"),
//				inverseJoinColumns = @JoinColumn(name="idUD"))
	private UtilisateurDetails utilisateurDetails;
	
	@ManyToMany
	@JoinTable(name="Role_Utilisateur",
	joinColumns = @JoinColumn(name="idU"),
	inverseJoinColumns = @JoinColumn(name="idR"))
	private List<Utilisateur> listeUtilisateurs;
	@ManyToMany(mappedBy = "listeUtilisateurs", targetEntity = Role.class)
	private List<Role> listeRole;
	
	@OneToMany(mappedBy = "utilisateur", targetEntity = Commande.class)
	private List<Commande> listeCommande;
	
	public Utilisateur() {
		super();
	}

	
	public Utilisateur(int idUtilisateur) {
		super();
		this.idUtilisateur = idUtilisateur;
	}



	public Utilisateur(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}


	public Utilisateur(int idUtilisateur, String login, String mdp) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.login = login;
		this.mdp = mdp;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	

	public UtilisateurDetails getUtilisateurDetails() {
		return utilisateurDetails;
	}

	public void setUtilisateurDetails(UtilisateurDetails utilisateurDetails) {
		this.utilisateurDetails = utilisateurDetails;
	}

	
	
	public List<Utilisateur> getListeUtilisateurs() {
		return listeUtilisateurs;
	}


	public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
		this.listeUtilisateurs = listeUtilisateurs;
	}


	public List<Role> getListeRole() {
		return listeRole;
	}


	public void setListeRole(List<Role> listeRole) {
		this.listeRole = listeRole;
	}


	public List<Commande> getListeCommande() {
		return listeCommande;
	}


	public void setListeCommande(List<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}


	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", login=" + login + ", mdp=" + mdp
				+ ", utilisateurDetails=" + utilisateurDetails + ", listeUtilisateurs=" + listeUtilisateurs
				+ ", listeRole=" + listeRole + ", listeCommande=" + listeCommande + "]";
	}



	
	
	
}
