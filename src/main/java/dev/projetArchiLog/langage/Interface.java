package dev.projetArchiLog.langage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.apache.batik.svggen.SVGGraphics2D;

public class Interface extends Classe{
	public Interface(Class<?> c){
		this.c=c;
	}
	public Graphics2D representation(SVGGraphics2D g2d, int x, int y) {
		return g2d;
		// TODO Auto-generated method stub
		
	}

}
