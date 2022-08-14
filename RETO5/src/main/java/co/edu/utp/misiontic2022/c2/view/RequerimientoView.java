package co.edu.utp.misiontic2022.c2.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.IconView;
import javax.swing.text.StyledEditorKit.FontFamilyAction;

import org.w3c.dom.Text;

import co.edu.utp.misiontic2022.c2.controller.RequerimientoController;
import co.edu.utp.misiontic2022.c2.model.vo.AsesorPorCiudadVo;
import co.edu.utp.misiontic2022.c2.model.vo.CompraPorProveedorVo;
import co.edu.utp.misiontic2022.c2.model.vo.ProyectoCasaCampestreVo;

public class RequerimientoView extends JFrame {

    public static final RequerimientoController controlador = new RequerimientoController();

    // Mitigar errores de instancia
    private static final long serialVersionUID = 1l;
    private JPanel contenPanel;
    private JTextArea textArea;

    public RequerimientoView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 800, 650);

        contenPanel = new JPanel();
        contenPanel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contenPanel);
        contenPanel.setLayout(null);

        JLabel lbTitulo = new JLabel("--- RETO 5 ---");
        lbTitulo.setBounds(25, 6, 81, 25);
        contenPanel.add(lbTitulo);

        // Dimensionar el contenido dentro de la ventana
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28,70,737, 455);
        contenPanel.add(scrollPane);

        // Proporcionar una vista desplazable  de un componente a una ventana
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnConsulta1 = new JButton("Informe 1");
        btnConsulta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // llamar el informe 1
                informe1();
            }  
        });
        btnConsulta1.setBounds(28, 537, 133, 29);
        btnConsulta1.setBackground(Color.LIGHT_GRAY);
        contenPanel.add(btnConsulta1);

        JButton btnConsulta2 = new JButton("Informe 2");
        btnConsulta2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // llamar el informe 2
                informe2();
            }
        });
        btnConsulta2.setBounds(167, 537, 133, 29);
        btnConsulta2.setBackground(Color.lightGray);
        contenPanel.add(btnConsulta2);

        JButton btnConsulta3 = new JButton("Informe 3");
        btnConsulta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // llamar el informe 3
                informe3();
            }
        });
        btnConsulta3.setBounds(307, 537, 133, 29);
        btnConsulta3.setBackground(Color.lightGray);
        contenPanel.add(btnConsulta3);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                textArea.setText("");
                
            }
        });
        btnLimpiar.setBounds(632, 537, 133, 29);
        btnLimpiar.setBackground(Color.lightGray);
        contenPanel.add(btnLimpiar);

    }

    public void informe1() {
        try {
            ArrayList<AsesorPorCiudadVo> asesores = controlador.consultarAsesorPorCiudad();
            String salida = "/------- ASESOR POR CIUDAD -------/ \n\nId Lider \t Nombre \t Primer Apellido \t Residencia\n\n";

            for (AsesorPorCiudadVo asesor: asesores) {
                salida += asesor.getIdLider() + " \t ";
                salida += asesor.getNombre() + " \t ";
                salida += asesor.getPrimerApellido() + " \t\t ";
                salida += asesor.getCiudadResidencia() + " \t\n";
            } 

            textArea.setText(salida);
        } catch (SQLException e) {
            System.err.println("Error inesperado..." + e.getMessage());
        }
    }

    public void informe2() {
        try {
            ArrayList<ProyectoCasaCampestreVo> casaCampestres = controlador.consultarProyectoCasaCampestre();
            String salida = "**** Proyecto Casa Campestre **** \n\nId Proyecto \t Constructora \t Num Habitaciones \t Ciudad \n\n";
            for (ProyectoCasaCampestreVo casaCampestre: casaCampestres) {
                salida += casaCampestre.getIdProyecto() + " \t ";
                salida += casaCampestre.getConstructora();
                if (casaCampestre.getConstructora().length() <= 11){
                    salida += " \t\t ";
                } else {
                    salida += " \t ";
                }
                salida += casaCampestre.getNumeroHabitaciones() + " \t ";
                salida += casaCampestre.getCiudad() + "\n";
            }
            textArea.setText(salida);

        } catch (SQLException e) {
            System.err.println("Error inesperado..." + e.getMessage());
        }
    }

    public void informe3() {
        try {
            ArrayList<CompraPorProveedorVo> compras = controlador.consultarCompraPorProveedor();
            String salida = "**** Compra Por Proveedor **** \n\nId Compra \t Constructora \t Banco Vinculado\n\n";

            for (CompraPorProveedorVo compra: compras){
                salida += compra.getIdCompra() + " \t ";
                salida += compra.getConstructora() + " \t ";
                salida += compra.getBancoVinculado() + "\n";
            }

            textArea.setText(salida);

        } catch (SQLException e) {
            System.err.println("Error inesperado..." + e.getMessage()); 
        }
    }
    
}
