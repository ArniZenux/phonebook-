/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simabook;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 * @version : 0.5 
 * @author : Arni
 * 
 */
public class Simabók extends javax.swing.JFrame {
    int size; 
    
    String s; 
    
    String strengur; 
    String lina; 
    
    String strengur1; 
    String strengur2;
    
    String nafn, GSM; 
    String tomur_strengur; 
    
    Connection conn; 
    Statement stmt; 
    ResultSet rs; 
    PreparedStatement prep;
    
    DefaultTableModel model_table; 
    
    public Simabók() {
        size = 0;  
        tomur_strengur = null ; 
        initComponents();
        Connectdb();
        model_table = (DefaultTableModel) jtSimaskra.getModel();
    }
    
    //after: Connect to a database
    public final void Connectdb()
     {
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test.db"); 
        }
        catch(ClassNotFoundException | SQLException e){
            System.err.println("Engin tengli");
        } 
     }
    
    //after: Delete a value from a database
    public void deleteValue(String GSMnr){
            String sql = "DELETE FROM vinur WHERE GSM = '" + GSMnr + "';";
            try{
                prep = conn.prepareStatement(sql);
                prep.execute();
                           
            }
            catch( Exception e) {
                System.err.println(e);
            }
    }
    
    //after: Insert a value into a database
    public void insertValue(String n, String g){
            String sql = "INSERT INTO vinur(nafn, gsm) VALUES(?, ? )";
            try {
			prep = conn.prepareStatement(sql);
			prep.setString(1, n );       
			prep.setString(2, g );       
			prep.executeUpdate(); 
		}		
            catch(Exception e){
			System.err.println(e);
		}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfNafn = new javax.swing.JTextField();
        bSkra = new javax.swing.JButton();
        jtfGSM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bEyda = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtSimaskra = new javax.swing.JTable();
        bStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Símabók 1.0 ");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Nafn");

        bSkra.setText("Skrá");
        bSkra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSkraActionPerformed(evt);
            }
        });

        jtfGSM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfGSMActionPerformed(evt);
            }
        });
        jtfGSM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfGSMKeyTyped(evt);
            }
        });

        jLabel2.setText("GSM");

        bEyda.setText("Eyða");
        bEyda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEydaActionPerformed(evt);
            }
        });

        jtSimaskra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nafn", "GSM"
            }
        ));
        jScrollPane2.setViewportView(jtSimaskra);

        bStop.setText("Hætta");
        bStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfGSM)
                            .addComponent(jtfNafn, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bEyda, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(bSkra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bStop, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfNafn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSkra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfGSM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(bEyda)
                    .addComponent(bStop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
           
    }                                 

    //after: Put a name and a mobile number to insertvalue()
    private void bSkraActionPerformed(java.awt.event.ActionEvent evt) {                                      
        nafn = jtfNafn.getText();
        GSM = jtfGSM.getText(); 
        
            if(nafn.trim().isEmpty() || GSM.trim().isEmpty()){
            System.out.println("Name is empty or a mobile number is not exist");
           
           }
        
        else {
            insertValue(nafn, GSM);  //insertValue(jTextField1.getText(), jTextField2.getText()); 
            model_table.insertRow(model_table.getRowCount(), new Object[]{nafn, GSM});
            System.out.println("vista");
            jtfNafn.setText("");
            jtfGSM.setText("");
        }
    }                                     

   //after: connect a database and fill a data from a database in a table
    private void formWindowActivated(java.awt.event.WindowEvent evt) {                                     
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM vinur;");
       
            while(rs.next()){
                     strengur1 = rs.getString("nafn");
                     strengur2 = rs.getString("gsm");
                     String s2 = strengur1 + " " + strengur2 ; 
                     model_table.insertRow(model_table.getRowCount(), new Object[]{strengur1, strengur2});
             }    
          }        
        catch( Exception e) {
           System.err.println("Getur ekki fyllad");
        
        }
    }                                    

    private void jtfGSMActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO adyour handling code here:
    }                                      

    //after : Only for a number in jTextField2 - GSM 
    private void jtfGSMKeyTyped(java.awt.event.KeyEvent evt) {                                
        char c = evt.getKeyChar();
        if(!( Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
        evt.consume();      
        }
    }                               

    //after : Remove a name and a mobile number from a table.    
    private void bEydaActionPerformed(java.awt.event.ActionEvent evt) {                                      
        s = (String) model_table.getValueAt(jtSimaskra.getSelectedRow(), 1);
        System.out.println(s); 
        deleteValue(s);
        model_table.removeRow(jtSimaskra.getSelectedRow());
    }                                     

    //after: Exit 
    private void bStopActionPerformed(java.awt.event.ActionEvent evt) {                                      
            System.exit(0);
    }                                     

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
            java.util.logging.Logger.getLogger(Simabók.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simabók.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simabók.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simabók.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simabók().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton bEyda;
    private javax.swing.JButton bSkra;
    private javax.swing.JButton bStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtSimaskra;
    private javax.swing.JTextField jtfGSM;
    private javax.swing.JTextField jtfNafn;
    // End of variables declaration                   

    
}
