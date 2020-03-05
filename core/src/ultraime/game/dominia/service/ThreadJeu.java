package ultraime.game.dominia.service;

import java.text.DecimalFormat;

import com.badlogic.gdx.Gdx;
import com.ultraime.game.gdxtraime.parametrage.Parametre;

import ultraime.game.dominia.entite.Caracteristique;
import ultraime.game.dominia.entite.Joueur;

public class ThreadJeu implements Runnable {
	private JeuService jeuService;

	// pour le mode debug
	private DecimalFormat decimalPrintFormat = new DecimalFormat("#,##0");
	static int BOUCLE = 0;

	public ThreadJeu(JeuService jeuService) {
		this.jeuService = jeuService;
	}

	@Override
	public void run() {
		do {
			if (!Parametre.PAUSE) {
				try {
					if (Parametre.MODE_DEBUG_SYSO) {
						BOUCLE++;
					}
					int timeToSleep = 1000/Parametre.VITESSE_DE_JEU;
					Thread.sleep(timeToSleep);
					for (int i = 0; i < this.jeuService.joueurs.size(); i++) {
						final Joueur joueur = this.jeuService.joueurs.get(i);
						final int idJoueur = joueur.id;

						if (Parametre.MODE_DEBUG_SYSO) {
							System.out.println("=============JOUEUR " + idJoueur + " ========================");
						}

						for (int x = 0; x < this.jeuService.zones.length; x++) {
							for (int y = 0; y < this.jeuService.zones[x].length; y++) {
								final Caracteristique caracteristique = this.jeuService.zones[x][y]
										.getCaracteristiqueMoyenFromJoueur(idJoueur);

								// Naissance
								this.jeuService.zones[x][y].gererNaissance(idJoueur, joueur.ameliorations,
										caracteristique);
								// Migration
								this.jeuService.zones[x][y].gererMigration(idJoueur, this.jeuService.zones, x, y);

								if (Parametre.MODE_DEBUG_SYSO) {
									String nbPerso = "";
									nbPerso = decimalPrintFormat
											.format(this.jeuService.zones[x][y].getNbPersonnageFromJoueur(idJoueur));
									System.out.println("Boucle : " + BOUCLE + " population zone[" + x + "][" + y
											+ "] = " + nbPerso);
								}
							}
						}
						if (Parametre.MODE_DEBUG_SYSO) {
							System.out.println("Boucle : " + BOUCLE + " Nombre total de personnage : "
									+ decimalPrintFormat.format(this.jeuService.getAllPersonnageFromJoueur(idJoueur)));
						}

					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} while (Gdx.app != null);
	}

}
