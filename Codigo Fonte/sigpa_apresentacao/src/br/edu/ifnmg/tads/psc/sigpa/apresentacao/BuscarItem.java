/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.apresentacao;

import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ItemFinanceiroRepositorio;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Fornecedor;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.RepositorioBuilder;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ananda Sá
 */
public class BuscarItem extends FormBuscar<Fornecedor> {
    
    ItemFinanceiroRepositorio item;
    public BuscarItem() throws ClassNotFoundException{
            initComponents();
            setRepositorio(RepositorioBuilder.getFornecedorRepositorio());
    }
    
@Override
    protected void preencherTabela(List<Fornecedor> resultado) {
        DefaultTableModel modelo = new DefaultTableModel();
            
        modelo.addColumn("ID");
        modelo.addColumn("CNPJ");
        modelo.addColumn("Cidade");
        modelo.addColumn("Telefone");
        modelo.addColumn("Nome");
        modelo.addColumn("Representante");

        for(Fornecedor f : resultado){
            Vector valores = new Vector();
            valores.add(f.getId());
            valores.add(f.getCnpj());
            valores.add(f.getEndereco().getCidade());
            valores.add(f.getTelefone());
            valores.add(f.getNome());
            valores.add(f.getRepresentante());

            modelo.addRow(valores);
        }

       // tabResultado.setModel(modelo);
    }
    @Override
    protected Fornecedor carregaFiltro() {
        Fornecedor filtro = new Fornecedor();
        if(!txt_nome.getText().isEmpty()){
            filtro.setNome(txt_nome.getText());
        }
        if(!txt_cnpj.getText().isEmpty()){
            filtro.setCnpj(txt_cnpj.getText());
        }
        return filtro;
    }

    @Override
    protected Fornecedor novaEntidade() {
        return new Fornecedor();
    }    /**
     * Creates new form BuscarFornecedor
     */
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_cnpj = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Buscar Item Financeiro");

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel1.setText("Data");

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel3.setText("Fornecedor");

        btn_buscar.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/tads/psc/sigpa/apresentacao/research(1).png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cnpj))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btn_buscar)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        buscar();
    }//GEN-LAST:event_btn_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txt_cnpj;
    private javax.swing.JTextField txt_nome;
    // End of variables declaration//GEN-END:variables

}

