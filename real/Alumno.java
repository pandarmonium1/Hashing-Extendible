package real;
public class Alumno {
	
	protected int  cod;
	protected String nombre;
	
	public Alumno (int cod, String n){
		this.cod=cod;
		this.nombre=n;
	}

	
	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString(){
		return "Codigo: "+cod+"\t Nombre: "+nombre;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Alumno))
			return false;
		else {
			Alumno a = (Alumno) o;
			return this.cod == a.cod;
		}
	}

	public int compareTo(Alumno o) {
		return this.cod - o.cod;
	}
	
}
