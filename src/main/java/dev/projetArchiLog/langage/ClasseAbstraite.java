package dev.projetArchiLog.langage;

import java.awt.Graphics2D;

import org.apache.batik.svggen.SVGGraphics2D;

public class ClasseAbstraite extends Classe{
	public ClasseAbstraite(Class<?> c){
		this.c=c;
	}

	public Graphics2D representation(SVGGraphics2D svgGenerator, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
