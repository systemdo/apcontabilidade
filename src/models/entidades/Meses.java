/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entidades;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "meses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meses.findAll", query = "SELECT m FROM Meses m"),
    @NamedQuery(name = "Meses.findByIdMes", query = "SELECT m FROM Meses m WHERE m.idMes = :idMes"),
    @NamedQuery(name = "Meses.findByNmMes", query = "SELECT m FROM Meses m WHERE m.nmMes = :nmMes")})
public class Meses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idMes")
    private Integer idMes;
    @Basic(optional = false)
    @Column(name = "nmMes")
    private String nmMes;
    @OneToMany(mappedBy = "idMes")
    private Collection<DespesasMeses> despesasMesesCollection;

    public Meses() {
    }

    public Meses(Integer idMes) {
        this.idMes = idMes;
    }

    public Meses(Integer idMes, String nmMes) {
        this.idMes = idMes;
        this.nmMes = nmMes;
    }

    public Integer getIdMes() {
        return idMes;
    }

    public void setIdMes(Integer idMes) {
        this.idMes = idMes;
    }

    public String getNmMes() {
        return nmMes;
    }

    public void setNmMes(String nmMes) {
        this.nmMes = nmMes;
    }

    @XmlTransient
    public Collection<DespesasMeses> getDespesasMesesCollection() {
        return despesasMesesCollection;
    }

    public void setDespesasMesesCollection(Collection<DespesasMeses> despesasMesesCollection) {
        this.despesasMesesCollection = despesasMesesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMes != null ? idMes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meses)) {
            return false;
        }
        Meses other = (Meses) object;
        if ((this.idMes == null && other.idMes != null) || (this.idMes != null && !this.idMes.equals(other.idMes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Meses[ idMes=" + idMes + " ]";
    }
    
}
