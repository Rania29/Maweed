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
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a")
    , @NamedQuery(name = "Area.findById", query = "SELECT a FROM Area a WHERE a.id = :id")
    , @NamedQuery(name = "Area.findByName", query = "SELECT a FROM Area a WHERE a.name = :name")
    , @NamedQuery(name = "Area.findNameSorted", query = "SELECT a.name FROM Area a order by a.name")
    , @NamedQuery(name = "Area.findArabicNameSorted", query = "SELECT a.inarabic FROM Area a order by a.inarabic")})
public class Area implements Serializable {

    @Size(max = 255)
    @Column(name = "inarabic")
    private String inarabic;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "areaId")
    private Collection<Hospital> hospitalCollection;

    public Area() {
    }

    public Area(Long id) {
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
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getInarabic() {
        return inarabic;
    }

    public void setInarabic(String inarabic) {
        this.inarabic = inarabic;
    }

    @Override
    public String toString() {
        return name;
    }

}
