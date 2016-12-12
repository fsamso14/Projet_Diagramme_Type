package dev.projetArchiLog;

import dev.projetArchiLog.langage.Classe;
import dev.projetArchiLog.langage.Diagramme;
import dev.projetArchiLog.langage.Heritage;
import dev.projetArchiLog.langage.IDiagramme;
import dev.projetArchiLog.langage.Liaison;
import dev.projetArchiLog.visiteur.VisiterSVG;

public class Test {
	public static void main(String[] args) {
		IDiagramme d = Diagramme.creerDiagramme();
		VisiterSVG visiteur = new VisiterSVG();
	try {
		Class c1=Class.forName("dev.projetArchiLog.langage.ClasseClassique");
		Class c2 = Class.forName("dev.projetArchiLog.langage.Classe");
		Class c3 = Class.forName("dev.projetArchiLog.langage.ClasseAbstraite");
		Class c4 = Class.forName("dev.projetArchiLog.langage.TypeEnumere");
		Class c5 = Class.forName("dev.projetArchiLog.langage.Interface");
		Class c6 = Class.forName("dev.projetArchiLog.visiteur.IVisitable");
		Classe d1 = Classe.classeFactory(c1,10,10);
		Classe d2 = Classe.classeFactory(c2,500,30);
		Classe d3 = Classe.classeFactory(c3,1000,50);
		Classe d4 = Classe.classeFactory(c4,300,20);
		Classe d5 = Classe.classeFactory(c5, 300, 540);
		Classe d6= Classe.classeFactory(c6,1000, 300);
		d = d.add(d1);
		d = d.add(d2);
		d = d.add(d3);
		d = d.add(d4);
		d = d.add(d6);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	d.accepter(visiteur);
	}
}
