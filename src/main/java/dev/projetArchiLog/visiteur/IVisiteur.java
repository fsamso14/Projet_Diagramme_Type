package dev.projetArchiLog.visiteur;
import dev.projetArchiLog.langage.*;

public interface IVisiteur {
	
	void visiter(IVisitable o);
	void visiter(ClasseClassique o);
	void visiter(ClasseAbstraite o);
	void visiter(TypeEnumere o);
	void visiter(Diagramme o);
	void visiter(Heritage o);
	void visiter(Interface o);
	void visiter(Delegation o);
	void visiter(Implementation o);
	void visiter(Liaison o);
	
}
