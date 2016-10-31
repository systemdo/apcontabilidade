/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import models.DAO.DespesasDAO;
import models.DAO.DespesasMesesDAO;
import models.DAO.MesesDAO;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "despesas_meses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DespesasMeses.findAll", query = "SELECT d FROM DespesasMeses d"),
    @NamedQuery(name = "DespesasMeses.findByIdDespesaMes", query = "SELECT d FROM DespesasMeses d WHERE d.idDespesaMes = :idDespesaMes"),
    @NamedQuery(name = "DespesasMeses.findByAno", query = "SELECT d FROM DespesasMeses d WHERE d.ano = :ano"),
    @NamedQuery(name = "DespesasMeses.findByValor", query = "SELECT d FROM DespesasMeses d WHERE d.valor = :valor"),
    @NamedQuery(name = "DespesasMeses.findByDtDiaInserido", query = "SELECT d FROM DespesasMeses d WHERE d.dtDiaInserido = :dtDiaInserido")})
public class DespesasMeses extends DespesasMesesDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDespesaMes")
    private Integer idDespesaMes;
    @Column(name = "ano")
    private String ano;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @Basic(optional = false)
    @Column(name = "dtDiaInserido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtDiaInserido;
    @JoinColumn(name = "idMes", referencedColumnName = "idMes")
    @ManyToOne
    private Meses idMes;
    @JoinColumn(name = "idDespesa", referencedColumnName = "idDespesa")
    @ManyToOne
    private Despesas idDespesa;

    public DespesasMeses() {
    }

    public DespesasMeses(Integer idDespesaMes) {
        this.idDespesaMes = idDespesaMes;
    }

    public DespesasMeses(Integer idDespesaMes, Date dtDiaInserido) {
        this.idDespesaMes = idDespesaMes;
        this.dtDiaInserido = dtDiaInserido;
    }

    public Integer getIdDespesaMes() {
        return idDespesaMes;
    }

    public void setIdDespesaMes(Integer idDespesaMes) {
        this.idDespesaMes = idDespesaMes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Date getDtDiaInserido() {
        return dtDiaInserido;
    }

    public void setDtDiaInserido(Date dtDiaInserido) {
        this.dtDiaInserido = dtDiaInserido;
    }

    public Meses getIdMes() {
        return idMes;
    }

    public void setIdMes(Meses idMes) {
        this.idMes = idMes;
    }

    public Despesas getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(Despesas idDespesa) {
        this.idDespesa = idDespesa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDespesaMes != null ? idDespesaMes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DespesasMeses)) {
            return false;
        }
        DespesasMeses other = (DespesasMeses) object;
        if ((this.idDespesaMes == null && other.idDespesaMes != null) || (this.idDespesaMes != null && !this.idDespesaMes.equals(other.idDespesaMes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.DespesasMeses[ idDespesaMes=" + idDespesaMes + " ]";
    }
    
}
