package fr.diginamic.projet.Entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("M")
public class Manager extends Salarie{

}
