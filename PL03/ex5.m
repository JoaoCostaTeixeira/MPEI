%% Exercicio 5

function y = ex5(p,N)
  p = p/sum(p);
  y = zeros(1,N);
  
  for j=1:N
    U=rand();
    i = 1 + sum(U > cumsum(p));
    y(j)=i;
  end
  
  
  
end