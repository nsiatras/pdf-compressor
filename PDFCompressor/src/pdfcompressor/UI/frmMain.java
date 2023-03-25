/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pdfcompressor.UI;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
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

        this.setLocationRelativeTo(null);

        jTable1.setModel(new PDFTableModel(new ArrayList<PDFFile>()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonAddFolder = new javax.swing.JButton();
        jButtonAddFile = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldOutputDirectory = new javax.swing.JTextField();
        jButtonSelectOutputDirectory = new javax.swing.JButton();
        jButtonCompressFiles = new javax.swing.JButton();
        jProgressBarCompression = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDF Compressor");
        setResizable(false);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButtonAddFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pdfcompressor/UI/Images/add-folder-32x32.png"))); // NOI18N
        jButtonAddFolder.setText("Add Folder");
        jButtonAddFolder.setFocusable(false);
        jButtonAddFolder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAddFolder.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAddFolder.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonAddFolderActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAddFolder);

        jButtonAddFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pdfcompressor/UI/Images/add-file-32x32.png"))); // NOI18N
        jButtonAddFile.setText("Add File");
        jButtonAddFile.setFocusable(false);
        jButtonAddFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAddFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButtonAddFile);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));

        jLabel1.setText("Directory:");

        jTextFieldOutputDirectory.setText("C:\\Users\\nsiat\\Desktop\\Compressed PDFs");

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
                        .addComponent(jButtonCompressFiles)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                                .addComponent(jButtonSelectOutputDirectory)))))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarCompression, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCompressFiles)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddFolderActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAddFolderActionPerformed
    {//GEN-HEADEREND:event_jButtonAddFolderActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select Directory");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            FileScanner scanner = new FileScanner(chooser.getSelectedFile());
            ArrayList<File> pdfFiles = scanner.getFiles(".pdf");

            // Create a PDFFile object for each file inside the pdfFiles list
            // and add it to fSelectedPDFFiles.
            for (File pdf : pdfFiles)
            {
                fSelectedPDFFiles.add(new PDFFile(pdf));
            }

            jTable1.setModel(new PDFTableModel(new ArrayList<PDFFile>(fSelectedPDFFiles)));

        }
        else
        {
            //System.out.println("No Selection ");
        }
    }//GEN-LAST:event_jButtonAddFolderActionPerformed

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

    public void UpdateCompressedSizeOfFile(final PDFFile f)
    {
        try
        {
            jTable1.repaint();

            fCompressedFilesCount += 1;
            jProgressBarCompression.setValue(fCompressedFilesCount);
            jProgressBarCompression.invalidate();
            jProgressBarCompression.repaint();
        }
        catch (Exception ex)
        {

        }
    }

    public void CompressionFinished()
    {
        jButtonCompressFiles.setText("Compress Files");
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
    private javax.swing.JButton jButtonAddFile;
    private javax.swing.JButton jButtonAddFolder;
    private javax.swing.JButton jButtonCompressFiles;
    private javax.swing.JButton jButtonSelectOutputDirectory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBarCompression;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldOutputDirectory;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
