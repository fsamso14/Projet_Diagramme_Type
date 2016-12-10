package dev.projetArchiLog.langage;

import dev.projetArchiLog.visiteur.IVisitable;

public abstract class Liaison implements IVisitable{
	Classe to;
	
	Classe getTo(){
		return to;
	}
}
