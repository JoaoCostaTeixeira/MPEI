%% Adicionar ao bloom filter

function Y = add(arr, palavra, k)
    arr(mod(string2hash(palavra), size(arr,1)),1)=1;
    for j=1 : k-1
       palavra = [palavra num2str(j)];
       arr(mod(string2hash(palavra), size(arr,1)),1)=1;
     end;
     Y=arr;

end;

  