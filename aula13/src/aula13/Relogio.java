package aula13;

public class Relogio
{
   public Mostrador hora, minuto, minutoSeg, horaSeg, segundo;
   public String mostrador, mostradorSeg;
   
   public Relogio()
   {
      hora = new Mostrador(24);
      minuto = new Mostrador(60);
      horaSeg = new Mostrador(24);
      minutoSeg = new Mostrador(60);
      segundo = new Mostrador(60);
      atualizaMostrador();
      atualizaMostradorSeg();
   }
   public void ticTac()
   {
	  minuto.incrementa();
      if(minuto.getValor()==0)
      {
         hora.incrementa();
      }
      atualizaMostrador();
   } 
    public void ticTacSeg()
   {
      segundo.incrementa();
      if(segundo.getValor()==0)
      {
    	  minutoSeg.incrementa();
         if(minutoSeg.getValor() == 0)
         {
        	 horaSeg.incrementa();
         }
      }
      atualizaMostradorSeg();
   } 
   private void atualizaMostrador()
   {
      mostrador = hora.mostra()+":"+minuto.mostra();
   }
   private void atualizaMostradorSeg()
   {
   		mostradorSeg = horaSeg.mostra()+":"+minutoSeg.mostra()+":"+segundo.mostra();
   }
   public String mostra()
   {
      return mostrador;
   }  
   public String mostraSeg()
   {
   	return mostradorSeg;
   }
   public String getSegundo()
   {
	   return segundo.mostra();
   }
}