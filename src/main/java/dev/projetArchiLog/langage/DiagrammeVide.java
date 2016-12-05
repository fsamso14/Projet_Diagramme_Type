package dev.projetArchiLog.langage;

import java.awt.Graphics2D;

import org.apache.batik.svggen.SVGGraphics2D;

public class DiagrammeVide extends Diagramme{
	private final static DiagrammeVide instance = new DiagrammeVide(); 
	public final static DiagrammeVide getInstance(){
		return instance; 
	}
	private DiagrammeVide(){}
	public Graphics2D representation(SVGGraphics2D svgGenerator, int x, int y){
		return svgGenerator;
	}
}
