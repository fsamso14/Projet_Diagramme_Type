package dev.projetArchiLog.langage;

import java.awt.Graphics2D;

import org.apache.batik.svggen.SVGGraphics2D;

import dev.projetArchiLog.visiteur.IVisiteur;

public class Implémentation extends Liaison{

	
	public void accepter(IVisiteur visiteur) {
		visiteur.visiter(this);
	}

}
