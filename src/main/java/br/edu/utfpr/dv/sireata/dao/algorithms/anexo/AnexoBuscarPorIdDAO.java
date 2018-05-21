package br.edu.utfpr.dv.sireata.dao.algorithms.anexo;

import br.edu.utfpr.dv.sireata.model.EntityDAO;
import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.BuscarPorIdDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Liah Beeshop'
 */
public class AnexoBuscarPorIdDAO implements BuscarPorIdDAO{
    
    @Override
    public EntityDAO buscarPorId(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AnexoCarregarObjetoDAO carregarObjeto = new AnexoCarregarObjetoDAO();

    try{
            conn = ConnectionDAO.getInstance().getConnection();
            stmt = conn.prepareStatement("SELECT anexos.* FROM anexos " +
                    "WHERE idAnexo = ?");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if(rs.next()){
                    return carregarObjeto.carregarObjeto(rs);
            }else{
                return null;
            }
    }finally{
            if((rs != null) && !rs.isClosed())
                    rs.close();
            if((stmt != null) && !stmt.isClosed())
                    stmt.close();
            if((conn != null) && !conn.isClosed())
                    conn.close();
    }
}

}
