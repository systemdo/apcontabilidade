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
@Table(name = "tipos_variacao_despesa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposVariacaoDespesa.findAll", query = "SELECT t FROM TiposVariacaoDespesa t"),
    @NamedQuery(name = "TiposVariacaoDespesa.findByIdTiposVariacaoDespesa", query = "SELECT t FROM TiposVariacaoDespesa t WHERE t.idTiposVariacaoDespesa = :idTiposVariacaoDespesa"),
    @NamedQuery(name = "TiposVariacaoDespesa.findByNmTiposVariacaoDespesa", query = "SELECT t FROM TiposVariacaoDespesa t WHERE t.nmTiposVariacaoDespesa = :nmTiposVariacaoDespesa")})
public class TiposVariacaoDespesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTiposVariacaoDespesa")
    private Integer idTiposVariacaoDespesa;
    @Basic(optional = false)
    @Column(name = "nmTiposVariacaoDespesa")
    private String nmTiposVariacaoDespesa;
    @OneToMany(mappedBy = "idTiposVariacaoDespesa")
    private Collection<Despesas> despesasCollection;

    public TiposVariacaoDespesa() {
    }

    public TiposVariacaoDespesa(Integer idTiposVariacaoDespesa) {
        this.idTiposVariacaoDespesa = idTiposVariacaoDespesa;
    }

    public TiposVariacaoDespesa(Integer idTiposVariacaoDespesa, String nmTiposVariacaoDespesa) {
        this.idTiposVariacaoDespesa = idTiposVariacaoDespesa;
        this.nmTiposVariacaoDespesa = nmTiposVariacaoDespesa;
    }

    public Integer getIdTiposVariacaoDespesa() {
        return idTiposVariacaoDespesa;
    }

    public void setIdTiposVariacaoDespesa(Integer idTiposVariacaoDespesa) {
        this.idTiposVariacaoDespesa = idTiposVariacaoDespesa;
    }

    public String getNmTiposVariacaoDespesa() {
        return nmTiposVariacaoDespesa;
    }

    public void setNmTiposVariacaoDespesa(String nmTiposVariacaoDespesa) {
        this.nmTiposVariacaoDespesa = nmTiposVariacaoDespesa;
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
        hash += (idTiposVariacaoDespesa != null ? idTiposVariacaoDespesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposVariacaoDespesa)) {
            return false;
        }
        TiposVariacaoDespesa other = (TiposVariacaoDespesa) object;
        if ((this.idTiposVariacaoDespesa == null && other.idTiposVariacaoDespesa != null) || (this.idTiposVariacaoDespesa != null && !this.idTiposVariacaoDespesa.equals(other.idTiposVariacaoDespesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.TiposVariacaoDespesa[ idTiposVariacaoDespesa=" + idTiposVariacaoDespesa + " ]";
    }
    
}
