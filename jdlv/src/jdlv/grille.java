package jdlv;
import java.util.Random;
public class grille {
	boolean rand;
	int tailleX, tailleY;
	cellule[][] grille;
	grille(int x,int y){
		this.tailleX=x;
		this.tailleY=y;
		for(int i=0;i<tailleX;i++) {
			for(int j=0;j<tailleY;j++) {
				Random r= new Random();
				if (r.nextInt(5)==1) {
					rand=true;
				}
				else {
					rand=false;
				}
				grille[i][j]=new cellule(rand);
			}
		}
	}
	
	
	void afficherGrille() {
		for(int j=0;j<tailleX;j++) {
			for(int i=0;i<tailleY;i++) {
				if (grille[i][j].remplie) {
					System.out.print("[X]");
				}
				else {
					System.out.print("[ ]");
				}
			}
			System.out.println();
	}

}
}