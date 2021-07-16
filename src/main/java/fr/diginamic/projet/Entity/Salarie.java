package fr.diginamic.projet.Entity;


import fr.diginamic.projet.Entity.Enumeration.AbsenceChoisieType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "salarie")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminant",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("salarie")
public class Salarie extends BasedEntity {

    @Column(name = "prenom")
    protected String prenom;

    @Column(name = "nom")
    protected String nom;

    @Column(name = "email")
    protected String email;

    @Column(name = "date_naissance")
    protected LocalDate dateDeNaissance;

    @Column(name = "date_arrivee")
    protected LocalDate dateArrivee;

    @Column(name = "password_hashed")
    protected String password;


    @ManyToOne
    @JoinColumn(name = "id_service",referencedColumnName = "id")
    protected Departement departement;

    @ManyToMany
    @JoinTable(name = "historique_absence",
            joinColumns = @JoinColumn(name = "id_Salarie",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_Absence",referencedColumnName = "id")
    )
    protected Set<Absence> absences = new HashSet<>();


//    public double getSolde(){
//        double max = RttEmploye.
//
//    }



    public Salarie(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Departement departement, Set<Absence> absences) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.dateArrivee = dateArrivee;
        this.password = password;
        this.departement = departement;
        this.absences = absences;
    }

    public Salarie() {
    }

    public Salarie(Long id, String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Departement departement) {
        super(id);
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.dateArrivee = dateArrivee;
        this.password = password;
        this.departement = departement;
    }

    public Salarie(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Departement departement) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.dateArrivee = dateArrivee;
        this.password = password;
        this.departement = departement;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public LocalDate getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(LocalDate dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Departement getService() {
        return departement;
    }

    public void setService(Departement departement) {
        this.departement = departement;
    }

    public Set<Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(Set<Absence> absences) {
        this.absences = absences;
    }

    @Override
    public String toString() {
        return "Salarie{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", dateDeNaissance=" + dateDeNaissance +
                ", dateArrivee=" + dateArrivee +
                ", password='" + password + '\'' +
                ", service=" + departement +
                ", absences=" + absences +
                '}';
    }
}
