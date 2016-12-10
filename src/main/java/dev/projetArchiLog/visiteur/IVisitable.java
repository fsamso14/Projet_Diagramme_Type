package dev.projetArchiLog.visiteur;

import java.awt.Graphics2D;

import org.apache.batik.svggen.SVGGraphics2D;

import dev.projetArchiLog.visiteur.*;

public interface IVisitable {
	
	public void accepter(IVisiteur visiteur);
	
}
