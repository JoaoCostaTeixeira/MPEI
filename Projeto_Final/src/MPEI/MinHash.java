package MPEI;

import java.util.ArrayList;
import java.util.LinkedList;

public class MinHash {
	
	
	ListLocalidade l;
	int[][] min;
	int hash_amm;
	int[] x_hash;
	
	public MinHash(ListLocalidade l, int k){
		this.l = l;
		min = new int[l.size()][k];
		hash_amm = k;
		x_hash = new int[k];
	}
	
	void getMinHash(){
		x_hash[0] = 0;
		for(int oi = 1; oi < hash_amm; oi++){
			x_hash[oi] += x_hash[oi - 1] + oi;
		}
		String temp;
		int temp_h;
		LinkedList<String> shingles = new LinkedList<>();
		LinkedList<Integer> temp_hash = new LinkedList<Integer>();
		for(int i = 0; i < l.size(); i++){
			temp = l.getSimple(i);
			for(int io = 0; io < temp.length() - 2; io++){
				shingles.add("" + temp.charAt(io) + temp.charAt(io + 1) + temp.charAt(io + 2));
			}
			for(int c = 0; c < hash_amm; c++){
				for(int t = 0; t < shingles.size(); t++){
					temp_h = ((shingles.get(t).hashCode() % 200) ^ x_hash[c]);
					temp_hash.add(temp_h); //Fazer hash a tudo
				}
				min[i][c] = getMinValue(temp_hash); //Obter o minimo
				temp_hash.clear();
			}
			shingles.clear();
		}
		
	}

	public static int getMinValue(LinkedList<Integer> lista) {
	    int minValue = lista.get(0);
	    for (int i = 1; i < lista.size(); i++) {
	    	if (lista.get(i) < minValue) {
				minValue = lista.get(i);
			}
	    }
	    return minValue;
	}
	
	public int randomNumber(){
		String num = "";
		for(int i = 0; i < 8; i++){
			num += "" + ((int)(Math.random()*9));
		}
		return Integer.parseInt(num);
	}
	
	public void printe(){
		for(int i = 0; i < l.size(); i++){
			for(int b = 0; b < hash_amm; b++){
				System.out.print(min[i][b] + "/");
			}
			System.out.println();
		}
	}
	
	public ArrayList<Integer> listMin(int i){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i1 = 0; i1 < hash_amm; i1++){
			temp.add(min[i][i1]);
		}
		return temp;
	}

}
