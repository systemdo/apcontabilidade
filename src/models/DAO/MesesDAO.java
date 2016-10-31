/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import java.util.List;
import models.entidades.Despesas;
import models.entidades.Meses;

/**
 *
 * @author lucas
 */
public class MesesDAO extends DAO{
    public List<Meses> getMeses(){
        List <Meses> meseslista;
        meseslista = em.createQuery("Select d from Meses as d" )
                .getResultList();
         
         return meseslista;
    }
}
