import java.util.ArrayList;

public class HashingExtensible<E> {
	int d;//exponente para el tamaño del directorio
	
	ArrayList<Page<E>> directorio;
	 
	public HashingExtensible(){
		d=0;
		this.directorio = new ArrayList<Page<E>>();
		this.directorio.add(new Page<E>(0));
		//this.directorio.get(0).tamañoRegistro++;
		
	}
	private int functionHash(int key){
		return (int)(key% Math.pow(2,d));
	}
	
	//comentario del metodo
	private void incrementar(int Hash){
		if (this.directorio.get(Hash).tamañoRegistro < 2){
			d++;
			int t = (int) Math.pow(2, d);
			for (int i=0; this.directorio.size() <=t; i++){
				this.directorio.add(this.directorio.get(i));
			}
		}
		this.dividir(Hash);
	}
	
	
	
	public void insertar (int key, E informacion){
		int Hash = this.functionHash(key);
		Page<E> valor = this.directorio.get(Hash);
		if(!valor.doubleKey(key)){
			if(!valor.isFull()){
				valor.insert(new Registro<E>(key,informacion));
			}else{
				this.incrementar(Hash);
				this.insertar(key, informacion);
			}
		}else{
			System.out.println("Valor Duplicado");
		}
	}
	//Busca la pagina donde se encuentra el dni a eliminar
	public Page buscarPagina(int key){
		
		int Hash = this.functionHash(key);
			return this.directorio.get(Hash);
	}
	//Busca el registro en la pagina donde se encuentra el dni a eliminar
	public Registro buscarEnPagina(int key){
	
		Page mostrar= (buscarPagina(key));  
		for(int i =0;i<mostrar.paginas.size();i++){
			Registro comparable = (Registro) mostrar.paginas.get(i);
			if (key == comparable.Key){
					System.out.println(comparable);
					break;
			}	
		}
		return null;	
	}
	
	//elimina un elemento de la tabla
	public void eliminar(int Key){
		Page rpta = buscarPagina(Key);
		
		for(int i =0;i<rpta.paginas.size();i++){
			Registro comparable = (Registro) rpta.paginas.get(i);
			if (Key == comparable.Key){
					rpta.paginas.remove(i);
					System.out.println(comparable);
					break;
			}	
		}
	}
	
	
	private void dividir (int Hash){
		this.directorio.get(Hash).p++;
			int other = (int) Math.pow(2, d-1);
		if (Hash > this.directorio.size()/2){
			other = other *(-1);
		}
		other = Hash + other;
		int posInicial = Hash; 
		Hash = Math.min(posInicial, other);
		other = Math.max(posInicial, other);
		ArrayList<Registro<E>> add = new ArrayList<Registro<E>>();
		for (int i=0 ; i < this.directorio.get(Hash).paginas.size(); i++){
			if (this.directorio.get(Hash).paginas.get(i)!= null && (this.directorio.get(Hash).paginas.get(i).Key % Math.pow(2, d)/ Math.pow(2,d-1) ) % 2!= Hash){
				add.add(this.directorio.get(Hash).paginas.get(i));
				this.directorio.get(Hash).paginas.set(i,null);
			}
		}
		this.directorio.set(other, new Page<E> (this.directorio.get(Hash).p));
		for (Registro<E> reg : add){
			this.insertar(reg.Key, reg.Register);
		}
		
	}
	
	public String toString() {
		String res = "";
		String numBin="";
		int longitud= d;
		System.out.println(longitud);
		for (int i = 0; i < this.directorio.size()-1; i++) {
			for (int j = 0; j<(int)Math.pow(2, longitud); j++){
				numBin = Integer.toBinaryString(i);
				while(numBin.length()<longitud){
					numBin=0+numBin;
				}
			}
			
			res = res + numBin + "\t-->\t" + this.directorio.get(i) + "\n";
		}
		return res;
	}
}
