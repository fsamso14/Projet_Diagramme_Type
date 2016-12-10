package dev.projetArchiLog;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;

import dev.projetArchiLog.langage.Classe;
import dev.projetArchiLog.langage.ClasseClassique;
import dev.projetArchiLog.langage.Heritage;

public class TestSVGGen {

  public void paint(Graphics2D g2d) {
    g2d.setPaint(Color.black);
   // g2d.fill(new Rectangle(10, 10, 100, 100));
    g2d.draw(new Rectangle(10,10,200,500));
    g2d.drawString("CLASSE 1", 50, 30);
  }

  public static void main(String[] args) throws IOException {

    // Get a DOMImplementation.
    DOMImplementation domImpl =
      GenericDOMImplementation.getDOMImplementation();

    // Create an instance of org.w3c.dom.Document.
    String svgNS = "http://www.w3.org/2000/svg";
    Document document = domImpl.createDocument(svgNS, "svg", null);

    // Create an instance of the SVG Generator.
    SVGGraphics2D svgGenerator = new SVGGraphics2D(document);

    // Ask the test to render into the SVG Graphics2D implementation.
    TestSVGGen test = new TestSVGGen();
    try {
	Class c=Class.forName("dev.projetArchiLog.langage.ClasseClassique");
	Classe s = Classe.classeFactory(c, 20, 20);
	Classe t = Classe.classeFactory(c, 500, 200);
	Heritage from = new Heritage(s,t);
	//s.representation(svgGenerator, s.getX1(),s.getY1());
	//from.representation(svgGenerator, s.getX1(), s.getY1());
	//t.representation(svgGenerator, t.getX1(),t.getY1());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	/*ArrayList<Class<?>> list=Interpretation.getListesClasse(Package.getPackages());
	ClasseClassique s = new ClasseClassique(list.get(3));
	s.representation(svgGenerator, 10, 10);*/

    // Finally, stream out SVG to the standard output using
    // UTF-8 encoding.
    boolean useCSS = true; // we want to use CSS style attributes
    Writer out = new OutputStreamWriter(System.out, "UTF-8");
    svgGenerator.stream(out, useCSS);
  }
}