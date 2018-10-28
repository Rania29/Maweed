/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nooshi
 */
@Entity
@Table(name = "hospitalimage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospitalimage.findAll", query = "SELECT h FROM Hospitalimage h")
    , @NamedQuery(name = "Hospitalimage.findById", query = "SELECT h FROM Hospitalimage h WHERE h.id = :id")
    , @NamedQuery(name = "Hospitalimage.findByImage", query = "SELECT h FROM Hospitalimage h WHERE h.image = :image")})
public class Hospitalimage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "image")
    private String image;
    @JoinColumn(name = "hospital_id", referencedColumnName = "id")
    @ManyToOne
    private Hospital hospitalId;

    public Hospitalimage() {
    }

    public Hospitalimage(Long id) {
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

    public Hospital getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Hospital hospitalId) {
        this.hospitalId = hospitalId;
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
        if (!(object instanceof Hospitalimage)) {
            return false;
        }
        Hospitalimage other = (Hospitalimage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.domain.Hospitalimage[ id=" + id + " ]";
    }
    
}
