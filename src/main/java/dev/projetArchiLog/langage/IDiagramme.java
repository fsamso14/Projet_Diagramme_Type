package dev.projetArchiLog.langage;

import java.util.ArrayList;

import dev.projetArchiLog.visiteur.IVisitable;

public interface IDiagramme extends IVisitable{
	IDiagramme add ( Classe c);
	Classe getTete();
	IDiagramme getQueue();
	void checkLiaisons(IDiagramme diag, Classe nouvelle);
}
