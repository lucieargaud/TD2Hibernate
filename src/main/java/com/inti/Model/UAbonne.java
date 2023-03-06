package com.inti.Model;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.inti.Model.Utilisateur;

@Entity
//@DiscriminatorValue("1")

//@Table
//@PrimaryKeyJoinColumn(name="idU")


public class UAbonne extends Utilisateur{

	private int duree;
	private int categorie;
	public UAbonne() {
		super();
	}
	public UAbonne(String login, String mdp, int duree, int categorie) {
		super(login, mdp);
		this.duree = duree;
		this.categorie = categorie;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getCategorie() {
		return categorie;
	}
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return "UAbonne [duree=" + duree + ", categorie=" + categorie + "]";
	}
	
	
}
