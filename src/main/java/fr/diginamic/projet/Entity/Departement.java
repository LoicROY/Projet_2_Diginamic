package fr.diginamic.projet.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
@Table(name = "service" )
@Entity
public class Departement extends BasedEntity {

    @Column
    protected String libelle;



    public Departement(String libelle, Set<Salarie> salaries) {
        this.libelle = libelle;

    }

    public Departement(Long id, String libelle, Set<Salarie> salaries) {
        super(id);
        this.libelle = libelle;

    }

    public Departement() {

    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }





    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +

                '}';
    }
}
