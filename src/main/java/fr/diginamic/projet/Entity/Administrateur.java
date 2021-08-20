package fr.diginamic.projet.Entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@DiscriminatorValue("administrateur")
public class Administrateur extends Salarie {


    public Administrateur() {
    }

    public Administrateur(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password) {
        super(prenom, nom, email, dateDeNaissance, dateArrivee, password);
    }

    public Administrateur(Long id, String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password) {
        super(id, prenom, nom, email, dateDeNaissance, dateArrivee, password);
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
                ", manager=" + manager.getId() +
                ", absences=" + absences +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(() -> "ROLE_ADMIN");
    }
}
