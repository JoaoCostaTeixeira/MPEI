%%Exercicio 1.e

N= 1e4; 
p = 0.5; 
n = 5; 

filhos = rand(n,N) > p;
sucessos2= sum(filhos) == 2
sucessos1= sum(filhos) == 1
probSimulacao= sum(sucessos)/sum(sucessos1)

