package fr.diginamic.projet.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("A")
public class Administateur extends Salarie {

    public Administateur(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Service service, Set<Absence> absences) {
        super(prenom, nom, email, dateDeNaissance, dateArrivee, password, service, absences);
    }

    public Administateur() {
    }

    public Administateur(Long id, String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Service service) {
        super(id, prenom, nom, email, dateDeNaissance, dateArrivee, password, service);
    }

    public Administateur(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Service service) {
        super(prenom, nom, email, dateDeNaissance, dateArrivee, password, service);
    }


    @Override
    public String toString() {
        return "Administateur{" +
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
