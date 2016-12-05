package dev.projetArchiLog.langage;

import java.awt.Color;
import java.awt.Graphics2D;

import org.apache.batik.svggen.SVGGraphics2D;

public class Heritage extends Liaison{
	
	public Classe from;
	public Classe to;
	int x;
	int y;
	public Heritage(Classe from,Classe to){
		this.from=from;
		this.to=to;
		x=from.getX1();
		y=from.getY1();
	}
	
	public Graphics2D representation(SVGGraphics2D g2d, int x, int y) {
		g2d.setPaint(Color.black);
		
		int X = to.getX1()+(to.getX2()-to.getX1())/2;
		int Y = to.getY1()+(to.getY2()-to.getY1())/2;
		if(X-x>=0){
			if(Y-y>=0){
				//relier à x1,y1
				g2d.drawLine(x, y, to.getX1(), to.getY1());
				
			}
			else{
				// relier à x1,y2
				g2d.drawLine(x, y, to.getX1(),to.getY2());
			}
		}
		else{
			if(Y-y>=0){
				//relier à x2,y1
				g2d.drawLine(x,y, to.getX2(), to.getY1());
			}
			else{
				// relier à x2,y2
				g2d.drawLine(x, y,to.getX2(), to.getY2());
			}
		}
		return null;
	}



	}
