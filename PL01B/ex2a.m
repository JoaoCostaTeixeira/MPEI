%% Exercicio 2.a

N=1e5;
n=10;
p =0.5;

lancamentos = rand(n,N) > p;
sucessos = sum(lancamentos) == 10;
probsumila = sum(sucessos)/N


%  Valor teorico  1 / 2^10 = 9.7656e-004 
