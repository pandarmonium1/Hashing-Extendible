package real;

import java.util.ArrayList;

public class HashingExten <E>{
	
	protected int d; 
	protected int tPag;
	protected ArrayList <Page<E>> paginas;
	
	
	public HashingExten(int a){
		this.paginas=new ArrayList<Page<E>> ();
		tPag=a;
		paginas.add(new Page<E>(tPag));
		paginas.get(0).setbDressH("0");
		d=0;
	}	
	private int functionHash(int key){
		return (int)(key%Math.pow(2,d));
	}
	private int functionHash(int key,int exp){
		return (int)(key%Math.pow(2,exp));
	}
	
	private void expHash(int dressH){
		//EVALUAREMOS SI DIVIDIMOS O EXPANDIMOS
		if(paginas.get(dressH).dPrima==d){
		d++;
		Page<E> auxPag= new Page<E> (tPag);
		Page<E> pagFull=paginas.get(dressH);
		Page<E> pagNueva=new Page<E> (tPag);
		pagFull.dPrima=d;
		while(!(pagFull.registros.isEmpty())){
			int i=0;
			auxPag.registros.add(pagFull.registros.remove(i));	
		}
		
		int exp=(int)(Math.pow(2,d)-(int)(Math.pow(2,d-1)));
		
		for(int i=0;i<exp ;i++){
			if(i==dressH){
				paginas.add(pagNueva);
				pagNueva.dPrima=d;
			}
			else {
				paginas.add(new Page<E>(tPag,d-1));
				paginas.get(paginas.size()-1).dressH=paginas.size()-1;
				paginas.get(paginas.size()-1).bDressH=Integer.toBinaryString(paginas.size()-1);
			}
		}

		while(!(auxPag.registros.isEmpty())){
			int j=0;
			Registro<E> auxReg=auxPag.registros.remove(j);
			insert(auxReg.key,auxReg.data);
			}
		
			for(int j=0;j<paginas.size() ;j++){
				if(paginas.get(j).dPrima<d&&paginas.get(j).registros.isEmpty())
					paginas.get(j).registros=paginas.get(functionHash(paginas.get(j).dressH,d-1)).registros;
			}
		}
		else{
			
			Page<E> auxPag=new Page<E> (tPag);
			Page<E> pagFull=paginas.get(dressH);
			pagFull.dPrima++;
			paginas.get(functionHash(dressH,d-1)).dPrima++;
			while(!(pagFull.registros.isEmpty())){
				int i=0;
				auxPag.registros.add(pagFull.registros.remove(i));	
			}
			pagFull.registros=new ArrayList<Registro<E>>();
			while(!(auxPag.registros.isEmpty())){
				int j=0;
				Registro<E> auxReg=auxPag.registros.remove(j);
				insert(auxReg.key,auxReg.data);
			}
			
		}
	}
	
	public void insert(int key, E reg) {
		
		if(searchData(key)==null){
		Registro<E> aux = new Registro<E>(key, reg);
		int dressH = functionHash(key);
		String bDressH= Integer.toBinaryString(dressH);
			
		if(d==0){
		if(paginas.get(dressH).registros.isEmpty()){
			paginas.get(dressH).setbDressH(bDressH);
			paginas.get(dressH).registros.add(aux);
			}
		else if(!(paginas.get(dressH).registros.size()+1>paginas.get(0).tamaño)){
			paginas.get(dressH).registros.add(aux);
		}
		else{
			paginas.get(dressH).registros.add(aux);	
			expHash(dressH);
			}
		}
		else{
			if(paginas.get(dressH).registros.isEmpty()){
				paginas.get(dressH).setbDressH(bDressH);
				paginas.get(dressH).registros.add(aux);
				}
			else if(!(paginas.get(dressH).registros.size()+1>paginas.get(0).tamaño)){
				paginas.get(dressH).registros.add(aux);
			}
			else{
				paginas.get(dressH).registros.add(aux);	
				expHash(dressH);
				}
			}
		}
		else{
			System.out.println("Codigo repetido");
			}
		}
		
	public E searchData(int key) {
		int dressH = functionHash(key);
		String bKey= Integer.toBinaryString(key);
		if(paginas.get(dressH).registros.contains(new Registro(key,null))){
			for(int i=0;i<paginas.get(dressH).registros.size();i++){
				if(paginas.get(dressH).registros.get(i).getBKey().equals(bKey)){
					return paginas.get(dressH).registros.get(i).data;
				}
			}
		}
		else { 
			return null;
		}
		
		return null;
	}
	

	public void delete(int key) {
		if(searchData(key)==null){
			System.out.println("No existe la clave en el Hash");
		}
		else{
			int dressH = functionHash(key);
			String bKey= Integer.toBinaryString(key);
			paginas.get(dressH).registros.remove(paginas.get(dressH).posKey(key));
			paginas.get(dressH).updateDensidad(paginas.get(dressH).registros.size(), tPag);
			contHash(dressH);
			}
		}
		
	
	private ArrayList<Integer> iniCarga(){
	ArrayList<Integer> aptos = new ArrayList<Integer>(paginas.size());
	int comp=0;
	int pareja=1;
	for(int i=0;i<this.paginas.size();i++){
	paginas.get(i).updateDensidad(paginas.get(i).registros.size(), tPag);
	}
		for(int i=0, j=1; i<this.paginas.size()&&j<this.paginas.size();i++,j++){
			for(int k=1;i<this.paginas.size();k++){
				if(paginas.get(i).densidad<=0.5&&paginas.get(k).densidad<=0.5)
					comp++;
				if(paginas.get(k).dPrima==paginas.get(i).dPrima)
					comp++;
				if(paginas.get(k).bDressH.indexOf(paginas.get(i).bDressH)>=paginas.get(i).bDressH.length() ||
						paginas.get(k).bDressH.indexOf(paginas.get(i).bDressH)>=paginas.get(k).bDressH.length())
					comp++;
				if(comp==3){
					aptos.set(i,pareja);
					aptos.set(k,pareja);
					pareja++;
				}
				comp=0;
			}
			if(aptos.get(i)==null)
				aptos.set(i,0);
		}
		
		return aptos;
	
		
	}
	
	private boolean AllPrimas(){
		Boolean contr=true;
		for(int i=0;i<paginas.size();i++){
			if(paginas.get(i).dPrima==d)
				contr=false;
		}
		return contr;
	}
	
	private void contHash(int dressH){
		ArrayList<Integer> aptosUnion= iniCarga();
		for(int i=0;i<aptosUnion.size();i++){
			//UNION
			if(aptosUnion.get(i)!=0){
				int posPareja= aptosUnion.lastIndexOf(aptosUnion.get(i));
				Page<E> auxPag= new Page<E> (tPag);
				Page<E> pagDiv=paginas.get(i);
				while(!(pagDiv.registros.isEmpty())){
					int a=0;
					auxPag.registros.add(pagDiv.registros.remove(a));	
				}
				pagDiv=paginas.get(posPareja);
				while(!(pagDiv.registros.isEmpty())){
					int a=0;
					auxPag.registros.add(pagDiv.registros.remove(a));	
				}
				paginas.get(i).registros=pagDiv.registros;
				pagDiv.dPrima--;
				while(!(auxPag.registros.isEmpty())){
					int j=0;
					Registro<E> auxReg=auxPag.registros.remove(j);
					insert(auxReg.key,auxReg.data);
				}				
			}		
		}
		Boolean aptoCont= AllPrimas();
		if(aptoCont){
			d--;
			int a=0; 
			for(int i=0;i<paginas.size();i++){
				if((i<=d)){
					paginas.get(i).registros=paginas.get(a).registros;
					a=+d;
				}
				else{
					paginas.remove(i);
				}
				
			}
		}
	}
			
		
	

	public String toString(){
		String s = "Indice\tBinary Dress\t\tData \n";
		int i=0;
		
		if(d==0&&paginas.size()<=0){
			s +=  "empty\n";
			return s;
		}
		else{
		for (Page<E> pag : paginas) {
			s+=Integer.toBinaryString(i)+"-->\t"+pag.bDressH+pag+"\n";
			i++;
		}
		return s;
		}
	}
	
	
}
