

public class Registro<E> implements Comparable<Registro<E>> {
	
	protected int Key;
	protected E Register;
	
	public Registro (int key, E register){
		Key= key;
		Register = register;
	}
	
	public void setKey(int k){
		Key = k;
	}
	
	public int getKey(){
		return Key;
	}
	public E getRegister(){
		return Register;
	}
	
	public int compareTo(Registro<E> r){
		return this.Key -r.Key;
	}
	
	public boolean equals(Object o){
		if (o instanceof Registro){
			Registro<E> r = (Registro <E>) o;
			return r.Key == this.Key;
		}
		return false;
	}
	public String toString(){
		return this.Key + ":" + this.Register.toString(); 
	}
	

}
