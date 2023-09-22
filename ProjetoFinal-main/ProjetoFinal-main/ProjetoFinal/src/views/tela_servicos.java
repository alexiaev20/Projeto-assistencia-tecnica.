package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Servico;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Button;
import java.awt.Checkbox;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tela_servicos extends JFrame {

	private JPanel contentPane;
	private String nomeProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_servicos frame = new tela_servicos();
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
	public tela_servicos() {
		setTitle("ForcTec - Assistência Técnica");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\Desktop\\images.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quase lá!...");
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 15));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(10, 22, 86, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Qual tipo de serviço gostaria de solicitar?");
		lblNewLabel_1.setFont(new Font("Century Schoolbook", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 51, 329, 23);
		contentPane.add(lblNewLabel_1);
		
		Servico servico = new Servico();
		JCheckBox box_limpeza = new JCheckBox(servico.getSERVICO()[0] +" R$: " + servico.getVALORES()[0]);
		box_limpeza.setHorizontalAlignment(SwingConstants.LEFT);
		box_limpeza.setBounds(23, 98, 155, 23);
		contentPane.add(box_limpeza);
		 
		JCheckBox box_troca_de_hd = new JCheckBox(servico.getSERVICO()[3] +" R$ " + servico.getVALORES()[3]);
		box_troca_de_hd.setHorizontalAlignment(SwingConstants.LEFT);
		box_troca_de_hd.setBounds(23, 141, 171, 23);
		contentPane.add(box_troca_de_hd);
		
		JCheckBox box_formatacao = new JCheckBox(servico.getSERVICO()[1] +" R$ " + servico.getVALORES()[1]);
		box_formatacao.setHorizontalAlignment(SwingConstants.LEFT);
		box_formatacao.setBounds(192, 98, 181, 23);
		contentPane.add(box_formatacao);
		
		JCheckBox box_troca_de_tela = new JCheckBox(servico.getSERVICO()[2] +" R$: " + servico.getVALORES()[2]);
		box_troca_de_tela.setHorizontalAlignment(SwingConstants.LEFT);
		box_troca_de_tela.setBounds(192, 141, 181, 23);
		contentPane.add(box_troca_de_tela);
		
		JButton botao_voltar_servicos = new JButton("Voltar");
		botao_voltar_servicos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botao_voltar_servicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
     			tela_produto telaProduto = new tela_produto();
				telaProduto.setVisible(true);
			}
		});
		botao_voltar_servicos.setBounds(63, 197, 117, 35);
		contentPane.add(botao_voltar_servicos);
		
		JButton botao_proximo = new JButton("Próximo");
		botao_proximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tela_pedido telaPedido = new tela_pedido();
				
				telaPedido.printValues(getNomeProduto(),box_limpeza.getText().toString());
				dispose();
				
				telaPedido.setVisible(true);
			}
		}
		);
		botao_proximo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botao_proximo.setBounds(222, 197, 117, 35);
		contentPane.add(botao_proximo);
	}
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
}