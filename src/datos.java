 


import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

   

public class datos extends javax.swing.JFrame {


 public static final String url = "jdbc:mysql://localhost:3306/notaestudiante";//link para conectar
    public static final String usuario = "root";
    public static final String pass = "";//<--si tiene contraseña, se coloca acá

    
    JFrame conect = new JFrame();
    Connection con = conect.getConnection();


datos() {
        initComponents();
        mostrardatos();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablan = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        tablan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombres", "Apellidos", "Materia", "Nota 1", "Nota 2", "Nota Parcial", "Nota final", "Veredicto final"
            }
        ));
        jScrollPane1.setViewportView(tablan);

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int fila = tablan.getSelectedRow();    
        JOptionPane.showMessageDialog(null,fila);



        double not1 = Double.parseDouble(this.tablan.getValueAt(fila,4).toString());
        double not2 = Double.parseDouble(this.tablan.getValueAt(fila,5).toString());
        double not3 = Double.parseDouble(this.tablan.getValueAt(fila,6).toString());
        double notafinal=0;
        String ver ="";

        notafinal=((not1+not2+not3)/3);
       


        if(notafinal>=3){
        ver="pasa";
        }else{
        ver="no pasa";
}

        
        
        try {
        Connection count = null;// cpunt es la variable
        count = getConnection();
        PreparedStatement num = count.prepareStatement("UPDATE nota SET nota1 = "+not1+", nota2 = "+not2+", nota3 = "+not3+", notafinal = "+notafinal+", veredicto ='"+ver+"' WHERE id = "+(fila+1)+";");  
        
        num.executeUpdate();
        mostrardatos();
         JOptionPane.showMessageDialog(null,"datos actualizados .");

            
        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

public static Connection getConnection(){
    Connection var2 = null;
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");//link de mysql para conectarnos
        var2 = (Connection) DriverManager.getConnection(url, usuario, pass);// realiza la conección con los datos de acceso para la sb
    }catch(Exception e){
        System.out.println(e);
    }
    return var2;
    }

    public void mostrardatos(){

    DefaultTableModel tnotas = new DefaultTableModel();
    tnotas.addColumn("id");
    tnotas.addColumn("nombres");
    tnotas.addColumn("apellidos");
    tnotas.addColumn("materia");
    tnotas.addColumn("nota1");
    tnotas.addColumn("nota2");
    tnotas.addColumn("nota Parcial");
    tnotas.addColumn("Nota Final");
    tnotas.addColumn("veredicto");
    tablan.setModel(tnotas);

    String[]datos = new String[9];
        Connection count = null;// cpunt es la variable
        count = getConnection();
        PreparedStatement var1;//preparar los resultados en la BD
        ResultSet rest;
        
        
        try {
        var1 = count.prepareStatement("SELECT * FROM nota");  
        rest = var1.executeQuery();

        while(rest.next()){
        datos[0]=rest.getString(1);
        datos[1]=rest.getString(2);
        datos[2]=rest.getString(3);
        datos[3]=rest.getString(4);
        datos[4]=rest.getString(5);
        datos[5]=rest.getString(6);
        datos[6]=rest.getString(7);
        datos[7]=rest.getString(8);
        datos[8]=rest.getString(9);

        tnotas.addRow(datos);

        }

    tablan.setModel(tnotas);
        } catch (Exception e) {

            System.out.println(e);
        }


}



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
            java.util.logging.Logger.getLogger(datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablan;
    // End of variables declaration//GEN-END:variables
}

