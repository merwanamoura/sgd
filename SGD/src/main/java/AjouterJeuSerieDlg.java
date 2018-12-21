
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import org.bson.BsonString;
import org.bson.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author at560075
 */
public class AjouterJeuSerieDlg extends javax.swing.JDialog {

    MongoDatabase db;
    
    /**
     * Creates new form AjoutSuppDlg
     */
    
    int Idjeu;
    String nomSerie;
    JList list;
    ArrayList <Integer> listIdJeu;
    
    
    public AjouterJeuSerieDlg(java.awt.Frame parent, boolean modal,String nomSerie) {
        super(parent, modal);
        initComponents();
        db = MongoDBConnection.getDb();
        this.nomSerie = nomSerie;
        System.out.println("wtf");
        fillListeJeux();

    }
    
    public void fillListeJeux()
    {
        
        
        MongoCollection<Document> jeux = db.getCollection("jeux");    
        MongoCollection<Document> SJ = db.getCollection("seriesJeux");       
        DefaultListModel dlm = new DefaultListModel();
        MongoCursor<Document> it;
        MongoCursor<Document> cursor;
        
        it = SJ.find(eq("nom",nomSerie)).iterator();
        Document doc = it.next();
        
        ArrayList<Integer> listeJeux = (ArrayList<Integer>)doc.get("tabJeux");
        
        for (int i = 0 ; i < listeJeux.size() ; i++)
        {
            System.out.println(listeJeux.get(i));
        
        }
   
        List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
        BasicDBObject andQueryIdJeu = new BasicDBObject();
        BasicDBObject andQuery = new BasicDBObject();     
        BasicDBObject andQueryText = new BasicDBObject(); 
        andQueryIdJeu.put("idJeu", new BasicDBObject("$nin",listeJeux));  
        obj.add(andQueryIdJeu);
        andQuery.put("$and",obj);
        
        String testSaisie = saisie.getText();
        
        if(!testSaisie.equals(""))
        {
                    
            andQueryText.put("nom" , new BasicDBObject("$regex",testSaisie));
            obj.add(andQueryText);
            andQuery.put("$and",obj);

        }
        
        
        
        cursor = jeux.find(andQuery).iterator();
       
        System.out.println(andQuery.toString());
        
        while (cursor.hasNext()) 
        {
            Document dac = cursor.next();
            File f = new File((String) dac.get("image"));
            
            if(f.exists() && !f.isDirectory())dlm.addElement(new ListEntry((String) dac.get("nom"), new ImageIcon((String) dac.get("image"))));
            else dlm.addElement(new ListEntry((String) dac.get("nom"), new ImageIcon("imageJeux/default.png")));
        }
        
        list = new JList(dlm);
        list.setCellRenderer(new ListEntryCellRenderer());   
        
        
        
        scrollListeJeux.add(list); 
        scrollListeJeux.setViewportView(list);
        
        }
    
    public void ajouterGame()
    {
        if(list.getSelectedValue() != null)
        {
        MongoCollection<Document> SJ = db.getCollection("seriesJeux");  
        MongoCollection<Document> jeux = db.getCollection("jeux");
        String nameGame = list.getSelectedValue().toString(); 
        MongoCursor<Document> cursor;
        
        cursor = SJ.find(eq("nom",nomSerie)).iterator();
        Document doc = cursor.next();
        
        MongoCursor<Document> at = jeux.find(eq("nom",nameGame)).iterator();
        Document jeu = at.next();
        
        int idJeu = (int)jeu.get("idJeu");
       
        Document updatedDocument = SJ.findOneAndUpdate(
             Filters.eq("nom", nomSerie),
             new Document("$push",  
             new BasicDBObject("tabJeux", (idJeu)))
        );
        dispose();
        this.setVisible(false);
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

        general = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botPanel = new javax.swing.JPanel();
        leftSpacePanel = new javax.swing.JPanel();
        buttonPannel = new javax.swing.JPanel();
        supprimerButton = new javax.swing.JButton();
        rightSpacePanel = new javax.swing.JPanel();
        midPanel = new javax.swing.JPanel();
        listeJeuPanel = new javax.swing.JPanel();
        scrollListeJeux = new javax.swing.JScrollPane();
        recherchePanel = new javax.swing.JPanel();
        leftRecherchePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rightRecherchePanel = new javax.swing.JPanel();
        saisie = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        general.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sélectionnez votre jeu");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        general.add(topPanel, java.awt.BorderLayout.PAGE_START);

        botPanel.setPreferredSize(new java.awt.Dimension(553, 60));
        botPanel.setLayout(new java.awt.GridLayout(1, 3));

        javax.swing.GroupLayout leftSpacePanelLayout = new javax.swing.GroupLayout(leftSpacePanel);
        leftSpacePanel.setLayout(leftSpacePanelLayout);
        leftSpacePanelLayout.setHorizontalGroup(
            leftSpacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );
        leftSpacePanelLayout.setVerticalGroup(
            leftSpacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        botPanel.add(leftSpacePanel);

        supprimerButton.setText("Ajouter");
        supprimerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPannelLayout = new javax.swing.GroupLayout(buttonPannel);
        buttonPannel.setLayout(buttonPannelLayout);
        buttonPannelLayout.setHorizontalGroup(
            buttonPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPannelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(supprimerButton, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );
        buttonPannelLayout.setVerticalGroup(
            buttonPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPannelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(supprimerButton, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        botPanel.add(buttonPannel);

        javax.swing.GroupLayout rightSpacePanelLayout = new javax.swing.GroupLayout(rightSpacePanel);
        rightSpacePanel.setLayout(rightSpacePanelLayout);
        rightSpacePanelLayout.setHorizontalGroup(
            rightSpacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );
        rightSpacePanelLayout.setVerticalGroup(
            rightSpacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        botPanel.add(rightSpacePanel);

        general.add(botPanel, java.awt.BorderLayout.PAGE_END);

        midPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout listeJeuPanelLayout = new javax.swing.GroupLayout(listeJeuPanel);
        listeJeuPanel.setLayout(listeJeuPanelLayout);
        listeJeuPanelLayout.setHorizontalGroup(
            listeJeuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listeJeuPanelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(scrollListeJeux, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        listeJeuPanelLayout.setVerticalGroup(
            listeJeuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollListeJeux, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
        );

        midPanel.add(listeJeuPanel, java.awt.BorderLayout.CENTER);

        recherchePanel.setPreferredSize(new java.awt.Dimension(553, 60));
        recherchePanel.setLayout(new java.awt.BorderLayout());

        leftRecherchePanel.setPreferredSize(new java.awt.Dimension(160, 60));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Entrez le nom du jeu :");
        jLabel2.setMinimumSize(new java.awt.Dimension(170, 15));

        javax.swing.GroupLayout leftRecherchePanelLayout = new javax.swing.GroupLayout(leftRecherchePanel);
        leftRecherchePanel.setLayout(leftRecherchePanelLayout);
        leftRecherchePanelLayout.setHorizontalGroup(
            leftRecherchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        leftRecherchePanelLayout.setVerticalGroup(
            leftRecherchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        recherchePanel.add(leftRecherchePanel, java.awt.BorderLayout.WEST);

        saisie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saisieActionPerformed(evt);
            }
        });
        saisie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                saisieKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout rightRecherchePanelLayout = new javax.swing.GroupLayout(rightRecherchePanel);
        rightRecherchePanel.setLayout(rightRecherchePanelLayout);
        rightRecherchePanelLayout.setHorizontalGroup(
            rightRecherchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightRecherchePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saisie, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        rightRecherchePanelLayout.setVerticalGroup(
            rightRecherchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightRecherchePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saisie)
                .addContainerGap())
        );

        recherchePanel.add(rightRecherchePanel, java.awt.BorderLayout.CENTER);

        midPanel.add(recherchePanel, java.awt.BorderLayout.NORTH);

        general.add(midPanel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(general, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(general, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void supprimerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerButtonActionPerformed

        ajouterGame();
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_supprimerButtonActionPerformed

    private void saisieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saisieActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_saisieActionPerformed

    private void saisieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saisieKeyPressed

        fillListeJeux();

        // TODO add your handling code here:
    }//GEN-LAST:event_saisieKeyPressed

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
            java.util.logging.Logger.getLogger(AjouterJeuSerieDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjouterJeuSerieDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjouterJeuSerieDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjouterJeuSerieDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AjouterJeuSerieDlg dialog = new AjouterJeuSerieDlg(new javax.swing.JFrame(), true,"Le Vampire");
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
    private javax.swing.JPanel botPanel;
    private javax.swing.JPanel buttonPannel;
    private javax.swing.JPanel general;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel leftRecherchePanel;
    private javax.swing.JPanel leftSpacePanel;
    private javax.swing.JPanel listeJeuPanel;
    private javax.swing.JPanel midPanel;
    private javax.swing.JPanel recherchePanel;
    private javax.swing.JPanel rightRecherchePanel;
    private javax.swing.JPanel rightSpacePanel;
    private javax.swing.JTextField saisie;
    private javax.swing.JScrollPane scrollListeJeux;
    private javax.swing.JButton supprimerButton;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
