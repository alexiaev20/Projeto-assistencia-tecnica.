package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UsuarioDAO;
import Factory.ConnectionFactory;
import Modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPasswordField;

public class tela_cadastro extends JFrame {
	private JTextField campo_cpf;
	private JTextField campo_email;
	private JTextField campo_nome;
	private JTextField campo_telefone;
	private JTextField campo_endereço;
	private JPanel contentPane;
	private JPasswordField campo_login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_cadastro frame = new tela_cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tela_cadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\Desktop\\images.png"));
		setType(Type.POPUP);
		setTitle("ForcTec - Assistência Técnica");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 611, 306);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seja nosso novo cliente, cadastre-se:");
		lblNewLabel.setBounds(10, 11, 287, 25);
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JLabel nome = new JLabel("Nome:");
		nome.setHorizontalAlignment(SwingConstants.LEFT);
		nome.setBounds(18, 64, 46, 14);
		contentPane.add(nome);
		
		JLabel cpf = new JLabel("CPF:");
		cpf.setBounds(28, 95, 29, 14);
		cpf.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(cpf);
		
		JLabel email = new JLabel("E-mail:");
		email.setHorizontalAlignment(SwingConstants.LEFT);
		email.setBounds(18, 128, 38, 14);
		contentPane.add(email);
		
		JLabel telefone = new JLabel("Telefone:");
		telefone.setHorizontalAlignment(SwingConstants.LEFT);
		telefone.setBounds(8, 164, 56, 14);
		contentPane.add(telefone);
		
		JLabel endereço = new JLabel("Endereço:");
		endereço.setHorizontalAlignment(SwingConstants.LEFT);
		endereço.setBounds(8, 200, 66, 14);
		contentPane.add(endereço);
		
		campo_cpf = new JTextField();
		campo_cpf.setBounds(66, 90, 195, 25);
		contentPane.add(campo_cpf);
		campo_cpf.setColumns(10);
		
		campo_email = new JTextField();
		campo_email.setBounds(66, 123, 195, 25);
		contentPane.add(campo_email);
		campo_email.setColumns(10);
		
		JButton botao_cadastrar = new JButton("Cadastrar");
		botao_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Usuario usuario = new Usuario();
				usuario.setNome(campo_nome.getText());
			    System.out.println(usuario.getNome());
			    
			    usuario.setCpf(Long.parseLong(campo_cpf.getText()));
			    System.out.println(usuario.getCpf());
			    
			    usuario.setEmail(campo_email.getText());
			    System.out.println(usuario.getEmail());
			    
			    usuario.setTelefone(Long.parseLong(campo_telefone.getText()));
			    System.out.println(usuario.getTelefone());
			    
			    usuario.setEndereço(campo_endereço.getText());
			    System.out.println(usuario.getEndereço());
			    
			    usuario.setSenha(campo_login.getText());
			    UsuarioDAO usuarioDAO = new UsuarioDAO();
			    usuarioDAO.criarUsuario(usuario);
			    
			    //usuario.getNome(campo_nome);
			    tela_login telaLogin = new tela_login();
				dispose();
				telaLogin.setVisible(true);
				
			}
		});
		botao_cadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botao_cadastrar.setBounds(323, 145, 160, 49);
		contentPane.add(botao_cadastrar);
		
		campo_nome = new JTextField();
		campo_nome.setBounds(66, 59, 195, 25);
		contentPane.add(campo_nome);
		campo_nome.setColumns(10);
		
		campo_telefone = new JTextField();
		campo_telefone.setBounds(66, 159, 195, 25);
		contentPane.add(campo_telefone);
		campo_telefone.setColumns(10);
		
		campo_endereço = new JTextField();
		campo_endereço.setBounds(66, 195, 195, 25);
		contentPane.add(campo_endereço);
		campo_endereço.setColumns(10);
		
		JLabel senha_de_login = new JLabel("Senha de Login:");
		senha_de_login.setBounds(271, 64, 92, 14);
		contentPane.add(senha_de_login);
		
		campo_login = new JPasswordField();
		campo_login.setBounds(362, 61, 147, 23);
		contentPane.add(campo_login);
	}
}