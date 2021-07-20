package fr.diginamic.projet.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "SERVICE" )
@Entity
public class Departement extends BasedEntity {

    @Column(name = "libelle", nullable = false)
    protected String libelle;

    public Departement() {
        this(null,null);
    }

    public Departement(String libelle) {
        this(null,libelle);
    }

    public Departement(Long id, String libelle) {
        super(id);
        this.libelle = libelle;
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
