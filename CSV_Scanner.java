import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSV_Scanner extends FileOptions
{
    BufferedReader CSVReader;
    String Line = "";
     Object [] ValuesData ;
     String [] ValuesRow ;
    {
        try
        {
            CSVReader = new BufferedReader(new FileReader(FilePath));
//            Line = CSVReader.readLine().trim();
//            ValuesData = Line.split(",");
              DefaultTableModel CSVTable =
                    (DefaultTableModel)InvoicesTable.getModel();
              ValuesData = CSVReader.lines().toArray();
              for (int i = 0 ; i < ValuesData.length ; i++)
              {
                  Line = ValuesData[i].toString().trim();
                  ValuesRow = Line.split(";");
                  CSVTable.addRow(ValuesRow) ;
              }
//            CSVTable.setColumns
//            while ((Line = CSVReader.readLine())!=null)
//            {
//                ValuesTable = Line.split(",");
//                //System.out.println(ValuesTable[0]);
//            }
        }
        catch (FileNotFoundException FileNotFound)
        {
            FileNotFound.printStackTrace();
        }
        catch (IOException NoLines2Read)
        {
            NoLines2Read.printStackTrace();
        }
    }
}
