package pdfcompressor.Core;

import java.io.File;
import java.util.ArrayList;
import pdfcompressor.UI.frmMain;

/**
 *
 * @author Nikos Siatras
 */
public class PDFFilesCompressor
{

    private final ArrayList<PDFFile> fFiles;
    private final String fOutputDirectoryPath;

    private boolean fKeepRunning = false;

    private String fGhostScriptPath = "";

    public PDFFilesCompressor(ArrayList<PDFFile> files, String outputDirectoryPath)
    {
        fFiles = files;
        fOutputDirectoryPath = outputDirectoryPath;

        try
        {
            fGhostScriptPath = new File(".").getCanonicalPath() + File.separator + "Prerequisites" + File.separator + "gswin32c.exe";
        }
        catch (Exception ex)
        {

        }
    }

    public void CompressFiles()
    {
        fKeepRunning = true;

        for (PDFFile pdf : fFiles)
        {
            if (fKeepRunning)
            {
                final String outputPath = fOutputDirectoryPath + "\\" + pdf.getFileName();

                String command = fGhostScriptPath;
                command += " -sDEVICE=pdfwrite -dCompatibilityLevel=1.4 -dPDFSETTINGS=/ebook -dNOPAUSE -dQUIET -dBATCH";
                command += " -sOutputFile=\"" + outputPath + "\"";
                command += " \"" + pdf.getPhysicalFile().getAbsolutePath() + "\"";

                try
                {
                    Process p = Runtime.getRuntime().exec(command);
                    int exitVal = p.waitFor();
                    if (exitVal == 0)
                    {
                        File f = new File(outputPath);
                        pdf.setCompressedSize(f.length());

                        // The PDF File has been compressed.
                        // Inform frmMain to display the compressed size of the
                        // file on the appropriate Table.
                        frmMain.fActiveInstance.UpdateCompressedSizeOfFile(pdf);
                    }
                }
                catch (Exception ex)
                {

                }
            }
        }
    }

    public void CancelFilesCompression()
    {
        fKeepRunning = false;
    }

}
