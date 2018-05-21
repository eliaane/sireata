/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dv.sireata.dao;

import br.edu.utfpr.dv.sireata.dao.algorithms.BuscarPorIdDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.CarregarObjetoDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ExcluirDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.SalvarDAO;
import br.edu.utfpr.dv.sireata.model.EntityDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Liah Beeshop'
 */
public abstract class FullDAO {
    
    protected BuscarPorIdDAO buscar;
    protected CarregarObjetoDAO carregar;
    protected ExcluirDAO excluir;
    protected ListarPorAtaDAO listar;
    protected SalvarDAO salvar;
    
    public EntityDAO buscarPorId(int id) throws SQLException{
        return buscar.buscarPorId(id);
    }
    
    public EntityDAO carregarObjeto(ResultSet rs) throws SQLException{
        return carregar.carregarObjeto(rs);
    }
    
    public void excluir(int id) throws SQLException{
        excluir.excluir(id);
    }
    
    public List<EntityDAO> listarPorAta(int idAta) throws SQLException{
        return listar.listarPorAta(idAta);
    }

    public int salvar(EntityDAO entity) throws SQLException{
        return salvar.salvar(entity);
    }
   
}
