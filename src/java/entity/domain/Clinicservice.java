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
@Table(name = "clinicservice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clinicservice.findAll", query = "SELECT c FROM Clinicservice c")
    , @NamedQuery(name = "Clinicservice.findById", query = "SELECT c FROM Clinicservice c WHERE c.id = :id")
    , @NamedQuery(name = "Clinicservice.findByDiscount", query = "SELECT c FROM Clinicservice c WHERE c.discount = :discount")
    , @NamedQuery(name = "Clinicservice.findByPrice", query = "SELECT c FROM Clinicservice c WHERE c.price = :price")})
public class Clinicservice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "discount")
    private String discount;
    @Size(max = 255)
    @Column(name = "price")
    private String price;
    @JoinColumn(name = "clinic_id", referencedColumnName = "id")
    @ManyToOne
    private Clinic clinicId;
    @JoinColumn(name = "servicelist_id", referencedColumnName = "id")
    @ManyToOne
    private Servicelist servicelistId;

    public Clinicservice() {
    }

    public Clinicservice(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Clinic getClinicId() {
        return clinicId;
    }

    public void setClinicId(Clinic clinicId) {
        this.clinicId = clinicId;
    }

    public Servicelist getServicelistId() {
        return servicelistId;
    }

    public void setServicelistId(Servicelist servicelistId) {
        this.servicelistId = servicelistId;
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
        if (!(object instanceof Clinicservice)) {
            return false;
        }
        Clinicservice other = (Clinicservice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.domain.Clinicservice[ id=" + id + " ]";
    }
    
}
