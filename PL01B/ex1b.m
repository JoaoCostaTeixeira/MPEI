%%Definiçao frequentista

N= 1e5; 
p = 0.5; 
k = 1; 
n = 2; 
filhos = rand(n,N) > p;
sucessos= sum(filhos)>=k;
probSimulacao= sum(sucessos)/N

%%teoria classica

p = 0.5;
n = 2;
prob = 0;

for k=1:2
  prob = prob + factorial(n)/(factorial(n-k)*factorial(k))*p^k*(1-p)^(n-k);
end
  prob


%% Os valores são iguais quando arredondados as centesimas prob = 0.75  