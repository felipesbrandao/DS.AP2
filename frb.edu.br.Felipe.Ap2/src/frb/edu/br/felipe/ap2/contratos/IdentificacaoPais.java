
package frb.edu.br.felipe.ap2.contratos;

import frb.edu.br.felipe.ap2.entidades.Pais;

import java.util.List;

public interface IdentificacaoPais {

    boolean inserir(Pais pais);

    boolean alterar(Pais pais);

    boolean excluir(int id);

    Pais getRegistroPorId(int id);

    List<Pais> getListaDeTodosRegistros();
}
