/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.ChamadoCliente;
import Modelo.ChamadoGerente;
import Modelo.ChamadoLivros;
import Modelo.ChamadoPgto;
import java.sql.*; // Importando todos os Comandos SQL do Java.
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Anuli
 */
public class DAO {
    public static final Logger logger = Logger.getLogger(DAO.class.getName());
    
    public void CadastrarCliente(ChamadoCliente chamadoCliente) throws ClassNotFoundException, SQLException{
        String SQL = "INSERT INTO Cliente (nome,email,telefone,senha,idade,cpf) VALUES (?,?,?,?,?,?)";
        
        try(
            Connection conexao = new Conexao().getConnection();
            PreparedStatement ps = conexao.prepareStatement(SQL)){
            ps.setString(1, chamadoCliente.getNome());
            ps.setString(2, chamadoCliente.getEmail());
            ps.setString(3, chamadoCliente.getTelefone());
            ps.setString(4, chamadoCliente.getSenha());
            ps.setString(5, chamadoCliente.getIdade());
            ps.setString(6, chamadoCliente.getCpf());
            ps.executeUpdate();
            logger.log(Level.INFO, "cadastrado com sucesso.");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao cadastrar o chamado", ex);
            throw ex; // Relança a exceção para quem chamou o método tratar
        }
}
    
    
    public void LogarGerente(ChamadoGerente chamadoGerente) throws ClassNotFoundException, SQLException{
        String SQL = "INSERT INTO Gerente (email,senha) values (?,?)";
        try(
            Connection conexao = new Conexao().getConnection();
            PreparedStatement ps = conexao.prepareStatement(SQL)){
            ps.setString(1, chamadoGerente.getEmail());
            ps.setString(1, chamadoGerente.getSenha());
    
        }
    }
    
    public void CadastrarLivros(ChamadoLivros chamadoLivros) throws ClassNotFoundException, SQLException{
        String SQL = "INSERT INTO Livros (titulo,autor,genero,isbn,ano_publicacao,editora,num_paginas,idioma,lido,preco,data_do_cadastro,estoque_fisico) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try(
            Connection conexao = new Conexao().getConnection();
            PreparedStatement ps = conexao.prepareStatement(SQL)){
            ps.setString(1, chamadoLivros.getTitulo());
            ps.setString(2, chamadoLivros.getAutor());
            ps.setString(3, chamadoLivros.getGenero());
            ps.setString(4, chamadoLivros.getIsbn());
            ps.setString(5, chamadoLivros.getAno_publicacao());
            ps.setString(6, chamadoLivros.getEditora());
            ps.setString(7, chamadoLivros.getNum_paginas());
            ps.setString(8, chamadoLivros.getIdioma());
            ps.setString(9, chamadoLivros.getLido());
            ps.setString(10, chamadoLivros.getPreco());
            ps.setString(11, chamadoLivros.getData_do_cadastro());
            ps.setString(12, chamadoLivros.getEstoque_fisico());
            ps.executeUpdate();
            logger.log(Level.INFO, "Livro Registrado.");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao cadastrar o chamado", ex);
            throw ex; // Relança a exceção para quem chamou o método tratar
        }
}
    
    public void RealizarCompra(ChamadoPgto chamadoPgto) throws ClassNotFoundException, SQLException{
        String SQL = "INSERT INTO Compra (titular,numero_cartao,validade,cvv,endereco)VALUES (?,?,?,?,?)";
        
        try(
            Connection conexao = new Conexao().getConnection();
            PreparedStatement ps = conexao.prepareStatement(SQL)){
            ps.setString(1, chamadoPgto.getTitular());
            ps.setString(2, chamadoPgto.getNumero_cartao());
            ps.setString(3, chamadoPgto.getValidade());
            ps.setString(4, chamadoPgto.getCvv());
            ps.setString(5, chamadoPgto.getEndereco());
            ps.executeUpdate();
            logger.log(Level.INFO, "Compra Efetuada.");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao cadastrar o chamado", ex);
            throw ex; // Relança a exceção para quem chamou o método tratar
        }
}
    
    public void PesquisarLivros(ChamadoLivros chamadoLivros) throws ClassNotFoundException, SQLException{
        String SQL = "SELECT * FROM Livros where titulo = ? or idioma = ? or genero = ? or autor = ? or estoque_fisico = ? or ano_publicacao = ? or editora = ?";
        try (Connection conexao = new Conexao().getConnection();
            PreparedStatement ps = conexao.prepareStatement(SQL)){
            ps.setString(1, chamadoLivros.getTitulo());
            ps.setString(6, chamadoLivros.getAno_publicacao());
            ps.setString(2, chamadoLivros.getIdioma());
            ps.setString(3, chamadoLivros.getGenero());
            ps.setString(4, chamadoLivros.getAutor());
            ps.setString(7, chamadoLivros.getEditora());
            ps.setString(5, chamadoLivros.getEstoque_fisico());
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    chamadoLivros.setAno_publicacao(rs.getString("ano_publicacao"));
                    chamadoLivros.setTitulo(rs.getString("titulo"));
                    chamadoLivros.setIdioma(rs.getString("idioma"));
                    chamadoLivros.setGenero(rs.getString("genero"));
                    chamadoLivros.setAutor(rs.getString("autor"));
                    chamadoLivros.setEditora(rs.getString("editora"));
                    chamadoLivros.setEstoque_fisico(rs.getString("estoque_fisico"));
                    logger.log(Level.INFO, "Livro encontrado com sucesso.");
                } else {
                    logger.log(Level.WARNING, "Livro não encontrado.");
                }
                }
            } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao buscar o Livro", ex);
            throw ex;
            }
        }
    
    
     public void BuscarLivros(ChamadoLivros chamadoLivros) throws ClassNotFoundException, SQLException{
        String SQL = "SELECT * FROM Livros where id = ?";
        try (Connection conexao = new Conexao().getConnection();
            PreparedStatement ps = conexao.prepareStatement(SQL)){
            ps.setInt(1, chamadoLivros.getId());
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    chamadoLivros.setTitulo(rs.getString("titulo"));
                    chamadoLivros.setAutor(rs.getString("autor"));
                    chamadoLivros.setGenero(rs.getString("genero"));
                    chamadoLivros.setIsbn(rs.getString("isbn"));
                    chamadoLivros.setAno_publicacao(rs.getString("ano_publicacao"));
                    chamadoLivros.setEditora(rs.getString("editora"));
                    chamadoLivros.setNum_paginas(rs.getString("num_paginas"));
                    chamadoLivros.setIdioma(rs.getString("idioma"));
                    chamadoLivros.setLido(rs.getString("lido"));
                    chamadoLivros.setPreco(rs.getString("preco"));
                    chamadoLivros.setData_do_cadastro(rs.getString("data_do_cadastro"));
                    chamadoLivros.setEstoque_fisico(rs.getString("estoque_fisico"));
                    logger.log(Level.INFO, "Livro encontrado com sucesso.");
                } else {
                    logger.log(Level.WARNING, "Livro não encontrado.");
                }
                }
            } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao buscar o Livro", ex);
            throw ex;
            }
        }
     
     public void AlterarLivros(ChamadoLivros chamadoLivros) throws ClassNotFoundException,SQLException{
         String SQL = "UPDATE Livros SET titulo = ?,autor = ?,genero = ?,isbn = ?,ano_publicacao = ?,editora = ?,num_paginas = ?,idioma = ?,lido = ?,preco = ?,data_do_cadastro = ?,estoque_fisico = ? "+"WHERE id = ?";
         try(Connection conexao = new Conexao().getConnection();
         PreparedStatement ps = conexao.prepareStatement(SQL)){
           ps.setString(1, chamadoLivros.getTitulo());
           ps.setString(2, chamadoLivros.getAutor());
           ps.setString(3, chamadoLivros.getGenero());
           ps.setString(4, chamadoLivros.getIsbn());
           ps.setString(5, chamadoLivros.getAno_publicacao());
           ps.setString(6, chamadoLivros.getEditora());
           ps.setString(7, chamadoLivros.getNum_paginas());
           ps.setString(8, chamadoLivros.getIdioma());
           ps.setString(9, chamadoLivros.getLido());
           ps.setString(10, chamadoLivros.getPreco());
           ps.setString(11, chamadoLivros.getData_do_cadastro());
           ps.setString(12, chamadoLivros.getEstoque_fisico());
           ps.setInt(13, chamadoLivros.getId());
           int LinhasAtualizadas = ps.executeUpdate();
            if(LinhasAtualizadas > 0){
                logger.log(Level.INFO, "Chamado atualizado com sucesso.");
            } else {
                logger.log(Level.WARNING, "Nenhuma linha foi atualizada.");
            }
             } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Erro ao tentar atualizar o chamado", ex);
            throw ex; // Relança a exceção para quem chamou o método poder tratar também
        }
         }
     
    public void AlterarCliente(ChamadoCliente chamadoCliente) throws ClassNotFoundException, SQLException {
    String SQL = "UPDATE Cliente SET  nome = ?, email = ?, telefone = ?, senha = ?, idade = ?, cpf = ? WHERE nome = ?";
    try (Connection conexao = new Conexao().getConnection();
         PreparedStatement ps = conexao.prepareStatement(SQL)) {
        ps.setString(1, chamadoCliente.getNome());
        ps.setString(2, chamadoCliente.getEmail());
        ps.setString(3, chamadoCliente.getTelefone());
        ps.setString(4, chamadoCliente.getSenha());
        ps.setString(5, chamadoCliente.getIdade());
        ps.setString(6, chamadoCliente.getCpf());
        ps.setString(7, chamadoCliente.getNome());
        int LinhasAtualizadas = ps.executeUpdate();
            if(LinhasAtualizadas > 0){
                logger.log(Level.INFO, "Chamado atualizado com sucesso.");
            } else {
                logger.log(Level.WARNING, "Nenhuma linha foi atualizada.");
            }
             } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Erro ao tentar atualizar o chamado", ex);
            throw ex; // Relança a exceção para quem chamou o método poder tratar também
        }
    // Só não está atualizando o nome
         
}
     
     public void BuscarCliente(ChamadoCliente chamadoCliente) throws ClassNotFoundException, SQLException{
        String SQL = "SELECT * FROM Cliente where nome = ? or email = ? or telefone = ? or senha = ? or idade = ? or cpf = ?";
        try (Connection conexao = new Conexao().getConnection();
            PreparedStatement ps = conexao.prepareStatement(SQL)){
            ps.setString(1, chamadoCliente.getNome());
            ps.setString(2, chamadoCliente.getEmail());
            ps.setString(3, chamadoCliente.getTelefone());
            ps.setString(4, chamadoCliente.getSenha());
            ps.setString(5, chamadoCliente.getIdade());
            ps.setString(6, chamadoCliente.getCpf());
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    chamadoCliente.setNome(rs.getString("nome"));
                    chamadoCliente.setEmail(rs.getString("email"));
                    chamadoCliente.setTelefone(rs.getString("telefone"));
                    chamadoCliente.setSenha(rs.getString("senha"));
                    chamadoCliente.setIdade(rs.getString("idade"));
                    chamadoCliente.setCpf(rs.getString("cpf"));
                    logger.log(Level.INFO, "Dados encontrados com sucesso.");
                } else {
                    logger.log(Level.WARNING, "Dados não foram encontrados.");
                }
                }
            } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Erro ao buscar os dados", ex);
            throw ex;
            }
        }
     
     public void ExcluirConta(ChamadoCliente chamadoCliente) throws SQLException,ClassNotFoundException{
        String sql = "DELETE from Cliente where nome = ?";
        PreparedStatement st = null;
        Connection con = null;
        con = new Conexao().getConnection();
        st = con.prepareStatement(sql);
        st.setString(1,chamadoCliente.getNome());
        st.execute();
    }
     
    }

