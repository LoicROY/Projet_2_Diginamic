package fr.diginamic.projet.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("M")
public class Manager extends Salarie{



    public Manager(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Service service, Set<Absence> absences) {
        super(prenom, nom, email, dateDeNaissance, dateArrivee, password, service, absences);
    }

    public Manager() {
    }

    public Manager(Long id, String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Service service) {
        super(id, prenom, nom, email, dateDeNaissance, dateArrivee, password, service);
    }

    public Manager(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Service service) {
        super(prenom, nom, email, dateDeNaissance, dateArrivee, password, service);
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
                ", service=" + service +
                ", absences=" + absences +
                '}';
    }
}
