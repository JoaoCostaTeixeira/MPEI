package MPEI;

public class testBloom {
	public static void main(String[] args) {
		BloomFilter b = new BloomFilter(1000,5, "praia");
		
		System.out.println("Test BloomFilter\n");
		
		String [] s = {"Portugal", "Espanha", "França"};
		
		for(int i=0; i<s.length;i++){
			b.add(s[i]);
			System.out.println("String " + s[i] + " adicionada" );
		}
		
		System.out.println("Portugal? " + b.verificar("Portugal"));
		System.out.println("Alemanha? " + b.verificar("Alemanha"));
		System.out.println("França? " + b.verificar("França"));
		System.out.println("Inglaterra? " + b.verificar("Inglaterra"));
		
	}

}
