
package sgp.Views;

import javax.swing.JOptionPane;
import sgp.database.Database;

public class MainView extends javax.swing.JFrame {
    public MainView() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        add_button = new javax.swing.JButton();
        view_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sh4dow18's Garanties Program");

        add_button.setBackground(new java.awt.Color(255, 255, 255));
        add_button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        add_button.setText("Add");
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });

        view_button.setBackground(new java.awt.Color(255, 255, 255));
        view_button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        view_button.setText("View");
        view_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(view_button, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_button)
                    .addComponent(view_button))
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
        String options[] = {"Register", "Service", "Client", "Promotion"};
        String option = (String) JOptionPane.showInputDialog(null, "What do you want to add?", "Options", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (option != null) {
            if (option.compareTo("Register") == 0) {
                if (Database.get_instance().are_services_in() == true) {
                    if (Database.get_instance().are_clients_in() == true) {
                        String clients_options[] = {"All", "Id", "Phone", "Name"};
                        option = (String) JOptionPane.showInputDialog(null, "To add a register, need a client, so, How do you want to search the Client?", "Options", JOptionPane.INFORMATION_MESSAGE, null, clients_options, clients_options[0]);
                        if (option != null) {
                            String search = "";
                            if (option.compareTo("All") != 0) {
                                search = (String) JOptionPane.showInputDialog(null, "Digit the " + option + " do you want to search");
                                if (search == null) {
                                    return;
                                }
                            }
                            option = Character.toLowerCase(option.charAt(0)) +  option.substring(1);
                            this.setVisible(false);
                            new ClientSelectorView().show_results(option, search);
                        }
                    }
                    else {
                         JOptionPane.showMessageDialog(null, "No Clients in Database, please add a client before create a register", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "No Services in Database, please add a service before create a register", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (option.compareTo("Service") == 0) {
                this.setVisible(false);
                new AddServiceView().setVisible(true);
            }
            else if (option.compareTo("Client") == 0) {
                this.setVisible(false);
                new AddClientView().setVisible(true);
            }
            else if (option.compareTo("Promotion") == 0) {
                this.setVisible(false);
                new AddPromotionView().setVisible(true);
            }
        }
    }//GEN-LAST:event_add_buttonActionPerformed

    private void view_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_buttonActionPerformed
        String options[] = {"Registers", "Services", "Clients", "Promotions"};
        String option = (String) JOptionPane.showInputDialog(null, "What do you want to search?", "Options", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (option != null) {
            if (option.compareTo("Registers") == 0) {
                String registers_options[] = {"All", "Code", "Phone", "Name"};
                option = (String) JOptionPane.showInputDialog(null, "How do you want to search the Registers?", "Options", JOptionPane.INFORMATION_MESSAGE, null, registers_options, registers_options[0]);
                if (option != null) {
                    String search = "";
                    if (option.compareTo("All") != 0) {
                        search = (String) JOptionPane.showInputDialog(null, "Digit the " + option + " do you want to search");
                        if (search == null) {
                            return;
                        }
                    }
                    option = Character.toLowerCase(option.charAt(0)) +  option.substring(1);
                    this.setVisible(false);
                    new ResultsRegisterView().show_results(option, search);
                }
            }
            else if (option.compareTo("Services") == 0) {
                this.setVisible(false);
                new ResultsServicesView().show_results();
            }
            else if (option.compareTo("Clients") == 0) {
                String clients_options[] = {"All", "Id", "Phone", "Name"};
                option = (String) JOptionPane.showInputDialog(null, "How do you want to search the Clients?", "Options", JOptionPane.INFORMATION_MESSAGE, null, clients_options, clients_options[0]);
                if (option != null) {
                    String search = "";
                    if (option.compareTo("All") != 0) {
                        search = (String) JOptionPane.showInputDialog(null, "Digit the " + option + " do you want to search");
                        if (search == null) {
                            return;
                        }
                    }
                    option = Character.toLowerCase(option.charAt(0)) +  option.substring(1);
                    this.setVisible(false);
                    new ResultsClientsView().show_results(option, search, 0);
                }
            }
            else if (option.compareTo("Promotions") == 0) {
                this.setVisible(false);
                new ResultsPromotionsView().show_results();
            }
        }
    }//GEN-LAST:event_view_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton view_button;
    // End of variables declaration//GEN-END:variables
}
