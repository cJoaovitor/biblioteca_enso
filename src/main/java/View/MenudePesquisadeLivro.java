package View;

public class MenudePesquisadeLivro extends javax.swing.JFrame {

    public MenudePesquisadeLivro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTelefone = new javax.swing.JFormattedTextField();
        txtCelular = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSexoM = new javax.swing.JRadioButton();
        txtSexoF = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtUf = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCep = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar10 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btnCancelar4 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        bntReserva = new javax.swing.JButton();
        bntVisualizarCatalogo = new javax.swing.JButton();
        bntConsultarHistoricoDeUsuario = new javax.swing.JButton();
        bntEditarDisponibilidadeDeLivro = new javax.swing.JButton();
        bntAdiconarLivro = new javax.swing.JButton();
        bntRemoverLivro = new javax.swing.JButton();
        bntPesquisarLivroDisponiveisParaEmprestimo = new javax.swing.JButton();
        bntEditarDadosDeUsuário = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        bntTítulo = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        bntAutor = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        bntDisponibilidade = new javax.swing.JButton();
        bntGenero = new javax.swing.JButton();

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

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
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
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
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));

        jLabel5.setText("Email:");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel6.setText("Fone:");

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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jLabel8.setText("Logadouro:");

        jLabel9.setText("Nº:");

        jLabel10.setText("Complemento:");

        jLabel11.setText("Bairro:");

        jLabel12.setText("UF:");

        txtUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jLabel13.setText("Cidade:");

        jLabel14.setText("CEP:");

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtComplemento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBairro))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCep)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Visualizar Meu Histórico");
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Nome:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar10.setText("Pesquisar Livros Disponíveis");
        btnCancelar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar10ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel15.setText("Bem Vindo!!");

        btnCancelar4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar4.setText("Criar Conta de Usuário");
        btnCancelar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar4ActionPerformed(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon("C:\\Users\\laris\\Downloads\\logo_bibliotecaCorija (1) (2).png")); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel29.setText("BIBLIOTECA ");

        bntReserva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntReserva.setText("Registrar Reservas");
        bntReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntReservaActionPerformed(evt);
            }
        });

        bntVisualizarCatalogo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntVisualizarCatalogo.setText("Visualizar Catálogo");
        bntVisualizarCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVisualizarCatalogoActionPerformed(evt);
            }
        });

        bntConsultarHistoricoDeUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntConsultarHistoricoDeUsuario.setText("Consultar Histórico do Usuário");
        bntConsultarHistoricoDeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntConsultarHistoricoDeUsuarioActionPerformed(evt);
            }
        });

        bntEditarDisponibilidadeDeLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntEditarDisponibilidadeDeLivro.setText("Editar Disponibilidade");
        bntEditarDisponibilidadeDeLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditarDisponibilidadeDeLivroActionPerformed(evt);
            }
        });

        bntAdiconarLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntAdiconarLivro.setText("Adicionar Livros");
        bntAdiconarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAdiconarLivroActionPerformed(evt);
            }
        });

        bntRemoverLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntRemoverLivro.setText("Remover Livros");
        bntRemoverLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRemoverLivroActionPerformed(evt);
            }
        });

        bntPesquisarLivroDisponiveisParaEmprestimo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntPesquisarLivroDisponiveisParaEmprestimo.setText("Pesquisar Livros Disponíveis");
        bntPesquisarLivroDisponiveisParaEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPesquisarLivroDisponiveisParaEmprestimoActionPerformed(evt);
            }
        });

        bntEditarDadosDeUsuário.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntEditarDadosDeUsuário.setText("Editar Dados de Usuário");
        bntEditarDadosDeUsuário.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditarDadosDeUsuárioActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCancelar.setText("Voltar Para a Tela Inicial");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        bntTítulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntTítulo.setText("Título");
        bntTítulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntTítuloActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Viner Hand ITC", 1, 60)); // NOI18N
        jLabel16.setText("PESQUISA");

        jLabel19.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        jLabel19.setText("CORUJA");

        jLabel18.setFont(new java.awt.Font("Tempus Sans ITC", 1, 10)); // NOI18N
        jLabel18.setText("BIBLIOTECA ");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Users\\laris\\Downloads\\logo_bibliotecaCorija (1) (2) (1).png")); // NOI18N

        bntAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntAutor.setText("Autor");
        bntAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAutorActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel30.setText("Por qual critério gostaria de Pesquisar?");

        bntDisponibilidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntDisponibilidade.setText("Disponibilidade");
        bntDisponibilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDisponibilidadeActionPerformed(evt);
            }
        });

        bntGenero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntGenero.setText("Gênero");
        bntGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntGeneroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(284, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(165, 165, 165)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntTítulo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntDisponibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(155, 155, 155))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntTítulo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntDisponibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(29, 29, 29))
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

    private void bntConsultarHistoricoDeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntConsultarHistoricoDeUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntConsultarHistoricoDeUsuarioActionPerformed

    private void bntRemoverLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRemoverLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntRemoverLivroActionPerformed

    private void bntAdiconarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAdiconarLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntAdiconarLivroActionPerformed

    private void btnCancelar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelar4ActionPerformed

    private void bntTítuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntTítuloActionPerformed
        PesquisaRequisitoTitulo tela = new PesquisaRequisitoTitulo();
        tela.setVisible(true);
    }//GEN-LAST:event_bntTítuloActionPerformed

    private void bntReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntReservaActionPerformed

    private void bntEditarDisponibilidadeDeLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarDisponibilidadeDeLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntEditarDisponibilidadeDeLivroActionPerformed

    private void bntVisualizarCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVisualizarCatalogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntVisualizarCatalogoActionPerformed

    private void bntEditarDadosDeUsuárioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarDadosDeUsuárioActionPerformed
        
    }//GEN-LAST:event_bntEditarDadosDeUsuárioActionPerformed

    private void btnCancelar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelar10ActionPerformed

    private void bntPesquisarLivroDisponiveisParaEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPesquisarLivroDisponiveisParaEmprestimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntPesquisarLivroDisponiveisParaEmprestimoActionPerformed

    private void bntAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAutorActionPerformed
            PesquisaRequisitoAutor tela = new PesquisaRequisitoAutor();
            tela.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bntAutorActionPerformed

    private void bntDisponibilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDisponibilidadeActionPerformed
        VisualizarLivrosDisponiveis tela = new VisualizarLivrosDisponiveis();
        tela.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_bntDisponibilidadeActionPerformed

    private void bntGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntGeneroActionPerformed
            PesquisaRequisitoGenero tela = new PesquisaRequisitoGenero();
            tela.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bntGeneroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAdiconarLivro;
    private javax.swing.JButton bntAutor;
    private javax.swing.JButton bntConsultarHistoricoDeUsuario;
    private javax.swing.JButton bntDisponibilidade;
    private javax.swing.JButton bntEditarDadosDeUsuário;
    private javax.swing.JButton bntEditarDisponibilidadeDeLivro;
    private javax.swing.JButton bntGenero;
    private javax.swing.JButton bntPesquisarLivroDisponiveisParaEmprestimo;
    private javax.swing.JButton bntRemoverLivro;
    private javax.swing.JButton bntReserva;
    private javax.swing.JButton bntTítulo;
    private javax.swing.JButton bntVisualizarCatalogo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar10;
    private javax.swing.JButton btnCancelar4;
    private javax.swing.JButton btnSalvar;
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JRadioButton txtSexoF;
    private javax.swing.JRadioButton txtSexoM;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JComboBox txtUf;
    // End of variables declaration//GEN-END:variables
}
