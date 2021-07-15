package fr.diginamic.projet.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("M")
public class Manager extends Salarie{

    private Boolean valide;


    public Absence managerDemande(Absence absence, Boolean valide){
        if(valide == true ){
            return absence;
        }else{
            return null;
        }
    }

    public Manager(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Service service, Set<Absence> absences, Boolean valide) {
        super(prenom, nom, email, dateDeNaissance, dateArrivee, password, service, absences);
        this.valide = valide;
    }

    public Manager(Boolean valide) {
        this.valide = valide;
    }

    public Manager(Long id, String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Service service, Boolean valide) {
        super(id, prenom, nom, email, dateDeNaissance, dateArrivee, password, service);
        this.valide = valide;
    }

    public Manager(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Service service, Boolean valide) {
        super(prenom, nom, email, dateDeNaissance, dateArrivee, password, service);
        this.valide = valide;
    }

    public Manager() {

    }

    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }

}
