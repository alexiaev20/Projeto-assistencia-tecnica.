package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Factory.ConnectionFactory;
import Modelo.Usuario;

public class UsuarioDAO {
	
	public void criarUsuario(Usuario usuario)	{
		
		String dados = "INSERT INTO  clientes(nome,email,endereco,cpf,telefone,senha) VALUES (?,?,?,?,?,?)";
		
		Connection conex = null;
		PreparedStatement pstm = null;
		
	try {
		conex = ConnectionFactory.createConnectionToMySQL();
		pstm = (PreparedStatement) conex.prepareStatement(dados);
		
		
		pstm.setString(1, usuario.getNome());
		pstm.setString(2, usuario.getEmail());
		pstm.setString(3, usuario.getEndereço());
		pstm.setLong(4, usuario.getCpf());
		pstm.setLong(5, usuario.getTelefone());
		pstm.setString(6, usuario.getSenha());
		
		pstm.execute();
		
		System.out.println("Executado com Sucesso");
		
	} catch (Exception erro) {
		erro.printStackTrace();
		
	} finally {
		
		try {
			if(pstm !=null) {
				pstm.close();
			}
			if(conex != null) {
				conex.close();
				
			}
			
		}catch (Exception erro) {
			erro.printStackTrace();
		}
		
		
		}
	}
}