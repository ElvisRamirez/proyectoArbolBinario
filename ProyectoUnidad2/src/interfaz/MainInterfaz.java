package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.*;
import java.awt.*;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainInterfaz extends JFrame {

    private JPanel contentPane;
    private Image imagenFondo; // Variable para almacenar la imagen de fondo
    private JTextField txtUsuario;
    private JTextField txtContraseña;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainInterfaz frame = new MainInterfaz();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainInterfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(462, 480); // Establecer el tamaño de la ventana
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar la imagen de fondo
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(107, 259, 89, 23);
        contentPane.add(btnIniciar);
        btnIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el usuario y la contraseña ingresados
                String usuario = txtUsuario.getText();
                String contrasena = txtContraseña.getText();

                // Realizar la validación de usuario y contraseña
                if (usuario.equals("admin") && contrasena.equals("123456")) {
                    // Acciones a realizar en caso de credenciales válidas
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                 // Abrir la ventana principal
                    InterfazCliente ventanaPrincipal = new InterfazCliente();
                    ventanaPrincipal.setVisible(true);
                } else {
                    // Acciones a realizar en caso de credenciales inválidas
                    JOptionPane.showMessageDialog(null, "Credenciales inválidas. Inténtalo de nuevo.");
                }
            }
        });

        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(241, 259, 89, 23);
        contentPane.add(btnSalir);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        txtUsuario = new JTextField();
        txtUsuario.setBounds(220, 101, 86, 20);
        contentPane.add(txtUsuario);
        txtUsuario.setColumns(10);
        
        txtContraseña = new JTextField();
        txtContraseña.setBounds(220, 147, 86, 20);
        contentPane.add(txtContraseña);
        txtContraseña.setColumns(10);
        
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setForeground(new Color(255, 255, 255));
        lblUsuario.setBounds(119, 104, 66, 14);
        contentPane.add(lblUsuario);
        
        JLabel lblContraseña = new JLabel("Constraseña:");
        lblContraseña.setForeground(new Color(255, 255, 255));
        lblContraseña.setBounds(119, 150, 77, 14);
        contentPane.add(lblContraseña);
        
        JLabel lblInicio = new JLabel("INICIO DE SESION  R.T");
        lblInicio.setForeground(new Color(255, 255, 255));
        lblInicio.setBounds(150, 49, 147, 14);
        contentPane.add(lblInicio);

        // Cargar la imagen de fondo desde la carpeta src/imagenes
        String imagePath = "/imagenes/inicio.jpg"; // Ruta relativa desde el directorio de trabajo
        imagenFondo = new ImageIcon(getClass().getResource(imagePath)).getImage();
    }
}
