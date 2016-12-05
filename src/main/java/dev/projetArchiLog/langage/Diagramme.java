package dev.projetArchiLog.langage;

import java.awt.Graphics2D;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

public class Diagramme implements Modele {
	public Classe tete;
	public Diagramme queue;
	public static SVGGraphics2D svgGenerator;
	
	private Diagramme(Diagramme queue, Classe tete){
		this.tete=tete;
		this.queue=queue;
	}
	public static Diagramme creerDiagramme(){
		
	}
	public Diagramme add (String classPath){
		try {
			return new Diagramme(this,Classe.classeFactory(Class.forName(classPath)));
		} catch (ClassNotFoundException e) {
			System.out.println("Classe non trouvée : "+classPath);
			e.printStackTrace();
			return null;
		}
	}
	
	public void init(){
		 // Get a DOMImplementation.
	    DOMImplementation domImpl =
	      GenericDOMImplementation.getDOMImplementation();

	    // Create an instance of org.w3c.dom.Document.
	    String svgNS = "http://www.w3.org/2000/svg";
	    Document document = domImpl.createDocument(svgNS, "svg", null);

	    // Create an instance of the SVG Generator.
	    svgGenerator = new SVGGraphics2D(document);
	    		
	}
	public void draw(){
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
	public Graphics2D representation(SVGGraphics2D svgGenerator, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
