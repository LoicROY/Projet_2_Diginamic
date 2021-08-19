package fr.diginamic.projet.Entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("manager")
public class Manager extends Salarie {

    public Manager() {
    }

    public Manager(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password) {
        super(prenom, nom, email, dateDeNaissance, dateArrivee, password);
    }

    public Manager(Long id, String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password) {
        super(id, prenom, nom, email, dateDeNaissance, dateArrivee, password);
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
                ", departement=" + departement +
                ", manager=" + manager.getId() +
                ", absences=" + absences +
                '}';
    }
}
