package dev.projetArchiLog;

import java.io.IOException;
import java.util.ArrayList;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

import dev.projetArchiLog.*;

/**
 * The Class Interprétation.
 */
public class Interpretation {
	
	 /**
 	 * Gets the nom classe.
 	 *
 	 * @param o the o
 	 * @return the nom classe
 	 */
 	public String getNomClasse(Object o)
	   {
	      Class c = o.getClass();
	      return c.getName();
	   }

	 /**
 	 * Gets the listes of classe.
 	 *
 	 * @param packages the packages
 	 * @return the listes classe
 	 */
 	public static ArrayList<Class<?>> getListesClasse(Package[] packages){
		 ArrayList<Class<?>> aRet=new ArrayList<Class<?>>();
		 ImmutableSet<ClassPath.ClassInfo> classes = null;
		 ///*
		 for(Package p:packages){
			 String name = p.getName();
			 try {
				classes = ClassPath.from(ClassLoader.getSystemClassLoader()).getTopLevelClasses(name);
			} catch (IOException e) {
				e.printStackTrace();
			}
			 for(ClassPath.ClassInfo c : classes){
				 try {
					aRet.add(Class.forName(c.getName()));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			 }
			 
		 }
		 for(Class x: aRet){
			 System.out.println(x.getName());
			 
		 }
		 
		 return aRet;
	 }
 	
 	/**
 	 * The main method.
 	 *
 	 * @param args the arguments
 	 */
 	public static void main(String[] args) {
		ArrayList<Class<?>> list=getListesClasse(Package.getPackages());

	}
	 
}
