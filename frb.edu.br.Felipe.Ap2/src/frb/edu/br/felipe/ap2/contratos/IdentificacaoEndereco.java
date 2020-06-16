
package frb.edu.br.felipe.ap2.contratos;

import frb.edu.br.felipe.ap2.entidades.Cidade;
import frb.edu.br.felipe.ap2.entidades.Endereco;

import java.util.List;

public interface IdentificacaoEndereco {

    boolean inserir(Endereco endereco);

    boolean alterar(Endereco endereco);

    boolean excluir (int id);

    Endereco getRegistroPorId (int id);

    List<Endereco> getListaDeTodosRegistros();
}
