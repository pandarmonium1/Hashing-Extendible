import java.util.ArrayList;

public class Page<E> {
	int p; //profundidad de la pagina
	int tamañoRegistro;
	ArrayList<Registro<E>> paginas;

	//Creacion de las paginas
	//comenmtario del metodo
	public Page(int p){
		this.paginas = new ArrayList<Registro<E>>(); 
		for(int i=0;i<2;i++)
			this.paginas.add(null);
		this.p=p;
	}
	//la funcion hash que halla la posicion donde debe insertarse el elemento
	protected int funcionHash(int Key){
		//System.out.println(this.paginas.size());
		return Key%this.paginas.size();
	}
	//Visita la posicion que nos envia la funcion hash y evalua si esta disponible
	// en caso el modulo sea el mismo, pero las claves no, vuelve a calcular el modulo de hash incrementado en 1
	public int searchPosition(int hash,int itera, int key){
		int posicionInicial=hash;
		do{
			if(this.paginas.get(hash) == null && itera==0)
				return hash;
			if(this.paginas.get(hash) !=null && this.paginas.get(hash).Key == (key))
				if (itera == 0)
					return -1;
			else 
						return hash;
			hash = (hash +1) % this.paginas.size();
		}
		while(hash !=posicionInicial);
		return -1;	
	}
	//Verifica si el Dni esta repetido
	protected boolean doubleKey (int key){
		int hash = this.funcionHash(key);
		hash = this.searchPosition(hash, 1, key);
		return hash!=-1;
	}
	
	//verifica si las paginas del directorio estan llenas
	protected boolean isFull(){
		for(int i=0;i<this.paginas.size();i++){
			if(this.paginas.get(i) == null)
				return false;
		}
		return true;
	}
	

	public void insert(Registro<E>nuevo){
	
		int hash = funcionHash(nuevo.getKey());
		//buscamos la posicion donde debe ser ingresado
		hash = searchPosition(hash,0,nuevo.Key);
		if(hash == -1)
			return ;
		else{
			this.paginas.set(hash, nuevo);
		}
			
	}
	
	public String toString(){
		String respuesta="";
		for (int i=0;i<this.paginas.size();i++){
			if(this.paginas.get(i)!=null)
				respuesta=respuesta+ Integer.toBinaryString(this.paginas.get(i).Key)+ " >>>>  " + this.paginas.get(i).toString() + "," ;
		
		}
		return respuesta;
		

	}
	
}
