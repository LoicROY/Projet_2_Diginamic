package fr.diginamic.projet.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("manager")
public class Manager extends Salarie{

    public Manager(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Departement departement, Set<Absence> absences) {
        super(prenom, nom, email, dateDeNaissance, dateArrivee, password, departement, absences);
    }

    public Manager() {
    }

    public Manager(Long id, String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Departement departement) {
        super(id, prenom, nom, email, dateDeNaissance, dateArrivee, password, departement);
    }

    public Manager(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Departement departement) {
        super(prenom, nom, email, dateDeNaissance, dateArrivee, password, departement);
    }

    @Override
    public String toString() {
        return "Manager{" +
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
