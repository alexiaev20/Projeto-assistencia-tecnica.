package DAO;

import Modelo.Usuario;

public class testeDAO {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuario.setId(1234);
		usuario.setNome("david");
		usuario.setEmail("ddmcosta@.com");
		usuario.setEndereço("rua setenta");
		usuario.setCpf(12345678);
		usuario.setTelefone(85879034);
		usuario.setSenha("DFDFF");
		
		usuarioDAO.criarUsuario(usuario);
		
		// TODO Auto-generated method stub

	}

}