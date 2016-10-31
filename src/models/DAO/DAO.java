/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

/**
 *
 * @author lucas
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {

    protected EntityManager em;  
    public DAO(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Ap_pgracaPU");
         em = factory.createEntityManager();
    }
    
    protected EntityManager getEm(){
        return em;
    }
    
    public Object salvar(Object obj)throws Exception{
          try {
            em.getTransaction().begin();
            if(obj instanceof models.entidades.DespesasMeses ){
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


}
