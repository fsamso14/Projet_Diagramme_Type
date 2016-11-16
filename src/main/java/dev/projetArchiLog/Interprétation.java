package dev.projetArchiLog;

import java.io.IOException;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import dev.projetArchiLog.*;
// TODO: Auto-generated Javadoc

/**
 * The Class Interprétation.
 */
public class Interprétation {
	
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
 	public static String getListesClasse(Package[] packages){
		 String aRet="Liste des classes :\n";
		 ImmutableSet<ClassPath.ClassInfo> classes = null;
		 ///*
		 for(Package p:packages){
			 String name = p.getName();
			 aRet +="	Nom du Packages : "+name+"\n 		Nom des classes : \n";//*/
			 try {
				classes = ClassPath.from(ClassLoader.getSystemClassLoader()).getTopLevelClassesRecursive(name);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 for(ClassPath.ClassInfo c : classes){
				 aRet +="		"+c.getName()+"\n";
			 }
		 }
		 return aRet;
	 }
	 
 	/**
 	 * The main method.
 	 *
 	 * @param args the arguments
 	 */
 	public static void main(String[] args) {
		System.out.println(getListesClasse(Package.getPackages()));
	}
	 
}
