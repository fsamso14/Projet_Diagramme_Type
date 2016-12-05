package dev.projetArchiLog.langage;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class Classe implements Modele{
	Class<?> c;
	int x1;
	int y1;
	int x2;
	int y2;
	
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
		Method[] m = this.getClasse().getMethods();
		String[] aret = new String[m.length];
		for(int i = 0; i < m.length; i++){
			aret[i] = traitementNomMeth(m[i].toString());
		}
		return aret;
	}
	
	public static Classe classeFactory(Class<?> c){
		Classe aRet;
		if(c.isEnum()){
			aRet = new Enum(c);
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
	
}
