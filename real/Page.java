package real;

import java.util.ArrayList;

public class Page <E>{
	protected String bDressH;
	protected int dPrima;
	protected int dressH;
	protected int tamaño;
	protected ArrayList <Registro<E>> registros;
	protected double densidad;
	
	public Page(int m){
		tamaño=m;
		registros=new ArrayList<Registro<E>>();
	}
	
	public String getbDressH() {
		return bDressH;
	}
	public void setbDressH(String bDressH) {
		this.bDressH = bDressH;
	}
	public int getTamaño() {
		return tamaño;
	}
	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	public ArrayList<Registro<E>> getRegistros() {
		return registros;
	}
	public void setRegistros(ArrayList<Registro<E>> registros) {
		this.registros = registros;
	}
	public double getDensidad() {
		return densidad;
	}
	public void updateDensidad(int r, int n) {
		this.densidad = (double) (r/n);
	}
	
	public void setDensidad(double densidad) {
		this.densidad = densidad;
	}
	
	public String toString(){
		String s="";
		if(registros.size()==0){
			s+="Its Empty";
			return s;
		}
		for (Registro<E> reg : registros) {
			s+=reg+"||";
		}
		return s;
		}
	
}
