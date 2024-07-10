package ProgramaCadastro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnLogin;

    public LoginFrame() {
        setTitle("Login do Administrador");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel lblUsuario = new JLabel("Usuário:");
        JLabel lblSenha = new JLabel("Senha:");
        
        txtUsuario = new JTextField();
        txtSenha = new JPasswordField();
        btnLogin = new JButton("Login");
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtUsuario.getText().equals("admin") && new String(txtSenha.getPassword()).equals("admin123")) {
                    new ClienteFrame();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou Senha inválidos!");
                }
            }
        });
        
        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblSenha);
        panel.add(txtSenha);
        panel.add(new JLabel());
        panel.add(btnLogin);
        
        add(panel);
        
        setVisible(true);
    }
}
