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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import models.DAO.DespesasDAO;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "despesas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Despesas.findAll", query = "SELECT d FROM Despesas d"),
    @NamedQuery(name = "Despesas.findByIdDespesa", query = "SELECT d FROM Despesas d WHERE d.idDespesa = :idDespesa"),
    @NamedQuery(name = "Despesas.findByNmDespesa", query = "SELECT d FROM Despesas d WHERE d.nmDespesa = :nmDespesa")})
public class Despesas extends DespesasDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDespesa")
    private Integer idDespesa;
    @Column(name = "nmDespesa")
    private String nmDespesa;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "idDespesa")
    private Collection<DespesasMeses> despesasMesesCollection;
    @JoinColumn(name = "idTiposVariacaoDespesa", referencedColumnName = "idTiposVariacaoDespesa")
    @ManyToOne
    private TiposVariacaoDespesa idTiposVariacaoDespesa;
    @JoinColumn(name = "idDespesaCategoria", referencedColumnName = "idDespesaCategoria")
    @ManyToOne
    private DespesasCategorias idDespesaCategoria;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuarios idUsuario;
    @JoinColumn(name = "idResidencia", referencedColumnName = "idResidencia")
    @ManyToOne
    private Residencias idResidencia;

    public Despesas() {
    }

    public Despesas(Integer idDespesa) {
        this.idDespesa = idDespesa;
    }

    public Integer getIdDespesa() {
        return idDespesa;
    }
    public Integer getId() {
        return idDespesa;
    }

    public void setIdDespesa(Integer idDespesa) {
        this.idDespesa = idDespesa;
    }

    public String getNmDespesa() {
        return nmDespesa;
    }

    public void setNmDespesa(String nmDespesa) {
        this.nmDespesa = nmDespesa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<DespesasMeses> getDespesasMesesCollection() {
        return despesasMesesCollection;
    }

    public void setDespesasMesesCollection(Collection<DespesasMeses> despesasMesesCollection) {
        this.despesasMesesCollection = despesasMesesCollection;
    }

    public TiposVariacaoDespesa getIdTiposVariacaoDespesa() {
        return idTiposVariacaoDespesa;
    }

    public void setIdTiposVariacaoDespesa(TiposVariacaoDespesa idTiposVariacaoDespesa) {
        this.idTiposVariacaoDespesa = idTiposVariacaoDespesa;
    }

    public DespesasCategorias getIdDespesaCategoria() {
        return idDespesaCategoria;
    }

    public void setIdDespesaCategoria(DespesasCategorias idDespesaCategoria) {
        this.idDespesaCategoria = idDespesaCategoria;
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
        hash += (idDespesa != null ? idDespesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Despesas)) {
            return false;
        }
        Despesas other = (Despesas) object;
        if ((this.idDespesa == null && other.idDespesa != null) || (this.idDespesa != null && !this.idDespesa.equals(other.idDespesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Despesas[ idDespesa=" + idDespesa + " ]";
    }


    
}
