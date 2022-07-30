import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.function.DoubleToIntFunction;

public class SalesInvoiceGenerator extends JFrame implements ActionListener
    {
        public static JFrame InvoicesFrame = new JFrame();
        public JMenuBar MainMenuBar = new JMenuBar();
        public JTable InvoicesTable = new JTable(5,4);
        public JTable InvoiceItemsTable = new JTable(5,5);
        public JMenu FileMenu = new JMenu("File");
        public JButton OpenBtn = new JButton("Open");
        public JButton SaveBtn = new JButton("Save");
        public JButton ExitBtn = new JButton("Exit");
        public JButton CreateNewInvoiceBtn = new JButton("Create New Invoice");
        public JButton DeleteInvoiceBtn = new JButton("Delete Invoice");
        public JButton InvoiceSaveBtn = new JButton("Save");
        public JButton CancelBtn = new JButton("Cancel");
        public JPanel MainPanel = new JPanel();
        public JPanel InvoicesPanel = new JPanel();
        public JPanel InvoicesFooterPanel = new JPanel();
        public JPanel InvoiceDetailsPanel = new JPanel();
        public JPanel InvoiceDetailsFooterPanel = new JPanel();
        public JPanel InvoiceHeader = new JPanel();
        public JPanel InvoiceItems = new JPanel();
        public JTextField InvoiceNumber = new JTextField(50);
        public JTextField InvoiceDate = new JTextField(50);
        public JTextField CustomerName = new JTextField(50);
        public JTextField InvoiceTotal = new JTextField(50);
        public static JTextArea InvoicesData = new JTextArea();


        Border BlackLine = BorderFactory.createLineBorder(Color.BLACK);

        SalesInvoiceGenerator()
        {
            super("Sales Invoice Generator");
            //setLayout(new FlowLayout());
            Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
            double ScreenWidth =  ScreenSize.getWidth();
            double ScreenHeight = ScreenSize.getWidth();
            setSize((int) ScreenWidth,(int) ScreenHeight);
            setLocation(0,0);

            //InvoicesPanel.setSize((int) ScreenWidth/2,(int) ScreenHeight/2);
            //InvoicesPanel.setLocation((int) ScreenWidth/2,(int) ScreenHeight/2);
            //InvoiceDetailsPanel.setSize((int) ScreenWidth/2,(int) ScreenHeight/2);
            //InvoiceDetailsPanel.setLocation((int) ScreenWidth/2,(int) ScreenHeight/2);


            OpenBtn.setMnemonic('O');
            OpenBtn.addActionListener(this);
            OpenBtn.setActionCommand("OpenPressed");
            SaveBtn.setMnemonic('S');
            SaveBtn.addActionListener(this);
            SaveBtn.setActionCommand("SavePressed");
            ExitBtn.setMnemonic('X');
            ExitBtn.addActionListener(this);
            ExitBtn.setActionCommand("ExitPressed");
            CreateNewInvoiceBtn.addActionListener(this);
            CreateNewInvoiceBtn.setActionCommand("CreateNewInvoicePressed");
            DeleteInvoiceBtn.addActionListener(this);
            DeleteInvoiceBtn.setActionCommand("DeleteInvoicePressed");
            InvoiceSaveBtn.addActionListener(this);
            InvoiceSaveBtn.setActionCommand("InvoiceSavePressed");
            CancelBtn.addActionListener(this);
            CancelBtn.setActionCommand("CancelPressed");

            FileMenu.add(OpenBtn);
            FileMenu.add(SaveBtn);
            FileMenu.addSeparator();
            FileMenu.add(ExitBtn);
            MainMenuBar.add(FileMenu);
            setJMenuBar(MainMenuBar);


            //InvoicesPanel.add(new JSeparator());
            InvoicesTable.setBorder(BlackLine);
            InvoicesFooterPanel.add(CreateNewInvoiceBtn);
            InvoicesFooterPanel.add(DeleteInvoiceBtn);
            InvoicesPanel.setLayout(new GridLayout(3,1));
            InvoicesPanel.add(new JLabel("Invoices Table"));
            InvoicesPanel.add(InvoicesTable);
            InvoicesPanel.add(InvoicesFooterPanel);

            InvoiceHeader();

            InvoiceDetailsFooterPanel.add(InvoiceSaveBtn);
            InvoiceDetailsFooterPanel.add(CancelBtn);
            InvoiceDetailsPanel.setLayout(new GridLayout(4,1));
            InvoiceDetailsPanel.add(InvoiceHeader);
            InvoiceDetailsPanel.add(new JLabel("Invoice Items"));
            InvoiceDetailsPanel.add(InvoiceItemsTable);
            InvoiceDetailsPanel.add(InvoiceDetailsFooterPanel);

            MainPanel.setLayout(new GridLayout(1,2));
            InvoicesPanel.setBorder(BlackLine);
            InvoiceDetailsPanel.setBorder(BlackLine);
            MainPanel.add(InvoicesPanel);
            MainPanel.add(InvoiceDetailsPanel);

            InvoicesFrame();
            InvoicesPanel.add(InvoicesFooterPanel);
            add(MainPanel);

            setDefaultCloseOperation(EXIT_ON_CLOSE);

        }

        public void InvoiceHeader() {
            //InvoiceTotal.setSize(InvoiceDetailsPanel.getSize());
            setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
           // setLayout(new BoxLayout(getContentPane(),BoxLayout.LINE_AXIS));
            InvoiceHeader.add(new JLabel("Invoice Number"));
            InvoiceHeader.add(InvoiceNumber);
            InvoiceHeader.add(new JLabel("Invoice Date"));
            InvoiceHeader.add(InvoiceDate);
            InvoiceHeader.add(new JLabel("Customer Name"));
            InvoiceHeader.add(CustomerName);
            InvoiceHeader.add(new JLabel("Invoice Total"));
            InvoiceHeader.add(InvoiceTotal);
        }

        public static void main(String[] args) {
            new SalesInvoiceGenerator().setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent ButtonPressed) {
            if (ButtonPressed.getActionCommand().equals("OpenPressed"))
            {
                FileOptions.LoadFile();
            }
            if (ButtonPressed.getActionCommand().equals("SavePressed"))
            {
                FileOptions.SaveFile();
            }
            if (ButtonPressed.getActionCommand().equals("ExitPressed"))
            {
                JOptionPane.showMessageDialog(InvoicesFrame ,
                        "Application is Closed Successfully" ,
                        "Close the Sales Invoice Generator App" , JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            if (ButtonPressed.getActionCommand().equals("CreateNewInvoicePressed"))
            {

            }
            if (ButtonPressed.getActionCommand().equals("DeleteInvoicePressed"))
            {

            }
            if (ButtonPressed.getActionCommand().equals("InvoiceSavePressed"))
            {

            }
            if (ButtonPressed.getActionCommand().equals("CancelPressed"))
            {

            }

        }
        public void InvoicesFrame()
        {
             String [] InvoicesTableHeader = {"","","",""};
             String [] [] InvoicesTableDetails =
                     {
                     {"","","","",""},
                     {"","","","",""},
                     {"","","","",""},
                     {"","","","",""},
                     {"","","","",""},
                     };

        }
    }
