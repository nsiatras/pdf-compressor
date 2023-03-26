package pdfcompressor;

import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import pdfcompressor.Core.FileScanner;
import pdfcompressor.Core.PDFFile;
import pdfcompressor.Core.PDFFilesCompressor;
import pdfcompressor.UI.TableModels.PDFTableModel;

/**
 *
 * @author Nikos Siatras
 */
public class frmMain extends javax.swing.JFrame
{

    public static frmMain fActiveInstance;
    private Thread fCompressFilesThread;
    private int fCompressedFilesCount = 0;

    private ArrayList<PDFFile> fSelectedPDFFiles = new ArrayList<>();
    private PDFFilesCompressor fPDFFilesCompressorActiveInstance;

    public frmMain()
    {
        initComponents();
        fActiveInstance = this;

        // Set Titlebar Icon
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("UI/Images/app-icon-24x24.png")));

        this.setLocationRelativeTo(null);
        jTableFiles.setModel(new PDFTableModel(new ArrayList<PDFFile>()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldOutputDirectory = new javax.swing.JTextField();
        jButtonSelectOutputDirectory = new javax.swing.JButton();
        jButtonCompressFiles = new javax.swing.JButton();
        jProgressBarCompression = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldInputDirectory = new javax.swing.JTextField();
        jButtonSelectInputDirectory = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFiles = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDF Compressor");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Step 2 - Choose Output Directory", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel1.setInheritsPopupMenu(true);

        jLabel1.setText("Directory:");

        jTextFieldOutputDirectory.setEditable(false);

        jButtonSelectOutputDirectory.setText("...");
        jButtonSelectOutputDirectory.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonSelectOutputDirectoryActionPerformed(evt);
            }
        });

        jButtonCompressFiles.setText("Compress Files");
        jButtonCompressFiles.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonCompressFilesActionPerformed(evt);
            }
        });

        jProgressBarCompression.setStringPainted(true);

        jLabel2.setText("Progress:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jProgressBarCompression, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldOutputDirectory, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonSelectOutputDirectory))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCompressFiles)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldOutputDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSelectOutputDirectory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jProgressBarCompression, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButtonCompressFiles)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Step 1 - Choose PDFs Directory", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 102, 204))); // NOI18N

        jLabel3.setText("Directory:");

        jTextFieldInputDirectory.setEditable(false);

        jButtonSelectInputDirectory.setText("...");
        jButtonSelectInputDirectory.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonSelectInputDirectoryActionPerformed(evt);
            }
        });

        jTableFiles.setAutoCreateRowSorter(true);
        jTableFiles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null},
                {null},
                {null},
                {null}
            },
            new String []
            {
                "Column 1"
            }
        ));
        jScrollPane1.setViewportView(jTableFiles);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldInputDirectory, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSelectInputDirectory))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldInputDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSelectInputDirectory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelectOutputDirectoryActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSelectOutputDirectoryActionPerformed
    {//GEN-HEADEREND:event_jButtonSelectOutputDirectoryActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select Directory");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            jTextFieldOutputDirectory.setText(chooser.getSelectedFile().getAbsolutePath());
        }
        else
        {

        }
    }//GEN-LAST:event_jButtonSelectOutputDirectoryActionPerformed

    private void jButtonCompressFilesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonCompressFilesActionPerformed
    {//GEN-HEADEREND:event_jButtonCompressFilesActionPerformed
        if (jButtonCompressFiles.getText().equals("Compress Files"))
        {
            if (jTextFieldOutputDirectory.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please select the output directory", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if (jTextFieldOutputDirectory.getText().equals(jTextFieldInputDirectory.getText()))
            {
                JOptionPane.showMessageDialog(this, "Output directory cannot be the same with the input directory.\nPlease choose an other output directory!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            fCompressFilesThread = new Thread(() ->
            {
                fPDFFilesCompressorActiveInstance = new PDFFilesCompressor(fSelectedPDFFiles, jTextFieldOutputDirectory.getText());
                fPDFFilesCompressorActiveInstance.CompressFiles();
            });

            fCompressedFilesCount = 0;
            jProgressBarCompression.setMaximum(fSelectedPDFFiles.size());
            jProgressBarCompression.setValue(fCompressedFilesCount);
            jButtonCompressFiles.setText("Click to Stop");
            fCompressFilesThread.start();

        }
        else
        {
            if (fPDFFilesCompressorActiveInstance != null)
            {
                fPDFFilesCompressorActiveInstance.CancelFilesCompression();
                fPDFFilesCompressorActiveInstance = null;
            }
            jButtonCompressFiles.setText("Compress Files");
        }

    }//GEN-LAST:event_jButtonCompressFilesActionPerformed

    private void jButtonSelectInputDirectoryActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSelectInputDirectoryActionPerformed
    {//GEN-HEADEREND:event_jButtonSelectInputDirectoryActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select Directory");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            jTextFieldInputDirectory.setText(chooser.getSelectedFile().getAbsolutePath());

            FileScanner scanner = new FileScanner(chooser.getSelectedFile());
            ArrayList<File> pdfFiles = scanner.getFiles(".pdf");

            // Create a PDFFile object for each file inside the pdfFiles list
            // and add it to fSelectedPDFFiles.
            for (File pdf : pdfFiles)
            {
                fSelectedPDFFiles.add(new PDFFile(pdf));
            }

            jTableFiles.setModel(new PDFTableModel(new ArrayList<PDFFile>(fSelectedPDFFiles)));
        }
        else
        {

        }
    }//GEN-LAST:event_jButtonSelectInputDirectoryActionPerformed

    public void FileCompressionFinished(final PDFFile f)
    {
        try
        {
            jTableFiles.repaint();

            fCompressedFilesCount += 1;
            jProgressBarCompression.setValue(fCompressedFilesCount);
            jProgressBarCompression.invalidate();
            jProgressBarCompression.repaint();
        }
        catch (Exception ex)
        {

        }
    }

    public void UpdateJTableFiles()
    {
        jTableFiles.repaint();
    }

    public void CompressionFinished()
    {
        jButtonCompressFiles.setText("Compress Files");
        JOptionPane.showMessageDialog(this, String.valueOf(fCompressedFilesCount) + " files compressed!", "Compression Finished", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String args[])
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex)
        {

        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new frmMain().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCompressFiles;
    private javax.swing.JButton jButtonSelectInputDirectory;
    private javax.swing.JButton jButtonSelectOutputDirectory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBarCompression;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFiles;
    private javax.swing.JTextField jTextFieldInputDirectory;
    private javax.swing.JTextField jTextFieldOutputDirectory;
    // End of variables declaration//GEN-END:variables
}
