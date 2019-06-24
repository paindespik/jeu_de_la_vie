package jdlv;
import java.util.*;
import java.lang.*;

public class Simulation {
	grille plateau;
	grille plateauTransition;
	int nb;
	
	Simulation() throws InterruptedException{

		plateau= new grille(20,20);
		plateauTransition= plateau;
		plateau.afficherGrille();
		nb=plateau.nbRemplie();
		Thread.sleep(5 * 1000);
		
		
		
		
		while(nb>0) {
			int nbEnt=0;
			for(int y=0;y<plateau.tailleY;y++) {
				for(int x=0;x<plateau.tailleX;x++) {
					nbEnt=plateau.nbEntourage(x,y);
					if(nbEnt<2 || nbEnt>3) {
						plateauTransition.vider(x,y);
					}
					else if (nbEnt==3) {
						plateauTransition.Remplir(x, y);
					}
				}
			}
			plateau=plateauTransition;
			plateau.afficherGrille();
			Thread.sleep(5 * 1000);
			System.out.println();
			System.out.println("nb=" + nb);
			
			nb=plateau.nbRemplie();
		}
		
		
	}
	
	
}
