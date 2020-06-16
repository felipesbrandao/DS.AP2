
package frb.edu.br.felipe.ap2.contratos;

import frb.edu.br.felipe.ap2.entidades.Cidade;

import java.util.List;

public interface IdentificacaoCidade {

    boolean inserir(Cidade cidade);

    boolean alterar(Cidade cidade);

    boolean excluir(int id);

    Cidade getRegistroPorId(int id);

    List<Cidade> getListaDeTodosRegistros();
}
