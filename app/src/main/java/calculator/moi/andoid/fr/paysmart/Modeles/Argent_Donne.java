package calculator.moi.andoid.fr.paysmart.Modeles;

public class Argent_Donne {

    //Attributs
    private String email_receveur;
    private String email_distributeur;
    private Categorie nom_categorie;
    private int somme;

    //Constructeurs

    public Argent_Donne() {
    }

    //Getters et Setters

    public String getEmail_receveur() {
        return email_receveur;
    }

    public void setEmail_receveur(String email_receveur) {
        this.email_receveur = email_receveur;
    }

    public String getEmail_distributeur() {
        return email_distributeur;
    }

    public void setEmail_distributeur(String email_distributeur) {
        this.email_distributeur = email_distributeur;
    }

    public Categorie getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(Categorie nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public int getSomme() {
        return somme;
    }

    public void setSomme(int somme) {
        this.somme = somme;
    }
}
