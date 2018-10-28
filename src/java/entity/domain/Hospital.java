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
@Table(name = "hospital")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospital.findAll", query = "SELECT h FROM Hospital h")
    , @NamedQuery(name = "Hospital.findById", query = "SELECT h FROM Hospital h WHERE h.id = :id")
    , @NamedQuery(name = "Hospital.findByEmail", query = "SELECT h FROM Hospital h WHERE h.email = :email")
    , @NamedQuery(name = "Hospital.findByLocationmap", query = "SELECT h FROM Hospital h WHERE h.locationmap = :locationmap")
    , @NamedQuery(name = "Hospital.findByName", query = "SELECT h FROM Hospital h WHERE h.name = :name")
    , @NamedQuery(name = "Hospital.findByPhoneno", query = "SELECT h FROM Hospital h WHERE h.phoneno = :phoneno")
    , @NamedQuery(name = "Hospital.findByWorkingdayshours", query = "SELECT h FROM Hospital h WHERE h.workingdayshours = :workingdayshours")})
public class Hospital implements Serializable {

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
    @Column(name = "locationmap")
    private String locationmap;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "phoneno")
    private String phoneno;
    @Size(max = 255)
    @Column(name = "workingdayshours")
    private String workingdayshours;
    @JoinTable(name = "insurance_hospital", joinColumns = {
        @JoinColumn(name = "hospitals_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "insurances_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Insurance> insuranceCollection;
    @OneToMany(mappedBy = "hospitalId")
    private Collection<Appointment> appointmentCollection;
    @OneToMany(mappedBy = "hospitalId")
    private Collection<Userauth> userauthCollection;
    @OneToMany(mappedBy = "hospitalId")
    private Collection<Hospitalimage> hospitalimageCollection;
    @OneToMany(mappedBy = "hospitalId")
    private Collection<Clinic> clinicCollection;
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    @ManyToOne
    private Area areaId;

    public Hospital() {
    }

    public Hospital(Long id) {
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

    public String getLocationmap() {
        return locationmap;
    }

    public void setLocationmap(String locationmap) {
        this.locationmap = locationmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getWorkingdayshours() {
        return workingdayshours;
    }

    public void setWorkingdayshours(String workingdayshours) {
        this.workingdayshours = workingdayshours;
    }

    @XmlTransient
    public Collection<Insurance> getInsuranceCollection() {
        return insuranceCollection;
    }

    public void setInsuranceCollection(Collection<Insurance> insuranceCollection) {
        this.insuranceCollection = insuranceCollection;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @XmlTransient
    public Collection<Userauth> getUserauthCollection() {
        return userauthCollection;
    }

    public void setUserauthCollection(Collection<Userauth> userauthCollection) {
        this.userauthCollection = userauthCollection;
    }

    @XmlTransient
    public Collection<Hospitalimage> getHospitalimageCollection() {
        return hospitalimageCollection;
    }

    public void setHospitalimageCollection(Collection<Hospitalimage> hospitalimageCollection) {
        this.hospitalimageCollection = hospitalimageCollection;
    }

    @XmlTransient
    public Collection<Clinic> getClinicCollection() {
        return clinicCollection;
    }

    public void setClinicCollection(Collection<Clinic> clinicCollection) {
        this.clinicCollection = clinicCollection;
    }

    public Area getAreaId() {
        return areaId;
    }

    public void setAreaId(Area areaId) {
        this.areaId = areaId;
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
        if (!(object instanceof Hospital)) {
            return false;
        }
        Hospital other = (Hospital) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.domain.Hospital[ id=" + id + " ]";
    }
    
}
