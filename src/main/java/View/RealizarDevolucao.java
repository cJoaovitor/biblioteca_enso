package View;

import Model.EmprestimoModel;
import Model.LivroModel;
import dados.Dados;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class RealizarDevolucao extends javax.swing.JFrame {

    public RealizarDevolucao() {
        initComponents();
    }

        private void limparCampos() {
            txtCodLivro.setText("");
            txtTituloLivro.setText("");
            txtNomeUsuario.setText("");
            txtNomeUsuario1.setText("");
            txtNomeUsuario3.setText("");
            atrazadoSIM1.setSelected(false);
            atrazadoNAO.setSelected(false);
            btnDevolver.setEnabled(false);
        }
        
        
        private EmprestimoModel buscarEmprestimoPorLivro(LivroModel livro) {
            for (EmprestimoModel emprestimo : Dados.getEmprestimos()) {
                if (emprestimo.getLivro().equals(livro) && !emprestimo.isDevolvido()) {
                    return emprestimo;
                }
            }
            return null;
        }
   
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTelefone = new javax.swing.JFormattedTextField();
        txtCelular = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSexoM = new javax.swing.JRadioButton();
        txtSexoF = new javax.swing.JRadioButton();
        txtCep = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtUf = new javax.swing.JComboBox();
        txtNumero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtCodUsuario = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtNomeUsuario2 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel15 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtCodLivro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTituloLivro = new javax.swing.JTextField();
        txtNomeUsuario = new javax.swing.JTextField();
        btnDevolver = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtNomeUsuario1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtNomeUsuario3 = new javax.swing.JTextField();
        atrazadoNAO = new javax.swing.JRadioButton();
        atrazadoSIM1 = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));

        jLabel5.setText("Email:");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel6.setText("Senha:");

        jLabel7.setText("Confirme a senha");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

        jLabel1.setText("Nome:");

        txtNome.setName(""); // NOI18N
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel2.setText("CPF:");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        jLabel3.setText("Data de Nascimento:");

        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Sexo:");

        txtSexoM.setText("Masculino");
        txtSexoM.setName("sexo"); // NOI18N

        txtSexoF.setText("Feminino");
        txtSexoF.setName("sexo"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSexoM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSexoF)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtSexoM)
                    .addComponent(txtSexoF))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel14.setText("CEP:");

        jLabel11.setText("Bairro:");

        jLabel10.setText("Descrição:");

        jLabel12.setText("Gênero:");

        txtUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ficção", "Romance", "Ficção científica", "Fantasia", "Mistério", "Thriller", "Horror", "Literatura contemporânea", "Literatura clássica", "Literatura juvenil", "Romance juvenil", "Ficção histórica", "Não-ficção", "Biografia", "Autobiografia", "Memórias", "Ensaios", "História", "Ciência", "Autoajuda", "Viagem", "Poesia", "Lírica", "Épica", "Dramática", "Haikai", "Drama", "Tragédia", "Comédia", "Teatro", "Literatura Infantil", "Contos de fadas", "Fábulas", "Livros ilustrados", "Literatura Jovem Adulto (YA)", "Romance YA", "Fantasia YA", "Ficção científica YA", "Graphic Novels e Quadrinhos", "Super-heróis", "Mangás", "Webcomics", "Literatura Erótica", "Literatura de Aventura", "Literatura Histórica", "Romance policial", "Literatura de suspense", "Literatura de terror", "Literatura de ficção especulativa", "Literatura de realismo mágico", "Literatura de mitologia", "Literatura de paródia", "Literatura de sátira", "Literatura de contos", "Literatura de ensaio", "Literatura de crítica social", "Literatura de filosofia", "Literatura de religião e espiritualidade", "Literatura de autoajuda", "Literatura de desenvolvimento pessoal", "Literatura de negócios", "Literatura de culinária", "Literatura de moda", "Literatura de esportes", "Literatura de ciência política", "Literatura de tecnologia", "Literatura de memórias gráficas", "Literatura de poesia visual", "Literatura de romance contemporâneo", "Literatura de ficção romântica", "Literatura de fantasia épica", "Literatura de fantasia urbana", "Literatura de ficção distópica", "Literatura de ficção utópica", "Literatura de horror gótico", "Literatura de horror psicológico", "Literatura de horror cósmico", "Literatura de ficção policial", "Literatura de ficção de espionagem", "Literatura de ficção de aventura", "Literatura de ficção de guerra" }));

        jLabel9.setText("Ano de Publicação:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jLabel8.setText("Título:");

        jLabel13.setText("Autor:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        jPanel3.getAccessibleContext().setAccessibleName("");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel17.setText("Cod. Usuário:");

        jLabel21.setText("Data de Devolução:");

        txtNomeUsuario2.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel15.setText("Devolução");

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon("C:\\Users\\laris\\Downloads\\logo_bibliotecaCorija (1) (2) (1).png")); // NOI18N

        jLabel27.setFont(new java.awt.Font("Tempus Sans ITC", 1, 10)); // NOI18N
        jLabel27.setText("BIBLIOTECA ");

        jLabel28.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel28.setText("CORUJA");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel16.setText("Cod. Livro:");

        txtCodLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodLivroActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel18.setText("Titulo do Livro:");

        jLabel19.setText("Nome do Usuário:");

        txtTituloLivro.setEnabled(false);

        txtNomeUsuario.setEnabled(false);

        btnDevolver.setText("Devolver");
        btnDevolver.setEnabled(false);
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        jLabel20.setText("Data de Empréstimo:");

        txtNomeUsuario1.setEnabled(false);

        jLabel22.setText("Data de Devolução:");

        txtNomeUsuario3.setEnabled(false);

        buttonGroup1.add(atrazadoNAO);
        atrazadoNAO.setText("NÃO");

        buttonGroup1.add(atrazadoSIM1);
        atrazadoSIM1.setText("SIM");

        jLabel23.setText("Atrazado?");

        jLabel24.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel24.setText("REALIZAR");

        jLabel25.setFont(new java.awt.Font("Viner Hand ITC", 1, 48)); // NOI18N
        jLabel25.setText("DEVOLUÇÃO");

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon("C:\\Users\\laris\\OneDrive\\Documentos\\NetBeansProjects\\Biblioteca1\\Imagens\\logo_bibliotecaCorija (1) (2) (1).png")); // NOI18N

        jLabel32.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel32.setText("CORUJA");

        jLabel33.setFont(new java.awt.Font("Tempus Sans ITC", 1, 10)); // NOI18N
        jLabel33.setText("BIBLIOTECA ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel16)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(jLabel18)
                                                    .addGap(17, 17, 17)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel19)
                                                    .addComponent(jLabel20))
                                                .addGap(17, 17, 17)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(txtCodLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTituloLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(txtNomeUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel22)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtNomeUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel23)
                                                        .addGap(28, 28, 28)
                                                        .addComponent(atrazadoSIM1)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(atrazadoNAO)
                                                        .addGap(302, 302, 302))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(314, 314, 314)))
                                .addGap(0, 47, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel32)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtCodLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTituloLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtNomeUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(atrazadoNAO)
                            .addComponent(jLabel23)
                            .addComponent(atrazadoSIM1))))
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDevolver)
                    .addComponent(btnCancelar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCodLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodLivroActionPerformed

    }//GEN-LAST:event_txtCodLivroActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
             String codLivro = txtCodLivro.getText();
    LivroModel livro = Dados.buscarLivroPorCodigo(codLivro);
    if (livro != null) {
        txtTituloLivro.setText(livro.getTitulo());
        EmprestimoModel emprestimo = buscarEmprestimoPorLivro(livro);
        if (emprestimo != null) {
            txtNomeUsuario.setText(emprestimo.getUsuario().getNome());
            txtNomeUsuario1.setText(emprestimo.getDataEmprestimo().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            txtNomeUsuario3.setText(emprestimo.getDataDevolucao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            atrazadoSIM1.setSelected(!emprestimo.isDevolvido() && emprestimo.getDataDevolucao().isBefore(LocalDate.now()));
            atrazadoNAO.setSelected(emprestimo.isDevolvido() || !emprestimo.getDataDevolucao().isBefore(LocalDate.now()));
            btnDevolver.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Não há empréstimo ativo para este livro.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Livro não encontrado.");
    }
 
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
            String codLivro = txtCodLivro.getText();
    LivroModel livro = Dados.buscarLivroPorCodigo(codLivro);
    if (livro != null) {
        EmprestimoModel emprestimo = buscarEmprestimoPorLivro(livro);
        if (emprestimo != null) {
            float multa = emprestimo.calcularMulta();
            if (multa > 0) {
                JOptionPane.showMessageDialog(this, "O usuário deve pagar uma multa de R$ " + multa + " pela devolução atrasada.");
            }
            emprestimo.devolverEmprestimo();
            livro.setDisponivel(true);
            JOptionPane.showMessageDialog(this, "Devolução realizada com sucesso!");
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Não há empréstimo ativo para este livro.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Livro não encontrado.");
    }
    }//GEN-LAST:event_btnDevolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton atrazadoNAO;
    private javax.swing.JRadioButton atrazadoSIM1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCodLivro;
    private javax.swing.JTextField txtCodUsuario;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeUsuario;
    private javax.swing.JTextField txtNomeUsuario1;
    private javax.swing.JTextField txtNomeUsuario2;
    private javax.swing.JTextField txtNomeUsuario3;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JRadioButton txtSexoF;
    private javax.swing.JRadioButton txtSexoM;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JTextField txtTituloLivro;
    private javax.swing.JComboBox txtUf;
    // End of variables declaration//GEN-END:variables

}
