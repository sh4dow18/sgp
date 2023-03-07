
package sgp.Views;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;
import sgp.database.Database;
import sgp.Utilities.PDF;
import sgp.Utilities.SendEmail;
import sgp.Utilities.XML;

public class RegisterView extends javax.swing.JFrame {
    private ArrayList<String> register;
    public RegisterView() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
    }
    
    public void set_register(int code_number) {
        register = Database.get_instance().obtain_register(code_number);
        code.setText(String.format("%05d", Integer.valueOf(register.get(0))));
        identification.setText(register.get(1));
        ArrayList<String> services_array = new ArrayList(Arrays.asList(register.get(2).split("\\s*, \\s*")));
        for (String service : services_array) {
            services.addItem(Database.get_instance().obtain_service_name(Integer.parseInt(service)));
        }
        details.setText(register.get(3));
        created_date.setText(register.get(4));
        finished_date.setText(register.get(5));
        if (finished_date.getText().compareTo("Not Yet") != 0) {
            delivered.setEnabled(true);
        }
        delivered_date.setText(register.get(6));
        if (delivered_date.getText().compareTo("Not Yet") != 0) {
            pdf_button.setEnabled(true);
        }
        if (register.get(7).compareTo("") != 0) {
            ArrayList<String> promotions_array = new ArrayList(Arrays.asList(register.get(7).split("\\s*, \\s*")));
            for (String promotion : promotions_array) {
                promotions.addItem(Database.get_instance().obtain_promotion_name(Integer.parseInt(promotion)));
            }
        }
        this.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        identification = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        details = new javax.swing.JTextArea();
        delete = new javax.swing.JButton();
        pdf_button = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        services = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        created_date = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        finished_date = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        delivered_date = new javax.swing.JTextField();
        finished = new javax.swing.JButton();
        delivered = new javax.swing.JButton();
        see_client = new javax.swing.JButton();
        send_button = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        promotions = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Register");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Client's ID");

        identification.setEditable(false);
        identification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificationActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Services:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Details:");

        details.setEditable(false);
        details.setColumns(20);
        details.setRows(5);
        jScrollPane1.setViewportView(details);

        delete.setBackground(new java.awt.Color(0, 0, 0));
        delete.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        pdf_button.setBackground(new java.awt.Color(0, 0, 0));
        pdf_button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        pdf_button.setForeground(new java.awt.Color(255, 255, 255));
        pdf_button.setText("PDF");
        pdf_button.setEnabled(false);
        pdf_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdf_buttonActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Code:");

        code.setEditable(false);
        code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(0, 0, 0));
        back.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Created on:");

        created_date.setEditable(false);
        created_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                created_dateActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Finished on:");

        finished_date.setEditable(false);
        finished_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finished_dateActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Delivered on:");

        delivered_date.setEditable(false);
        delivered_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delivered_dateActionPerformed(evt);
            }
        });

        finished.setBackground(new java.awt.Color(0, 0, 0));
        finished.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        finished.setForeground(new java.awt.Color(255, 255, 255));
        finished.setText("Finished");
        finished.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishedActionPerformed(evt);
            }
        });

        delivered.setBackground(new java.awt.Color(0, 0, 0));
        delivered.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        delivered.setForeground(new java.awt.Color(255, 255, 255));
        delivered.setText("Delivered");
        delivered.setEnabled(false);
        delivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveredActionPerformed(evt);
            }
        });

        see_client.setBackground(new java.awt.Color(0, 0, 0));
        see_client.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        see_client.setForeground(new java.awt.Color(255, 255, 255));
        see_client.setText("See Client");
        see_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                see_clientActionPerformed(evt);
            }
        });

        send_button.setBackground(new java.awt.Color(0, 0, 0));
        send_button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        send_button.setForeground(new java.awt.Color(255, 255, 255));
        send_button.setText("Send");
        send_button.setEnabled(false);
        send_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_buttonActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Promotions:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(identification, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(see_client, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(finished, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(delivered, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(services, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(pdf_button, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(created_date, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(36, 36, 36)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(finished_date, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(promotions, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(82, 82, 82)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(delivered_date, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(identification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(see_client, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(services, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(promotions, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(created_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finished_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delivered_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delivered)
                    .addComponent(finished)
                    .addComponent(pdf_button)
                    .addComponent(send_button))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(delete))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void identificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_identificationActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "Are you sure that do you want to remove this register?", "Sure?", JOptionPane.INFORMATION_MESSAGE);
        if (option == 0) {
            int result = Database.get_instance().remove_register(Integer.parseInt(code.getText()));
            switch (result) {
                case 0 -> {
                    JOptionPane.showMessageDialog(null, "Register removed sucessfully");
                    this.setVisible(false);
                    new MainView().setVisible(true);
                }
                case 1 -> JOptionPane.showMessageDialog(null, "Register cannot be removed, an Error ocurred with database", "Error", JOptionPane.ERROR_MESSAGE);
                default -> JOptionPane.showMessageDialog(null, "Register cannot be removed, an Error ocurred", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void pdf_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdf_buttonActionPerformed
        int result = 2;
        try {
            result = PDF.get_instance().create_PDF(register);
        } catch (DocumentException | IOException ex) {
            System.err.println(ex);
        }
        switch (result) {
            case 0 -> { 
                JOptionPane.showMessageDialog(null, "PDF Document created Sucessfully");
                send_button.setEnabled(true);
            }
            case 1 -> JOptionPane.showMessageDialog(null, "PDF Document cannot be created, an Error ocurred with database", "Error", JOptionPane.ERROR_MESSAGE);
            default -> JOptionPane.showMessageDialog(null, "PDF Document cannot be created, an Error ocurred", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pdf_buttonActionPerformed

    private void codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.setVisible(false);
        new MainView().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void created_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_created_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_created_dateActionPerformed

    private void finished_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finished_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finished_dateActionPerformed

    private void delivered_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delivered_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delivered_dateActionPerformed

    private void finishedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishedActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Is it finished?");
        if (result == 0) {
            finished_date.setText(new SimpleDateFormat("d MMM yyyy").format(new Date()));
            register.set(5, finished_date.getText());
            delivered.setEnabled(true);
        }
        else if (result == 1) {
            finished_date.setText("Not Yet");
            register.set(5, finished_date.getText());
            delivered.setEnabled(false);
        }
        if (result != 2) {
            Database.get_instance().save_dates(Integer.parseInt(code.getText()), finished_date.getText(), delivered_date.getText());
        }
    }//GEN-LAST:event_finishedActionPerformed

    private void deliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveredActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Is it delivered?");
        if (result == 0) {
            delivered_date.setText(new SimpleDateFormat("d MMM yyyy").format(new Date()));
            register.set(6, delivered_date.getText());
            pdf_button.setEnabled(true);
        }
        else if (result == 1) {
            delivered_date.setText("Not Yet");
            register.set(6, delivered_date.getText());
            pdf_button.setEnabled(false);
            send_button.setEnabled(false);
        }
        if (result != 2) {
            Database.get_instance().save_dates(Integer.parseInt(code.getText()), finished_date.getText(), delivered_date.getText());
        }
    }//GEN-LAST:event_deliveredActionPerformed

    private void see_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_see_clientActionPerformed
        this.setVisible(false);
        ResultsClientsView client_view = new ResultsClientsView();
        client_view.set_code(Integer.parseInt(code.getText()));
        client_view.show_results("id", identification.getText(), 2);
    }//GEN-LAST:event_see_clientActionPerformed

    private void send_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_buttonActionPerformed
        String file_name = "Factura y Garantia de Registro " + String.format("%05d", Integer.valueOf(code.getText())); 
        if (XML.get_instance().convert_pdf_to_xml(file_name) == true) {
            String to = Database.get_instance().obtain_email_from_id(Integer.parseInt(identification.getText()));
            int result = SendEmail.get_instance().sent_email(to, file_name);
            switch (result) {
                case 0 -> JOptionPane.showMessageDialog(null, "PDF Document sent Sucessfully");
                default -> JOptionPane.showMessageDialog(null, "PDF Document cannot be send, an Error ocurred", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "XML Document cannot be created, an Error ocurred", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_send_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField code;
    private javax.swing.JTextField created_date;
    private javax.swing.JButton delete;
    private javax.swing.JButton delivered;
    private javax.swing.JTextField delivered_date;
    private javax.swing.JTextArea details;
    private javax.swing.JButton finished;
    private javax.swing.JTextField finished_date;
    private javax.swing.JTextField identification;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pdf_button;
    private javax.swing.JComboBox<String> promotions;
    private javax.swing.JButton see_client;
    private javax.swing.JButton send_button;
    private javax.swing.JComboBox<String> services;
    // End of variables declaration//GEN-END:variables
}
