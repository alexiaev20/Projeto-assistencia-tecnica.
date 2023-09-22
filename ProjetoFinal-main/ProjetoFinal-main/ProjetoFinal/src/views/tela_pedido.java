package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import Modelo.Produto;
import Modelo.Servico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Label;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.FlowLayout;

public class tela_pedido extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_pedido frame = new tela_pedido();
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
	public tela_pedido() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\Desktop\\images.png"));
		setTitle("ForcTec - Assistência Técnica");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Solicitações feitas, finalizar?");
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 346, 25);
		contentPane.add(lblNewLabel);
		
		JButton botao_finalizar = new JButton("Finalizar");
		botao_finalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Solicitação encaminhada! Entraremos em contato em breve.");
				
				tela_login tela_Login = new tela_login();
				dispose();
				tela_Login.setVisible(true);
			}
		});
		botao_finalizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botao_finalizar.setBounds(204, 214, 127, 36);
		contentPane.add(botao_finalizar);
		
		JButton botao_voltar = new JButton("Voltar");
		botao_voltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botao_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tela_servicos telaServicos = new tela_servicos();
				telaServicos.setVisible(true);
			}
		});
		botao_voltar.setBounds(30, 214, 127, 36);
		contentPane.add(botao_voltar);
		
		JLabel valor_total = new JLabel("Valor total:");
		valor_total.setFont(new Font("Tahoma", Font.PLAIN, 14));
		valor_total.setHorizontalAlignment(SwingConstants.LEFT);
		valor_total.setBounds(10, 119, 89, 25);
		contentPane.add(valor_total);
		
		JLabel prazo_de_entrega = new JLabel("Prazo de entrega:");
		prazo_de_entrega.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prazo_de_entrega.setBounds(10, 155, 119, 25);
		contentPane.add(prazo_de_entrega);
		
		JPanel panel_valor_total = new JPanel();
		panel_valor_total.setBorder(null);
		panel_valor_total.setBackground(new Color(240, 240, 240));
		panel_valor_total.setBounds(84, 119, 340, 25);
		contentPane.add(panel_valor_total);
		
		JPanel panel_prazo_de_entrega = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_prazo_de_entrega.getLayout();
		panel_prazo_de_entrega.setBounds(125, 155, 299, 25);
		contentPane.add(panel_prazo_de_entrega);
		
		JLabel lblNewLabel_1 = new JLabel("Produto:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 47, 76, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Serviços:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 83, 76, 25);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel_servicos = new JPanel();
		panel_servicos.setBounds(84, 83, 340, 25);
		contentPane.add(panel_servicos);
		
		JPanel panel_produto = new JPanel();
		panel_produto.setBounds(84, 47, 340, 25);
		contentPane.add(panel_produto);}
	
        public void printValues(String nomeProduto,String nomeServico) {
		
        	JLabel lblNewLabel_1 = new JLabel();
    		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
    		lblNewLabel_1.setBounds(23, 63, 76, 25);
    		contentPane.add(lblNewLabel_1);
    		lblNewLabel_1.setText(nomeProduto);
    		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setFont(new Font("Tahoma",Font.PLAIN,14));
		lblNewLabel_2.setBounds(23, 98, 155, 23);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setText(nomeServico);
	
		

	{
		JPanel panel = new JPanel();
		panel.setBounds(74, 47, 350, 25);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(74, 83, 350, 25);
		contentPane.add(panel_1);
	}
	
		
	}
}