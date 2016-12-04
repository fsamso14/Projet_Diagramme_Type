package dev.projetArchiLog;

/**
 * Hello world!
 *
 */
public class App 
{
	public String msg;
	
    public static void main( String[] args )
    {
        try {
			Class A = ClassLoader.getSystemClassLoader().loadClass("dev.projetArchiLog.langage.Classe");
			System.out.println(A.getCanonicalName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }    
}
