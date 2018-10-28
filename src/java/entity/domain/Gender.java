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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "gender")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gender.findAll", query = "SELECT g FROM Gender g")
    , @NamedQuery(name = "Gender.findById", query = "SELECT g FROM Gender g WHERE g.id = :id")
    , @NamedQuery(name = "Gender.findByName", query = "SELECT g FROM Gender g WHERE g.name = :name")})
public class Gender implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "doctorgenderId")
    private Collection<Appointment> appointmentCollection;
    @OneToMany(mappedBy = "genderId")
    private Collection<Appointment> appointmentCollection1;
    @OneToMany(mappedBy = "genderId")
    private Collection<Guest> guestCollection;

    public Gender() {
    }

    public Gender(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection1() {
        return appointmentCollection1;
    }

    public void setAppointmentCollection1(Collection<Appointment> appointmentCollection1) {
        this.appointmentCollection1 = appointmentCollection1;
    }

    @XmlTransient
    public Collection<Guest> getGuestCollection() {
        return guestCollection;
    }

    public void setGuestCollection(Collection<Guest> guestCollection) {
        this.guestCollection = guestCollection;
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
        if (!(object instanceof Gender)) {
            return false;
        }
        Gender other = (Gender) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.domain.Gender[ id=" + id + " ]";
    }
    
}
