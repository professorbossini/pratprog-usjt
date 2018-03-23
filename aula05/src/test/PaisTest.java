package test;

import service.PaisService;
import model.Pais;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest
{
   Pais pais, copia;
   PaisService service = new PaisService();
   static int id = 10;
   
   @Before
   public void setUp() throws Exception
   {
      System.out.println("setUp");
      pais = new Pais(id, "Brasil", 19070000, 8.51);
      copia = new Pais(id, "Brasil", 19070000, 8.51);
		System.out.println(pais);
		System.out.println(copia);
   }
   @Test
   public void testSelect()
   {
      System.out.println("select");
      Pais esperado = new Pais(1, "Rússia", 140300000, 17.07);
      Pais obtido = service.carregar(1);
      assertEquals("test select", obtido, esperado);
   }
   @Test
   public void testInsert()
   {
      System.out.println("insert");
      service.inserir(pais);
      assertEquals("test insert", pais, copia);
   }
   @Test
   public void testUpdate()
   {
      System.out.println("update");
      Pais teste = new Pais(10, "Japao",19070000, 8.51);
      pais.setNome("Japao");
      service.atualizar(pais);
      assertEquals("test update", pais, teste);
   }
   @Test
   public void testDelete()
   {
      System.out.println("delete");
      copia.setId(-1);
      copia.setNome(null);
      copia.setPopulacao(-1);
      copia.setArea(-1);
      service.excluir(id);
      pais = service.carregar(id);
      assertEquals("test delete", pais, copia);
   }
   @Test
   public void testMaiorPopulacao()
   {
      System.out.println("maior populacao");
      Pais maiorP = new Pais(3, "China", 1300000000, 9.59);
      Pais obtido = service.maiorPopulacao();
      assertEquals("test maiorPopulacao", maiorP, obtido);
   }
   @Test
   public void testMenorArea()
   {
      System.out.println("menor area");
      Pais maiorP = new Pais(7, "Argentina", 40600000, 2.27);
      Pais obtido = service.menorArea();
      assertEquals("test menorArea", maiorP, obtido);
   }
   @Test
   public void testVetorTresPaises()
   {
      System.out.println("vetor tres paises");
      String[] vetor = service.vetorTresPaises();
      assertEquals("test vetorTresPaises", 3, vetor.length);
   }
}