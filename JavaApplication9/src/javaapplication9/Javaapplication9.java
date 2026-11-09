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

    public static void main(String[] args) {
      
            }
      
    
}