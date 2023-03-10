package com.inti.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommande;
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name="idUtilisateur", nullable = false)
//	@JoinTable(name="Commande_Utilisateur",
//	joinColumns = @JoinColumn(name="idCommande"),
//	inverseJoinColumns = @JoinColumn(name="idUtilisateur"))
	private Utilisateur utilisateur;
	
	@OneToOne(mappedBy = "commande")
	private Paiement paiement;

	@OneToMany(mappedBy = "commande", targetEntity = Article.class)
	private List<Article> listeArticles;
	
	public Commande() {
		super();
	}
	
	
	public Commande(LocalDate date) {
		super();
		this.date = date;
	}

	public Commande(int idCommande, LocalDate date) {
		super();
		this.idCommande = idCommande;
		this.date = date;
	}


	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", date=" + date + ", utilisateur=" + utilisateur + "]";
	}
	
	

}
