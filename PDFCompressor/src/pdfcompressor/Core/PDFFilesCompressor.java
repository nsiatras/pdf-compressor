package pdfcompressor.Core;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
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
            fGhostScriptPath = new File(".").getCanonicalPath() + File.separator + "Prerequisites" + File.separator + "gswin64c.exe";
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

                    File compressedFile = new File(outputPath);

                    // If for some reason the compressed file doesn't exist
                    // then copy the original to the output path.
                    if (!compressedFile.exists())
                    {
                        CopyFile(pdf.getPhysicalFile().getAbsolutePath(), outputPath);
                    }

                    // If the compressed file size is greater than the original
                    // then use the original
                    if (compressedFile.length() > pdf.getPhysicalFile().length())
                    {
                        CopyFile(pdf.getPhysicalFile().getAbsolutePath(), outputPath);
                        pdf.setCompressedSize(pdf.getPhysicalFile().length());
                    }
                    else
                    {
                        pdf.setCompressedSize(compressedFile.length());
                    }

                    // The PDF File has been compressed.
                    // Inform frmMain to display the compressed size of the
                    // file on the appropriate Table.
                    frmMain.fActiveInstance.UpdateCompressedSizeOfFile(pdf);

                    p.destroy();
                    p = null;
                }
                catch (Exception ex)
                {

                }
            }
        }

        // Inform frmMain that the compression is now finished!
        frmMain.fActiveInstance.CompressionFinished();
    }

    private void CopyFile(String from, String to)
    {
        try
        {
            Files.copy(Path.of(from), Path.of(to), StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Exception ex)
        {

        }
    }

    public void CancelFilesCompression()
    {
        fKeepRunning = false;
    }

}
