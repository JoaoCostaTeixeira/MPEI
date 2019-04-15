%%Exercicio 1.c

%%Frequentista

N= 1e5; 
p = 0.5; 
k = 2; 
n = 2; 
filhos = rand(n,N) > p;
sucessos= sum(filhos)>=k;
probSimulacao= sum(sucessos)/N

%% Classica
prob = factorial(n)/(factorial(n-k)*factorial(k))*p^k*(1-p)^(n-k)