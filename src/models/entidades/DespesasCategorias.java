/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "despesas_categorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DespesasCategorias.findAll", query = "SELECT d FROM DespesasCategorias d"),
    @NamedQuery(name = "DespesasCategorias.findByIdDespesaCategoria", query = "SELECT d FROM DespesasCategorias d WHERE d.idDespesaCategoria = :idDespesaCategoria"),
    @NamedQuery(name = "DespesasCategorias.findByNmDespesaCategoria", query = "SELECT d FROM DespesasCategorias d WHERE d.nmDespesaCategoria = :nmDespesaCategoria")})
public class DespesasCategorias implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDespesaCategoria")
    private Integer idDespesaCategoria;
    @Basic(optional = false)
    @Column(name = "nmDespesaCategoria")
    private String nmDespesaCategoria;
    @OneToMany(mappedBy = "idDespesaCategoria")
    private Collection<Despesas> despesasCollection;

    public DespesasCategorias() {
    }

    public DespesasCategorias(Integer idDespesaCategoria) {
        this.idDespesaCategoria = idDespesaCategoria;
    }

    public DespesasCategorias(Integer idDespesaCategoria, String nmDespesaCategoria) {
        this.idDespesaCategoria = idDespesaCategoria;
        this.nmDespesaCategoria = nmDespesaCategoria;
    }

    public Integer getIdDespesaCategoria() {
        return idDespesaCategoria;
    }

    public void setIdDespesaCategoria(Integer idDespesaCategoria) {
        Integer oldIdDespesaCategoria = this.idDespesaCategoria;
        this.idDespesaCategoria = idDespesaCategoria;
        changeSupport.firePropertyChange("idDespesaCategoria", oldIdDespesaCategoria, idDespesaCategoria);
    }

    public String getNmDespesaCategoria() {
        return nmDespesaCategoria;
    }

    public void setNmDespesaCategoria(String nmDespesaCategoria) {
        String oldNmDespesaCategoria = this.nmDespesaCategoria;
        this.nmDespesaCategoria = nmDespesaCategoria;
        changeSupport.firePropertyChange("nmDespesaCategoria", oldNmDespesaCategoria, nmDespesaCategoria);
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
        hash += (idDespesaCategoria != null ? idDespesaCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DespesasCategorias)) {
            return false;
        }
        DespesasCategorias other = (DespesasCategorias) object;
        if ((this.idDespesaCategoria == null && other.idDespesaCategoria != null) || (this.idDespesaCategoria != null && !this.idDespesaCategoria.equals(other.idDespesaCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.DespesasCategorias[ idDespesaCategoria=" + idDespesaCategoria + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
