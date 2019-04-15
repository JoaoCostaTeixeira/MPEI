%%ex3a

p=0.5;
n=4;

 prob0 = factorial(n)/(factorial(n-0)*factorial(0))*p^k*(1-p)^(n-0)
 prob1 = factorial(n)/(factorial(n-1)*factorial(1))*p^k*(1-p)^(n-1)
 prob2 = factorial(n)/(factorial(n-2)*factorial(2))*p^k*(1-p)^(n-2)
 prob3 = factorial(n)/(factorial(n-3)*factorial(3))*p^k*(1-p)^(n-3)
 prob4 = factorial(n)/(factorial(n-4)*factorial(4))*p^k*(1-p)^(n-4)
 
%%ex3b

valoresperado=(0+1+2+3+4)/5

var=0;

for k=0:4
  var = var + (k - valoresperado)^2;
end
var