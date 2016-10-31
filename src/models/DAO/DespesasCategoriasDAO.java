/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import models.entidades.DespesasCategorias;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.entidades.Despesas;

/**
 *
 * @author lsmarques
 */
public class DespesasCategoriasDAO extends DAO{
    
    public List<DespesasCategorias> getDespesasCategorias(){
        DespesasCategorias despesasCategorias = new DespesasCategorias();
        List <DespesasCategorias> despesasCategoriaslista;
        despesasCategoriaslista = em.createQuery("Select d from DespesasCategorias as d" )
                .getResultList();
         /*for (DespesasCategorias dC : despesasCategoriaslista) {
            System.out.println(dC.getNmDespesaCategoria());
         }*/
         return despesasCategoriaslista;
    }
}
