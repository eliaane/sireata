package br.edu.utfpr.dv.sireata.dao;

import br.edu.utfpr.dv.sireata.dao.algorithms.BuscarPorIdDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.CarregarObjetoDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ExcluirDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.ListarPorAtaDAO;
import br.edu.utfpr.dv.sireata.dao.algorithms.SalvarDAO;

public class AnexoDAO extends FullDAO{

    public AnexoDAO(BuscarPorIdDAO buscar, CarregarObjetoDAO carregar, ExcluirDAO excluir, ListarPorAtaDAO listar, SalvarDAO salvar) {
        this.buscar = buscar;
        this.carregar = carregar;
        this.excluir = excluir;
        this.listar = listar;
        this.salvar = salvar;
    }    
}   