package dev.projetArchiLog.langage;

import java.awt.Graphics2D;

import org.apache.batik.svggen.SVGGraphics2D;

import dev.projetArchiLog.visiteur.IVisitable;
import dev.projetArchiLog.visiteur.IVisiteur;

public class DiagrammeVide implements IVisitable, IDiagramme{
	private final static DiagrammeVide instance = new DiagrammeVide(); 
	public final static DiagrammeVide getInstance(){
		return instance; 
	}
	private DiagrammeVide(){}
	public void accepter(IVisiteur visiteur) {
		visiteur.visiter(this);
		
	}
	public IDiagramme add(Classe c) {
		IDiagramme d = Diagramme.creerDiagramme(this,c);
		return ((Diagramme)d.add(c));
	}
}
