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
import javax.persistence.ManyToMany;
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
@Table(name = "insurance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insurance.findAll", query = "SELECT i FROM Insurance i")
    , @NamedQuery(name = "Insurance.findById", query = "SELECT i FROM Insurance i WHERE i.id = :id")
    , @NamedQuery(name = "Insurance.findByImage", query = "SELECT i FROM Insurance i WHERE i.image = :image")
    , @NamedQuery(name = "Insurance.findByName", query = "SELECT i FROM Insurance i WHERE i.name = :name")})
public class Insurance implements Serializable {

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
    @ManyToMany(mappedBy = "insuranceCollection")
    private Collection<Hospital> hospitalCollection;

    public Insurance() {
    }

    public Insurance(Long id) {
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
    public Collection<Hospital> getHospitalCollection() {
        return hospitalCollection;
    }

    public void setHospitalCollection(Collection<Hospital> hospitalCollection) {
        this.hospitalCollection = hospitalCollection;
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
        if (!(object instanceof Insurance)) {
            return false;
        }
        Insurance other = (Insurance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.domain.Insurance[ id=" + id + " ]";
    }
    
}
