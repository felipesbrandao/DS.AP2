
package frb.edu.br.felipe.ap2.infra.controladores;

import frb.edu.br.felipe.ap2.contratos.IdentificacaoCidade;
import frb.edu.br.felipe.ap2.entidades.Cidade;
import frb.edu.br.felipe.ap2.reposi.CidadeRe;

import java.util.List;

public class ControleCidade{

    private Cidade cidade;
    private List<Cidade> cidades = null;
    private IdentificacaoCidade CidadeRe = (IdentificacaoCidade) new CidadeRe() {};

    public ControleCidade() {

    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {

        if(cidades == null){
            cidades = CidadeRe.getListaDeTodosRegistros();
        }
        return cidades;
    }

    public String prepararInclusao(){

        cidade = new Cidade ();

        return "inclua";
    }

    public String finalizaInclusao(){

        CidadeRe.inserir(cidade);
        cidade = null;

        return "voltarListagem";
    }

    public String finalizaEdicao(){

        CidadeRe.alterar(cidade);
        cidade = null;

        return "voltaListagem";
    }

    public String finalizaDelecao(){

        CidadeRe.excluir(cidade.getCidade_id());
        cidade = null;
        return "refresh";
    }
}
