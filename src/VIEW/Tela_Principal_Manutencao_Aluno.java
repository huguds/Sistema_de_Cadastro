/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import CONEXAO.ModuloDeConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author vitin
 */
public class Tela_Principal_Manutencao_Aluno extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    // criando o metodo para alterar dados do usuário
    
    private void alterar(){
        String sql = "update aluno set nomealu=?, nasalu=?, curso=? where idaluno=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TxtNome2.getText());
            pst.setString(2, TxtDataNascimento2.getText());
            pst.setString(3, TxtCurso2.getText());
            pst.setString(4, TxtIdAluno.getText());
            
            if((TxtIdAluno.getText().isEmpty() || (TxtNome2.getText().isEmpty() || TxtDataNascimento2.getText().isEmpty() || TxtCurso2.getText().isEmpty())))
            {
                 JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                int adicionado = pst.executeUpdate();
                
                if (adicionado > 0){
                    JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso");
                    TxtNome2.setText(null);
                    TxtDataNascimento2.setText(null);
                    TxtIdAluno.setText(null);
                    TxtCurso2.setText(null);
                    
                
                }
            
            }
               
               
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void remover(){
        
        int confirma=JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma==JOptionPane.YES_OPTION){
            String sql = "delete from aluno where idaluno=?";
            try {
                pst=conexao.prepareStatement(sql);
                pst.setString(1, TxtIdAluno.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0){
                    JOptionPane.showMessageDialog(null, "Aluno removido com sucesso");
                    TxtNome2.setText(null);
                    TxtDataNascimento2.setText(null);
                    TxtIdAluno.setText(null);
                    TxtCurso2.setText(null);
                
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        
        }
    
    }
    
    
    
   

    /**
     * Creates new form Tela_Principal_Manutencao_Aluno
     */
    public Tela_Principal_Manutencao_Aluno() {
        conexao = ModuloDeConexao.conector();
        initComponents();
        
        if (conexao != null) {
            JOptionPane.showMessageDialog(null, "Exito na Conexão");
        } else {
            JOptionPane.showMessageDialog(null, "Falha na Conexão");
        }
        
    }
    
    private void consultar(){
        String sql = "Select * from aluno where idaluno=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TxtIdAluno.getText());
            rs=pst.executeQuery();
            if (rs.next()) {
                TxtNome2.setText(rs.getString(2));
                TxtDataNascimento2.setText(rs.getString(3));
                TxtCurso2.setText(rs.getString(4));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
                
                TxtNome2.setText(null);
                TxtDataNascimento2.setText(null);
                TxtCurso2.setText(null);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CadastroAlunos = new javax.swing.JLabel();
        NomeAluno2 = new javax.swing.JLabel();
        TxtNome2 = new javax.swing.JTextField();
        DataNascimento2 = new javax.swing.JLabel();
        TxtDataNascimento2 = new javax.swing.JTextField();
        Curso2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlstCurso = new javax.swing.JList<>();
        jButton_Alterar_Aluno = new javax.swing.JButton();
        jButton_Excluir_Aluno = new javax.swing.JButton();
        lblIdAluno = new javax.swing.JLabel();
        TxtIdAluno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblCurso2 = new javax.swing.JLabel();
        TxtCurso2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        CadastroAlunos.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        CadastroAlunos.setText("Dados do Aluno");

        NomeAluno2.setText("Nome");

        DataNascimento2.setText("Data de Nascimento");

        Curso2.setText("Curso");

        jlstCurso.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Administração de Empresas", "Bio Medicina", "Ciências Biológicas", "Ciências da Computação", "Direito", "Educação Física", "Farmacologia", "Rede de Computadores", "Sistemas de Informação" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jlstCurso);

        jButton_Alterar_Aluno.setBackground(new java.awt.Color(153, 153, 153));
        jButton_Alterar_Aluno.setText("Alterar");
        jButton_Alterar_Aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Alterar_AlunoActionPerformed(evt);
            }
        });

        jButton_Excluir_Aluno.setBackground(new java.awt.Color(153, 153, 153));
        jButton_Excluir_Aluno.setText("Excluir");
        jButton_Excluir_Aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Excluir_AlunoActionPerformed(evt);
            }
        });

        lblIdAluno.setText("Id Aluno");

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblCurso2.setText("Curso");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_Alterar_Aluno)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton_Excluir_Aluno))
                                .addComponent(TxtIdAluno, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TxtDataNascimento2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(DataNascimento2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TxtNome2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(CadastroAlunos)
                            .addComponent(NomeAluno2)
                            .addComponent(lblIdAluno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curso2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCurso2)
                            .addComponent(TxtCurso2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CadastroAlunos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Curso2)
                    .addComponent(lblIdAluno))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TxtIdAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NomeAluno2)
                        .addGap(18, 18, 18)
                        .addComponent(TxtNome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DataNascimento2)
                        .addGap(18, 18, 18)
                        .addComponent(TxtDataNascimento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCurso2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCurso2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Alterar_Aluno)
                    .addComponent(jButton_Excluir_Aluno)
                    .addComponent(jButton1)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Excluir_AlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Excluir_AlunoActionPerformed
        //deletar();
        remover();
    }//GEN-LAST:event_jButton_Excluir_AlunoActionPerformed

    private void jButton_Alterar_AlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Alterar_AlunoActionPerformed
        // alterar
        alterar();
    }//GEN-LAST:event_jButton_Alterar_AlunoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Evento para consultar:
        consultar();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Principal_Manutencao_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Principal_Manutencao_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Principal_Manutencao_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Principal_Manutencao_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Principal_Manutencao_Aluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CadastroAlunos;
    private javax.swing.JLabel Curso2;
    private javax.swing.JLabel DataNascimento2;
    private javax.swing.JLabel NomeAluno2;
    private javax.swing.JTextField TxtCurso2;
    private javax.swing.JTextField TxtDataNascimento2;
    private javax.swing.JTextField TxtIdAluno;
    private javax.swing.JTextField TxtNome2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Alterar_Aluno;
    private javax.swing.JButton jButton_Excluir_Aluno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> jlstCurso;
    private javax.swing.JLabel lblCurso2;
    private javax.swing.JLabel lblIdAluno;
    // End of variables declaration//GEN-END:variables
}
