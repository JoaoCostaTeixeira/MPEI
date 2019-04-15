

function Y = palavraAleatoria(tamanho)
   str = ['A':'Z' 'a':'z' '0':'9'];
   nums = randi(numel(str),[1 tamanho]);
   Y = str (nums);
end;