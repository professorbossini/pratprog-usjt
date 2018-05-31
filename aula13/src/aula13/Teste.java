package aula13;

public class Teste
{
   public static void main(String[] args)
   {
	   	Thread mainThread = Thread.currentThread();
	   	//
	    Relogio relogio1 = new Relogio();
	    Relogio relogio2 = new Relogio();
	   	Thread thread1 = new Thread(new Exibe(mainThread, relogio1));
	   	Thread thread2 = new Thread(new Exibe(mainThread, relogio2));
	   	//
	   	thread1.start();
	   	thread2.start();
	   	//
   }
}

class Exibe implements Runnable
{
	private Relogio relogio;
	private Thread main;
	public Exibe(Thread main, Relogio relogio)
	{
		this.main = main;
		this.relogio = relogio;
	}	
	@Override
	public void run()
	{
		try
		{
			main.join();
		}catch(InterruptedException e)
		{ 
				e.printStackTrace();
		}
		//i <= 1440 para minutos e 86340 para segundos
		for(int i = 0; i <= 86340; i++)
		{
			System.out.println(relogio.mostraSeg());
			if(relogio.getSegundo().equals("00"))
			{
				System.out.println(relogio.mostra());
				relogio.ticTac();
			}
			relogio.ticTacSeg();
		}
	}
}