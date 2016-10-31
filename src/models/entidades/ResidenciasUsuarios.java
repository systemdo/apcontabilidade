/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "residencias_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResidenciasUsuarios.findAll", query = "SELECT r FROM ResidenciasUsuarios r"),
    @NamedQuery(name = "ResidenciasUsuarios.findByIdResidenciasUsuario", query = "SELECT r FROM ResidenciasUsuarios r WHERE r.idResidenciasUsuario = :idResidenciasUsuario")})
public class ResidenciasUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idResidenciasUsuario")
    private Integer idResidenciasUsuario;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuarios idUsuario;
    @JoinColumn(name = "idResidencia", referencedColumnName = "idResidencia")
    @ManyToOne
    private Residencias idResidencia;

    public ResidenciasUsuarios() {
    }

    public ResidenciasUsuarios(Integer idResidenciasUsuario) {
        this.idResidenciasUsuario = idResidenciasUsuario;
    }

    public Integer getIdResidenciasUsuario() {
        return idResidenciasUsuario;
    }

    public void setIdResidenciasUsuario(Integer idResidenciasUsuario) {
        this.idResidenciasUsuario = idResidenciasUsuario;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Residencias getIdResidencia() {
        return idResidencia;
    }

    public void setIdResidencia(Residencias idResidencia) {
        this.idResidencia = idResidencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResidenciasUsuario != null ? idResidenciasUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResidenciasUsuarios)) {
            return false;
        }
        ResidenciasUsuarios other = (ResidenciasUsuarios) object;
        if ((this.idResidenciasUsuario == null && other.idResidenciasUsuario != null) || (this.idResidenciasUsuario != null && !this.idResidenciasUsuario.equals(other.idResidenciasUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.ResidenciasUsuarios[ idResidenciasUsuario=" + idResidenciasUsuario + " ]";
    }
    
}
