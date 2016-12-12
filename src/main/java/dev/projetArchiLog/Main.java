package dev.projetArchiLog;

import dev.projetArchiLog.langage.Classe;
import dev.projetArchiLog.langage.Diagramme;
import dev.projetArchiLog.langage.Heritage;
import dev.projetArchiLog.langage.IDiagramme;
import dev.projetArchiLog.langage.Liaison;
import dev.projetArchiLog.visiteur.VisiterSVG;

public class Main {
	public static void main(String[] args) {
		IDiagramme d = Diagramme.creerDiagramme();
		VisiterSVG visiteur = new VisiterSVG();
	try {
		// L'utilisateur note les classes qu'il désire visualiser dans son diagramme de types
		// Le string en param correspond au nom excate de la classe dans le projet
		Class c1=Class.forName("dev.projetArchiLog.langage.ClasseClassique");
		Class c2 = Class.forName("dev.projetArchiLog.langage.Classe");
		Class c3 = Class.forName("dev.projetArchiLog.langage.ClasseAbstraite");
		Class c4 = Class.forName("dev.projetArchiLog.langage.TypeEnumere");
		Class c5 = Class.forName("dev.projetArchiLog.langage.Interface");
		Class c6 = Class.forName("dev.projetArchiLog.visiteur.IVisitable");
		
		// Ici l'utilisateur dispose les classes voulues dans l'espace,
		// Les 2 entiers en param représentent respectivement l'abscisse et l'ordonnée
		// L'origine du plan d'affichage est en haut à gauche de la fenêtre
		// Charge à l'utilisateur de les disposer au mieux
		Classe d1 = Classe.classeFactory(c1,10,10);
		Classe d2 = Classe.classeFactory(c2,500,30);
		Classe d3 = Classe.classeFactory(c3,1000,50);
		Classe d4 = Classe.classeFactory(c4,300,20);
		Classe d5 = Classe.classeFactory(c5, 1000, 540);
		Classe d6= Classe.classeFactory(c6,1000, 250);
		
		// On ajoute les classes crées au diagramme
		// Les Liaisons sont créées automatiquement
		d = d.add(d1);
		d = d.add(d2);
		d = d.add(d3);
		d = d.add(d4);
		d = d.add(d5);
		d = d.add(d6);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	d.accepter(visiteur);
	}
}
