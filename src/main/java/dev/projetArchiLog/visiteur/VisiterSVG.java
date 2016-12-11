package dev.projetArchiLog.visiteur;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import dev.projetArchiLog.langage.ClasseAbstraite;
import dev.projetArchiLog.langage.ClasseClassique;
import dev.projetArchiLog.langage.Delegation;
import dev.projetArchiLog.langage.Diagramme;
import dev.projetArchiLog.langage.DiagrammeVide;
import dev.projetArchiLog.langage.Heritage;
import dev.projetArchiLog.langage.Implementation;
import dev.projetArchiLog.langage.Interface;
import dev.projetArchiLog.langage.Liaison;
import dev.projetArchiLog.langage.TypeEnumere;

public class VisiterSVG implements IVisiteur{
	
	public static SVGGraphics2D svgGenerator;
	
	// constructor
	public VisiterSVG(){ 
		 // Get a DOMImplementation.
	    DOMImplementation domImpl =
	      GenericDOMImplementation.getDOMImplementation();

	    // Create an instance of org.w3c.dom.Document.
	    String svgNS = "http://www.w3.org/2000/svg";
	    Document document = domImpl.createDocument(svgNS, "svg", null);

	    // Create an instance of the SVG Generator.
	    svgGenerator = new SVGGraphics2D(document);
	}

	public void visiter(IVisitable o) {
		// TODO Auto-generated method stub
		
	}
	
	public void visiter(ClasseClassique o) {
		svgGenerator.setPaint(new Color(255,228,196));
	    svgGenerator.fill(new Rectangle(o.getX1(),o.getY1(),o.getX2()-o.getX1(),o.getY2()-o.getY1()));
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
		    svgGenerator.draw(new Rectangle(o.getX1(),o.getY1(),o.getX2()-o.getX1(),o.getY2()-o.getY1()));
		    svgGenerator.drawLine(o.getX1(), o.getY1()+25, o.getX1()+5*size+10, o.getY1()+25);
		    svgGenerator.drawLine(o.getX1(), o.getY1()+(j+1)*20+5, o.getX1()+5*size+10, o.getY1()+(j+1)*20+5);		
	}

	public void visiter(ClasseAbstraite o) {
		svgGenerator.setPaint(new Color(130,196,108));
	    svgGenerator.fill(new Rectangle(o.getX1(),o.getY1(),o.getX2()-o.getX1(),o.getY2()-o.getY1()));
		  svgGenerator.setPaint(Color.black);
		  int size = o.getName().length();
		    svgGenerator.drawString("<<Abstract>>  "+o.getName(), o.getX1()+10, o.getY1()+20);
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
		    svgGenerator.draw(new Rectangle(o.getX1(),o.getY1(),o.getX2()-o.getX1(),o.getY2()-o.getY1()));
		    svgGenerator.drawLine(o.getX1(), o.getY1()+25, o.getX1()+5*size+10, o.getY1()+25);
		    svgGenerator.drawLine(o.getX1(), o.getY1()+(j+1)*20+5, o.getX1()+5*size+10, o.getY1()+(j+1)*20+5);		
		
	}

	public void visiter(TypeEnumere o) {
		svgGenerator.setPaint(new Color(112,53,22));
	    svgGenerator.fill(new Rectangle(o.getX1(),o.getY1(),o.getX2()-o.getX1(),o.getY2()-o.getY1()));
		  svgGenerator.setPaint(Color.black);
		  int size = o.getName().length();
		    svgGenerator.drawString("<<Enum>>  "+o.getName(), o.getX1()+10, o.getY1()+20);
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
		    svgGenerator.draw(new Rectangle(o.getX1(),o.getY1(),o.getX2()-o.getX1(),o.getY2()-o.getY1()));
		    svgGenerator.drawLine(o.getX1(), o.getY1()+25, o.getX1()+5*size+10, o.getY1()+25);
		    svgGenerator.drawLine(o.getX1(), o.getY1()+(j+1)*20+5, o.getX1()+5*size+10, o.getY1()+(j+1)*20+5);		
		
		
	}
	public void visiter(DiagrammeVide o){
		for(Liaison l : Diagramme.liaisons){
			l.accepter(this);
		}
		boolean useCSS = true; // we want to use CSS style attributes
	    Writer out;
		try {
			out = new OutputStreamWriter(System.out, "UTF-8");
			try {
				svgGenerator.stream(out, useCSS);
			} catch (SVGGraphics2DIOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void visiter(Diagramme o) {
		o.checkLiaisons(o.getQueue(), o.getTete());
		o.getTete().accepter(this);
		//this.visiter(o.getTete());
		o.getQueue().accepter(this);
		//this.visiter(o.getQueue());
	}

	public void visiter(Heritage o) {
		// TODO Auto-generated method stub
		
	}

	public void visiter(Interface o) {
		svgGenerator.setPaint(new Color(38,196,236));
	    svgGenerator.fill(new Rectangle(o.getX1(),o.getY1(),o.getX2()-o.getX1(),o.getY2()-o.getY1()));
		  svgGenerator.setPaint(Color.black);
		  int size = o.getName().length();
		    svgGenerator.drawString("<<Abstract>>  "+o.getName(), o.getX1()+10, o.getY1()+20);
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
		    svgGenerator.draw(new Rectangle(o.getX1(),o.getY1(),o.getX2()-o.getX1(),o.getY2()-o.getY1()));
		    svgGenerator.drawLine(o.getX1(), o.getY1()+25, o.getX1()+5*size+10, o.getY1()+25);
		    svgGenerator.drawLine(o.getX1(), o.getY1()+(j+1)*20+5, o.getX1()+5*size+10, o.getY1()+(j+1)*20+5);		
		
		
	}

	public void visiter(Delegation o) {
		// TODO Auto-generated method stub
		
	}

	public void visiter(Implementation o) {
		// TODO Auto-generated method stub
		
	}
}
