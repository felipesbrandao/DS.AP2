
package frb.edu.br.felipe.ap2.infra.controladores;

import frb.edu.br.felipe.ap2.contratos.IdentificacaoCidade;
import frb.edu.br.felipe.ap2.contratos.IdentificacaoEndereco;
import frb.edu.br.felipe.ap2.entidades.Cidade;
import frb.edu.br.felipe.ap2.entidades.Endereco;
import frb.edu.br.felipe.ap2.reposi.CidadeRe;
import frb.edu.br.felipe.ap2.reposi.EnderecoRe;


import java.util.List;


public class ControleEndereco  {

    private Endereco endereco;
    private List<Endereco> enderecos;
    private final IdentificacaoEndereco EnderecoRe = new EnderecoRe() {};

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> getEnderecos() {
        return enderecos = EnderecoRe.getListaDeTodosRegistros();
    }

    public String prepararInclusao(){

        endereco = new Endereco();

        return "adicao-endereco";
    }

    public String finalizarInclusao(){

        EnderecoRe.inserir(endereco);
        endereco = null;

        return "listagem-endereco";
    }

    public String finalizarEdicao(){

        EnderecoRe.alterar(endereco);
        endereco = null;

        return "listagem-endereco";
    }

    public String finalizarDelecao(){

        EnderecoRe.excluir(endereco.getEndereco_id());
        endereco = null;

        return "listagem-endereco";
    }
}
