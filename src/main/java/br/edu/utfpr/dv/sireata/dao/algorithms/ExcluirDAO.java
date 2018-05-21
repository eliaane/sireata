/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dv.sireata.dao.algorithms;

import java.sql.SQLException;

/**
 *
 * @author Liah Beeshop'
 */
public interface ExcluirDAO {
    
    public void excluir(int id) throws SQLException;
    
}
