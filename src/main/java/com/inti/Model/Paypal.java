package com.inti.Model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
//@DiscriminatorValue("1")
@PrimaryKeyJoinColumn(name="idPaiement")
public class Paypal extends Paiement {

	private int numeroCompte;

	public Paypal(double montant, LocalDate date, int numeroCompte) {
		super(montant, date);
		this.numeroCompte = numeroCompte;
	}
	

	public Paypal(LocalDate date, int numeroCompte) {
		super(date);
		this.numeroCompte = numeroCompte;
	}



	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	@Override
	public String toString() {
		return "Paypal [numeroCompte=" + numeroCompte + "]";
	}
	
	
}
