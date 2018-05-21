package br.edu.utfpr.dv.sireata.dao.algorithms.anexo;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;
import br.edu.utfpr.dv.sireata.model.EntityDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Liah Beeshop'
 */
public class AnexoListarPorAtaDAO implements ListarPorAtaDAO{

    @Override
    public List<EntityDAO> listarPorAta(int idAta) throws SQLException{
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            AnexoCarregarObjetoDAO carregarObjeto = new AnexoCarregarObjetoDAO();

            try{
                    conn = ConnectionDAO.getInstance().getConnection();
                    stmt = conn.createStatement();

                    rs = stmt.executeQuery("SELECT anexos.* FROM anexos " +
                            "WHERE idAta=" + String.valueOf(idAta) + " ORDER BY anexos.ordem");

                    List<EntityDAO> list = new ArrayList<EntityDAO>();

                    while(rs.next()){
                            list.add(carregarObjeto.carregarObjeto(rs));
                    }

                    return list;
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
