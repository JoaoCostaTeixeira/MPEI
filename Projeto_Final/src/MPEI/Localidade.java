package MPEI;

public class Localidade {
	private String nome, pais, atributos;
	private int populacao, temperatura,index;
	
	public Localidade(String nome, String pais, String atributos, int temperatura, int populacao, int index){
		this.nome=nome;
		this.pais=pais;
		this.atributos=atributos;
		this.temperatura=temperatura;
		this.populacao=populacao;
		this.index=index;
	}
	
	public String getNome(){
		return nome;
	}
	public String getPais(){
		return pais;
	}
	public String[] getAtributos(){
		return atributos.split(",");
	}
	public String getAtributos_simple(){
		return atributos;
	}
	public int getTemperatura(){
		return temperatura;
	}
	public int getPopulacao(){
		return populacao;
	}
	public int getIndex(){
		return index;
	}

	public String toString2() {
		return index+  " | " + nome ;
	}
	
	@Override
	public String toString() {
		return 	getIndex() +  " | " + getNome()+  " | " +getAtributos_simple() + " | " + getPais() + " | " + getPopulacao() +  " pessoas | " +  getTemperatura() + "ºC";

	}

	
	
}
