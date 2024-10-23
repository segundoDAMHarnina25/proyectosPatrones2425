package ejercicio01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import easy.ClienteResponse;
import easy.Mapper;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

public class EjercicioAdapterOne extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjercicioAdapterOne frame = new EjercicioAdapterOne();
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
	public EjercicioAdapterOne() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//Crear la clase ClienteResponseSaldo que solamente 
		//lleva la informacion del nombre del cliente y su saldo 
		//Cuando recibas la lista de Clientes, segun om,
//		debes convertir usando un Adapter para que se convierta en una 
		//String[] que se le puede dar a JList
		Mapper<Cliente, ClienteResponse> cliente2ClientResponse=new Mapper<Cliente, ClienteResponse>() {
			
			@Override
			public ClienteResponse map(Cliente t) {
				return new ClienteResponse(t.getNombre(), t.getCuenta().getSaldo());
			}
		};
		String[] array = new ClientesOM().getAll().stream()
			.map(cliente2ClientResponse::map)
			.map(ClienteResponse::toString)
			.collect(Collectors.toList()).toArray(new String[0]);
		JList<String> list = new JList(array);
		contentPane.add(list, BorderLayout.CENTER);
		JButton btnGo = new JButton("GO!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnGo, BorderLayout.SOUTH);
	}

}
