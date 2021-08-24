package fr.diginamic.projet.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.diginamic.projet.Utils.DateUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "salarie")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminant", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("salarie")
public class Salarie extends BasedEntity implements UserDetails {

    @Column(name = "prenom", nullable = false)
    protected String prenom;

    @Column(name = "nom", nullable = false)
    protected String nom;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    protected String email;

    @Column(name = "date_naissance", nullable = false)
    protected LocalDate dateDeNaissance;

    @Column(name = "date_arrivee", nullable = false)
    protected LocalDate dateArrivee;

    @Column(name = "password_hashed", nullable = false)
    protected String password;


    @ManyToOne
    @JoinColumn(name = "id_service", referencedColumnName = "id", nullable = false)
    protected Departement departement;

    @ManyToOne
    @JoinColumn(name = "id_manager", referencedColumnName = "id")
    protected Manager manager;

    @OneToMany(mappedBy = "salarie")
    protected Set<Absence> absences = new HashSet<>();


    public Salarie() {
        super();
    }

    public Salarie(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password) {
        this(null, prenom, nom, email, dateDeNaissance, dateArrivee, password);
    }

    public Salarie(Long id, String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password) {
        super(id);
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.dateArrivee = dateArrivee;
        this.password = password;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public LocalDate getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(LocalDate dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

//    public String getPassword() {
//        return password;
//    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Set<Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(Set<Absence> absences) {
        this.absences = absences;
    }


    public long getSoldeRTT() {
        return RttEmploye.NOMBRE_MAX - absences.stream()
                .filter(absence -> absence instanceof RttEmploye)
                .mapToLong(value -> DateUtils.workedDaysBetween(
                        ((RttEmploye) value).getDateDebut(),
                        ((RttEmploye) value).getDateFin()
                ))
                .sum();
    }

    public long getSoldeCP() {
        return CongePaye.NOMBRE_MAX - absences.stream()
                .filter(absence -> absence instanceof CongePaye)
                .mapToLong(value -> DateUtils.workedDaysBetween(
                        ((CongePaye) value).getDateDebut(),
                        ((CongePaye) value).getDateFin()
                ))
                .sum();
    }

    public void addAbsence(Absence absence) {
        if (absence != null) {
            absence.setSalarie(this);
        }
    }

    public void removeAbsence(Absence absence) {
        if (absence != null) {
            absence.setSalarie(null);
        }
    }

    @Override
    public String toString() {
        return "Salarie{" +
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


    public String getType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(() -> "ROLE_SALARIE");
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    @JsonIgnore
    public String getUsername(){
        return getEmail();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled(){
        return true;
    }
}
