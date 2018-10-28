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
@Table(name = "servicelist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicelist.findAll", query = "SELECT s FROM Servicelist s")
    , @NamedQuery(name = "Servicelist.findById", query = "SELECT s FROM Servicelist s WHERE s.id = :id")
    , @NamedQuery(name = "Servicelist.findByImage", query = "SELECT s FROM Servicelist s WHERE s.image = :image")
    , @NamedQuery(name = "Servicelist.findByName", query = "SELECT s FROM Servicelist s WHERE s.name = :name")})
public class Servicelist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "image")
    private String image;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "servicelistId")
    private Collection<Clinicservice> clinicserviceCollection;

    public Servicelist() {
    }

    public Servicelist(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Clinicservice> getClinicserviceCollection() {
        return clinicserviceCollection;
    }

    public void setClinicserviceCollection(Collection<Clinicservice> clinicserviceCollection) {
        this.clinicserviceCollection = clinicserviceCollection;
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
        if (!(object instanceof Servicelist)) {
            return false;
        }
        Servicelist other = (Servicelist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.domain.Servicelist[ id=" + id + " ]";
    }
    
}
