%% Exercicio 6




%% Binomial

n=8000;
p=1/1000;
k=7;

ProbB =  factorial(n)/(factorial(n-k)*factorial(k))*p^k*(1-p)^(n-k)


%% Poisson

l=8;

probP = ((l^k)/factorial(k))*exp(-l)