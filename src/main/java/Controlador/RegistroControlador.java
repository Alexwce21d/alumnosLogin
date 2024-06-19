
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioModelo;
import Vista.LoginVista;
import Vista.RegistroVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroControlador implements ActionListener {
    private UsuarioModelo modelo;
    private RegistroVista vista;

    public RegistroControlador(UsuarioModelo modelo, RegistroVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.getBtnRegistrar().addActionListener(this);
        this.vista.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnRegistrar()) {
            registrar();
        } else if (e.getSource() == vista.getBtnCancelar()) {
            volverLogin();
        }
    }

    private void registrar() {
        String nombre = vista.getTxtNombre().getText();
        String email = vista.getTxtEmail().getText();
        String password = vista.getTxtContraseña().getText();
        Usuario usuario = new Usuario(0, nombre, email, password);
        if (modelo.registrarUsuario(usuario)) {
            vista.showMessage("Registro exitoso");
        } else {
            vista.showMessage("Error en el registro");
        }
    }
    
    private void volverLogin() {
        LoginVista loginVista = new LoginVista();
        LoginControlador loginControlador = new LoginControlador(modelo, loginVista);
        loginVista.setVisible(true);
        vista.dispose();  // Cerrar la ventana de registro actual
    }
}
