package dev.projetArchiLog.langage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.apache.batik.svggen.SVGGraphics2D;

import dev.projetArchiLog.visiteur.IVisiteur;

public class Interface extends Classe{
	public Interface(Class<?> c){
		this.c=c;
	}	
	public void accepter(IVisiteur visiteur) {
		visiteur.visiter(this);	
	}

}
