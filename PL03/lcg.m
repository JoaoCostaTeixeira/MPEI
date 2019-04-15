%% EXercicio 1


function y = lcg(X0,a,c,m,N);
 y(1) = X0;
  for i = 2:N
    y(i) = mod((y(i-1)*a+c), m);
  end
end




