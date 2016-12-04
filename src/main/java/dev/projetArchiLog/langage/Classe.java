package dev.projetArchiLog.langage;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class Classe implements Modele{
	Class<?> c;
	public Class<?> getClasse(){
		return this.c;
	}
	
	public String getName(){
		return this.getClasse().getName();
	}
	public String[] getAttributs(){
		Field[] f = this.getClasse().getFields();
		String[] aret = new String[f.length];
		for(int i = 0; i < f.length; i++){
			aret[i] = f.toString();
		}
		return aret;
	}
	public String[] getMethodes(){
		Method[] m = this.getClasse().getMethods();
		String[] aret = new String[m.length];
		for(int i = 0; i < m.length; i++){
			aret[i] = m[i].toString();
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
	
}
