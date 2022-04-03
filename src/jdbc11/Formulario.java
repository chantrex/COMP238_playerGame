package jdbc11;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

//import org.foobarspam.interfazformularios.modelo.Persona;

public class Formulario extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario window = new Formulario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Formulario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 367, 204);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		ArrayList<Persona> personas = new ArrayList<Persona>();
		btnCrear.setBounds(20, 137, 89, 42);
		//BOTON ACEPTAR
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Persona persona = new Persona(txtNombre.getText(), getSelectedCheckBox(), comboBox.getSelectedItem().toString() );
//				personas.add(persona);
				JOptionPane.showMessageDialog(null, "Guardado el solicitante.\n"
						+ "Aprieta Limpiar o sobreescribe los datos para guardar otro solicitante.");
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnCrear);
		btnLimpiar.setBounds(121, 137, 89, 42);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");

				comboBox.setSelectedItem("Hombre");
			}
		});
		frame.getContentPane().add(btnLimpiar);
		btnSalir.setBounds(222, 137, 89, 42);
		
		//BOTON SALIR
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try(FileWriter fw = new FileWriter("src/org/foobarspam/interfaces/checkbox/EstatSolicitants.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw)) {
//					for (int i = 0; i<personas.size(); i++) {
////						out.println(personas.get(i).getNombre()+" "+ 
////									personas.get(i).getEdad()+" "+
////									personas.get(i).getSexo());
//					}
					} catch (IOException error) {
						System.out.println(error);
					}
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnSalir);
		comboBox.setBounds(82, 94, 116, 24);
	
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		frame.getContentPane().add(comboBox);
		lblSexo.setBounds(39, 99, 56, 15);
		frame.getContentPane().add(lblSexo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(84, 33, 177, 19);
		txtNombre.setText("Introduce nombre");
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		lblNombre.setBounds(20, 35, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(39, 67, 70, 15);
		frame.getContentPane().add(lblEdad);
		
		txtIntroduceEdad = new JTextField();
		txtIntroduceEdad.setBounds(84, 64, 177, 19);
		txtIntroduceEdad.setText("Introduce edad");
		frame.getContentPane().add(txtIntroduceEdad);
		txtIntroduceEdad.setColumns(10);
		
	}
	
	public String getSelectedCheckBox() {
		/*
		if (checkEstudiando.isSelected()) {
			return checkEstudiando.getText();
		}
		else if (checkParo.isSelected()) {
			return checkParo.getText();
		}
		else if (checkTrabajando.isSelected()){
			return checkTrabajando.getText();
		}
		else {
			return "Indefinido";
		}*/
		return "hola";
	}
	
	JButton btnCrear = new JButton("Crear");
	JButton btnLimpiar = new JButton("Limpiar");
	JButton btnSalir = new JButton("Salir");
	
	JComboBox comboBox = new JComboBox();
	JLabel lblNombre = new JLabel("Nombre");
	JLabel lblSexo = new JLabel("Sexo");
	private JTextField txtNombre;
	private JTextField txtIntroduceEdad;
}