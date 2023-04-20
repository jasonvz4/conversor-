
/**
 *
 * @author Jason
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversorMonedas extends JFrame {

    private JLabel lblTitulo;
    private JPanel panelSeleccion;
    private JComboBox<String> comboOrigen, comboDestino;
    private JPanel panelEntrada;
    private JTextField txtMonto;
    private JPanel panelResultado;
    private JLabel lblResultado;

    public ConversorMonedas() {
        // Configuración de la ventana principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setTitle("Conversor de Monedas");

        // Agregar paneles y componentes
        setLayout(new GridLayout(4, 1));

        // Panel de título
        lblTitulo = new JLabel("Ingrese los datos para la conversión:");
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        add(lblTitulo);

        // Panel de selección de monedas
        panelSeleccion = new JPanel();
        panelSeleccion.setLayout(new FlowLayout());

        JLabel lblOrigen = new JLabel("Moneda Origen:");
        panelSeleccion.add(lblOrigen);

        comboOrigen = new JComboBox<>();
        comboOrigen.addItem("USD");
        comboOrigen.addItem("EUR");
        comboOrigen.addItem("JPY");
        panelSeleccion.add(comboOrigen);

        JLabel lblDestino = new JLabel("Moneda Destino:");
        panelSeleccion.add(lblDestino);

        comboDestino = new JComboBox<>();
        comboDestino.addItem("USD");
        comboDestino.addItem("EUR");
        comboDestino.addItem("JPY");
        panelSeleccion.add(comboDestino);

        add(panelSeleccion);

        // Panel de entrada de monto
        panelEntrada = new JPanel();
        panelEntrada.setLayout(new FlowLayout());

        JLabel lblMonto = new JLabel("Monto:");
        panelEntrada.add(lblMonto);

        txtMonto = new JTextField(10);
        panelEntrada.add(txtMonto);

        add(panelEntrada);

        // Panel de resultado
        panelResultado = new JPanel();
        panelResultado.setLayout(new FlowLayout());

        JLabel lblResultadoTitulo = new JLabel("Resultado:");
        panelResultado.add(lblResultadoTitulo);

        lblResultado = new JLabel("");
        panelResultado.add(lblResultado);

        add(panelResultado);

        // Configuración del botón de conversión
        // Configuración del botón de conversión
        JButton btnConvertir = new JButton("Convertir");
        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText());
                String monedaOrigen = (String) comboOrigen.getSelectedItem();
                String monedaDestino = (String) comboDestino.getSelectedItem();

                double resultado = 0.0;

                if (monedaOrigen.equals("USD") && monedaDestino.equals("EUR")) {
                    resultado = monto * 0.83;
                } else if (monedaOrigen.equals("USD") && monedaDestino.equals("JPY")) {
                    resultado = monto * 110.96;
                } else if (monedaOrigen.equals("EUR") && monedaDestino.equals("USD")) {
                    resultado = monto * 1.20;
                } else if (monedaOrigen.equals("EUR") && monedaDestino.equals("JPY")) {
                    resultado = monto * 132.94;
                } else if (monedaOrigen.equals("JPY") && monedaDestino.equals("USD")) {
                    resultado = monto * 0.0090;
                } else if (monedaOrigen.equals("JPY") && monedaDestino.equals("EUR")) {
                    resultado = monto * 0.0075;
                } else {
                    // Si no hay una conversión definida, mostrar un mensaje de error
                    JOptionPane.showMessageDialog(null, "Conversión no definida", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Mostrar el resultado de la conversión
                lblResultado.setText(String.format("%.2f", resultado));
            }
        });

        add(btnConvertir);

        // Mostrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new ConversorMonedas();
    }
}