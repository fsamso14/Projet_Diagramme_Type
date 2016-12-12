package dev.projetArchiLog.langage;

import java.awt.Graphics2D;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import dev.projetArchiLog.visiteur.IVisitable;
import dev.projetArchiLog.visiteur.IVisiteur;

public class Diagramme implements IVisitable,IDiagramme {
	public Classe tete;
	public IDiagramme queue;
	public static ArrayList<Liaison> liaisons;
	
	private Diagramme(IDiagramme queue, Classe tete){
		this.tete=tete;
		this.queue=queue;
	}
	public Diagramme(){
	}
	public static IDiagramme creerDiagramme(){
		liaisons = new ArrayList<Liaison>();
		return DiagrammeVide.getInstance();
	}
	public Diagramme add (Classe c) {
		return new Diagramme(this,c);
	}
	public static IDiagramme creerDiagramme(IDiagramme queue, Classe tete){
		return new Diagramme(queue,tete);
	}
	
	public Classe getTete() throws NullPointerException{
			return tete;
	}
	public void setTete(Classe tete) {
		this.tete = tete;
	}
	public IDiagramme getQueue() {
		return queue;
	}
	public void setQueue(IDiagramme queue) {
		this.queue = queue;
	}
	public void draw(){
		
	}
	public void accepter(IVisiteur visiteur) {
		visiteur.visiter(this);
		// TODO Auto-generated method stub	
	}
	public void checkLiaisons(IDiagramme idiag,Classe nouvelle){
		
		for(Class<?> c : nouvelle.getClasse().getInterfaces()){
			if(c==this.getTete().getClasse()){
				liaisons.add(Liaison.liaisonFactory(nouvelle, idiag.getTete()));
			}
		}
		if( nouvelle.getClasse().getSuperclass() == idiag.getTete().getClasse()){
			liaisons.add(Liaison.liaisonFactory(nouvelle,idiag.getTete()));
			//liaisons.add(Liaison.liaisonFactory(idiag.getTete(),nouvelle));
		}
		if(idiag.getTete().getClasse().getSuperclass() == nouvelle.getClasse()){
			liaisons.add(Liaison.liaisonFactory(idiag.getTete(),nouvelle));
		}
		for(Class<?> c : idiag.getTete().getClasse().getInterfaces()){
			if(c==nouvelle.getClasse()){
				liaisons.add(Liaison.liaisonFactory(idiag.getTete(),nouvelle));
			}
		}
		for(Field f : nouvelle.getClasse().getFields()){
			if(f.getType() == this.getTete().getClasse()){
				liaisons.add(Liaison.liaisonFactory(idiag.getTete(),nouvelle));
			}
		}
		for(Field f : idiag.getTete().getClasse().getFields()){
			if(f.getType() == nouvelle.getClasse()){
				liaisons.add(Liaison.liaisonFactory(nouvelle, idiag.getTete()));
			}
		}
		idiag.getQueue().checkLiaisons(idiag.getQueue(), nouvelle);
	}
}
