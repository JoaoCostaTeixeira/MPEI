%% Exercicio 1

function saida = ex1();
      comprimento = ceil(rand()*17 + 3);
      str = ['A':'Z' 'a':'z'];
      a = ceil(rand(1, comprimento)*(length(str)-1)+1);
      saida = str(a);
end
 