package dev.projetArchiLog.langage;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Set;

import dev.projetArchiLog.visiteur.IVisitable;

public abstract class Classe implements IVisitable{
	Class<?> c;
	Set<Liaison> from;
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	public ArrayList<Liaison> liaisons;
	
	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public Class<?> getClasse(){
		return this.c;
	}
	
	public String getName(){
		String[] s=this.getClasse().getName().split("\\.");
		return s[s.length-1];
	}
	
	public String[] getAttributs(){
		Field[] f = this.getClasse().getFields();
		String[] aret = new String[f.length];
		for(int i = 0; i < f.length; i++){
			aret[i] = traitementNomAttr(f[i].toGenericString());
		}
		return aret;
	}
	
	public String[] getMethodes(){
		Method[] m = this.getClasse().getDeclaredMethods();
		String[] aret = new String[m.length];
		for(int i = 0; i < m.length; i++){
			aret[i] = traitementNomMeth(m[i].toString());
		}
		return aret;
	}
	
	public static Classe classeFactory(Class<?> c,int x, int y){
		Classe aRet;
		if(c.isEnum()){
			aRet = new TypeEnumere(c);
		}
		else if(c.isInterface()){
			aRet = new Interface(c);
		}
		else if(Modifier.isAbstract(c.getModifiers())){
			aRet = new ClasseAbstraite(c);
		}
		else {
			aRet = new ClasseClassique(c);
		}
		aRet.setX1(x);
		aRet.setY1(y);
		aRet.calculX2Y2();
		aRet.setLiaisons(new ArrayList<Liaison>());
		return aRet;
	}
	
	public static String traitementNomAttr(String s){
		String aRet="";
		String[] p = s.split(" ");
		aRet += p[0];
		for(int i=1;i<p.length;i++){
			String[] p2 = p[i].split("\\.");
			if(p2.length==0){
				aRet +=" "+p[i];
			}
			else{
				aRet +=" "+p2[p2.length-1];
			}
		}
		
		
		return aRet;
	}
	
	public static String traitementNomMeth(String s){
		String aRet="";
		String[] err = s.split("throws");
		String[] p;
		if(err.length==0){
			p = s.split(" ");
		}
		else{
			p = err[0].split(" ");
		}
		aRet += p[0];
		for(int i=1;i<p.length-1;i++){
			String[] p2 = p[i].split("\\.");
			if(p2.length==0){
				aRet +=" "+p[i];
			}
			else{
				aRet +=" "+p2[p2.length-1];
			}
		}
		p=p[p.length-1].split("\\(");
		p[0]+=" (";
		for(int i=0;i<p.length && i<2;i++){
			String[] p2 = p[i].split("\\.");
			if(p2.length==0){
				aRet +=" "+p[i];
			}
			else{
				aRet +=" "+p2[p2.length-1];
			}
		}
		return aRet;
	}
	public void calculX2Y2(){
		int size = this.getName().length();
	    int i=0;
	    for(String attri : this.getAttributs()){
	    	if(size < attri.length()){
	    		size = attri.length();
	    	}
	    	i++;
	    }
	    int j=i;
	    for(String meth : this.getMethodes()){
	    	if(size < meth.length()){
	    		size = meth.length();
	    	}
	    	i++;
	    }
	    this.setX2(x1+5*size+10);
	    this.setY2(y1+(i+1)*20+5);
	}

	public ArrayList<Liaison> getLiaisons() {
		return liaisons;
	}

	public void setLiaisons(ArrayList<Liaison> liaisons) {
		this.liaisons = liaisons;
	}
	
}
