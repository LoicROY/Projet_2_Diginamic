package fr.diginamic.projet.Entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("A")
public class Administateur extends Salarie {

}
