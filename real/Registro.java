package real;


public class Registro<E> implements Comparable<Registro<E>> {
	
	protected int key;
	private String bKey;
	protected E data;
	
	public Registro (int key, E register){
		this.key= key;
		this.setBKey(Integer.toBinaryString(key));
		data = register;
	}
	
	public void setKey(int k){
		key = k;
	}
	
	public int getKey(){
		return key;
	}
	
	public String getBKey() {
		return bKey;
	}

	public void setBKey(String bKey) {
		this.bKey = bKey;
	}

	public int compareTo(Registro<E> r){
		return this.key -r.key;
	}
	
	public boolean equals(Object o){
		if (o instanceof Registro){
			Registro<E> r = (Registro <E>) o;
			return r.key == this.key;
		}
		return false;
	}
	public String toString(){
		return bKey+ ":\t\t" + this.data.toString(); 
	}
	

}
