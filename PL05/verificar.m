
%% Verificar 

function Y = verificar(arr, palavra, k)
  d = 1;
  for j=0 : k-1
    if(j!=0)
        palavra = [palavra num2str(j)];
    end;
      if(arr(mod(string2hash(palavra), size(arr,1)),1)==0) 
          d=0;
      end
  end;
    Y=d;
end;