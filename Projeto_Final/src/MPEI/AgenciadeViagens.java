package MPEI;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgenciadeViagens {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		//Leitura do ficheiro	
		Path p = Paths.get("viagens.txt");					
		List<String> lines = new ArrayList<String>();			
		try {
			lines = Files.readAllLines(p,Charset.defaultCharset());
		}catch (IOException e) {
			e.printStackTrace();
		}																	
		String [] aux=lines.get(1).split(",");
		 
		//Criaçao dos BloomFilters
		 BloomFilter [] b = new BloomFilter[aux.length];
		 for(int i=0; i<aux.length;i++){
			 b[i]= new BloomFilter(1000,5, aux[i]);
		 }
		 
		 // Criaçao de uma lista com todas as localidades e seus respetivos atributos
		 
		 ListLocalidade local = new ListLocalidade();	
		 for(int i=3; i<lines.size(); i++){
			 local.add(lines.get(i), i-3);
		 }
		 
		 //Adiçao das localidades ao bloomfilter
		 for(int i=0; i<local.size();i++){
			 String [] x=local.get(i).getAtributos();
			 for(int j=0;j<aux.length;j++){
				 for(int k=0; k<x.length; k++){
					 if(b[j].getAtributo().equals(x[k])){
						 b[j].add(local.get(i).getNome());
					 }
				 }
			 }
		 }
		 
//		 for(int i5 = 0; i5 < 13; i5++){ //Teste ao módulo: "BLOOMFILTER"
//		 	System.out.println(b[i5].getAtributo());
//			 b[i5].print_teste();
//	 }
		 
		 //Criação e obtenção do MinHash
		 int hash_a = 50;
		 MinHash sim = new MinHash(local, hash_a);
		 sim.getMinHash();
		
		 //sim.printe(); //Tirar de comentario para testar o módulo:  "MINHASH Tables"
		
		 int x =0;
		 do{
			 menus.principal();
			 x = sc.nextInt();
			 sc.nextLine();
			 clearScreen();
			 switch(x){
				 case 1:
					 menus.filtros(aux);
					 String filt = sc.nextLine();
					 clearScreen();
					 String [] aa = verificarFiltro(b, filt, local);
					 for(int i=0; i<aa.length;i++){
						local.print(aa[i]);
					 }
					 System.out.print("Selecione uma das Localidades:	");
					 int xxx = sc.nextInt();
					 clearScreen();
					 local.print2(xxx);
					 
					 double d_hamm;
					 ArrayList<Double> hamm = new ArrayList<>();
					 int intersect;
					 int uni;
					 for(int i1= 0; i1 < local.size(); i1++){
						 //System.out.println(intersection(sim.listMin(xxx), sim.listMin(i1)) + "/" + union(sim.listMin(xxx), sim.listMin(i1)));
						 intersect = intersection(sim.listMin(xxx), sim.listMin(i1));
						 uni = union(sim.listMin(xxx), sim.listMin(i1));
						 d_hamm =(double) intersect / uni;
						 //System.out.println(d_hamm);
						 hamm.add(d_hamm);
					 }
					 
//					 for(int i2 = 0; i2 < hamm.size(); i2++){
//						 System.out.println(hamm.get(i2));
//					 }
					 System.out.println();
					 System.out.println("Localizações similares: ");
					 System.out.println();
					 getMinIndex(hamm, local, xxx);
					 System.out.println();
					 break;
					 
				 case 2:
					 for(int i=0; i<local.size();i++){
							local.print(local.get(i).getNome());
					 }
					 System.out.print("Selecione uma das Localidades:	");
					 xxx = sc.nextInt();
					 clearScreen();
					 local.print2(xxx);
					 ArrayList<Double> hamm2 = new ArrayList<>();
					 for(int i1= 0; i1 < local.size(); i1++){
						 //System.out.println(intersection(sim.listMin(xxx), sim.listMin(i1)) + "/" + union(sim.listMin(xxx), sim.listMin(i1)));
						 intersect = intersection(sim.listMin(xxx), sim.listMin(i1));
						 uni = union(sim.listMin(xxx), sim.listMin(i1));
						 d_hamm =(double) intersect / uni;
						 //System.out.println(d_hamm);
						 hamm2.add(d_hamm);
					 }
					 System.out.println();
					 System.out.println("Localizações similares: ");
					 System.out.println();
					 getMinIndex(hamm2, local, xxx);
					 System.out.println();
					 break;
					 
				 case 0:
					System.exit(1);
				default:
					System.out.println("Opção não existe!");
			 }
		 }while(x!=0); 
	}
	
	private static void getMinIndex(ArrayList<Double> hamm, ListLocalidade l, int index) {
		int indice = 0;
		int[] excl = new int[3];
		excl[0] = -1;
		excl[1] = -1;
		excl[2] = -1;
		
		for(double b = 1; b > 0; b = b - 0.01){
			for(int i = 0; i < hamm.size(); i++){
				if(indice == 3){
					return;
				}
				if(hamm.get(i) >= b){
					if(i != index && i != excl[0] && i != excl[1] && i != excl[2]){
						System.out.println(l.get(i)/* + "|" + hamm.get(i)*/); //Retirar de comentario para testar "DISTANCIA DE JACCARD"
						excl[indice] = i;
						indice++;
					}
				}
			}
		}
		
	}

	public static String [] verificarFiltro( BloomFilter [] b, String s,  ListLocalidade local){
		char x;
		int y;
		ArrayList<String> ss = new ArrayList<>();
		int i=0;
		do{
			ss.add(local.get(i).getNome());
			i++;
		}while(i<local.size());
		
		for(i=0; i<s.length();i++){
			
			// converter cada carater para um numero do bloom filter
			x = s.charAt(i);
			if(x=='A'|| x=='B' || x=='C' || x=='D' || x=='E'){
				y = (int)x - 55;
			}else{
				y = (int)x - 48;
			}
			int j=0;
			do{
				if(!b[y].verificar(ss.get(j))){
					ss.remove(ss.get(j));
					j--;
				}
				j++;
			}while(j<ss.size());
			
		}
		
		
		return  toArray(ss);
	}
	
	public static String [] toArray(ArrayList<String> s){
		String [] ss = new String [s.size()];
		for(int i=0; i<ss.length;i++){
			ss[i]=s.get(i);
		}
		return ss;
	}
	public static void clearScreen(){  
			for (int i = 0; i < 50; ++i) System.out.println();
	} 
	
	//Função parcialmente copiada do StackOverflow
		public static <T> int union(List<T> list1, List<T> list2) {
		    ArrayList<T> temp = new ArrayList<T>();
		    for(int i = 0; i < list1.size(); i++){
		    	temp.add(list1.get(i));
		    }
		    for(int b = 0; b < list2.size(); b++){
		    	temp.add(list2.get(b));
		    }
		    
		    List<T> temp_int = new ArrayList<>(intersectionList(list1, list2));
		    
		    for(int k = 0; k < temp_int.size(); k++){
		    	temp.remove(temp_int.get(k));
		    }
		    
		    return temp.size();
	    }
		
	//Função parcialmente copiada do StackOverflow
	public static <T> int intersection(List<T> list1, List<T> list2) {
		List<T> lista = new ArrayList<T>();
	       for (T t : list1) {
	    	   if(list2.contains(t)){
	            lista.add(t);
	    	   }
	       }
	    return lista.size();
	}
	
	public static <T> List<T> intersectionList(List<T> list1, List<T> list2) {
		List<T> lista = new ArrayList<T>();
	       for (T t : list1) {
	    	   if(list2.contains(t)){
	            lista.add(t);
	    	   }
	       }
	    return lista;
	}
}
