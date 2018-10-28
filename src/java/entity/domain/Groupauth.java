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
@Table(name = "groupauth")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupauth.findAll", query = "SELECT g FROM Groupauth g")
    , @NamedQuery(name = "Groupauth.findById", query = "SELECT g FROM Groupauth g WHERE g.id = :id")
    , @NamedQuery(name = "Groupauth.findByGroupname", query = "SELECT g FROM Groupauth g WHERE g.groupname = :groupname")})
public class Groupauth implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "groupname")
    private String groupname;
    @JoinTable(name = "userauth_groupauth", joinColumns = {
        @JoinColumn(name = "groupauths_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "userauths_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Userauth> userauthCollection;

    public Groupauth() {
    }

    public Groupauth(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    @XmlTransient
    public Collection<Userauth> getUserauthCollection() {
        return userauthCollection;
    }

    public void setUserauthCollection(Collection<Userauth> userauthCollection) {
        this.userauthCollection = userauthCollection;
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
        if (!(object instanceof Groupauth)) {
            return false;
        }
        Groupauth other = (Groupauth) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.domain.Groupauth[ id=" + id + " ]";
    }
    
}
