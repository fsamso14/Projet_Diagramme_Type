package dev.projetArchiLog.langage;

import dev.projetArchiLog.visiteur.IVisitable;

public interface IDiagramme extends IVisitable{
	IDiagramme add ( Classe c);
	
}
