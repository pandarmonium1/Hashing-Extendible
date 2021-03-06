package real;

import java.util.ArrayList;

public class Page <E>{
	protected String bDressH;
	protected int dPrima;
	protected int dressH;
	protected int tama�o;
	protected ArrayList <Registro<E>> registros;
	protected double densidad;
	
	public Page(int m){
		tama�o=m;
		registros=new ArrayList<Registro<E>>();
	}
	public Page(int m, int dPrima){
		this.dPrima=dPrima;
		tama�o=m;
		registros=new ArrayList<Registro<E>>();
	}
	
	public int posKey(int key) {
		for(int i=0;i<registros.size();i++){
			if(registros.get(i).key==key)
				return i;
		}
		return -1;
	}
	
	public String getbDressH() {
		return bDressH;
	}
	public void setbDressH(String bDressH) {
		this.bDressH = bDressH;
	}
	public int getTama�o() {
		return tama�o;
	}
	public void setTama�o(int tama�o) {
		this.tama�o = tama�o;
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
		s+="\t("+dPrima+")\t";
		for (Registro<E> reg : registros) {
			s+=reg+"||";
		}
		return s;
		}
	
}
