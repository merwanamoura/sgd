/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author at560075
 */
public class pageJeux extends javax.swing.JFrame {

    /**
     * Creates new form pageJeux
     */
    public pageJeux() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barrehaut = new javax.swing.JPanel();
        fonctionnalitepanel = new javax.swing.JPanel();
        optsbuttons = new javax.swing.JButton();
        mesjeuxbutton = new javax.swing.JButton();
        favoributton = new javax.swing.JButton();
        jpanelrecherche = new javax.swing.JPanel();
        backtoacceuil = new javax.swing.JButton();
        barrerecherche = new javax.swing.JTextField();
        recherche = new javax.swing.JButton();
        corps = new javax.swing.JPanel();
        panelfiltre = new javax.swing.JPanel();
        labelfiltre = new java.awt.Label();
        filtres = new javax.swing.JPanel();
        filtreEditeur = new javax.swing.JPanel();
        labelEditeur = new javax.swing.JLabel();
        scrollEditeur = new javax.swing.JScrollPane();
        lesEditeurs = new javax.swing.JPanel();
        filtrePrix = new javax.swing.JPanel();
        labelPrix = new javax.swing.JLabel();
        scrollPrix = new javax.swing.JScrollPane();
        lesPrix = new javax.swing.JPanel();
        filtreCategorie = new javax.swing.JPanel();
        labelCategorie = new javax.swing.JLabel();
        scrollCategorie = new javax.swing.JScrollPane();
        lesCategories = new javax.swing.JPanel();
        corpspanelrecherche = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeJeux = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        barrehaut.setName("barrehaut"); // NOI18N
        barrehaut.setLayout(new java.awt.BorderLayout());

        fonctionnalitepanel.setLayout(new java.awt.GridLayout(1, 3));

        optsbuttons.setText("opts");
        fonctionnalitepanel.add(optsbuttons);

        mesjeuxbutton.setText("Mes jeux");
        fonctionnalitepanel.add(mesjeuxbutton);

        favoributton.setText("Favori");
        fonctionnalitepanel.add(favoributton);

        barrehaut.add(fonctionnalitepanel, java.awt.BorderLayout.EAST);

        jpanelrecherche.setLayout(new java.awt.BorderLayout());

        backtoacceuil.setText("Acceuil");
        jpanelrecherche.add(backtoacceuil, java.awt.BorderLayout.WEST);

        barrerecherche.setText("Entrer votre recherche ...");
        barrerecherche.setPreferredSize(new java.awt.Dimension(300, 19));
        jpanelrecherche.add(barrerecherche, java.awt.BorderLayout.CENTER);

        recherche.setText("Recherche");
        jpanelrecherche.add(recherche, java.awt.BorderLayout.EAST);

        barrehaut.add(jpanelrecherche, java.awt.BorderLayout.WEST);

        getContentPane().add(barrehaut, java.awt.BorderLayout.NORTH);

        corps.setLayout(new java.awt.BorderLayout());

        panelfiltre.setMinimumSize(new java.awt.Dimension(70, 270));
        panelfiltre.setPreferredSize(new java.awt.Dimension(220, 600));
        panelfiltre.setLayout(new java.awt.BorderLayout());

        labelfiltre.setAlignment(java.awt.Label.CENTER);
        labelfiltre.setPreferredSize(new java.awt.Dimension(35, 40));
        labelfiltre.setText("Filtre");
        panelfiltre.add(labelfiltre, java.awt.BorderLayout.NORTH);

        filtres.setLayout(new java.awt.GridLayout(3, 1));

        filtreEditeur.setLayout(new java.awt.BorderLayout());

        labelEditeur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEditeur.setText("Editeur");
        labelEditeur.setPreferredSize(new java.awt.Dimension(51, 30));
        filtreEditeur.add(labelEditeur, java.awt.BorderLayout.NORTH);

        lesEditeurs.setLayout(new java.awt.GridLayout(0, 1));
        scrollEditeur.setViewportView(lesEditeurs);

        filtreEditeur.add(scrollEditeur, java.awt.BorderLayout.CENTER);

        filtres.add(filtreEditeur);

        filtrePrix.setLayout(new java.awt.BorderLayout());

        labelPrix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPrix.setText("Prix");
        labelPrix.setPreferredSize(new java.awt.Dimension(26, 30));
        filtrePrix.add(labelPrix, java.awt.BorderLayout.NORTH);

        lesPrix.setLayout(new java.awt.GridLayout(0, 1));
        scrollPrix.setViewportView(lesPrix);

        filtrePrix.add(scrollPrix, java.awt.BorderLayout.CENTER);

        filtres.add(filtrePrix);

        filtreCategorie.setLayout(new java.awt.BorderLayout());

        labelCategorie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCategorie.setText("Catégorie");
        labelCategorie.setPreferredSize(new java.awt.Dimension(70, 30));
        filtreCategorie.add(labelCategorie, java.awt.BorderLayout.NORTH);

        lesCategories.setLayout(new java.awt.GridLayout(0, 1));
        scrollCategorie.setViewportView(lesCategories);

        filtreCategorie.add(scrollCategorie, java.awt.BorderLayout.CENTER);

        filtres.add(filtreCategorie);

        panelfiltre.add(filtres, java.awt.BorderLayout.CENTER);

        corps.add(panelfiltre, java.awt.BorderLayout.WEST);

        corpspanelrecherche.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Liste des jeux");
        jLabel2.setPreferredSize(new java.awt.Dimension(98, 70));
        corpspanelrecherche.add(jLabel2, java.awt.BorderLayout.NORTH);

        jScrollPane1.setViewportView(listeJeux);

        corpspanelrecherche.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        corps.add(corpspanelrecherche, java.awt.BorderLayout.CENTER);

        getContentPane().add(corps, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(pageJeux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pageJeux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pageJeux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pageJeux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pageJeux().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backtoacceuil;
    private javax.swing.JPanel barrehaut;
    private javax.swing.JTextField barrerecherche;
    private javax.swing.JPanel corps;
    private javax.swing.JPanel corpspanelrecherche;
    private javax.swing.JButton favoributton;
    private javax.swing.JPanel filtreCategorie;
    private javax.swing.JPanel filtreEditeur;
    private javax.swing.JPanel filtrePrix;
    private javax.swing.JPanel filtres;
    private javax.swing.JPanel fonctionnalitepanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpanelrecherche;
    private javax.swing.JLabel labelCategorie;
    private javax.swing.JLabel labelEditeur;
    private javax.swing.JLabel labelPrix;
    private java.awt.Label labelfiltre;
    private javax.swing.JPanel lesCategories;
    private javax.swing.JPanel lesEditeurs;
    private javax.swing.JPanel lesPrix;
    private javax.swing.JList<String> listeJeux;
    private javax.swing.JButton mesjeuxbutton;
    private javax.swing.JButton optsbuttons;
    private javax.swing.JPanel panelfiltre;
    private javax.swing.JButton recherche;
    private javax.swing.JScrollPane scrollCategorie;
    private javax.swing.JScrollPane scrollEditeur;
    private javax.swing.JScrollPane scrollPrix;
    // End of variables declaration//GEN-END:variables
}
