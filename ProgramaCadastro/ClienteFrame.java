package ProgramaCadastro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClienteFrame extends JFrame {
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtEndereco;
    private JTextField txtTelefone;
    private JTextField txtServicos;
    private JTextField txtData;
    private JTextField txtGarantia;
    private JButton btnAdicionar;
    private JButton btnMostrarClientes;
    private JButton btnPesquisar;
    private JTextField txtPesquisa;
    private JPanel panelClientes;

    private ArrayList<String[]> listaClientes;

    public ClienteFrame() {
        listaClientes = new ArrayList<>();

        setTitle("Cadastro de Clientes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblNome = new JLabel("Nome Completo:");
        JLabel lblCpf = new JLabel("CPF:");
        JLabel lblEndereco = new JLabel("Endereço:");
        JLabel lblTelefone = new JLabel("Telefone:");
        JLabel lblServicos = new JLabel("Serviços Prestados:");
        JLabel lblData = new JLabel("Data:");
        JLabel lblGarantia = new JLabel("Tempo de Garantia:");
        JLabel lblPesquisa = new JLabel("Pesquisar Nome:");

        txtNome = new JTextField(20);
        txtCpf = new JTextField(20);
        txtEndereco = new JTextField(20);
        txtTelefone = new JTextField(20);
        txtServicos = new JTextField(20);
        txtData = new JTextField(20);
        txtGarantia = new JTextField(20);
        txtPesquisa = new JTextField(20);

        btnAdicionar = new JButton("Adicionar Cliente");
        btnMostrarClientes = new JButton("Mostrar Clientes");
        btnPesquisar = new JButton("Pesquisar");

        panelClientes = new JPanel();
        panelClientes.setLayout(new BoxLayout(panelClientes, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(panelClientes);

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String cpf = txtCpf.getText();
                String endereco = txtEndereco.getText();
                String telefone = txtTelefone.getText();
                String servicos = txtServicos.getText();
                String data = txtData.getText();
                String garantia = txtGarantia.getText();

                String[] cliente = {nome, cpf, endereco, telefone, servicos, data, garantia};
                listaClientes.add(cliente);
                JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");

                txtNome.setText("");
                txtCpf.setText("");
                txtEndereco.setText("");
                txtTelefone.setText("");
                txtServicos.setText("");
                txtData.setText("");
                txtGarantia.setText("");
            }
        });

        btnMostrarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelClientes.removeAll();
                for (String[] cliente : listaClientes) {
                    JLabel lblCliente = new JLabel(formatarCliente(cliente));
                    panelClientes.add(lblCliente);
                }
                panelClientes.revalidate();
                panelClientes.repaint();
            }
        });

        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomePesquisa = txtPesquisa.getText().toLowerCase();
                panelClientes.removeAll();
                for (String[] cliente : listaClientes) {
                    if (cliente[0].toLowerCase().contains(nomePesquisa)) {
                        JLabel lblCliente = new JLabel(formatarCliente(cliente));
                        panelClientes.add(lblCliente);
                    }
                }
                panelClientes.revalidate();
                panelClientes.repaint();
            }
        });

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(lblNome, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(txtNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(lblCpf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(txtCpf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(lblEndereco, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(txtEndereco, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(lblTelefone, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(txtTelefone, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(lblServicos, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(txtServicos, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(lblData, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(txtData, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(lblGarantia, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(txtGarantia, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnAdicionar, gbc);

        gbc.gridy = 8;
        panel.add(btnMostrarClientes, gbc);

        gbc.gridy = 9;
        panel.add(lblPesquisa, gbc);

        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(txtPesquisa, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(btnPesquisar, gbc);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private String formatarCliente(String[] cliente) {
        return "<html><b>Nome:</b> " + cliente[0] + " | " +
               "<b>CPF:</b> " + cliente[1] + " | " +
               "<b>Endereço:</b> " + cliente[2] + " | " +
               "<b>Telefone:</b> " + cliente[3] + " | " +
               "<b>Serviços:</b> " + cliente[4] + " | " +
               "<b>Data:</b> " + cliente[5] + " | " +
               "<b>Garantia:</b> " + cliente[6] + "</html>";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteFrame();
            }
        });
    }
}

