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
		
		alumnos.insert(4, new Alumno(4,"Juan1"));
		alumnos.insert(2, new Alumno(2,"Juan2"));
		alumnos.insert(9, new Alumno(9,"Juan3"));
		alumnos.insert(8, new Alumno(8,"Juan4"));
		//alumnos.insert(7, new Alumno(4,"Juan5"));
		
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
