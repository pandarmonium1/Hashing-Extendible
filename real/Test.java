package real;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
	
		System.out.println("EDAT- TRABAJO FINAL");
		
		//System.out.print("Ingrese el tamaño de las páginas: ");
//		int tamPag = scan.nextInt();
		
		HashingExten<Alumno> alumnos = new HashingExten<Alumno>(5);
		int opt=0;;
		
		alumnos.insert(9, new Alumno(9,"Juan1"));
		alumnos.insert(10, new Alumno(10,"Juan2"));
		alumnos.insert(12, new Alumno(12,"Juan3"));
		alumnos.insert(15, new Alumno(15,"Juan4"));
		alumnos.insert(14, new Alumno(14,"Juan5"));
		
		System.out.println(alumnos);
		
		
		
		alumnos.insert(12, new Alumno(12,"Juan6"));
		
		//ACA TENGO UN PROBLEMA PARA CUANDO TRABAJO DE A MAS DE 2ELEVADO  A 3, PERO ESTA BIEN LA PRIMERA EXPANSION, 
		//Trabaja con eso, para el delete y el search, q te devuelva registro, ya tengo un search Data ahi, creo q 
		//Llegare a las 10 por ahi creo, ahmmm bno me avisas q avanzas si 
		
		
		System.out.println(alumnos);
		alumnos.insert(22, new Alumno(22,"Juan3"));
		alumnos.insert(24, new Alumno(24,"Juan4"));
		alumnos.insert(28, new Alumno(28,"Juan5"));
		alumnos.insert(29, new Alumno(29,"Juan3"));
		alumnos.insert(31, new Alumno(31,"Juan4"));
		alumnos.insert(32, new Alumno(32,"Juan5"));
		System.out.println(alumnos);
		
		/*while (true){
			System.out.println("***************");
			System.out.println("Funcion a realizar:" +"\n" +"1.Ingresar"+ "\n" +"2.Buscar"+"\n"+"3.Eliminar"+"\n"+"4.Mostrar"+"\n"+"5.Salir");
			opt = scan.nextInt();
			System.out.println("***************");
			if(opt == 1){
				Alumno nuevo;
				System.out.println("Ingrese Codigo: ");
				int cod = scan.nextInt();
				System.out.println("Ingrese Nombre");
				String name = scan.next();
				nuevo = new Alumno(cod,name);
				alumnos.insert(cod, nuevo);
			
			}
			
			if(opt == 2){
				System.out.println("Ingrese DNI a buscar:");
				int cod = scan.nextInt();
				alumnos.searchCod(cod);

			}
			if(opt == 3){
				System.out.println("Ingrese DNI a eliminar:");
				int eliminar = scan.nextInt();
				alumnos.delete(eliminar);
			}
			if(opt == 4){
				System.out.println("Tabla hashing extensible");
				System.out.println(alumnos);
			}
			if (opt == 5){
				System.out.println("Hasta Pronto");
				break;
			}
			
		}
*/	}


}
