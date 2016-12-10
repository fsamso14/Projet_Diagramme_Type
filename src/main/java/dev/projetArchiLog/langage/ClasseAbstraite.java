package dev.projetArchiLog.langage;

import java.awt.Graphics2D;

import org.apache.batik.svggen.SVGGraphics2D;

import dev.projetArchiLog.visiteur.IVisiteur;

public class ClasseAbstraite extends Classe{
	public ClasseAbstraite(Class<?> c){
		this.c=c;
	}

	public void accepter(IVisiteur visiteur) {
		visiteur.visiter(this);
	}

}
