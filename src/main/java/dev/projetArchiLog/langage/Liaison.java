package dev.projetArchiLog.langage;

public abstract class Liaison implements Modele{
	Classe to;
	Classe from;
	
	Classe getTo(){
		return to;
	}
	Classe getFrom(){
		return from;
	}
}
