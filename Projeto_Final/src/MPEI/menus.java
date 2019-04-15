package MPEI;

public class menus {
	public static void principal(){
		System.out.println("1-Pesquisar por filtro");
		System.out.println("2-Listar todas as Localidades");
		System.out.println("0-Sair");
	}
	public static void filtros(String [] s){
		char a=' ';
		for(int i=0; i<s.length;i++){
			if(i<10) a = (char) ('0' + i);
			if(i>=10) a= (char) ('A'+(i-10));
			System.out.println(a + " - " + s[i]);
		}
		System.out.print("Filtros:	");
	}
}
