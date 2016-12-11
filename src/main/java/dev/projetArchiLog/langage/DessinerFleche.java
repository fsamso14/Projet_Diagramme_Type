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



public class DessinerFleche {
	
	
	 /**
	   * Draws an arrow on the given Graphics2D context
	   * @param g The Graphics2D context to draw on
	   * @param x The x location of the "tail" of the arrow
	   * @param y The y location of the "tail" of the arrow
	   * @param xx The x location of the "head" of the arrow
	   * @param yy The y location of the "head" of the arrow
	   */
	  public static void drawArrow( SVGGraphics2D  g, int x, int y, int xx, int yy )
	  {
	    float arrowWidth = 10.0f ;
	    float theta = 0.7f ;
	    int[] xPoints = new int[ 3 ] ;
	    int[] yPoints = new int[ 3 ] ;
	    float[] vecLine = new float[ 2 ] ;
	    float[] vecLeft = new float[ 2 ] ;
	    float fLength;
	    float th;
	    float ta;
	    float baseX, baseY ;

	    xPoints[ 0 ] = xx ;
	    yPoints[ 0 ] = yy ;

	    // build the line vector
	    vecLine[ 0 ] = (float)xPoints[ 0 ] - x ;
	    vecLine[ 1 ] = (float)yPoints[ 0 ] - y ;

	    // build the arrow base vector - normal to the line
	    vecLeft[ 0 ] = -vecLine[ 1 ] ;
	    vecLeft[ 1 ] = vecLine[ 0 ] ;

	    // setup length parameters
	    fLength = (float)Math.sqrt( vecLine[0] * vecLine[0] + vecLine[1] * vecLine[1] ) ;
	    th = arrowWidth / ( 2.0f * fLength ) ;
	    ta = arrowWidth / ( 2.0f * ( (float)Math.tan( theta ) / 2.0f ) * fLength ) ;

	    // find the base of the arrow
	    baseX = ( (float)xPoints[ 0 ] - ta * vecLine[0]);
	    baseY = ( (float)yPoints[ 0 ] - ta * vecLine[1]);

	    // build the points on the sides of the arrow
	    xPoints[ 1 ] = (int)( baseX + th * vecLeft[0] );
	    yPoints[ 1 ] = (int)( baseY + th * vecLeft[1] );
	    xPoints[ 2 ] = (int)( baseX - th * vecLeft[0] );
	    yPoints[ 2 ] = (int)( baseY - th * vecLeft[1] );

	    g.drawLine( x, y, (int)baseX, (int)baseY ) ;
	    g.fillPolygon( xPoints, yPoints, 3 ) ;
	  }
	  
	/*  public static void main(String[] args) throws UnsupportedEncodingException, SVGGraphics2DIOException {
		  // Get a DOMImplementation.
		    DOMImplementation domImpl =
		      GenericDOMImplementation.getDOMImplementation();

		    // Create an instance of org.w3c.dom.Document.
		    String svgNS = "http://www.w3.org/2001/svg";
		    Document document = domImpl.createDocument(svgNS, "svg", null);

		    // Create an instance of the SVG Generator.
		    SVGGraphics2D svgGenerator = new SVGGraphics2D(document);

		    // Ask the test to render into the SVG Graphics2D implementation.
		    TestSVGGen test = new TestSVGGen();
		    drawArrow1( svgGenerator, 20, 40, 1000 ,10 );

		    // Finally, stream out SVG to the standard output using
		    // UTF-8 encoding.
		    boolean useCSS = true; // we want to use CSS style attributes
		    Writer out = new OutputStreamWriter(System.out, "UTF-8");
		    svgGenerator.stream(out, useCSS);
	}*/
}
