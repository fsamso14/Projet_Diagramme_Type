package dev.projetArchiLog.langage;

import dev.projetArchiLog.visiteur.IVisitable;

public abstract class Liaison implements IVisitable{
	Classe to;
	Classe from;
	
	Classe getTo(){
		return to;
	}
	Classe getFrom(){
		return from;
	}
}
