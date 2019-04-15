%% Exercicio 7


l=15; %%mensagens por segundo

%% a)
k=0;

porb0 = ((l^k)/factorial(k))*exp(-l)


%% b)

prob=0;

for k=0:10
  prob = prob + (((l^k)/factorial(k))*exp(-l));
  end
  
  prob = 1-k;