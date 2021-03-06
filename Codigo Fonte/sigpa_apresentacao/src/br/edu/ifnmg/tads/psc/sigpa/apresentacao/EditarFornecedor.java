/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.psc.sigpa.apresentacao;

import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Endereco;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.EnderecoRepositorio;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Fornecedor;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.RepositorioBuilder;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ViolacaoRegraNegocioException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jéssica Ramos
 */
public class EditarFornecedor extends javax.swing.JInternalFrame{

    FornecedorRepositorio fornecedor;
    EnderecoRepositorio endereco;
    
    Endereco e;
    Fornecedor f;
   
    /** Creates new form CadastroFornecedor
     * @throws java.lang.ClassNotFoundException */
    public EditarFornecedor() throws ClassNotFoundException {
            initComponents();
            e = new Endereco();
            f = new Fornecedor();
            endereco=RepositorioBuilder.getEnderecoRepositorio();
            fornecedor=RepositorioBuilder.getFornecedorRepositorio(); 
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_telefone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_representante = new javax.swing.JTextField();
        btn_salvar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_rua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_numero = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_bairro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_cidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cb_uf = new javax.swing.JComboBox<>();
        txt_cnpj = new javax.swing.JFormattedTextField();
        txt_cep = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Nome: ");

        jLabel2.setText("CNPJ:");

        jLabel3.setText("E-Mail:");

        jLabel4.setText("Telefone:");

        jLabel5.setText("Representante:");

        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        jLabel6.setText("Rua: ");

        jLabel7.setText("N°");

        txt_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numeroActionPerformed(evt);
            }
        });

        jLabel8.setText("Bairro:");

        jLabel9.setText("Cidade");

        jLabel10.setText("CEP:");

        jLabel11.setText("UF:");

        cb_uf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        try {
            txt_cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txt_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_representante, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(10, 10, 10)
                                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_telefone, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(txt_cnpj))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_rua, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_bairro)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_representante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numeroActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        try {
            // TODO add your handling code here:
            preencherParametros();
            
            salvar();
            limparCampos();
        } catch (ViolacaoRegraNegocioException | ParseException ex) {
            Logger.getLogger(EditarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_salvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_salvar;
    private javax.swing.JComboBox<String> cb_uf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JFormattedTextField txt_cep;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JFormattedTextField txt_cnpj;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextField txt_representante;
    private javax.swing.JTextField txt_rua;
    private javax.swing.JTextField txt_telefone;
    // End of variables declaration//GEN-END:variables

    private void preencherParametros() throws ViolacaoRegraNegocioException, ParseException{
        f.setCnpj(txt_cnpj.getText());
        f.setNome(txt_nome.getText());
        f.setEmail(txt_email.getText());
        f.setTelefone(txt_telefone.getText());
        f.setRepresentante(txt_representante.getText());

        e.setRua(txt_rua.getText());
        e.setNumero(new Integer(txt_numero.getText()));
        e.setBairro(txt_bairro.getText());
        e.setCidade(txt_cidade.getText());
        e.setUf((String) cb_uf.getSelectedItem());
        e.setCep(txt_cep.getText());
        f.setEndereco(e);
    }


    protected void salvar() {
        if (endereco.Salvar(e) && (fornecedor.Salvar(f))){
            JOptionPane.showMessageDialog(rootPane, "Fornecedor cadastrado com sucesso!");
        } else{
            JOptionPane.showMessageDialog(rootPane, "NÃO FOI POSSIVEL FAZER O CADASTRO!");
        }
    }
    
    private void limparCampos() {
       txt_bairro.setText("");
       txt_cep.setText("");
       txt_cidade.setText("");
       txt_cnpj.setText("");
       txt_email.setText("");
       txt_representante.setText("");
       txt_nome.setText("");
       txt_numero.setText("");
       txt_rua.setText("");
       txt_telefone.setText("");
    }

    /**
     *
     * @throws ViolacaoRegraNegocioException
     */
    protected void carregaObjeto() throws ViolacaoRegraNegocioException {
        f.setCnpj(txt_cnpj.getText());
        f.setNome(txt_nome.getText());
        f.setEmail(txt_email.getText());
        f.setTelefone(txt_telefone.getText());
        e.setRua(txt_rua.getText());
        e.setNumero(new Integer(txt_numero.getText()));
        e.setBairro(txt_bairro.getText());
        e.setCidade(txt_cidade.getText());
        e.setUf((String) cb_uf.getSelectedItem());
        e.setCep(txt_cep.getText());  
        f.setRepresentante(txt_representante.getText()); 
        f.setEndereco(e);
    }

    protected void carregaCampos() {
       txt_bairro.setText(e.getBairro());
       txt_cep.setText(e.getCep());
       txt_cidade.setText(e.getCidade());
       txt_cnpj.setText(f.getCnpj());
       txt_email.setText(f.getEmail());
       txt_representante.setText(f.getRepresentante());
       txt_nome.setText(f.getNome());
       txt_numero.setText(Integer.toString(e.getNumero()));
       txt_rua.setText(e.getRua());
       txt_telefone.setText(f.getTelefone());
    }
}
