
package frb.edu.br.felipe.ap2.infra.controladores;

import frb.edu.br.felipe.ap2.contratos.IdentificacaoPais;
import frb.edu.br.felipe.ap2.entidades.Pais;
import frb.edu.br.felipe.ap2.reposi.PaisRe;


import java.util.List;


public class ControlePais {

    private Pais pais;
    private List<Pais> paises = null;
    private final IdentificacaoPais PaisRe = new PaisRe();

    public ControlePais() {

    }

    public List<Pais> getPaises() {

        if(paises == null){
            paises = PaisRe.getListaDeTodosRegistros();
        }
        return paises;
    }

    public String prepararInclusao(){

        pais = new Pais();

        return "vaiParaIncluir";
    }

    public String finalizaInclusao(){

        PaisRe.inserir(pais);
        pais = null;
        paises = null;

        return "listagem-pais";
    }

    public String finalizaEdicao(){

      PaisRe.alterar(pais);
        pais = null;

        return "listagem-pais";
    }

    public String finalizaDelecao(){

        PaisRe.excluir(pais.getPais_id());
        pais = null;
        return "listagem-pais";
    }
}
