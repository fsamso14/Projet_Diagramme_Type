package dev.projetArchiLog.visiteur;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.apache.batik.svggen.SVGGraphics2D;

import dev.projetArchiLog.langage.ClasseAbstraite;
import dev.projetArchiLog.langage.ClasseClassique;
import dev.projetArchiLog.langage.Delegation;
import dev.projetArchiLog.langage.Diagramme;
import dev.projetArchiLog.langage.Heritage;
import dev.projetArchiLog.langage.Implementation;
import dev.projetArchiLog.langage.Interface;
import dev.projetArchiLog.langage.Liaison;
import dev.projetArchiLog.langage.TypeEnumere;

public class VisiterSVG implements IVisiteur{
	
	private Graphics2D elt;
	public static SVGGraphics2D svgGenerator;
	
	// constructor
	public VisiterSVG(Graphics2D elt){ 
		this.elt = elt ; 
	}

	public void visiter(IVisitable o) {
		// TODO Auto-generated method stub
		
	}
	
	public void visiter(ClasseClassique o) {
		
		Class<?> c = o.getClasse();
		  svgGenerator.setPaint(Color.black);
		  int size = o.getName().length();
		    svgGenerator.drawString(o.getName(), o.getX1()+10, o.getY1()+20);
		    int i=0;
		    for(String attri : o.getAttributs()){
		    	if(size < attri.length()){
		    		size = attri.length();
		    	}
		    	i++;
		    	svgGenerator.drawString(attri, o.getX1()+10, o.getY1()+(i+1)*20);
		    }
		    int j=i;
		    for(String meth : o.getMethodes()){
		    	if(size < meth.length()){
		    		size = meth.length();
		    	}
		    	i++;
		    	svgGenerator.drawString(meth, o.getX1()+10, o.getY1()+(i+1)*20);
		    }
		    svgGenerator.draw(new Rectangle(o.getX1(),o.getY1(),o.getX1()+5*size+10,o.getY1()+(i+1)*20+5));
		    svgGenerator.drawLine(o.getX1(), o.getY1()+25, o.getX1()+5*size+20, o.getY1()+25);
		    svgGenerator.drawLine(o.getX1(), o.getY1()+(j+1)*20+5, o.getX1()+5*size+20, o.getY1()+(j+1)*20+5);
		    this.elt=svgGenerator;
		
	}

	public void visiter(ClasseAbstraite o) {
		// TODO Auto-generated method stub
		
	}

	public void visiter(TypeEnumere o) {
		// TODO Auto-generated method stub
		
	}

	public void visiter(Diagramme o) {
		// TODO Auto-generated method stub
		
	}

	public void visiter(Heritage o) {
		// TODO Auto-generated method stub
		
	}

	public void visiter(Interface o) {
		// TODO Auto-generated method stub
		
	}

	public void visiter(Delegation o) {
		// TODO Auto-generated method stub
		
	}

	public void visiter(Implementation o) {
		// TODO Auto-generated method stub
		
	}

	public void visiter(Liaison o) {
		// TODO Auto-generated method stub
		
	}
	
	

 

}
