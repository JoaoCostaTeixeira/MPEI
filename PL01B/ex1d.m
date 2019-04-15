%% Exercicio 1.d

N= 1e5;
p=0.5;
n=2;

s = rand(n,N) > p;

sucessos2 = sum(s) == 2;
s(:,2) = [];
suc=sum(s) == 1;
probsimu = sum(sucessos)/sum(suc)
