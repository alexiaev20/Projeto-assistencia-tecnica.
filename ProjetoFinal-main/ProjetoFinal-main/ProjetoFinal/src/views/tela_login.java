package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import Factory.ConnectionFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.sql.DataSource;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;

public class tela_login extends JFrame {

	private JPanel contentPane;
	private JTextField campo_login;
	private JPasswordField campo_senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_login frame = new tela_login();
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
	public tela_login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\Desktop\\images.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("ForTec - Assistência Técnica");
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 301);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 10, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel login = new JLabel("Login:");
		login.setBounds(27, 128, 36, 14);
		login.setBackground(new Color(255, 255, 255));
		login.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(login);
		
		campo_login = new JTextField();
		campo_login.setFont(new Font("Arial", Font.PLAIN, 13));
		campo_login.setBounds(84, 125, 244, 20);
		contentPane.add(campo_login);
		campo_login.setColumns(10);
		
		JLabel senha = new JLabel("Senha:");
		senha.setBounds(27, 159, 46, 14);
		contentPane.add(senha);
		
		JLabel lblNewLabel_2 = new JLabel("Bem Vindo(a) a ForcTec\r\n");
		lblNewLabel_2.setForeground(new Color(0, 100, 0));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setToolTipText("");
		lblNewLabel_2.setBounds(90, 11, 238, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Assistência Técnica Especializada\r\n");
		lblNewLabel_3.setForeground(new Color(0, 128, 0));
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 17));
		lblNewLabel_3.setBounds(64, 31, 307, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Faça o login para a solicitar o seu pedido.");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setFont(new Font("Century Schoolbook", Font.BOLD, 15));
		lblNewLabel_4.setBounds(41, 64, 330, 20);
		contentPane.add(lblNewLabel_4);
		
		campo_senha = new JPasswordField();
		campo_senha.setFont(new Font("Arial", Font.PLAIN, 13));
		campo_senha.setBounds(84, 156, 244, 20);
		contentPane.add(campo_senha);
		
		JButton botao_logar = new JButton("Logar");
		botao_logar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				if(campo_login.getText().equals("admin") && campo_senha.getText().equals("123")) {
					
					JOptionPane.showMessageDialog(null, "  Seja Bem-Vindo  ");
					tela_produto telaProduto = new tela_produto();
					dispose();
					telaProduto.setVisible(true);
				}else {
			
					JOptionPane.showMessageDialog(null, "Usuário não encontrado");
				}
			
		}
		});
		botao_logar.setForeground(new Color(0, 0, 0));
		botao_logar.setFont(new Font("Arial", Font.PLAIN, 14));
		botao_logar.setBounds(84, 198, 86, 36);
		contentPane.add(botao_logar);
		
		JButton botao_cadastrar = new JButton("Cadastrar");
		botao_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tela_cadastro telaCadastro = new tela_cadastro();
				dispose();
				telaCadastro.setVisible(true);
			}
		});
		botao_cadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botao_cadastrar.setForeground(new Color(0, 0, 0));
		botao_cadastrar.setBounds(206, 197, 122, 36);
		contentPane.add(botao_cadastrar);
		
		JLabel lblNewLabel = new JLabel("Caso seja um novo cliente, clique em cadastrar.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 15));
		lblNewLabel.setBounds(41, 82, 383, 20);
		contentPane.add(lblNewLabel);
	}
}