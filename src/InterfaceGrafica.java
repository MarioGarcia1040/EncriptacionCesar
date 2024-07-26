import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/*
 Proyecto - Analizador criptografico
 Programa que encripta y desencripta archivo de texto plano usando método césar
 Clase Interface Gráfica - Crea la interface gráfica del programa, y gestiona eventos del programa.
 Autor - Mario García. mariogarcia1040@gmail.com
 12-Junio-2024 | 23-Julio-2024
*/

public class InterfaceGrafica extends JFrame implements ActionListener {

    JLabel encabezado;
    JButton seleccionarArchivo;
    JTextField archivoAEncriptar;
    JLabel textoDelArchivo;
    JTextArea textoOriginalDelArchivo;
    JLabel resultadoDelTextoProcesado;
    JTextArea textoProcesado;
    JButton encriptar;
    JTextField valorClave;
    JButton exportarResultado;
    JButton fuerzaBruta;
    JTextField valorIntentos;
    JButton analisisCriptografico;

    LectorDeArchivo lectorDeArchivo = new LectorDeArchivo();
    DesplazarCaracter desplazarCaracter = new DesplazarCaracter();
    CreadorDeArchivo creadorDeArchivo = new CreadorDeArchivo();
    DesencriptadorPorFuerzaBruta desencriptadorPorFuerzaBruta = new DesencriptadorPorFuerzaBruta();
    AnalisCriptograficoPorFrecuencias analisCriptograficoPorFrecuencias = new AnalisCriptograficoPorFrecuencias();

    public InterfaceGrafica() {

        setTitle("César v. 2.0.0");
        setSize(600, 480);
        setResizable(false);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        encabezado = new JLabel("Archivo a Procesar");
        encabezado.setBounds(10, 5, 330, 30);
        archivoAEncriptar = new JFormattedTextField();
        archivoAEncriptar.setBounds(10, 35, 350, 30);
        seleccionarArchivo = new JButton("Seleccionar");
        seleccionarArchivo.setBounds(370, 35, 200, 30);
        textoDelArchivo = new JLabel("Texto del Archivo a Procesar");
        textoDelArchivo.setBounds(10, 70, 350, 30);
        textoOriginalDelArchivo = new JTextArea();
        textoOriginalDelArchivo.setBounds(10, 100, 560, 100);
        resultadoDelTextoProcesado = new JLabel("Resultado del proceso");
        resultadoDelTextoProcesado.setBounds(10, 210, 360, 30);
        textoProcesado = new JTextArea();
        textoProcesado.setBounds(10, 240, 560, 110);
        encriptar = new JButton("Encriptar");
        encriptar.setBounds(10, 360, 180, 30);
        fuerzaBruta = new JButton("Fuerza Bruta");
        fuerzaBruta.setBounds(200, 360, 180, 30);
        analisisCriptografico = new JButton("Análisis criptográfico");
        analisisCriptografico.setBounds(390, 360, 180, 30);
        exportarResultado = new JButton("Exportar resultado");
        exportarResultado.setBounds(390, 400, 180, 30);
        JLabel clave = new JLabel("Clave:");
        clave.setBounds(15, 400, 85, 30);
        valorClave = new JFormattedTextField();
        valorClave.setBounds(90, 400, 100, 30);
        JLabel intentos = new JLabel("Intentos:");
        intentos.setBounds(205, 400, 85, 30);
        valorIntentos = new JFormattedTextField();
        valorIntentos.setBounds(280, 400, 100, 30);

        seleccionarArchivo.addActionListener(this);
        encriptar.addActionListener(this);
        exportarResultado.addActionListener(this);
        fuerzaBruta.addActionListener(this);
        analisisCriptografico.addActionListener(this);

        getContentPane().add(encabezado);
        getContentPane().add(archivoAEncriptar);
        getContentPane().add(seleccionarArchivo);
        getContentPane().add(textoDelArchivo);
        getContentPane().add(textoOriginalDelArchivo);
        getContentPane().add(resultadoDelTextoProcesado);
        getContentPane().add(textoProcesado);
        getContentPane().add(encriptar);
        getContentPane().add(fuerzaBruta);
        getContentPane().add(analisisCriptografico);
        getContentPane().add(clave);
        getContentPane().add(intentos);
        getContentPane().add(valorClave);
        getContentPane().add(valorIntentos);
        getContentPane().add(exportarResultado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == seleccionarArchivo) {
            JFileChooser seleccionarRutaDelArchivo = new JFileChooser();
            int respuestaDelUsuario = seleccionarRutaDelArchivo.showOpenDialog(this);

            if (respuestaDelUsuario == JFileChooser.APPROVE_OPTION) {
                File rutaDelArchivoSeleccionado = seleccionarRutaDelArchivo.getSelectedFile();
                archivoAEncriptar.setText(rutaDelArchivoSeleccionado.getAbsolutePath());
                textoOriginalDelArchivo.setText(lectorDeArchivo.leerArchivo(String.valueOf(rutaDelArchivoSeleccionado)));
            }
        }

        if (e.getSource() == encriptar) {
            if (textoOriginalDelArchivo.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Error - no hay datos para encriptar, reintente");
            } else if (valorClave.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Error - no ha capturado la clave a utilizar");
            } else {
                textoProcesado.setText(
                        desplazarCaracter.desplazarCaracterDeLaCadena(textoOriginalDelArchivo.getText(), Integer.parseInt(valorClave.getText())));
            }
        }

        if (e.getSource() == exportarResultado) {
            JFileChooser seleccionDeGuardado = new JFileChooser();
            seleccionDeGuardado.setDialogTitle("Guardar resultado");
            seleccionDeGuardado.setDialogType(JFileChooser.SAVE_DIALOG);

            int respuestaDelUsuario = seleccionDeGuardado.showSaveDialog(this);
            if (respuestaDelUsuario == JFileChooser.APPROVE_OPTION) {
                File rutaYNombreDelArchivoResultado = seleccionDeGuardado.getSelectedFile().getAbsoluteFile();

                if (creadorDeArchivo.crearArchivo(rutaYNombreDelArchivoResultado.toPath())) {
                    creadorDeArchivo.escribirCadenaEncriptada(textoProcesado.getText(), rutaYNombreDelArchivoResultado.toPath());
                }
            }
        }

        if (e.getSource() == fuerzaBruta) {
            if (textoOriginalDelArchivo.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Error - no hay datos para desencriptar, reintente");
            } else if (valorIntentos.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Error - no ha capturado el número máximo de intentos");
            } else {
                textoProcesado.setText(desencriptadorPorFuerzaBruta.desencriptadoPorFuerzaBruta(textoOriginalDelArchivo.getText(),
                        Integer.parseInt(valorIntentos.getText())));
            }

        }

        if (e.getSource() == analisisCriptografico) {
            if (textoOriginalDelArchivo.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Error - no hay datos para desencriptar por anáñisis de frecuencias, reintente");
            } else {
                textoProcesado.setText(analisCriptograficoPorFrecuencias.caracterQueMasApareceEnTexto(textoOriginalDelArchivo.getText()));
            }

        }

    }

}
