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
        formPanel.add(btnProcess);  String[] columns = {"Patient Name", "Age", "Doctors Name", "Medicine Name"};

        
        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };  table = new JTable(model);
        table.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 320, 700, 240);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearInput();
            }
        });

        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processInvoice();
            }
        });

        add(mainPanel);
    }
 private void addItem() {
        String patient = txtPatient.getText().trim();
        String age = txtAge.getText().trim();
        String doctor = txtDoctor.getText().trim();
        String medicine = txtMedicine.getText().trim();

        // 5.1 Check if all fields are filled
        if (patient.isEmpty() || age.isEmpty()
                || doctor.isEmpty() || medicine.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please complete all fields!",
                    "Missing Information", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 5.2 Check if age is a number and within a valid range
        int ageValue;
        try {
            ageValue = Integer.parseInt(age);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Age must be a number!",
                    "Invalid Age", JOptionPane.ERROR_MESSAGE);
            txtAge.requestFocus();
            return;
        }

        if (ageValue < 1 || ageValue > 120) {
            JOptionPane.showMessageDialog(this, "Please enter a valid age (1-120)!",
                    "Invalid Age", JOptionPane.ERROR_MESSAGE);
            txtAge.requestFocus();
            return;
        }

        // 5.3 Add the row to the table
        model.addRow(new Object[]{patient, ageValue, doctor, medicine});

        // 5.4 Clear only the medicine so you can add another medicine
        //     for the same patient
        txtMedicine.setText("");
        txtMedicine.requestFocus();

        JOptionPane.showMessageDialog(this, "Item Added Successfully!");
    }

    // ===== STEP 6: CLEAR INPUT (empty all text fields) =====
    private void clearInput() {
        txtPatient.setText("");
        txtAge.setText("");
        txtDoctor.setText("");
        txtMedicine.setText("");
        txtPatient.requestFocus();
    }

    // ===== STEP 7: PROCESS INVOICE (build the invoice from the table) =====
    private void processInvoice() {

        // 7.1 There must be at least one item
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please add an item first!",
                    "No Items", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 7.2 Group the medicines per patient (in the order they were added)
        Map<String, StringBuilder> medicinesPerPatient
                = new LinkedHashMap<String, StringBuilder>();
        Map<String, Integer> countPerPatient
                = new LinkedHashMap<String, Integer>();

        for (int i = 0; i < model.getRowCount(); i++) {
            String patient = model.getValueAt(i, 0).toString();
            String age = model.getValueAt(i, 1).toString();
            String doctor = model.getValueAt(i, 2).toString();
            String medicine = model.getValueAt(i, 3).toString();

            String key = patient + "|" + age + "|" + doctor;

            if (!medicinesPerPatient.containsKey(key)) {
                medicinesPerPatient.put(key, new StringBuilder());
                countPerPatient.put(key, 0);
            }

            int number = countPerPatient.get(key) + 1;
            countPerPatient.put(key, number);

            medicinesPerPatient.get(key)
                    .append("   ").append(number).append(". ")
                    .append(medicine).append("\n");
        }

        // 7.3 Build the invoice text
        StringBuilder invoice = new StringBuilder();
        invoice.append("PHARMACY PRESCRIPTION INVOICE\n");
        invoice.append("==============================\n\n");

        for (Map.Entry<String, StringBuilder> entry : medicinesPerPatient.entrySet()) {
            String[] parts = entry.getKey().split("\\|");

            invoice.append("Patient Name: ").append(parts[0]).append("\n");
            invoice.append("Age:          ").append(parts[1]).append("\n");
            invoice.append("Doctor:       ").append(parts[2]).append("\n");
            invoice.append("MEDICINES:\n");
            invoice.append(entry.getValue());
            invoice.append("------------------------------\n");
        }

        invoice.append("Total Items: ").append(model.getRowCount()).append("\n");

        // 7.4 Show the invoice
        JTextArea area = new JTextArea(invoice.toString());
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JOptionPane.showMessageDialog(this, new JScrollPane(area),
                "Process Invoice", JOptionPane.INFORMATION_MESSAGE);

        // 7.5 Reset everything for the next customer
        model.setRowCount(0);
        clearInput();
    }

    // ===== STEP 8: MAIN METHOD (start the program) =====
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Javaapplication9().setVisible(true);
            }
        });
    }
}