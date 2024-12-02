import javax.swing.*;

public class RegistroForm extends javax.swing.JFrame {

    // 1
    private JTextField txtDni, txtNombre, txtApePaterno, txtApeMaterno, txtNumCelular, txtCorreo, txtFechaNacimiento;
    private JComboBox<String> comboTipoUsuario;
    private JButton btnRegistrar;
    private JLabel lblDni, lblNombre, lblApePaterno, lblApeMaterno, lblNumCelular, lblCorreo, lblFechaNacimiento, lblTipoUsuario;
    private Conection cursor = new Conection();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //2
    public RegistroForm() {
        initComponents();
        CrearComponents();
        
    }
    
    private void CrearComponents() {
        //3
        // Crear los componentes
        lblTipoUsuario = new JLabel("Tipo de Usuario:");
        comboTipoUsuario = new JComboBox<>(new String[] { "Operario", "Administrador" });
        lblDni = new JLabel("DNI:");
        txtDni = new JTextField();
        txtDni.setDocument(new JTextFieldLimit(9));
        lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();
        txtNombre.setDocument(new JTextFieldLimit(50));
        lblApePaterno = new JLabel("Apellido Paterno:");
        txtApePaterno = new JTextField();
        txtApePaterno.setDocument(new JTextFieldLimit(30));
        lblApeMaterno = new JLabel("Apellido Materno:");
        txtApeMaterno = new JTextField();
        txtApeMaterno.setDocument(new JTextFieldLimit(30));
        lblNumCelular = new JLabel("Número Celular:");
        txtNumCelular = new JTextField();
        txtNumCelular.setDocument(new JTextFieldLimit(9));
        lblCorreo = new JLabel("Correo:");
        txtCorreo = new JTextField();
        txtCorreo.setDocument(new JTextFieldLimit(128));
        lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        txtFechaNacimiento = new JTextField();
        txtFechaNacimiento.setDocument(new JTextFieldLimit(10));
        btnRegistrar = new JButton("Registrar");

        // Configurar el comportamiento del comboBox para mostrar diferentes campos según el tipo de usuario seleccionado
        comboTipoUsuario.addActionListener(evt -> actualizarFormulario());

        // Configurar el botón para registrar
        btnRegistrar.addActionListener(evt -> registrarUsuario());
        
        //4
        // Configurar el layout del formulario (agregar los componentes al JFrame)
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoUsuario)
                    .addComponent(comboTipoUsuario, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApePaterno)
                    .addComponent(txtApePaterno, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApeMaterno)
                    .addComponent(txtApeMaterno, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumCelular)
                    .addComponent(txtNumCelular, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(txtFechaNacimiento, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lblTipoUsuario)
            .addComponent(comboTipoUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblDni)
            .addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNombre)
            .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblApePaterno)
            .addComponent(txtApePaterno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblApeMaterno)
            .addComponent(txtApeMaterno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNumCelular)
            .addComponent(txtNumCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblCorreo)
            .addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblFechaNacimiento)
            .addComponent(txtFechaNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnRegistrar)
            .addContainerGap(30, Short.MAX_VALUE)
        );

        pack();
    }
    
    //5
    // Método para actualizar los campos del formulario según el tipo de usuario seleccionado
    private void actualizarFormulario() {
        String tipoUsuario = (String) comboTipoUsuario.getSelectedItem();

        // Si el tipo de usuario es "Operario", mostramos todos los campos
        if (tipoUsuario.equals("Operario")) {
            lblDni.setVisible(true);
            txtDni.setVisible(true);
            lblCorreo.setVisible(false);
            txtCorreo.setVisible(false);
        } 
        // Si el tipo de usuario es "Administrador", ocultamos el DNI y mostramos el correo
        else if (tipoUsuario.equals("Administrador")) {
            lblDni.setVisible(false);
            txtDni.setVisible(false);
            lblCorreo.setVisible(true);
            txtCorreo.setVisible(true);
        }
    }

    // Método para registrar el usuario
    //6
    private void registrarUsuario() {
        String dni = txtDni.getText();
        String nombre = txtNombre.getText();
        String apePaterno = txtApePaterno.getText();
        String apeMaterno = txtApeMaterno.getText();
        String numCelular = txtNumCelular.getText();
        String correo = txtCorreo.getText();
        String fechaNacimiento = txtFechaNacimiento.getText();

        // Mostrar los datos para verificar
        JOptionPane.showMessageDialog(this, """
                                            Datos registrados:
                                            DNI: """ + dni + "\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido Paterno: " + apePaterno + "\n" +
                "Apellido Materno: " + apeMaterno + "\n" +
                "Celular: " + numCelular + "\n" +
                "Correo: " + correo + "\n" +
                "Fecha de Nacimiento: " + fechaNacimiento);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new RegistroForm().setVisible(true);
        });
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

