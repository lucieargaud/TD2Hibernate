package com.inti.Model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="discriminator", discriminatorType = DiscriminatorType.INTEGER)
//@DiscriminatorValue("0")
public class Paiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPaiement;
	private double montant;
	private LocalDate date;
	
	
	
	public Paiement() {
		super();
	}

	public Paiement(LocalDate date) {
		super();
		this.date = date;
	}

	public Paiement(double montant, LocalDate date) {
		super();
		this.montant = montant;
		this.date = date;
	}



	public int getIdPaiement() {
		return idPaiement;
	}



	public void setIdPaiement(int idPaiement) {
		this.idPaiement = idPaiement;
	}



	public double getMontant() {
		return montant;
	}



	public void setMontant(double montant) {
		this.montant = montant;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "Paiement [idPaiement=" + idPaiement + ", montant=" + montant + ", date=" + date + "]";
	}
	
	
}
