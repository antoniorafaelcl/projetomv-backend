create or replace package reajustePrecoProduto as 
  procedure  reajustarPrecoPorCategoria(categoria varchar2, preco number);
  procedure  reajustarPrecoPorRangePercentual(percentualInicial number, percentualFim number, preco number);
end;


create or replace package body reajustePrecoProduto as
  procedure reajustarPrecoPorCategoria(categoria varchar2, preco number) is 
  begin
    update MV.PRODUTO p
       set p.PRECO_PRODUTO=preco
     where p.CD_CATEGORIA = (SELECT c.CD_CATEGORIA FROM CATEGORIA c WHERE c.DS_CATEGORIA = categoria);
  END reajustarPrecoPorCategoria;
  
  PROCEDURE reajustarPrecoPorRangePercentual(percentualInicial number, percentualFim number, preco number) as 
  begin
   update MV.PRODUTO p
       set p.PRECO_PRODUTO=preco
     where CD_CATEGORIA IN (SELECT c.CD_CATEGORIA FROM CATEGORIA c WHERE c.NR_PERCENTUAL between percentualInicial and percentualFim);
  END reajustarPrecoPorRangePercentual;
END;

