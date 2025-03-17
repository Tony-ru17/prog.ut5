package Ejemplos2.exDeserialitza;

import java.io.Serializable;

class rectangle implements Serializable
{
	// 2 tipus de membres: ATRIBUTS (propietats) i MÈTODES (funcions internes a la classe)
	
	// atributs: en principi han de ser privats
	private double ample;
	private double alt;

	// mètodes: en principi han de ser publics
	/* tipus de mètodes:
		1. constructors
		2. setters: permeten canviar els valors dels atributs
		3. getters: permeten obtenir els valors dels atributs
		4. altres mètodes: milloren el comportament de la classe */

	public rectangle() { ample=alt=1; }
	public rectangle(double am, double al) { ample=am; alt = al; }	
	// setters: generalment, un setter per a cada atribut
	public void setAmple(double am)
	{
		ample = am;	// atribut=parametre;
	}
	public void setAlt(double al)
	{
		alt = al;	// atribut=parametre;
	}
	
	// getters: generalment, un getter per a cada atribut
	public double getAmple()
	{
		return ample;
	}
	public double getAlt()
	{
		return alt;
	}
	// resta de mètodes
	public double area()
	{
		return ample * alt;
	}
	public double perimetre()
	{
		return 2 * (ample + alt);
	}
	public String toString() { return "Ample: " + ample + ", alt: " + alt; }
}
