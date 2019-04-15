import java.lang.*;
public class random {	
	public static void main (String args[]) {
		String [] s = {"praia","montanha","historico","comercio","neve","desporto","rural","urbano","noite","ilha","cultura","tropical","religioso"};
		
		for(int i=0;i<200;i++){
			int x = (int)(Math.random()*11)+3;
			String [] s1 = new String[x];
			for(int j=0;j<x;j++){
				if(j!=0)System.out.print(",");
				if(j==0)System.out.print(";");
				int y;
				do{
					y = (int)(Math.random()*13);
				}while(contains(s1,s[y],j));
				s1[j]=s[y];
				System.out.print(s1[j]);
			}
			System.out.printf(";%d;%d",(int)(Math.random()*30),(int)(Math.random()*1500000)+500000);
			System.out.println("");
		}
	}
	public static boolean contains(String [] s, String s1, int x){
		if(x==0) return false;
		for(int i=0; i<x; i++){
			if(s[i].equals(s1)) return true;
		}
		return false;
	}
}

