/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nooshi
 */
@Entity
@Table(name = "appointment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a")
    , @NamedQuery(name = "Appointment.findById", query = "SELECT a FROM Appointment a WHERE a.id = :id")
    , @NamedQuery(name = "Appointment.findByDob", query = "SELECT a FROM Appointment a WHERE a.dob = :dob")
    , @NamedQuery(name = "Appointment.findByDescription", query = "SELECT a FROM Appointment a WHERE a.description = :description")
    , @NamedQuery(name = "Appointment.findByEmail", query = "SELECT a FROM Appointment a WHERE a.email = :email")
    , @NamedQuery(name = "Appointment.findByName", query = "SELECT a FROM Appointment a WHERE a.name = :name")
    , @NamedQuery(name = "Appointment.findByPhone", query = "SELECT a FROM Appointment a WHERE a.phone = :phone")})
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "dob")
    private String dob;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "phone")
    private String phone;
    @JoinTable(name = "appointment_daysofweek", joinColumns = {
        @JoinColumn(name = "appointment_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "daysofweeks_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Daysofweek> daysofweekCollection;
    @JoinColumn(name = "doctorgender_id", referencedColumnName = "id")
    @ManyToOne
    private Gender doctorgenderId;
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    @ManyToOne
    private Gender genderId;
    @JoinColumn(name = "hospital_id", referencedColumnName = "id")
    @ManyToOne
    private Hospital hospitalId;
    @JoinColumn(name = "morningorevening_id", referencedColumnName = "id")
    @ManyToOne
    private Shift morningoreveningId;

    public Appointment() {
    }

    public Appointment(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlTransient
    public Collection<Daysofweek> getDaysofweekCollection() {
        return daysofweekCollection;
    }

    public void setDaysofweekCollection(Collection<Daysofweek> daysofweekCollection) {
        this.daysofweekCollection = daysofweekCollection;
    }

    public Gender getDoctorgenderId() {
        return doctorgenderId;
    }

    public void setDoctorgenderId(Gender doctorgenderId) {
        this.doctorgenderId = doctorgenderId;
    }

    public Gender getGenderId() {
        return genderId;
    }

    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
    }

    public Hospital getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Hospital hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Shift getMorningoreveningId() {
        return morningoreveningId;
    }

    public void setMorningoreveningId(Shift morningoreveningId) {
        this.morningoreveningId = morningoreveningId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.domain.Appointment[ id=" + id + " ]";
    }
    
}
