package fr.diginamic.projet.Entity;


import javax.persistence.*;
import java.security.Provider;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
@DiscriminatorValue("S")
public class Salarie extends BasedEntity {

    @Column
    protected String prenom;

    @Column
    protected String nom;

    @Column
    protected String email;

    @Column(name = "dateNaissance")
    protected LocalDate dateDeNaissance;

    @Column(name = "dateArrivee")
    protected LocalDate dateArrivee;

    @Column(name = "passwordHashed")
    protected String password;


    @ManyToOne
    @JoinColumn(name = "id_service")
    protected Service service;

    @ManyToMany
    @JoinTable(name = "historique_absence",
            joinColumns = @JoinColumn(name = "SALARIE_ID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ABSENCE_ID",referencedColumnName = "id")
    )
    protected Set<Absence> absences = new HashSet<>();


   /* public Boolean ifWeekEnd(LocalDate date, Absence dateAbsence){
        if(date == dateAbsence){
            return false;
        }else{
            return true;
        }
    }*/

   // public int getSolde()


    public Salarie(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Service service, Set<Absence> absences) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.dateArrivee = dateArrivee;
        this.password = password;
        this.service = service;
        this.absences = absences;
    }

    public Salarie() {
    }

    public Salarie(Long id, String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Service service) {
        super(id);
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.dateArrivee = dateArrivee;
        this.password = password;
        this.service = service;
    }

    public Salarie(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Service service) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.dateArrivee = dateArrivee;
        this.password = password;
        this.service = service;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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
                ", service=" + service +
                ", absences=" + absences +
                '}';
    }
}
