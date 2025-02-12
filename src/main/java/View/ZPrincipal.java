package View;
  
public class ZPrincipal extends javax.swing.JFrame {
    public ZPrincipal() {
        initComponents();
        // Chama a tela inicial do sistema
        MenuInicial menuInicial = new MenuInicial();
        menuInicial.setVisible(true);
        this.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        bntSairDoSistema = new javax.swing.JButton();
        bntNotificacoes = new javax.swing.JButton();
        bntEditarPerfil = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");

        bntSairDoSistema.setBackground(new java.awt.Color(242, 242, 242));
        bntSairDoSistema.setText("Sair");
        bntSairDoSistema.setBorder(null);
        bntSairDoSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSairDoSistemaActionPerformed(evt);
            }
        });

        bntNotificacoes.setBackground(new java.awt.Color(242, 242, 242));
        bntNotificacoes.setText("Notificações");
        bntNotificacoes.setBorder(null);
        bntNotificacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNotificacoesActionPerformed(evt);
            }
        });

        bntEditarPerfil.setBackground(new java.awt.Color(242, 242, 242));
        bntEditarPerfil.setText("Editar Perfil");
        bntEditarPerfil.setBorder(null);
        bntEditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditarPerfilActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bntSairDoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntNotificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntEditarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 801, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntSairDoSistema)
                    .addComponent(bntNotificacoes)
                    .addComponent(bntEditarPerfil))
                .addGap(0, 638, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntSairDoSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSairDoSistemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntSairDoSistemaActionPerformed

    private void bntNotificacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNotificacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntNotificacoesActionPerformed

    private void bntEditarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntEditarPerfilActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntEditarPerfil;
    private javax.swing.JButton bntNotificacoes;
    private javax.swing.JButton bntSairDoSistema;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
