
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioModelo;
import Vista.LoginVista;
import Vista.RegistroVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginControlador implements ActionListener {
    private UsuarioModelo modelo;
    private LoginVista vista;

    public LoginControlador(UsuarioModelo modelo, LoginVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.getBtnLogin().addActionListener(this);
        this.vista.getBtnRegistro().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnLogin()) {
            login();
        } else if (e.getSource() == vista.getBtnRegistro()) {
            abrirRegistro();
        }
    }

    private void login() {
        String email = vista.getTxtEmail().getText();
        String password = vista.getTxtContraseña().getText();
        Usuario usuario = modelo.obtenerUsuarioPorEmail(email);
        if (usuario != null && usuario.getPassword().equals(password)) {
            vista.showMessage("Login exitoso");
        } else {
            vista.showMessage("Email o contraseña incorrectos");
        }
    }
    
    private void abrirRegistro() {
        RegistroVista registroVista = new RegistroVista();
        RegistroControlador registroControlador = new RegistroControlador(modelo, registroVista);
        registroVista.setVisible(true);
        vista.dispose();  // Cerrar la ventana de login actual
    }
    
}
