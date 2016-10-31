/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import models.entidades.Despesas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author lsmarques 
 */

public class DespesasDAO extends DAO {
       
        public Object salvar(Despesas obj)throws Exception{
          try {
            em.getTransaction().begin();
            if(obj.getId() == null ){
                em.persist(obj);
            }else{
                if(!em.contains(obj)){
                    if(em.find(obj.getClass(), obj.getId()) == null){
                        throw new Exception("Erro em atualizar "+ obj.getClass() +" !");
                    }
                }
                obj = em.merge(obj); 
            }
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return obj;
    }
        
    public List<Despesas> getDespesas(){
        List <Despesas> despesaslista;
        despesaslista = em.createQuery("Select d from Despesas as d" )
                .getResultList();
         
         return despesaslista;
    }
    
    public List<Despesas> getDespesasPorMes(int idMes){
        Despesas despesas = new Despesas();
        String query = "Select d from Despesas as d "
                + "left join DespesasMeses dm "
                + "on d.idDespesa = dm.idDespesas"
                + "WHERE dm.idMes="+idMes; 
        
        List <Despesas> despesaslista;
        despesaslista = em.createQuery(query)
                .getResultList();
         
        return despesaslista;
    }
} 
