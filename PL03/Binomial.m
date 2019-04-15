%% Exercicio 4

function y = Binomial(n, p, N);
  Bern=rand(n,N)<=p; 
  Y = sum(Bern);
  
end