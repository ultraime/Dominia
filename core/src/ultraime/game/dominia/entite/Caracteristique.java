package ultraime.game.dominia.entite;

public class Caracteristique {

	public int vitalite = 20;
	public int fertilite = 20;
	public int migration = 1000;
	public int resistChaleur = 20;
	public int resistFroid = 20;
	public int force = 20;
	public int intelligence = 20;

	public Caracteristique() {
	}

	public Caracteristique(final Caracteristique caracteristique) {
		this.vitalite = caracteristique.vitalite;
		this.fertilite = caracteristique.fertilite;
		this.migration = caracteristique.migration;
		this.resistChaleur = caracteristique.resistChaleur;
		this.resistFroid = caracteristique.resistFroid;
		this.force = caracteristique.force;
		this.intelligence = caracteristique.intelligence;
	}

	@Override
	public String toString() {
		return "Caracteristique [vitalite=" + vitalite + ", fertilite=" + fertilite + ", migration=" + migration
				+ ", resistChaleur=" + resistChaleur + ", resistFroid=" + resistFroid + ", force=" + force
				+ ", intelligence=" + intelligence + "]";
	}

	public void clear() {
		this.vitalite = 0;
		this.fertilite = 0;
		this.migration = 0;
		this.resistChaleur = 0;
		this.resistFroid = 0;
		this.force = 0;
		this.intelligence = 0;
	}

	public void addition(final Caracteristique caracteristique) {
		this.vitalite += caracteristique.vitalite;
		this.fertilite += caracteristique.fertilite;
		this.migration += caracteristique.migration;
		this.resistChaleur += caracteristique.resistChaleur;
		this.resistFroid += caracteristique.resistFroid;
		this.force += caracteristique.force;
		this.intelligence += caracteristique.intelligence;
	}

	public void divisionStats(int diviseur) {
		if (diviseur == 0) {
			diviseur = 1;
		}
		this.vitalite = this.vitalite / diviseur;
		this.fertilite = this.fertilite / diviseur;
		this.migration = this.migration / diviseur;
		this.resistChaleur = this.resistChaleur / diviseur;
		this.resistFroid = this.resistFroid / diviseur;
		this.force = this.force / diviseur;
		this.intelligence = this.intelligence / diviseur;

	}

}
