package emparejador;
import javax.swing.JOptionPane;


public class EmparejadorM {
	/**
	 * El numero de participantes en el torneo
	 */
	private int numParticipantes;
	/**
	 * Un vector que contiene los nombres de todos los participantes del torneo
	 */
	private String [] arrayParticipantes;
	/**
	 * El numero de equipos del torneo
	 */
	private int numEquipos;
	/**
	 * Un vector que contiene los equipos del torneo
	 */
	private String [] arrayEquipos;
	
	
	
	
	/**
	 * 
	 * @return Crea el vector que contiene los nombres de todos los participantes del torneo, a partir del numero de Participantes
	 */
	public String [] crearArrayParticipantes () {
		String participantes = JOptionPane.showInputDialog("Introduce el numero de participantes del torneo");
		this.numParticipantes = Integer.parseInt(participantes);
		
		this.arrayParticipantes = new String [this.numParticipantes];
		for (int i = 0; i < this.numParticipantes; i++) {
			arrayParticipantes[i] = JOptionPane.showInputDialog(this,"Nombre del participante " + (i+1));
		}
		return this.arrayParticipantes;
	}
	
	/**
	 * 
	 * @param arrayParticipantes - El vector que contiene los nombres de todos los participantes
	 * @return Devuelve un String mostrando todos los participantes del torneo
	 */
	public String mostrarArrayParticipantes (String [] arrayParticipantes) {
		String resultado = "";
		for (int i = 0; i < arrayParticipantes.length;i++) {
			resultado = resultado + "Participante " + (i+1) + ": " + this.arrayParticipantes[i] + "\n";
		}
		return resultado;
	}

	/**
	 * @return Devuelve el vector de participantes
	 */
	public String[] getArrayParticipantes() {
		return arrayParticipantes;
	}
	
	/**
	 * 
	 * @return Devuelve un vector con enteros aleatorios entre 0 y el numero de participantes
	 */
	public  int [] posiciones() {
		
		//Proceso de Mezclado
		int posiciones [] = new int [arrayParticipantes.length];
		int i = 0, j;
		posiciones [i] = (int)(Math.random()*this.numParticipantes);
		for (i = 1; i < posiciones.length; i++) {
			posiciones [i] = (int)(Math.random()*this.numParticipantes);
			for (j =0; j < i; j++) {
				if(posiciones[i]==posiciones[j]) 
				{ 
					i--; 
				}
			}
		}
		return posiciones;
	}
	
	/**
	 * 
	 * @param arrayParticipantes - Un vector de Participantes del torneo
	 * @return Devuelve los equipos de participantes, formados aleatoriamente usando el vector de enteros de posiciones()
	 */
	public String [] mezclarParticipantes (String [] arrayParticipantes) {
		this.arrayEquipos = new String [arrayParticipantes.length /2];
		int [] posObtenidas = this.posiciones();
		int j = 0;
		for (int i = 0; i < this.arrayEquipos.length; i++) {
			this.arrayEquipos[i] = "Equipo " + (i+1) + ": " + this.arrayParticipantes[posObtenidas[j]] + " y " + this.arrayParticipantes[posObtenidas[j+1]];
				j=j+2;
		}
		this.numEquipos = arrayEquipos.length;
		return arrayEquipos;
	}
	
	/**
	 * 
	 * @param mezcladosYEmparejados - Un vector que contiene a los participantes en equipos formados de forma aleatoria
	 * @return Permite visualizar los equipos formados
	 */
	public String mostrarMezcladosYEmparejados (String [] mezcladosYEmparejados) {
		String resultado = "";
		for (int i = 0; i< arrayEquipos.length; i++) {
			resultado = resultado + arrayEquipos[i] + "\n";
		}
		return resultado;
	}
	
	
	/**
	 * @return Devuelve el array de equipos
	 */
	public String[] getArrayEquipos() {
		return arrayEquipos;
	}
	
	/**
	 * 
	 * @return Devuelve el array de posiciones aleatorias para los combates
	 */
	public  int [] posicionesCombate() {	
		//Proceso de Mezclado
		int posiciones [] = new int [this.numEquipos];
		int i = 0, j;
		posiciones [i] = (int)(Math.random()*this.numEquipos);
		for (i = 1; i < posiciones.length; i++) {
			posiciones [i] = (int)(Math.random()*this.numEquipos);
			for (j =0; j < i; j++) {
				if(posiciones[i]==posiciones[j]) 
				{ 
					i--; 
				}
			}
		}
		return posiciones;
	}
	
	
	/**
	 * 
	 * @param mezcladosYEmparejados - Array de participantes mezclados y emparejados
	 * @return Devuelve un array de Strings con los equipos emparejados
	 */
	public String [] mezclarEquipos (String [] mezcladosYEmparejados) {
		String [] equiposMezclados;
		if (this.numEquipos % 2 == 0) {
			equiposMezclados = new String [this.numEquipos/2];
			int [] posObtenidas = this.posicionesCombate();
			int j = 0;
			for (int i = 0; i < equiposMezclados.length; i++) {
				equiposMezclados[i] = "Combate " + (i+1) + ": " +arrayEquipos [posObtenidas[j]] + " VS " + arrayEquipos[posObtenidas[j+1]];
				j = j +2;
			}
		}
		else {
			equiposMezclados = new String [this.numEquipos/2 +1];
			int [] posObtenidas = this.posicionesCombate();
			int j = 0;
			for (int i = 0; i < equiposMezclados.length - 1; i++) {
				equiposMezclados[i] = "Combate " + (i+1) + " " +arrayEquipos [posObtenidas[j]] + "  VS  " + arrayEquipos[posObtenidas[j+1]];
				j = j +2;
				equiposMezclados[equiposMezclados.length-1] = "El " + arrayEquipos[posObtenidas[posObtenidas.length -1]] + " pasa a la siguiente ronda automaticamente";
			}
		}
		return equiposMezclados;
	}
	
	/**
	 * 
	 * @param equiposMezclados - Un array de Strings con los equipos emparejados
	 * @return Permite visualizar el array de equipos emparejados
	 */
	public String mostrarEquiposMezclados (String [] equiposMezclados) {
		String resultado = "";
		for (int i = 0; i< equiposMezclados.length; i++) {
			resultado = resultado + equiposMezclados[i] + "\n";
		}
		return resultado;
	}
}
