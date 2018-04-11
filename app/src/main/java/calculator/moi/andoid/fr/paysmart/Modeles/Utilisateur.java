package calculator.moi.andoid.fr.paysmart.Modeles;

public class Utilisateur {

    //Attributs
    private String email;
    private String nom;
    private String prenom;
    private String nom_societe;
    private String ville;
    private Categorie categorie;
    private String mot_de_passe;
    private int code_PIN;
    private int RIB;
    private String telephone;
    private int budget_total;


    //Getters et Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom_societe() {
        return nom_societe;
    }

    public void setNom_societe(String nom_societe) {
        this.nom_societe = nom_societe;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCategorie() {
        return categorie.getNom_categorie();
    }

    public void setCategorie(String categorie) {
        this.categorie.setNom_categorie(categorie);
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public int getCode_PIN() {
        return code_PIN;
    }

    public void setCode_PIN(int code_PIN) {
        this.code_PIN = code_PIN;
    }

    public int getRIB() {
        return RIB;
    }

    public void setRIB(int RIB) {
        this.RIB = RIB;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getBudget_total() {
        return budget_total;
    }

    public void setBudget_total(int budget_total) {
        this.budget_total = budget_total;
    }

    //Constructeurs
    public Utilisateur() {
    }

}
