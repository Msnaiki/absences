package application;

import java.net.URL;
import java.util.ResourceBundle;



public class Apprenant   {
	private int id;
	private String nom;
	private String email;
	private int promotion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPromotion() {
		return promotion;
	}
	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}
public Apprenant(int id, String nom, String email,int promotion) {
	this.id=id;
	this.email=email;
	this.nom=nom;
	this.promotion=promotion;
}




}
