package real;

import java.util.ArrayList;

public class HashingExten <E>{
	protected int d; //Exponente con el cual inicia;
	protected int bits;
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
	
	private void expHash(int dressH){
		d++;
		Page<E> auxPag= new Page<E> (tPag);
		Page<E> pagFull=paginas.get(dressH);
		Page<E> pagNueva=new Page<E> (tPag);;
		pagFull.dPrima=d;
		while(!(pagFull.registros.isEmpty())){
			int i=0;
			auxPag.registros.add(pagFull.registros.remove(i));	
		}
		
		int exp=(int)(Math.pow(2,d)-(int)(Math.pow(2,d-1)));
		
		for(int i=0;i<exp ;i++){
			if(i==dressH){
				paginas.add(dressH+1,pagNueva);
				pagNueva.dPrima=d;
			}
			else {
				paginas.add(new Page<E>(tPag,d-1));
				
			}
		}
	
		while(!(auxPag.registros.isEmpty())){
			int j=0;
			Registro<E> auxReg=auxPag.registros.remove(j);
			insert(auxReg.key,auxReg.data);
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
		/*if (paginas.get(dressH).registros.isEmpty()) {
		
			paginas.get(dressHash).dressH = dressHash;
			paginas.get(dressHash).registros.add(aux);
		} else {
			if (paginas.get(dressHash).registros.search(aux) == false)
				paginas.get(dressHash).registros.add(0,aux);
			else
				System.out.println(key + " ya fue insertada antes...");
		}*/
	
	private E searchData(int key) {
		int dressH = functionHash(key);
		String bKey= Integer.toBinaryString(key);
		if(paginas.get(dressH).registros.contains(bKey)){
			for(int i=0;i<paginas.get(dressH).registros.size();i++){
				if(paginas.get(dressH).registros.get(i).getBKey().equals(bKey))
					return paginas.get(dressH).registros.get(i).data;
			}
		}
		else return null;
		
		return null;
	}
	
	public void searchCod(int key) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int key) {
		// TODO Auto-generated method stub
		
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
			s+=Integer.toBinaryString(i)+"---->\t"+pag.bDressH+pag+"\n";
			i++;
		}
		return s;
		}
	}
	
	
}
