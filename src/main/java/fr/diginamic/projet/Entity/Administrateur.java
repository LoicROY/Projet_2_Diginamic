package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Exception.SalarieException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("administrateur")
public class Administrateur extends Salarie {


    public Administrateur() {
    }

    public Administrateur(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Departement departement) throws SalarieException {
        super(prenom, nom, email, dateDeNaissance, dateArrivee, password, departement);
    }

    public Administrateur(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Departement departement, Set<Absence> absences) {
        super(prenom, nom, email, dateDeNaissance, dateArrivee, password, departement, absences);
    }

    public Administrateur(Long id, String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Departement departement, Set<Absence> absences) {
        super(id, prenom, nom, email, dateDeNaissance, dateArrivee, password, departement, absences);
    }

    @Override
    public String toString() {
        return "Administrateur{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", dateDeNaissance=" + dateDeNaissance +
                ", dateArrivee=" + dateArrivee +
                ", password='" + password + '\'' +
                ", departement=" + departement +
                ", absences=" + absences +
                '}';
    }
}
