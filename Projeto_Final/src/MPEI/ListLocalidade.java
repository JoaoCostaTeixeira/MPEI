package MPEI;

import java.util.ArrayList;

public class ListLocalidade {
	private ArrayList<Localidade> arr = new ArrayList<Localidade>();
	public ListLocalidade(){
		
	}
	public void add(String s, int index){
		String[] aux=s.split(";");
		Localidade c = new Localidade(aux[0], aux[1], aux[2], Integer.parseInt(aux[3]),  Integer.parseInt(aux[4]),index);
		arr.add(c);
	}
	
	public Localidade get(int i){
		return arr.get(i);
	}
	public int size(){
		return arr.size();
	}
	public void print(String s){
		for(int i=0; i<arr.size();i++){
			if(arr.get(i).getNome().equals(s)){
				System.out.println(arr.get(i).toString2());
			}
		}
	}
	public void print2(int i){
		System.out.println(i +  " | " + arr.get(i).getNome()+  " | " +arr.get(i).getAtributos_simple() + " | " + arr.get(i).getPais() + " | " + arr.get(i).getPopulacao() +  " pessoas | " +  arr.get(i).getTemperatura() + "ºC");
	}
	
	public String getSimple(int i){
		return (arr.get(i).getAtributos_simple() + " " + arr.get(i).getPais() + " " + arr.get(i).getPopulacao() +  " " +  arr.get(i).getTemperatura());
	}
	
	
	
	
}
