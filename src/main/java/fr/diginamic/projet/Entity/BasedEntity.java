package fr.diginamic.projet.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BasedEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected BasedEntity() {
    }

    protected BasedEntity(Long id) {
        this.id = id;
    }
}
