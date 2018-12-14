/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import java.util.*;
import org.bson.Document;

import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.set;
import java.awt.Color;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.util.Arrays.asList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;


/**
 *
 * @author at560075
 */
public class AjoutJeuDlg extends javax.swing.JDialog {

     MongoDatabase db;
     boolean test = false;
     String nomJeu;
     String Editeur;
     String dateSortie;
     Date dateS;
     String categorie;
     String pathImage;
     File f;
    /**
     * Creates new form AjoutJeuDlg
     */
    public AjoutJeuDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fillDate();
        connexionBD();
    }
    
    public void fillDate()
    {
        for ( int i = 1 ; i < 32 ; i++)
        {
           String tmp; 
           
            if(i < 10)
            {
                tmp = "0" +i;
            }
            else
            {
                tmp = i + "";
            }
            Jour.addItem(tmp);
        }
        
        for ( int i = 1 ; i < 13 ; i++)
        {
           String tmp; 
           
            if(i < 10)
            {
                tmp = "0" +i;
            }
            else
            {
                tmp = i + "";
            }
            mois.addItem(tmp);
        }
        
        for ( int i = 2018 ; i > 1970 ; i--)
        {
           String tmp; 
           
            if(i < 10)
            {
                tmp = "0" +i;
            }
            else
            {
                tmp = i + "";
            }
            annee.addItem(tmp);
        }
        
        
        
    }
    
    public void connexionBD()
    {
        char[] pass = new char[10];
        String s = "hc047736";
        pass = s.toCharArray();
        MongoCredential credential = MongoCredential.createCredential("hc047736","hc047736",pass);
        MongoClient client = new MongoClient(new ServerAddress("mongo",27017),Arrays.asList(credential));
        db = client.getDatabase("hc047736");
        // Liste de collections 
        for (String name : db.listCollectionNames())
        {
            System.out.println(name);
        }
    }
    /*
    
    db.jeux.insertOne({"nomJeu":"Fortnite","Editeur":"Epic Games","dateSortie":"13/10/1997" ,"Categorie" : "BattleRoyale"})
    
    */
    
    public void ajouterJeu()
    {
        
        
      
            MongoCollection<Document> jeux = db.getCollection("jeux");

            Document doc = new Document("", "1234");
            doc.append("nomJeu" ,nomJeu);
            doc.append("editeur" ,Editeur);
            doc.append("dateSortie",dateS);
            doc.append("categorie",categorie); 
            doc.append("pathImage", pathImage);
            
            jeux.insertOne(doc); 
            test = true;
        
      
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
        topPanel = new javax.swing.JPanel();
        titre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        annulerButton = new javax.swing.JButton();
        rightPanel = new javax.swing.JPanel();
        jeuText = new javax.swing.JTextField();
        editeurText = new javax.swing.JTextField();
        categorieText = new javax.swing.JTextField();
        datePAnel = new javax.swing.JPanel();
        Jour = new javax.swing.JComboBox<>();
        mois = new javax.swing.JComboBox<>();
        annee = new javax.swing.JComboBox<>();
        importButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        topPanel.setPreferredSize(new java.awt.Dimension(469, 80));

        titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titre.setText("VEUILLEZ AJOUTER VOTRE JEU");
        titre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addComponent(titre, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(topPanel, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        leftPanel.setLayout(new java.awt.GridLayout(6, 1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nom du jeu");
        leftPanel.add(jLabel2);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Editeur");
        leftPanel.add(jLabel3);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Catégorie");
        leftPanel.add(jLabel4);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Date");
        leftPanel.add(jLabel5);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Image");
        leftPanel.add(jLabel1);

        annulerButton.setText("Annuler");
        annulerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerButtonActionPerformed(evt);
            }
        });
        leftPanel.add(annulerButton);

        jPanel2.add(leftPanel);

        rightPanel.setLayout(new java.awt.GridLayout(6, 1));

        jeuText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jeuTextActionPerformed(evt);
            }
        });
        rightPanel.add(jeuText);

        editeurText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editeurTextActionPerformed(evt);
            }
        });
        rightPanel.add(editeurText);

        categorieText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorieTextActionPerformed(evt);
            }
        });
        rightPanel.add(categorieText);

        datePAnel.setLayout(new java.awt.GridLayout(1, 3));

        Jour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JourActionPerformed(evt);
            }
        });
        datePAnel.add(Jour);

        datePAnel.add(mois);

        datePAnel.add(annee);

        rightPanel.add(datePAnel);

        importButton.setBackground(new java.awt.Color(188, 188, 188));
        importButton.setText("Import");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });
        rightPanel.add(importButton);

        jButton2.setText("Valider");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        rightPanel.add(jButton2);

        jPanel2.add(rightPanel);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categorieTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorieTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categorieTextActionPerformed

    private void editeurTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editeurTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editeurTextActionPerformed

    private void jeuTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jeuTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jeuTextActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        nomJeu = jeuText.getText();
        Editeur = editeurText.getText();
     //   dateSortie = dateText.getText();
     
        dateSortie = Jour.getSelectedItem().toString() + "-" + mois.getSelectedItem().toString() + "-" + annee.getSelectedItem().toString();
        categorie = categorieText.getText();
        
        if ( f != null)
        {
            pathImage = f.getAbsolutePath();       
        }

     
        

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss");
        
        if(!dateSortie.equals(""))
        {
            try {    
             dateS = dateFormat.parse(dateSortie+"T00:00:00");
         } catch (ParseException ex) {
             Logger.getLogger(AjoutJeuDlg.class.getName()).log(Level.SEVERE, null, ex);
         }
            
        }
        
             
         if ( (!nomJeu.equals("")) && (!editeurText.equals("")) && (!categorieText.equals("")) && (f != null)  )
        
        {       
            ajouterJeu();         
        }
           else
        {
            
            showMessageDialog(null, "Veuillez remplir tous les champs !");
            
        }
        
        if( test == true)
        {
            this.setVisible(false);
        }

        //System.out.println(f.getAbsolutePath());


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void annulerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerButtonActionPerformed

        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_annulerButtonActionPerformed

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed

        JFileChooser chooser = new JFileChooser();
        // optionally set chooser options ...
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
             f = chooser.getSelectedFile();
             importButton.setText("Fichier importé");
             importButton.setForeground(new java.awt.Color(0, 100, 0));
             importButton.setEnabled(false);
             importButton.setBackground(new java.awt.Color(240, 240, 240));
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_importButtonActionPerformed

    private void JourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JourActionPerformed

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
            java.util.logging.Logger.getLogger(AjoutJeuDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutJeuDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutJeuDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutJeuDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AjoutJeuDlg dialog = new AjoutJeuDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Jour;
    private javax.swing.JComboBox<String> annee;
    private javax.swing.JButton annulerButton;
    private javax.swing.JTextField categorieText;
    private javax.swing.JPanel datePAnel;
    private javax.swing.JTextField editeurText;
    private javax.swing.JButton importButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jeuText;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JComboBox<String> mois;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel titre;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
