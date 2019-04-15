%% Exercicio 3
l=1000/0.8;   %%tamanho do array
pos=zeros(1, l); %% araay com tamanho l

for i=0 : 1000
  a=ex1();
  b=string2hash(a);
  d=mod(b,l)+1;
  pos(d)=pos(d)+1;
end
hist(pos,0:10);

