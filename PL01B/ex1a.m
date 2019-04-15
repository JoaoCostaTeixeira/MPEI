%%Exercicio 1.a

N= 1e5; 
p = 0.5; 
k = 1; 
n = 2; 
filhos = rand(n,N) > p;
sucessos= sum(filhos)>=k;
probSimulacao= sum(sucessos)/N

