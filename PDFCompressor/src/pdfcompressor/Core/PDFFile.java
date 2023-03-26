package pdfcompressor.Core;

import java.io.File;

/**
 *
 * @author Nikos Siatras
 */
public class PDFFile
{

    private File fPhysicalFile;
    private long fCompressedSize = 0;
    private String fMessage = null;

    public PDFFile(File physicalFile)
    {
        fPhysicalFile = physicalFile;
    }

    public File getPhysicalFile()
    {
        return fPhysicalFile;
    }

    public String getFileName()
    {
        return fPhysicalFile.getName();
    }

    public double getSizeKb()
    {
        return fPhysicalFile.length() / 1024;
    }

    public void setCompressedSize(long size)
    {
        fCompressedSize = size;
    }

    public double getCompressedSize()
    {
        return fCompressedSize / 1024;
    }

    public void setMessage(String message)
    {
        fMessage = message;
    }

    public String getMessage()
    {
        return fMessage;
    }

}
