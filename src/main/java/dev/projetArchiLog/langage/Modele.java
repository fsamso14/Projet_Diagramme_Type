package dev.projetArchiLog.langage;

import java.awt.Graphics2D;

import org.apache.batik.svggen.SVGGraphics2D;

public interface Modele {
	public Graphics2D representation (SVGGraphics2D svgGenerator,int x, int y);
	
}
