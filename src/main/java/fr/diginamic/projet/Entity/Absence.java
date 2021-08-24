package fr.diginamic.projet.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;
import javax.persistence.*;

@Entity
@Table(name = "ABSENCE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminant", discriminatorType = DiscriminatorType.STRING)
public abstract class Absence extends BasedEntity {

    @Column(name = "statut", nullable = false)
    @Enumerated(value = EnumType.STRING)
    protected StatutType statut = StatutType.INITIALE ;

    @ManyToOne
    @JoinColumn(name = "id_salarie", referencedColumnName = "id")
    @JsonIgnore
    protected Salarie salarie;


    protected Absence() {
        super();
    }

    protected Absence(StatutType statut) {
        this(null, statut);
    }

    protected Absence(Long id, StatutType statut) {
        super(id);
        this.statut = statut;
    }

    public StatutType getStatut() {
        return statut;
    }

    public void setStatut(StatutType statut) {
        this.statut = statut;
    }

    public Salarie getSalarie() {
        return salarie;
    }

    public void setSalarie(Salarie salarie) {
        if (this.salarie != null){
            this.salarie.getAbsences().remove(this);
        }
        this.salarie = salarie;
        if (salarie != null){
            salarie.getAbsences().add(this);
        }
    }

    public abstract void isValid() throws AbsenceException;

    @Override
    public String toString() {
        return "Absence{" +
                "statut=" + statut +
                ", salarie=" + salarie.getId() +
                ", id=" + id +
                '}';
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }
}