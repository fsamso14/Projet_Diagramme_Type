package dev.projetArchiLog.langage;

import java.lang.reflect.Modifier;

import dev.projetArchiLog.visiteur.IVisitable;

public abstract class Liaison implements IVisitable{
	public Classe t;
	public Classe f;
	public int x;
	public int y;

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Classe getTo(){
		return t;
	}
	public Classe getFrom(){
		return f;
	}
	public static Liaison liaisonFactory(Classe from, Classe to){

		Liaison aRet;
		
		if(from.getClasse().isInterface() && to.getClasse().isInterface()){
			aRet = new Heritage(from,to);
		}

		else {
			if(to.getClasse().isInterface() && !from.getClasse().isInterface()){

				//if(Modifier.isAbstract(f.getModifiers())){
					Interface tO= new Interface(to.getClasse());
					tO.setX1(to.getX1());
					tO.setY1(to.getY1());
					
					aRet = new Implementation(from,tO);
				//}
				/*else{
					
					aRet = new Implementation(from,to);
				}*/
			}
			else {
				if(from.getClasse().getSuperclass()==to.getClasse()){
					
					aRet = new Heritage(from,to);
				}
				else{
					
					aRet = new Delegation(from,to);
				}
			}
		}

		return aRet;
	}

}
