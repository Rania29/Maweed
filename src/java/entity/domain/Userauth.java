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
@Table(name = "userauth")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userauth.findAll", query = "SELECT u FROM Userauth u")
    , @NamedQuery(name = "Userauth.findById", query = "SELECT u FROM Userauth u WHERE u.id = :id")
    , @NamedQuery(name = "Userauth.findByEmail", query = "SELECT u FROM Userauth u WHERE u.email = :email")
    , @NamedQuery(name = "Userauth.findByPassword", query = "SELECT u FROM Userauth u WHERE u.password = :password")
    , @NamedQuery(name = "Userauth.findByUsername", query = "SELECT u FROM Userauth u WHERE u.username = :username")})
public class Userauth implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 255)
    @Column(name = "username")
    private String username;
    @ManyToMany(mappedBy = "userauthCollection")
    private Collection<Groupauth> groupauthCollection;
    @JoinColumn(name = "hospital_id", referencedColumnName = "id")
    @ManyToOne
    private Hospital hospitalId;

    public Userauth() {
    }

    public Userauth(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlTransient
    public Collection<Groupauth> getGroupauthCollection() {
        return groupauthCollection;
    }

    public void setGroupauthCollection(Collection<Groupauth> groupauthCollection) {
        this.groupauthCollection = groupauthCollection;
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
        if (!(object instanceof Userauth)) {
            return false;
        }
        Userauth other = (Userauth) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.domain.Userauth[ id=" + id + " ]";
    }
    
}
