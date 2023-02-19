
package sgp.Views;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;
import sgp.database.Database;

public class AddRegisterView extends javax.swing.JFrame {
    private ArrayList<String> services;
    private ArrayList<String> promotions;
    public AddRegisterView() {
        services = new ArrayList();
        promotions = new ArrayList();
    }
    
    public void start(String id) {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        identification.setText(id);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        identification = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        details = new javax.swing.JTextArea();
        add = new javax.swing.JButton();
        select_services = new javax.swing.JButton();
        back = new javax.swing.JButton();
        remove_services = new javax.swing.JButton();
        see_client = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        select_promotions = new javax.swing.JButton();
        remove_promotions = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Register");

        identification.setBackground(new java.awt.Color(69, 69, 69));
        identification.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        identification.setEnabled(false);
        identification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificationActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Identification:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Services:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Details:");

        details.setColumns(20);
        details.setRows(5);
        jScrollPane1.setViewportView(details);

        add.setBackground(new java.awt.Color(0, 0, 0));
        add.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        select_services.setBackground(new java.awt.Color(0, 0, 0));
        select_services.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        select_services.setForeground(new java.awt.Color(255, 255, 255));
        select_services.setText("Select");
        select_services.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_servicesActionPerformed(evt);
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

        remove_services.setBackground(new java.awt.Color(0, 0, 0));
        remove_services.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        remove_services.setForeground(new java.awt.Color(255, 255, 255));
        remove_services.setText("Remove");
        remove_services.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_servicesActionPerformed(evt);
            }
        });

        see_client.setBackground(new java.awt.Color(0, 0, 0));
        see_client.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        see_client.setForeground(new java.awt.Color(255, 255, 255));
        see_client.setText("See");
        see_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                see_clientActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Client:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Promotions:");

        select_promotions.setBackground(new java.awt.Color(0, 0, 0));
        select_promotions.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        select_promotions.setForeground(new java.awt.Color(255, 255, 255));
        select_promotions.setText("Select");
        select_promotions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_promotionsActionPerformed(evt);
            }
        });

        remove_promotions.setBackground(new java.awt.Color(0, 0, 0));
        remove_promotions.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        remove_promotions.setForeground(new java.awt.Color(255, 255, 255));
        remove_promotions.setText("Remove");
        remove_promotions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_promotionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(remove_promotions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(remove_services, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(select_services, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(identification, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(see_client, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(select_promotions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(identification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(see_client, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(select_services)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(remove_services)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(select_promotions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(remove_promotions)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(back))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void identificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_identificationActionPerformed

    private void select_servicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_servicesActionPerformed
        String options[] = Database.get_instance().show_services();
        String option = (String) JOptionPane.showInputDialog(null, "What Service do you want to add?", "Services", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (option != null) {
            services.add(option);
            JOptionPane.showMessageDialog(null, "Service: '" + option + "' was added sucessfully");
        }
    }//GEN-LAST:event_select_servicesActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.setVisible(false);
        new MainView().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void remove_servicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_servicesActionPerformed
        if (services.isEmpty() == false) {
            String options[] = Arrays.copyOf(services.toArray(), services.size(), String[] .class);
            String option = (String) JOptionPane.showInputDialog(null, "What Service do you want to Remove?", "Services", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (option != null) {
                if (services.remove(option) == true) {
                    JOptionPane.showMessageDialog(null, "Service: '" + option + "' was removed sucessfully");
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "No Services Added");
        }
    }//GEN-LAST:event_remove_servicesActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        if (services.isEmpty() == false) {
            if (details.getText().compareTo("") != 0) {
                String services_string = "";
                for (int iterable = 0; iterable < services.size(); iterable++) {
                    int service_code = Database.get_instance().obtain_service_code(services.get(iterable));
                    if (service_code != -1) {
                        services_string = services_string + service_code;
                        if (iterable != services.size() - 1) {
                            services_string = services_string + ", ";
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "An error Ocurred while Services have been added", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                String promotion_string = "";
                if (promotions.isEmpty() == false) {
                    for (int iterable = 0; iterable < promotions.size(); iterable++) {
                        int promotion_code = Database.get_instance().obtain_promotion_code(promotions.get(iterable));
                        if (promotion_code != -1) {
                            promotion_string = promotion_string + promotion_code;
                            if (iterable != promotions.size() - 1) {
                                promotion_string = promotion_string + ", ";
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "An error Ocurred while promotions have been added", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                }
                int result = Database.get_instance().add_register(Integer.parseInt(identification.getText()),  services_string, details.getText(), new SimpleDateFormat("d MMM yyyy").format(new Date()), promotion_string);
                switch (result) {
                    case 0 -> JOptionPane.showMessageDialog(null, "Register added sucessfully");
                    case 1 -> JOptionPane.showMessageDialog(null, "Register cannot be added, an Error ocurred with database", "Error", JOptionPane.ERROR_MESSAGE);
                    default -> JOptionPane.showMessageDialog(null, "Register cannot be added, an Error ocurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Details can not be Blank", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "The Services can not be 0", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addActionPerformed

    private void see_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_see_clientActionPerformed
        this.setVisible(false);
        new ResultsClientsView().show_results("id", identification.getText(), 1);
    }//GEN-LAST:event_see_clientActionPerformed

    private void select_promotionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_promotionsActionPerformed
        if (Database.get_instance().are_promotions_in() == true) {
            String options[] = Database.get_instance().show_promotions();
            String option = (String) JOptionPane.showInputDialog(null, "What Service do you want to add?", "Services", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (option != null) {
                promotions.add(option);
                JOptionPane.showMessageDialog(null, "Service: '" + option + "' was added sucessfully");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "No Promotions Available");
        }
    }//GEN-LAST:event_select_promotionsActionPerformed

    private void remove_promotionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_promotionsActionPerformed
        if (promotions.isEmpty() == false) {
            String options[] = Arrays.copyOf(promotions.toArray(), promotions.size(), String[] .class);
            String option = (String) JOptionPane.showInputDialog(null, "What Service do you want to Remove?", "Services", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (option != null) {
                if (promotions.remove(option) == true) {
                    JOptionPane.showMessageDialog(null, "Promotion: '" + option + "' was removed sucessfully");
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "No Promotions Added");
        }
    }//GEN-LAST:event_remove_promotionsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JTextArea details;
    private javax.swing.JTextField identification;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton remove_promotions;
    private javax.swing.JButton remove_services;
    private javax.swing.JButton see_client;
    private javax.swing.JButton select_promotions;
    private javax.swing.JButton select_services;
    // End of variables declaration//GEN-END:variables
}
