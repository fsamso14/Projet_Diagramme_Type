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
		  int size = this.getName().length();
		    g2d.drawString(this.getName(), x+10, y+20);
		    int i=0;
		    for(String attri : this.getAttributs()){
		    	if(size < attri.length()){
		    		size = attri.length();
		    	}
		    	i++;
		    	g2d.drawString(attri, x+10, y+(i+1)*20);
		    }
		    int j=i;
		    for(String meth : this.getMethodes()){
		    	if(size < meth.length()){
		    		size = meth.length();
		    	}
		    	i++;
		    	g2d.drawString(meth, x+10, y+(i+1)*20);
		    }
		    g2d.drawLine(x, y+25, x+5*size+20, y+25);
		    g2d.drawLine(x, y+(j+1)*20+5, x+5*size+20, y+(j+1)*20+5);
		    g2d.setPaint(Color.green);
		    g2d.draw(new Rectangle(x,y,x+5*size+10,y+(i+1)*20+5));
		    
		return g2d;
	}

}
