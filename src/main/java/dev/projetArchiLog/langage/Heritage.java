package dev.projetArchiLog.langage;

import java.awt.Color;
import java.awt.Graphics2D;

import org.apache.batik.svggen.SVGGraphics2D;

import dev.projetArchiLog.visiteur.IVisiteur;

public class Heritage extends Liaison{
	
	public Classe from;
	public Classe to;
	int x;
	int y;
	public Heritage(Classe from,Classe to){
		this.from=from;
		this.to=to;
		this.x=from.getX1();
		this.y=from.getY1();
	}
	
	public void accepter(IVisiteur visiteur) {
		visiteur.visiter(this);
	}

}
