import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner scan = new Scanner (System.in);
	
		System.out.println("HASHING EXTENSIBLE EDAT 2018");
		
		System.out.print("Ingrese el tamaño de las páginas: ");
		int M = scan.nextInt();
		
		int it = 0;
		int opc;
		
		HashingExtensible<Empleado> people = new HashingExtensible<Empleado>();
		
		while (it == 0){
			System.out.println("***************");
			System.out.println("Funcion a realizar:" +"\n" +"1.Ingresar"+ "\n" +"2.Buscar"+"\n"+"3.Eliminar"+"\n"+"4.Mostrar"+"\n"+"5.Salir");
			opc = scan.nextInt();
			System.out.println("***************");
			if(opc == 1){
				Empleado p;
				System.out.println("Ingrese DNI: ");
				int dni = scan.nextInt();
				System.out.println("Ingrese Nombre");
				String name = scan.next();
				System.out.println("Ingrese Direccion");
				String dire = scan.next(); 
				p = new Empleado(dni,name,dire);
				people.insertar(p.dni,p);
				it = 0;
			}
			if(opc == 2){
				System.out.println("Ingrese DNI a buscar:");
				int buscar = scan.nextInt();
				people.buscarEnPagina(buscar);
				it = 0;

			}
			if(opc == 3){
				System.out.println("Ingrese DNI a eliminar:");
				int eliminar = scan.nextInt();
				people.eliminar(eliminar);
				it = 0;

			}
			if(opc == 4){
				System.out.println("Tabla hashing extensible");
				
				System.out.println(people);
				it = 0;
			}
			if (opc == 5){
				System.out.println("Hasta Pronto");
				it = 1;
			}
			
		}
		
		
	
	/*
	Empleado p1 = new Empleado(71813918,"Andrea Huayna ", "Paucarpata");
	Empleado p2 = new Empleado(74988827,"Diego Chara", "Socabaya");
	Empleado p3 = new Empleado(72610440,"Frank Murga", "Miraflores");
	Empleado p4 = new Empleado(71894556,"Karla Riveros", "Mariano Melgar");
	//Empleado p5 = new Empleado(73456785,"Rocio Madariaga", "Mariano Melgar");
	//Empleado p6 = new Empleado(72345467,"Karina Benito", "Bustamante y Rivero");
	/*Empleado p7 = new Empleado(76564534,"Elizabeth Cruz", "Cayma");
	
	Empleado p8 = new Empleado(71178677,"Glenier Zuñiga", "Selva Alegre");
	Empleado p9 = new Empleado(76569878,"Ana Palomino", "Miraflores");
	Empleado p10 = new Empleado(7767986,"Lizeth Cabana", "Cercado");
	Empleado p11 = new Empleado(7865454,"Karen Cosi", "Hunter");
	Empleado p12 = new Empleado(7609809,"Victoria Saravia", "Sachaca");
	Empleado p13 = new Empleado(7354565,"Alejandra Huamani", "Paucarpata");
	Empleado p14 = new Empleado(7178908,"Diana Serrano", "Miraflores");
	Empleado p15 = new Empleado(7256768,"Flor Patiño", "Paucarpata");
	
	HashingExtensible<Empleado> people = new HashingExtensible<Empleado>();

	people.insertar(p1.dni, p1);
	people.insertar(p2.dni, p2);
	people.insertar(p3.dni, p3);
	people.insertar(p4.dni, p4);
	//people.insertar(p5.dni, p5);
	//people.insertar(p6.dni, p6);
	/*people.insertar(p7.dni, p7);
	people.insertar(p8.dni, p8);
	people.insertar(p9.dni, p9);
	people.insertar(p10.dni, p10);
	people.insertar(p11.dni, p11);
	people.insertar(p12.dni, p12);
	people.insertar(p13.dni, p13);
	
	people.insertar(p14.dni, p14);
	
	people.insertar(p15.dni, p15);
	/*
	
	System.out.println(people);
	people.buscarEnPagina(71894556);
	people.eliminar(71894556);
	System.out.println(people);
	*/
	
	}


}
