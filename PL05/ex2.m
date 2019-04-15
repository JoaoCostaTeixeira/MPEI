%% EXERCICIO 2 

bloom = dados(300); %% tamanho do bloom filter
k=5;


%% adicionar paises

str =['portugal'; 'espanha'; 'inglaterra'; 'suiça'; 'fraça'; 'suecia'; 'belgica'];   

for i=1 : size(str)
  bloom=add(bloom, str(i),k);
end;

%%  verificar 

str2 = ['porugal'; 'russia'; 'espanha'; 'USA'] ;

for i=1 : size(str2)
  d=verificar(bloom, str2(i), k)
end;