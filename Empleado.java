public class Empleado {
	
	protected int  dni;
	protected String nombres;
	protected String direccion;
	
	public Empleado (int dni, String n, String d){
		dni = dni;
		nombres = n;
		direccion = d;
		
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) { 
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String toString() {
		return this.nombres + " " + this.direccion + ".";
	}

	public boolean equals(Object o) {
		if (!(o instanceof Empleado))
			return false;
		else {
			Empleado p = (Empleado) o;
			return this.dni == p.dni;
		}
	}

	public int compareTo(Empleado o) {
		if (this.dni < o.dni)
			return -1;
		else if (this.dni > o.dni)
			return 1;
		else
			return 0;
	}
	
}
