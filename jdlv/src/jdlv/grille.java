package jdlv;
import java.util.Random;
public class grille {
	boolean rand;
	cellule[][] grille;
	grille(int x,int y){
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
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
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
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