/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dv.sireata.dao.algorithms;

import br.edu.utfpr.dv.sireata.model.EntityDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Liah Beeshop'
 */
public interface ListarPorAtaDAO {
    
    public List<EntityDAO> listarPorAta(int idAta) throws SQLException;
    
}
