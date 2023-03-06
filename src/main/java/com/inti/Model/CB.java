package com.inti.Model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
//@DiscriminatorValue("2")
@PrimaryKeyJoinColumn(name="idPaiement")
public class CB extends Paiement{

	private long numeroCarte;
	private String dateExpiration;
	
	
	public CB() {
		super();
	}
	
	
	public CB(LocalDate date, long numeroCarte, String dateExpiration) {
		super(date);
		this.numeroCarte = numeroCarte;
		this.dateExpiration = dateExpiration;
	}


	public CB(double montant, LocalDate date, long numeroCarte, String dateExpiration) {
		super(montant, date);
		this.numeroCarte = numeroCarte;
		this.dateExpiration = dateExpiration;
	}
	public long getNumeroCarte() {
		return numeroCarte;
	}
	public void setNumeroCarte(long numeroCarte) {
		this.numeroCarte = numeroCarte;
	}
	public String getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	@Override
	public String toString() {
		return "CB [numeroCarte=" + numeroCarte + ", dateExpiration=" + dateExpiration + "]";
	}
	
	
}
