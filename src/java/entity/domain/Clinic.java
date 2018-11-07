package entity.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "clinic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clinic.findAll", query = "SELECT c FROM Clinic c")
    , @NamedQuery(name = "Clinic.findById", query = "SELECT c FROM Clinic c WHERE c.id = :id")
    , @NamedQuery(name = "Clinic.findByWorkingdayshours", query = "SELECT c FROM Clinic c WHERE c.workingdayshours = :workingdayshours")
    , @NamedQuery(name = "Clinic.findClinicByCat", query = "SELECT c FROM Clinic c WHERE c.categoryId = :categoryId")})
public class Clinic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "workingdayshours")
    private String workingdayshours;
    @OneToMany(mappedBy = "clinicId")
    private Collection<Clinicservice> clinicserviceCollection;
    @OneToMany(mappedBy = "clinicId")
    private Collection<Doctor> doctorCollection;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private Category categoryId;
    @JoinColumn(name = "hospital_id", referencedColumnName = "id")
    @ManyToOne
    private Hospital hospitalId;

    public Clinic() {
    }

    public Clinic(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkingdayshours() {
        return workingdayshours;
    }

    public void setWorkingdayshours(String workingdayshours) {
        this.workingdayshours = workingdayshours;
    }

    @XmlTransient
    public Collection<Clinicservice> getClinicserviceCollection() {
        return clinicserviceCollection;
    }

    public void setClinicserviceCollection(Collection<Clinicservice> clinicserviceCollection) {
        this.clinicserviceCollection = clinicserviceCollection;
    }

    @XmlTransient
    public Collection<Doctor> getDoctorCollection() {
        return doctorCollection;
    }

    public void setDoctorCollection(Collection<Doctor> doctorCollection) {
        this.doctorCollection = doctorCollection;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
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
        if (!(object instanceof Clinic)) {
            return false;
        }
        Clinic other = (Clinic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.domain.Clinic[ id=" + id + " ]";
    }

}
