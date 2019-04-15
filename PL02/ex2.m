%% ex2a
%% Sexp.aleat = {nota1, nota2,..., nota100}  e cada nota tem probablilidade dos 
%% dos acontecimentos elementares = 1/100


%% ex2b
%% Sx = {5, 50, 100} espaço de amostragem de X

prob5 = 90/100
prob50= 9/100
prob100 = 1/100 


%%ex2c

p=[prob5 prob50 prob100];
n=[5 50 100]
b=cumsum(p);
stairs(n,b)


