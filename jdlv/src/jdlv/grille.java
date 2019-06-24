package jdlv;
import java.util.Random;
public class grille {
	boolean rand;
	int tailleX, tailleY;
	cellule[][] grille;
	
	
	
	grille(int x,int y){
		
		this.tailleX=x;
		this.tailleY=y;
		grille=new cellule[tailleX][tailleY];
		for(int i=0;i<tailleX;i++) {
			for(int j=0;j<tailleY;j++) {
				Random r= new Random();
				if (r.nextInt(7)==1) {
					rand=true;
				}
				else {
					rand=false;
				}
				grille[i][j]=new cellule(rand);
			}
		}
	}
	
	int nbEntourage(int x, int y) {
		int nb=0;
		if (x>0) {
			if(grille[x-1][y].remplie) {
				nb++;
				
			}
			if (y>0) {
					if(grille[x-1][y-1].remplie) {
						nb++;
					}
				}
		}
		if (x<tailleX-1) {
			if(grille[x+1][y].remplie) {
				nb++;
			}
			if (y<tailleY-1) {
				if(grille[x+1][y+1].remplie) {
					nb++;
				}
			}
		}
		if (y>0) {
			if(grille[x][y-1].remplie) {
				nb++;
			}
			if(x<tailleY-1) {
				if(grille[x+1][y-1].remplie) {
					nb++;
				}
			}
		}
		if (y<tailleY-1) {
			if(grille[x][y+1].remplie) {
				nb++;
			}
			if (x>0) {
				if(grille[x-1][y+1].remplie) {
					nb++;
				}
			}
		}
		return nb;
		
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
	
	int nbRemplie() {
		int nb=0;
		
		for (int y=0;y<tailleY;y++) {
			for (int  x=0;x<tailleX;x++) {
				if(grille[x][y].remplie) {
					nb++;
				}
			}
		}
		
	
	
		
		
		return nb;
	}
	
	void vider(int x,int y) {
		grille[x][y].remplie=false;
	}
	void Remplir(int x,int y) {
		grille[x][y].remplie=true;
	}
	
	
	

	
	
}


