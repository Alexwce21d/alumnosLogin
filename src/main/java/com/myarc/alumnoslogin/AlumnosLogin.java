
package com.myarc.alumnoslogin;

import Controlador.LoginControlador;
import Controlador.RegistroControlador;
import Modelo.UsuarioModelo;
import Vista.LoginVista;
import Vista.RegistroVista;

public class AlumnosLogin {

      public static void main(String[] args) {
        UsuarioModelo modelo = new UsuarioModelo();
        LoginVista loginVista = new LoginVista();
        RegistroVista registroVista = new RegistroVista();

        new LoginControlador(modelo, loginVista);
        new RegistroControlador(modelo, registroVista);

        // Muestra la vista de login inicialmente
        loginVista.setVisible(true);
    }
}
