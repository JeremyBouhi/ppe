package calculator.moi.andoid.fr.paysmart.Modeles;

public class Argent_Depense {

    //Attributs
    private String email_utilisateur;
    private String email_commerce;
    private String jour;
    private int montant;

    //Constructeurs

    public Argent_Depense() {
    }

    //Getters et Setters

    public String getEmail_utilisateur() {
        return email_utilisateur;
    }

    public void setEmail_utilisateur(String email_utilisateur) {
        this.email_utilisateur = email_utilisateur;
    }

    public String getEmail_commerce() {
        return email_commerce;
    }

    public void setEmail_commerce(String email_commerce) {
        this.email_commerce = email_commerce;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
}
