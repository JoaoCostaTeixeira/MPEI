%% Exercicio 3 a) adicionar ao bloom filter

k=3; %% numero de funçoes de dispersao 
t=8000;  %% tamanho do bloom filter

bloom = dados(t);

for i=1 : 1000
  bloom = add(bloom, palavraAleatoria(40), k);
end;

%% b)

for j=1 : 1000
  verificar(bloom, palavraAleatoria(40),k)
end;
