package dev.projetArchiLog.langage;

public class DiagrammeVide extends Diagramme{
	private final static DiagrammeVide instance = new DiagrammeVide(); 
	public final static DiagrammeVide getInstance(){
		return instance; 
	}
	private DiagrammeVide(){}

}
