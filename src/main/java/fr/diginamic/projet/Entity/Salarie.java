package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Exception.AbsenceException;
import fr.diginamic.projet.Exception.SalarieException;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "salarie")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminant",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("salarie")
public class Salarie extends BasedEntity {

    @Column(name = "prenom", nullable = false)
    protected String prenom;

    @Column(name = "nom", nullable = false)
    protected String nom;

    @Column(name = "email", length = 100, nullable = false)
    protected String email;

    @Column(name = "date_naissance", nullable = false)
    protected LocalDate dateDeNaissance;

    @Column(name = "date_arrivee", nullable = false)
    protected LocalDate dateArrivee;

    @Column(name = "password_hashed", nullable = false)
    protected String password;


    @ManyToOne
    @JoinColumn(name = "id_service", referencedColumnName = "id", nullable = false)
    protected Departement departement;

    @ManyToOne
    @JoinColumn(name = "id_manager", referencedColumnName = "id", nullable = false)
    protected Manager manager;

    @OneToMany(mappedBy = "salarie")
    protected Set<Absence> absences = new HashSet<>();


    public Salarie() {
        this(null,null,null,null,null,null,null,null,null);
    }
    public Salarie(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Departement departement)  {
        this(null,prenom,nom,email,dateDeNaissance,dateArrivee,password,departement,null);
    }
    public Salarie(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Departement departement, Set<Absence> absences) {
        this(null,prenom,nom,email,dateDeNaissance,dateArrivee,password,departement,absences);

    }
    public Salarie(Long id, String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Departement departement,Set<Absence> absences) {
        super(id);
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.dateArrivee = dateArrivee;
        this.password = password;
        this.departement = departement;
        this.absences=absences;
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

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Set<Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(Set<Absence> absences) {
        this.absences = absences;
    }


    public double getSoldeRTT() {
        double cpt=0;
        for (Absence a :absences){
            if (a instanceof RttEmploye){
                cpt+= ChronoUnit.DAYS.between(((RttEmploye) a).getDateDebut(), ((RttEmploye) a).getDateFin());
            }
        }
        return RttEmploye.NOMBRE_MAX - cpt;
    }

    public double getSoldeCP(){
        double cpt=0;
        for (Absence a :absences){
            if (a instanceof CongePaye){
                cpt += ChronoUnit.DAYS.between(((CongePaye) a).getDateDebut(), ((CongePaye) a).getDateFin());
            }
        }
        return CongePaye.NOMBRE_MAX - cpt;
    }

    public void addAbsence(Absence absence) {
        if (absence != null) {
            absence.setSalarie(this);
        }
    }

    public void removeAbsence(Absence absence) {
        if (absence != null) {
            absence.setSalarie(null);
        }
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
                ", departement=" + departement +
                ", manager=" + manager.getId() +
                ", absences=" + absences +
                '}';
    }
}
