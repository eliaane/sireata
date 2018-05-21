package br.edu.utfpr.dv.sireata.bo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.utfpr.dv.sireata.dao.AnexoDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.SalvarDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.anexo.AnexoBuscarPorIdDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.anexo.AnexoCarregarObjetoDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.anexo.AnexoExcluirDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.anexo.AnexoListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.anexo.AnexoSalvarDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;
import br.edu.utfpr.dv.sireata.model.EntityDAO;

public class AnexoBO {
    
    private AnexoDAO dao;
    
    public AnexoBO() {
        dao = new AnexoDAO(
                new AnexoBuscarPorIdDAO(),
                new AnexoCarregarObjetoDAO(), 
                new AnexoExcluirDAO(), 
                new AnexoListarPorAtaDAO(), 
                new AnexoSalvarDAO()
        );
    }
    
    

	public EntityDAO buscarPorId(int id) throws Exception{
		try{
			
                    return dao.buscarPorId(id);
                    
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public List<EntityDAO> listarPorAta(int idAta) throws Exception{
		try{
					
                    return dao.listarPorAta(idAta);
                    
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public void validarDados(Anexo anexo) throws Exception{
		if(anexo.getArquivo() == null){
			throw new Exception("Efetue o envio do arquivo.");
		}
		if(anexo.getDescricao().isEmpty()){
			throw new Exception("Informe a descrição do anexo.");
		}
	}
	
	public int salvar(Anexo anexo) throws Exception{
		try{
			if((anexo.getAta() == null) || (anexo.getAta().getIdAta() == 0)){
				throw new Exception("Informe a ata.");
			}
			
			this.validarDados(anexo);
			
			return dao.salvar(anexo);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
	public void excluir(Anexo anexo) throws Exception{
		this.excluir(anexo.getIdAnexo());
	}
	
	public void excluir(int id) throws Exception{
		try{
			
			dao.excluir(id);
		}catch(Exception e){
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			
			throw new Exception(e.getMessage());
		}
	}
	
}
