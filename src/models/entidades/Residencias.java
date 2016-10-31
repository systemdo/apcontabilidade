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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "residencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Residencias.findAll", query = "SELECT r FROM Residencias r"),
    @NamedQuery(name = "Residencias.findByIdResidencia", query = "SELECT r FROM Residencias r WHERE r.idResidencia = :idResidencia"),
    @NamedQuery(name = "Residencias.findByNmResidencia", query = "SELECT r FROM Residencias r WHERE r.nmResidencia = :nmResidencia")})
public class Residencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idResidencia")
    private Integer idResidencia;
    @Basic(optional = false)
    @Column(name = "nmResidencia")
    private String nmResidencia;
    @OneToMany(mappedBy = "idResidencia")
    private Collection<ResidenciasUsuarios> residenciasUsuariosCollection;
    @OneToMany(mappedBy = "idResidencia")
    private Collection<Despesas> despesasCollection;

    public Residencias() {
    }

    public Residencias(Integer idResidencia) {
        this.idResidencia = idResidencia;
    }

    public Residencias(Integer idResidencia, String nmResidencia) {
        this.idResidencia = idResidencia;
        this.nmResidencia = nmResidencia;
    }

    public Integer getIdResidencia() {
        return idResidencia;
    }

    public void setIdResidencia(Integer idResidencia) {
        this.idResidencia = idResidencia;
    }

    public String getNmResidencia() {
        return nmResidencia;
    }

    public void setNmResidencia(String nmResidencia) {
        this.nmResidencia = nmResidencia;
    }

    @XmlTransient
    public Collection<ResidenciasUsuarios> getResidenciasUsuariosCollection() {
        return residenciasUsuariosCollection;
    }

    public void setResidenciasUsuariosCollection(Collection<ResidenciasUsuarios> residenciasUsuariosCollection) {
        this.residenciasUsuariosCollection = residenciasUsuariosCollection;
    }

    @XmlTransient
    public Collection<Despesas> getDespesasCollection() {
        return despesasCollection;
    }

    public void setDespesasCollection(Collection<Despesas> despesasCollection) {
        this.despesasCollection = despesasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResidencia != null ? idResidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Residencias)) {
            return false;
        }
        Residencias other = (Residencias) object;
        if ((this.idResidencia == null && other.idResidencia != null) || (this.idResidencia != null && !this.idResidencia.equals(other.idResidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Residencias[ idResidencia=" + idResidencia + " ]";
    }
    
}
