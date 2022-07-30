import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;


public class FileOptions extends SalesInvoiceGenerator{
    String FilePath ;
    public static void LoadFile()
    {
        JFileChooser SelectForm = new JFileChooser();
        int SelectionResult = SelectForm.showOpenDialog(null);
        if (SelectionResult == JFileChooser.APPROVE_OPTION) {
             String FilePath = SelectForm.getSelectedFile().getPath();

            FileInputStream LoadingFile = null;
            int FileSize = 0 ;
            String FileName = SelectForm.getName();
            byte [] FileData;
            InvoicesData.setText(new String (FileName));
            try {
                LoadingFile = new FileInputStream(FilePath);

                FileSize = LoadingFile.available();
                FileData = new byte[FileSize];
                LoadingFile.read(FileData);

            }
            catch (IOException LoadException)
            {
                LoadException.printStackTrace();
            }

            finally {
                try
                {
                    LoadingFile.close();
                }
                catch (IOException CannotClose)
                {
                    CannotClose.printStackTrace();
                }
            }
        }
        else {JOptionPane.showMessageDialog(null , "There is No File Loaded" ,
                "File Open is Canceled" , JOptionPane.INFORMATION_MESSAGE);}

    }
    public static void SaveFile()
    {
        JFileChooser SaveForm = new JFileChooser();
        FileOutputStream SavingFile = null;
        int SaveResult = SaveForm.showSaveDialog(null);
        if (SaveResult == JFileChooser.APPROVE_OPTION)
        {
            String SavePath = SaveForm.getSelectedFile().getPath();
            try
            {
                SavingFile = new FileOutputStream(SavePath);
                byte [] FileData = InvoicesData.getText().getBytes();
                SavingFile.write(FileData);
                JOptionPane.showMessageDialog(InvoicesFrame ,
                        "File is Saved Successfully" ,
                        "Saved Successfully" , JOptionPane.INFORMATION_MESSAGE);
            }
            catch (IOException SaveException)
            {
                SaveException.printStackTrace();
            }
            finally
            {
                try
                {
                    SavingFile.close();
                }
                catch (IOException CannotClose)
                {
                    CannotClose.printStackTrace();
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null ,
                    "The File Isn't Saved" , "File Save is Canceled"
                    , JOptionPane.ERROR_MESSAGE);
        }
    }
}
