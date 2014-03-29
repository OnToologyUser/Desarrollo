
import javax.swing.JOptionPane;

/**
 * 
 * @author JESUS
 * @category Aplicaciones y juegos
 * @version 2.0
 *
 */
class Ahorcado{

  public static void main (String args[]){
    
	  Ahorcado av = new Ahorcado ();
    
    
    String pista;
    String strPal;
    int fallos;
    fallos = 0;
    String intentos;
    
    JOptionPane.showMessageDialog(null, "EL EMOCIONANTE JUEGO DEL AHORCADO \n" +
    		"\n" + 
    		"Deberas indicar el numero de intentos que deseas para resolver la palabra. Dichos intentos hay que realizarlos obligatoriamente" + "\n" +  
    		"Dime una palabra, a ver si otro la adivina. Escribe en minusculas." + "\n", "El Juego del Ahorcado", 0);
   
   
    strPal = JOptionPane.showInputDialog( "Palabra a acertar" );
    char[] arrayPalabra = strPal.toCharArray(); //Transformacion de "palabra" en array de caracteres
    
   
    char[] arrayPalabraF = strPal.toCharArray(); // Creamos un array de asteriscos que sera lo que se muestre.
    for (int n = 0; n < arrayPalabraF.length; n++)
    {
      arrayPalabraF[n] = '*';
    }
   
    pista = JOptionPane.showInputDialog( "Introduce una Pista para la palabra que has elegido. Puede ser una palabra o una frase");
    
 //---------------------------------------------------------------------------------------------------------- 
    JOptionPane.showMessageDialog(null, "Te informo de que la palabra tiene " + strPal.length() + " letras", "El juego del Ahorcado", 0);
    JOptionPane.showMessageDialog(null, " Ahora introduce el numero de intentos que quieres tener. \n " 
    		+ "INFORMACION: Si fallas 7 veces, perderas", "El juego del Ahorcado", 0);
    intentos = JOptionPane.showInputDialog("Intentos");
    int numIntentos = Integer.parseInt(intentos); // Convierte el String intentos en un entero
    JOptionPane.showConfirmDialog(null, "¿ COMENZAMOS ?", "Estas a punto de empezar...", 0);
   
//IDENTIFICAR LETRAS-------------------------------------------------------------------------------------------------
    av.hayLetra(numIntentos, fallos, arrayPalabra, arrayPalabraF, av, pista);

//EVALUACION---------------------------------------------------------------------------------------------------------
    av.evaluacion(fallos, numIntentos, pista, arrayPalabraF, av, strPal);
  
  }
  
  
  
  
  // METODOS DE CLASE

  /**
   * 
   * @param array - La palabra introducida convertida en array de caracteres
   * @return Visualiza el array de caracteres
   */
  public String mostrar(char [] array) {
	  String result = "";
	  for (int i = 0; i < array.length; i++) {
		  result = result + array[i];
	  }
	  return result;
	  }
  /**
   * 
   * @param numIntentos - Numero de intentos permitidos
   * @param fallos - Numero de fallos actuales
   * @param arrayPalabra - La palabra introducida convertida en array de caracteres
   * @param arrayPalabraF - Array con la palabra en forma de caracteres
   * @param av - Objeto Ahorcado
   * @param pista - La pista introducida para la palabra
   */
  public void hayLetra (int numIntentos, int fallos, char [] arrayPalabra, char [] arrayPalabraF, Ahorcado av, String pista) {
	  for (int i = 0; i < numIntentos && fallos < 7; i++)
	    {

	      String letra1 = JOptionPane.showInputDialog("Dime una letra \n" + "La pista era: " + pista);
	      char letra = letra1.charAt (0);
	    
	      boolean resultado = false;
	      for (int e= 0; e < arrayPalabra.length; e++)
	      {
	        if (arrayPalabra[e] == letra)
	        {
	          resultado = true;
	          arrayPalabraF[e] = letra;
	        }
	      }
	    

	      if (resultado == true)
	      {     
	        JOptionPane.showMessageDialog(null, "Tu letra esta en la palabra,  has cometido " + fallos + " fallos" 
	        		+ "\n" + "Estado actual de la palabra: " + av.mostrar(arrayPalabraF) ,"El juego del Ahorcado", 0);
	      }
	      if (resultado == false)
	      {
	        fallos = fallos + 1;
	        JOptionPane.showMessageDialog(null, "Tu letra no esta en la palabra, perdiste una oportunidad y has cometido " + fallos + " fallos" 
	        		+ "\n" + "Estado actual de la palabra: " + av.mostrar(arrayPalabraF) ,"El juego del Ahorcado", 0);
	        
	      }
	      
	      
	      if (resultado == false && fallos == 7)
	      {
	    	  JOptionPane.showMessageDialog(null, "Has cometido siete errores. Has perdido ", "El juego del Ahorcado", 0);
	      }
	    }
  }
  
  /**
   * 
   * @param fallos - Numero de fallos actuales
   * @param numIntentos - Numero de intentos permitidos
   * @param pista - Pista de la palabra
   * @param arrayPalabraF - Array con la palabra en forma de caracteres
   * @param av - Objeto Ahorcado
   * @param strPal - Palabra introducida
   */
  public void evaluacion (int fallos, int numIntentos, String pista, char [] arrayPalabraF, Ahorcado av, String strPal) {
	  if (fallos < 7)
	    {   
	      JOptionPane.showMessageDialog(null, " Ya has dicho " + numIntentos + " letras. No puedes decir mas. Ahora debes resolver la palabra."
	    		  + "\n" + "La pista era: " + pista
	    		  + "\n" + "Estado actual de la palabra: " + av.mostrar(arrayPalabraF)
	    		  + "\n" + "¿Que palabra es?", "El juego del Ahorcado", 0);
	      
	      String strPal2;
	      strPal2 = JOptionPane.showInputDialog( "¿Que palabra crees que es?" );    
	  
	      
	      if (strPal.equals(strPal2))
	        JOptionPane.showMessageDialog(null, "¡HAS GANADO!");
	      else
	        JOptionPane.showMessageDialog(null, "¡ESA NO ERA LA PALABRA! HAS PERDIDO...");
	      

	    }
  }
  }



