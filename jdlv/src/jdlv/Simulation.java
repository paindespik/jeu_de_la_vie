package jdlv;
import java.util.*;
import java.lang.*;

public class Simulation {
	grille plateau;
	
	int nb;
	
	Simulation() throws InterruptedException{

		plateau= new grille(20,20);
		int[][] tabTransition= new int[plateau.tailleX][plateau.tailleY];
	
		plateau.afficherGrille();
		nb=plateau.nbRemplie();
		Thread.sleep(5 * 1000);
		
		
		
		
		while(nb>0) {
			
			for(int v=0;v<plateau.tailleY;v++) {
				for(int c=0;c<plateau.tailleX;c++) {
					tabTransition[c][v]=0;
				}
			}
			
			
			
			int nbEnt=0;
			for(int y=0;y<plateau.tailleY;y++) {
				for(int x=0;x<plateau.tailleX;x++) {
					nbEnt=plateau.nbEntourage(x,y);
					if (plateau.retournEtat(x, y)) {
						if(nbEnt<2 || nbEnt>3) {
							tabTransition[x][y]=1;
						}
						
					}
					else {
						if(nbEnt==3) {
							tabTransition[x][y]=1;
						}
					}
				}
			}
			for(int y=0; y<plateau.tailleY;y++) {
				for(int i=0; i<plateau.tailleX;i++) {
					if(tabTransition[i][y]==1) {
						plateau.changerEtat(i, y);
					}
				}
			}
			
			
			plateau.afficherGrille();
			Thread.sleep(5 * 1000);
			System.out.println();
			System.out.println("nb=" + nb);
			
			nb=plateau.nbRemplie();
		}
		
		
	}
	
	
}
