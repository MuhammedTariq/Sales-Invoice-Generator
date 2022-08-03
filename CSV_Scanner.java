import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSV_Scanner extends FileOptions {
//    public static String [] InvoicesTableHeaderData = new String[]{"No.", "Date", "Customer", "Total"};
    static BufferedReader CSVReader;
    static String Line = "";
    static Object[] ValuesData;
    static String[] ValuesRow;

    public static void ScanCSV() {
        try {
            JFileChooser SelectForm = new JFileChooser();
            int SelectionResult = SelectForm.showOpenDialog(null);
            if (SelectionResult == JFileChooser.APPROVE_OPTION)
            {
                String FilePath = SelectForm.getSelectedFile().getPath();
                CSVReader = new BufferedReader(new FileReader(FilePath));
//            Line = CSVReader.readLine().trim();
//            ValuesData = Line.split(",");
                DefaultTableModel CSVTable =
                        (DefaultTableModel) InvoicesTable.getModel();
                ValuesData = CSVReader.lines().toArray();
//                DefaultTableModel HeaderModel = new DefaultTableModel(InvoicesTableHeaderData, 1);
//                InvoicesTableHeader.setModel(HeaderModel);
                for (int i = 0; i < ValuesData.length; i++)
                {
                    Line = ValuesData[i].toString().trim();
                    ValuesRow = Line.split(",");
                    CSVTable.addRow(ValuesRow);
                }
//            CSVTable.setColumns
//            while ((Line = CSVReader.readLine())!=null)
//            {
//                ValuesTable = Line.split(",");
//                //System.out.println(ValuesTable[0]);
//            }
            }
            else
            {
                JOptionPane.showMessageDialog(null , "There is No File Loaded" ,
                    "File Open is Canceled" , JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(FileNotFoundException FileNotFound)
        {
            JOptionPane.showMessageDialog(null, "File Not Found", "No File", JOptionPane.ERROR_MESSAGE);
            FileNotFound.printStackTrace();
        }
        catch(IOException NoLines2Read)
        {
            JOptionPane.showMessageDialog(null, "No Data Remains", "No Data", JOptionPane.ERROR_MESSAGE);
            NoLines2Read.printStackTrace();
        }
                    finally
            {
               try
                {
                    CSVReader.close();
                }
                catch (IOException CannotClose)
                {
                    CannotClose.printStackTrace();
                }
            }
    }
}
