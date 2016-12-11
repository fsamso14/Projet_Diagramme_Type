package dev.projetArchiLog.langage;

import java.awt.Graphics2D;

import org.apache.batik.svggen.SVGGraphics2D;
import dev.projetArchiLog.visiteur.IVisiteur;

public class Implementation extends Liaison{	
	public Classe from;
	public Interface to;
	int x;
	int y;
	public Implementation(Classe from,Interface to){
		this.from=from;
		this.to=to;
		x=from.getX1();
		y=from.getY1();
	}
	public void accepter(IVisiteur visiteur) {
		visiteur.visiter(this);
	}

}
