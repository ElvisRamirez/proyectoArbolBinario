package interfaz;

import java.awt.BorderLayout;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import mundo.Cliente;

import mundoArboles.arbolBinario;

public class InterfazCliente extends JFrame {

	private JPanel contentPane;
	 private Image imagenFondo1;
	 private JTextField txtNombre;
	 private JTextField txtApellido;
	 private JTextField txtCedula;
	 private JTextField txtCorreo;
	 private JTextField txtTelefono;
	 private JTable table;

	 private JTable table1;
	/**
	 * Launch the application.
	 */
	 arbolBinario arbol = new arbolBinario();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazCliente frame = new InterfazCliente();
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
	public InterfazCliente() {
		
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(1025, 584); // Establecer el tamaño de la ventana
	        contentPane = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                // Dibujar la imagen de fondo
	                g.drawImage(imagenFondo1, 0, 0, getWidth(), getHeight(), this);
	            }
	        };
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);

	        // Cargar la imagen de fondo desde la carpeta src/imagenes
	        String imagePath = "/imagenes/interfaz.jpg"; // Ruta relativa desde el directorio de trabajo
	        imagenFondo1 = new ImageIcon(getClass().getResource(imagePath)).getImage();
	        contentPane.setLayout(null);
	    
	        JLabel lblNewLabel = new JLabel("------DATOS CLIENTES------");
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Constantia", Font.BOLD, 25));
			lblNewLabel.setBounds(282, 11, 388, 32);
			contentPane.add(lblNewLabel);
			
			JLabel lbNombre = new JLabel("- NOMBRES: ");
			lbNombre.setBackground(Color.WHITE);
			lbNombre.setForeground(Color.WHITE);
			lbNombre.setFont(new Font("Constantia", Font.BOLD, 16));
			lbNombre.setBounds(10, 64, 103, 32);
			contentPane.add(lbNombre);
			
			JLabel lblApellidos = new JLabel("- APELLIDOS: ");
			lblApellidos.setBackground(Color.WHITE);
			lblApellidos.setForeground(Color.WHITE);
			lblApellidos.setFont(new Font("Constantia", Font.BOLD, 16));
			lblApellidos.setBounds(465, 64, 121, 32);
			contentPane.add(lblApellidos);
			
			JLabel lbCedula = new JLabel("- CÉDULA     : ");
			lbCedula.setBackground(Color.WHITE);
			lbCedula.setForeground(Color.WHITE);
			lbCedula.setFont(new Font("Constantia", Font.BOLD, 16));
			lbCedula.setBounds(10, 107, 105, 32);
			contentPane.add(lbCedula);
			
			JLabel lbEdad = new JLabel("- EDAD         : ");
			lbEdad.setBackground(Color.WHITE);
			lbEdad.setForeground(Color.WHITE);
			lbEdad.setFont(new Font("Constantia", Font.BOLD, 16));
			lbEdad.setBounds(465, 107, 103, 32);
			contentPane.add(lbEdad);
			
			JLabel lbCorreo = new JLabel("- C. ELECTRÓNICO: ");
			lbCorreo.setBackground(Color.WHITE);
			lbCorreo.setForeground(Color.WHITE);
			lbCorreo.setFont(new Font("Constantia", Font.BOLD, 16));
			lbCorreo.setBounds(10, 150, 215, 32);
			contentPane.add(lbCorreo);
			
			JLabel lbtelefono = new JLabel("- # TELÉFONO: ");
			lbtelefono.setBackground(Color.WHITE);
			lbtelefono.setForeground(Color.WHITE);
			lbtelefono.setFont(new Font("Constantia", Font.BOLD, 16));
			lbtelefono.setBounds(467, 150, 152, 32);
			contentPane.add(lbtelefono);
		
			JButton btnBuscar = new JButton("BUSCAR");
			
			btnBuscar.setForeground(new Color(0, 153, 153));
			btnBuscar.setFont(new Font("Constantia", Font.BOLD, 18));
			btnBuscar.setBounds(165, 389, 128, 32);
			contentPane.add(btnBuscar);
			
			JButton btnIngresar = new JButton("INGRESAR");
			btnIngresar.setForeground(new Color(0, 153, 153));
			btnIngresar.setFont(new Font("Constantia", Font.BOLD, 18));
			btnIngresar.setBounds(28, 389, 128, 32);
			contentPane.add(btnIngresar);
			
			JButton btnSalir_1 = new JButton("SALIR");
			
			btnSalir_1.setForeground(new Color(0, 153, 153));
			btnSalir_1.setFont(new Font("Constantia", Font.BOLD, 18));
			btnSalir_1.setBounds(458, 502, 128, 32);
			contentPane.add(btnSalir_1);

			JButton btnEliminar = new JButton("ELIMINAR");
			
			btnEliminar.setForeground(new Color(0, 153, 153));
			btnEliminar.setFont(new Font("Constantia", Font.BOLD, 18));
			btnEliminar.setBounds(322, 389, 133, 32);
			contentPane.add(btnEliminar);
			
			JButton btnPreOrden = new JButton("PRE-ORDEN");
			
			btnPreOrden.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnPreOrden.setForeground(new Color(0, 153, 153));
			btnPreOrden.setFont(new Font("Constantia", Font.BOLD, 18));
			btnPreOrden.setBounds(518, 389, 152, 32);
			contentPane.add(btnPreOrden);

			JButton btnInOrden = new JButton("IN-ORDEN");
			btnInOrden.setForeground(new Color(0, 153, 153));
			btnInOrden.setFont(new Font("Constantia", Font.BOLD, 18));
			btnInOrden.setBounds(843, 389, 152, 32);
			contentPane.add(btnInOrden);
			
			JButton btnPostOrden = new JButton("POS-ORDEN");
			btnPostOrden.setForeground(new Color(0, 153, 153));
			btnPostOrden.setFont(new Font("Constantia", Font.BOLD, 18));
			btnPostOrden.setBounds(681, 389, 152, 32);
			contentPane.add(btnPostOrden);

				
			
			txtNombre = new JTextField();
			txtNombre.setForeground(new Color(0, 0, 0));
			txtNombre.setToolTipText("");
			txtNombre.setBackground(new Color(255, 255, 255));
			txtNombre.setBounds(116, 68, 133, 20);
			contentPane.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtApellido = new JTextField();
			txtApellido.setBounds(629, 68, 133, 20);
			contentPane.add(txtApellido);
			txtApellido.setColumns(10);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(116, 107, 133, 20);
			contentPane.add(txtCedula);
			txtCedula.setColumns(10);
			
			txtCorreo = new JTextField();
			txtCorreo.setBounds(165, 150, 157, 20);
			contentPane.add(txtCorreo);
			txtCorreo.setColumns(10);
			
			txtTelefono = new JTextField();
			txtTelefono.setBounds(629, 154, 120, 20);
			contentPane.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JSpinner txtEdad = new JSpinner();
			txtEdad.setBounds(629, 111, 41, 20);
			contentPane.add(txtEdad);
			
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );

			String[] columnas = {"Apellidos","Nombres", "Cedula", "Edad", "Correo", "Telefono"};
			DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
			    boolean[] columnEditables = new boolean[] { true,true, true, true, true, true };

			    public boolean isCellEditable(int row, int column) {
			        return columnEditables[column];
			    }
			};
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null,null},
					{null, null, null, null, null,null},
					{null, null, null, null, null,null},
					{null, null, null, null, null,null},
					{null, null, null, null, null,null},
					{null, null, null, null, null,null},
					{null, null, null, null, null,null},
					{null, null, null, null, null,null},
					{null, null, null, null, null,null},
				},
				new String[] {
						"Apellidos","Nombres", "Cedula", "Edad", "Correo", "Telefono"
				}
			));
			table.getColumnModel().getColumn(2).setResizable(false);
			table.setBounds(28, 218, 480, 144);
			contentPane.add(table);
			
			table1 = new JTable();
			table1.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"Apellido", "Nombre", "Cedula", "Edad", "C.Eelectronico", "Telefono"
				}
			));
			table1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			table1.setBounds(519, 218, 480, 144);
			contentPane.add(table1);
			
			btnIngresar.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        try {
			            String nombre = txtNombre.getText();
			            String apellido = txtApellido.getText();
			            String cedula = txtCedula.getText();
			            int edad = (int) txtEdad.getValue();
			            String correo = txtCorreo.getText();
			            String telefono = txtTelefono.getText();

			            // Validar que todos los campos estén completos
			            if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
			                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
			                return;
			            }

			            // Validar que la cédula tenga 10 números
			            if (cedula.length() != 10) {
			                JOptionPane.showMessageDialog(null, "La cédula debe contener 10 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
			                return;
			            }

			            // Validar que el teléfono tenga 10 números
			            if (telefono.length() != 10) {
			                JOptionPane.showMessageDialog(null, "El número de teléfono debe contener 10 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
			                return;
			            }

			            // Validar que la edad esté dentro del rango permitido
			            if (edad < 18 || edad > 90) {
			                JOptionPane.showMessageDialog(null, "La edad debe estar entre 18 y 90 años.", "Error", JOptionPane.ERROR_MESSAGE);
			                return;
			            }

			            // Crear el objeto Cliente
			            Cliente cliente = new Cliente(nombre, apellido, cedula, edad, correo, telefono);

			            // Agregar el cliente a la lista
			            arbol.insertarCliente(cliente);


			            // Actualizar la tabla
			            actualizarTabla();
			            // Borrar o limpiar los campos de texto
			            txtNombre.setText("");
			            txtApellido.setText("");
			            txtCedula.setText("");
			            txtEdad.setValue(18); // Establecer el valor mínimo por defecto
			            txtCorreo.setText("");
			            txtTelefono.setText("");
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(null, "Error en el formato de los campos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    }
			});

			
			btnBuscar.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        String cedulaBusqueda = JOptionPane.showInputDialog(null, "Ingrese la cédula a buscar:");

			        if (cedulaBusqueda != null && !cedulaBusqueda.isEmpty()) {
			            Cliente clienteEncontrado = arbol.buscarCliente(cedulaBusqueda);

			            if (clienteEncontrado != null) {
			                // Cliente encontrado, realizar acciones
			                JOptionPane.showMessageDialog(null, "Cliente encontrado:\n" + clienteEncontrado.toString());
			            } else {
			                // Cliente no encontrado, mostrar mensaje de error
			                JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con la cédula ingresada.");
			            }
			        }
			    }
			});





			
			btnEliminar.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        String cedulaEliminar = JOptionPane.showInputDialog(null, "Ingrese la cédula del cliente a eliminar:", "Eliminar cliente por cédula", JOptionPane.QUESTION_MESSAGE);
			        if (cedulaEliminar != null && !cedulaEliminar.isEmpty()) {
			            boolean clienteEliminado = arbol.eliminarClientePorCedula(cedulaEliminar);

			            if (clienteEliminado) {
			                // Cliente eliminado correctamente
			                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
			                // Actualizar la tabla
			                actualizarTabla(arbol.inorden(arbol.getRaiz()));
			            } else {
			                // No se encontró ningún cliente con la cédula ingresada
			                JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con la cédula ingresada.");
			            }
			        }
			    }
			});


			btnPreOrden.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        List<Cliente> clientesPreOrden = arbol.preorden(arbol.getRaiz());
			        // Actualizar la tabla con los clientes recorridos en Pre-Orden
			        actualizarTabla(clientesPreOrden);
			    }
			});

			btnInOrden.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        List<Cliente> clientesInOrden = arbol.inorden(arbol.getRaiz());
			        // Actualizar la tabla con los clientes recorridos en In-Orden
			        actualizarTabla(clientesInOrden);
			    }
			});

			btnPostOrden.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        List<Cliente> clientesPostOrden = arbol.postorden(arbol.getRaiz());
			        // Actualizar la tabla con los clientes recorridos en Post-Orden
			        actualizarTabla(clientesPostOrden);
			    }
			});

			
			

			btnSalir_1.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        System.exit(0);
			    }
			});

			
	}
	private void actualizarTabla() {
		
	    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
	    modelo.setRowCount(0); // Limpiar la tabla

	    List<Cliente> clientes = arbol.preorden(arbol.getRaiz());
	    for (Cliente cliente : clientes) {
	        Object[] fila = {cliente.getApellido(), cliente.getNombre(), cliente.getCedula(), cliente.getEdad(), cliente.getCorreoElectronico(), cliente.getNumeroTelefono()};
	        modelo.addRow(fila);
	    }
	}

	private void actualizarTabla(List<Cliente> listaClientes) {
	    DefaultTableModel modelo = (DefaultTableModel) table1.getModel();
	    modelo.setRowCount(0); // Limpiar la tabla

	    for (Cliente cliente : listaClientes) {
	        Object[] fila = {cliente.getApellido(), cliente.getNombre(), cliente.getCedula(), cliente.getEdad(), cliente.getCorreoElectronico(), cliente.getNumeroTelefono()};
	        modelo.addRow(fila);
	    }
	}


}
