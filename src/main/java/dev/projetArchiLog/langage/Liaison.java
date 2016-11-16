package dev.projetArchiLog.langage;

public abstract class Liaison {
	Classe from;
	Classe to;
	
	Classe getFrom() {
		return from;
	}
	Classe getTo(){
		return to;
	}
}
