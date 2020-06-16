
package frb.edu.br.felipe.ap2.entidades;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Cidade implements Serializable {

    private int cidade_id;

    private String cidade;

    private Pais pais;

    private Timestamp ultima_atualizacao;

    public int getCidade_id() {
        return cidade_id;
    }

    public void setCidade_id(int cidade_id) {
        this.cidade_id = cidade_id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Timestamp getUltima_atualizacao() {
        return ultima_atualizacao;
    }

    public void setUltima_atualizacao(Timestamp ultima_atualizacao) {
        this.ultima_atualizacao = ultima_atualizacao;
    }

    public Cidade() {
    }

    public Cidade(int cidade_id) {
        this.cidade_id = cidade_id;
    }

    public Cidade(int cidade_id, String cidade, Pais pais, Timestamp ultima_atualizacao) {
        this.cidade_id = cidade_id;
        this.cidade = cidade;
        this.pais = pais;
        this.ultima_atualizacao = ultima_atualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(cidade_id, cidade.cidade_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cidade_id);
    }
}
