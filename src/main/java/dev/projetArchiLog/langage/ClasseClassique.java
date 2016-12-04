package dev.projetArchiLog.langage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.apache.batik.svggen.SVGGraphics2D;

public class ClasseClassique extends ClasseConcrete {
	public int j;
	public ClasseClassique(Class<?> c){
		this.c=c;
	}
	public Graphics2D representation(SVGGraphics2D g2d, int x,
			int y) {
		Class<?> c = this.getClasse();
		  g2d.setPaint(Color.black);
		    g2d.draw(new Rectangle(x,y,200,500));
		    g2d.drawString(this.getName(), x+10, y+20);
		    g2d.drawLine(x, y+25, x+200, y+25);
		    int i=0;
		    for(String attri : this.getAttributs()){
		    	i++;
		    	g2d.drawString(attri, x+10, y+i*20);
		    }
		    g2d.drawLine(x, y+(i+1)*20+5, x+200, y+(i+1)*20+5);
		    for(String meth : this.getMethodes()){
		    	i++;
		    	g2d.drawString(meth, x+10, y+(i+1)*20);
		    }
		// TODO Auto-generated method stub
		return g2d;
	}

}
