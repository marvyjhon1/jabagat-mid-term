package Javaapplication9;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
public class Javaapplication9 extends JFrame {
  private JTextField txtPatient;
    private JTextField txtAge;
    private JTextField txtDoctor;
    private JTextField txtMedicine;
    private JButton btnAdd;
    private JButton btnClear;
    private JButton btnProcess;
    private JTable table;
    private DefaultTableModel model;
       private void initComponents() {

        setTitle("Pharmacy Prescription Processing");
        setSize(820, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);
        
         JLabel title = new JLabel("Pharmacy Prescription Processing");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(130, 15, 600, 45);
        mainPanel.add(title);
        new JPanel(null);
        formPanel.setBackground(new Color(240, 240, 240));
        formPanel.setBounds(50, 75, 700, 230);
        mainPanel.add(formPanel);
        mainPanel.add(formPanel);
        JLabel heading = new JLabel("Patient Information & Medicine Form Fields");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setBounds(20, 10, 500, 30);
        formPanel.add(heading);
        JLabel lblPatient = new JLabel("Patient Name:");
        lblPatient.setBounds(20, 55, 120, 25);
        JLabel lblPatient = new JLabel("Patient Name:");
        lblPatient.setBounds(20, 55, 120, 25);
        formPanel.add(lblPatient);

        txtPatient = new JTextField();
        txtPatient.setBounds(145, 55, 355, 25);
        formPanel.add(txtPatient);

      
        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(20, 85, 120, 25);
        formPanel.add(lblAge);
         txtAge = new JTextField();
        txtAge.setBounds(145, 85, 60, 25);
        formPanel.add(txtAge);

        
        JLabel lblDoctor = new JLabel("Doctors Name:");
        
        lblDoctor.setBounds(20, 115, 120, 25);
        formPanel.add(lblDoctor);

        txtDoctor = new JTextField();
        txtDoctor.setBounds(145, 115, 355, 25);
        formPanel.add(txtDoctor);
         JLabel lblMedicine = new JLabel("Medicine Name:");
        lblMedicine.setBounds(20, 145, 120, 25);
        formPanel.add(lblMedicine);

        txtMedicine = new JTextField();
        txtMedicine.setBounds(145, 145, 355, 25);
        formPanel.add(txtMedicine);

       
        btnAdd = new JButton("Add Item");
        btnAdd.setBounds(145, 185, 100, 30);
        formPanel.add(btnAdd);
        
        btnProcess = new JButton("Process Invoice");
        btnProcess.setBounds(375, 185, 130, 30);
        formPanel.add(btnProcess);


    public static void main(String[] args) {
      
            }
      
    
}