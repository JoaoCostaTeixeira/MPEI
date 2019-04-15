 %%   EXERCICIO 1 TEST
  k=5;
  x=200;
  bloom = dados(x);
  
  %%ADICIONAR PALAVRAS AO BLOOM

  bloom=add(bloom, 'escola',x,k);
  bloom=add(bloom, 'UA',x,k);
  bloom=add(bloom,'MPEI', x,k);
  bloom=add(bloom,'TRINTA',x,k);
  
  %%VERIFICAR SE EXISTE
  
  verificar(bloom, 'ola',x,k)
  verificar(bloom, 'UA',x,k)
  verificar(bloom, 'MAE',x,k)
  verificar(bloom, 'MPEI',x,k)
  