/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import models.entidades.Despesas;
import models.entidades.DespesasMeses;

/**
 *
 * @author lsmarques
 */
public class DespesasMesesDAO extends DAO{
    public Object salvar(DespesasMeses obj)throws Exception{
          try {
            em.getTransaction().begin();
            if(obj.getIdDespesaMes()== null ){
                em.persist(obj);
            }else{
                if(!em.contains(obj)){
                    if(em.find(obj.getClass(), obj.getIdDespesaMes()) == null){
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
