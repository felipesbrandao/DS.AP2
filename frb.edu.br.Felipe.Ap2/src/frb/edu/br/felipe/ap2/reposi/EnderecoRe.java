
package frb.edu.br.felipe.ap2.reposi;

import frb.edu.br.felipe.ap2.contratos.IdentificacaoEndereco;
import frb.edu.br.felipe.ap2.contratos.IdentificacaoPais;
import frb.edu.br.felipe.ap2.entidades.Cidade;
import frb.edu.br.felipe.ap2.entidades.Endereco;
import frb.edu.br.felipe.ap2.entidades.Pais;
import frb.edu.br.felipe.ap2.infra.data.DaoUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class EnderecoRe extends DaoUtil implements IdentificacaoEndereco {

    public boolean inserir(Endereco endereco) {

        String sql = "INSERT INTO endereco (endereco, endereco2, bairro, cidade_id, cep, telefone, ultima_atualizacao)" +  " VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement;

        int retorno = -1;

        try {

            statement = getPreparedStatement(sql);

            statement.setString(1, endereco.getEndereco());
            statement.setString(2, endereco.getEndereco2());
            statement.setString(3, endereco.getBairro());
            statement.setLong(4, endereco.getCidade().getCidade_id());
            statement.setString(5, endereco.getCep());
            statement.setString(6, endereco.getTelefone());
            statement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

            retorno = statement.executeUpdate();
            statement.close();

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(EnderecoRe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(EnderecoRe.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno > 0;
    }

    public boolean alterar(Endereco endereco) {

        String sql = "UPDATE endereco SET endereco = ?, endereco2 = ?, bairro = ?, cidade_id = ?, cep = ?, telefone = ?, ultima_atualizacao = ? WHERE endereco_id = ?";

        PreparedStatement statement;

        int retorno = -1;

        try {

            statement = getPreparedStatement(sql);

            statement.setString(1, endereco.getEndereco());
            statement.setString(2, endereco.getEndereco2());
            statement.setString(3, endereco.getBairro());
            statement.setLong(4, endereco.getCidade().getCidade_id());
            statement.setString(5, endereco.getCep());
            statement.setString(6, endereco.getTelefone());
            statement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            statement.setLong(8, endereco.getEndereco_id());

            retorno = statement.executeUpdate();
            statement.close();

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(EnderecoRe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(EnderecoRe.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno > 0;
    }

    public boolean excluir(Long id) {

        String sql = "DELETE FROM endereco WHERE endereco_id = ?";

        PreparedStatement statement;

        int retorno = -1;

        try {

            statement = getPreparedStatement(sql);
            statement.setLong(1, id);
            retorno = statement.executeUpdate();
            statement.close();
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(EnderecoRe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(EnderecoRe.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno > 0;
    }

    public Endereco getRegistroPorId(Long id) {

        Endereco endereco = new Endereco();

        String sql = "SELECT endereco_id, endereco, endereco2, bairro, cidade_id, cep, telefone, ultima_atualizacao FROM endereco WHERE endereco_id = ?";

        try {

            PreparedStatement statement = super.getPreparedStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                endereco = new Endereco(resultSet.getLong("endereco_id"),
                                        resultSet.getString("endereco"),
                                        resultSet.getString("endereco2"),
                                        resultSet.getString("bairro"),
                                        new Cidade((int) resultSet.getLong("cidade_id")),
                                        resultSet.getString("cep"),
                                        resultSet.getString("telefone"),
                                        resultSet.getTimestamp("ultima_atualizacao"));
            }

            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(EnderecoRe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(EnderecoRe.class.getName()).log(Level.SEVERE, null, ex);
        }

        return endereco;
    }

    public List<Endereco> getListaDeTodosRegistros() {

        List<Endereco> enderecos = new LinkedList<Endereco>();
        String sql = "SELECT endereco_id, endereco, endereco2, bairro, cidade_id, cep, telefone, ultima_atualizacao FROM endereco ";

        try {
            PreparedStatement statement = super.getPreparedStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                enderecos.add( new Endereco(resultSet.getLong("endereco_id"),
                                            resultSet.getString("endereco"),
                                            resultSet.getString("endereco2"),
                                            resultSet.getString("bairro"),
                                             new Cidade((int) resultSet.getLong("cidade_id")),
                                            resultSet.getString("cep"),
                                            resultSet.getString("telefone"),
                                            resultSet.getTimestamp("ultima_atualizacao")));
            }

            resultSet.close();
            statement.close();
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(EnderecoRe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(EnderecoRe.class.getName()).log(Level.SEVERE, null, ex);
        }

        return enderecos;
    }

    /**
     *
     * @param endereco
     * @return
     */
    @Override
    public boolean inserir(Endereco endereco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param endereco
     * @return
     */
    @Override
    public boolean alterar(Endereco endereco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Endereco getRegistroPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
