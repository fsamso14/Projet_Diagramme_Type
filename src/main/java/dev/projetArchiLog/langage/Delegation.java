package dev.projetArchiLog.langage;

import java.awt.Graphics2D;

import org.apache.batik.svggen.SVGGraphics2D;

import dev.projetArchiLog.visiteur.IVisiteur;

public class Delegation extends Liaison{
	public Classe from;
	public Classe to;
	int x;
	int y;
	
	public Delegation(Classe from,Classe to){
		this.from=from;
		this.to=to;
		x=from.getX1();
		y=from.getY1();
	}

	
	public void accepter(IVisiteur visiteur) {
		visiteur.visiter(this);
	}
	
}
