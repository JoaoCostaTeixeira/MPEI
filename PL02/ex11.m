%% Exercicio 11

n=1e4;
notas = randn(1, n)*2+14;
sucessos = notas<=16 ;


prob = sum(sucessos) / n