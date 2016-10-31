/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.entidades.TiposVariacaoDespesa;


/**
 *
 * @author lsmarques
 */
public class TiposVariacaoDespesaDAO extends DAO{
    
    public void getDespesasCategorias(){
        TiposVariacaoDespesa tiposVariacaoDespesa = new TiposVariacaoDespesa();
        List <TiposVariacaoDespesa> tiposVariacaoDespesalista;
        tiposVariacaoDespesalista = em.createQuery("Select d from tipos_variacao_despesa as d" )
                .getResultList();
         for(TiposVariacaoDespesa tvd : tiposVariacaoDespesalista) {
            System.out.println(tvd.getNmTiposVariacaoDespesa());
         }
    }
}
