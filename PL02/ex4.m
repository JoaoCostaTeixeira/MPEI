%% Exercicio 4


p=0.3;
n=5;

prob0 = factorial(n)/(factorial(n-0)*factorial(0))*p^0*(1-p)^(n-0);
prob1 = factorial(n)/(factorial(n-1)*factorial(1))*p^1*(1-p)^(n-1);
prob2 = factorial(n)/(factorial(n-2)*factorial(2))*p^2*(1-p)^(n-2);
prob3 = factorial(n)/(factorial(n-3)*factorial(3))*p^3*(1-p)^(n-3);
prob4 = factorial(n)/(factorial(n-4)*factorial(4))*p^4*(1-p)^(n-4);
prob5 = factorial(n)/(factorial(n-5)*factorial(5))*p^5*(1-p)^(n-5);

P = [prob0 prob1 prob2 prob3 prob4 prob5]
h = histc(0:5, P);
 stem(h)