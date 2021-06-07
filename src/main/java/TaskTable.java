
/**
 *
 * @author liam
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TaskTable {

    public static void main(String[] args){


        // create JFrame and JTable
        JFrame frame = new JFrame();
        JTable table = new JTable();

        //left menu panel
        JPanel p1 = new JPanel();
        p1.setBackground(Color.gray);
        p1.setBounds(0,0,100,600);

        //heading panel
        JPanel p2 = new JPanel();
        p2.setBackground(new Color(32,136,203));;
        p2.setBounds(100,0,1100,50);

        // create a table model and set a Column Identifiers to this model
        Object[] columns = {"Due","Task","Subject","Description"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(32,136,203));
        table.getTableHeader().setForeground(new Color(255,255,255));
        table.setRowHeight(25);
        table.setShowVerticalLines(false);




        // set the model to the table
        table.setModel(model);

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setFont(new Font("Segoe UI", Font.BOLD,12));
        table.setRowHeight(30);

        //image icons NOT USED YET
        ImageIcon home = new ImageIcon("home.png");
        ImageIcon task = new ImageIcon("task.png");
        ImageIcon calendar = new ImageIcon("calendar.png");
        ImageIcon user = new ImageIcon("user.png");
        //icon labels

        //JLabel homeImg = new JLabel();
        //JLabel taskImg = new JLabel();
        //JLabel calendarImg = new JLabel();
        //JLabel userImg = new JLabel();

        //setting icons to labels
        //homeImg.setIcon(home);
        //homeImg.setBounds(50,50,50,50);


        //create JLabels
        JLabel title = new JLabel("Title");
        JLabel subject = new JLabel("Subject");
        JLabel due = new JLabel("Due Date");
        JLabel des = new JLabel("Description");

        title.setBounds(500, 380, 200, 25);
        subject.setBounds(850,380,200,25);
        due.setBounds(150,380,200,25);
        des.setBounds(150,430,200,25);

        // create JTextFields
        JTextField textTitle = new JTextField();
        JTextField textSubject = new JTextField();
        JTextField textDue = new JTextField();
        JTextField textDescription = new JTextField();

        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");

        textTitle.setBounds(150, 400, 300, 25);
        textSubject.setBounds(500, 400, 300, 25);
        textDue.setBounds(850, 400, 300, 25);
        textDescription.setBounds(150, 450, 1000, 25);

        btnAdd.setBounds(480, 520, 100, 25);
        btnUpdate.setBounds(600, 520, 100, 25);
        btnDelete.setBounds(720, 520, 100, 25);



        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(150, 60, 1000, 300);

        frame.setLayout(null);


        frame.add(pane);
        frame.add(p1);
        frame.add(p2);


        //add Labels
        frame.add(title);
        frame.add(subject);
        frame.add(due);
        frame.add(des);

        // add JTextFields to the jframe
        frame.add(textTitle);
        frame.add(textSubject);
        frame.add(textDue);
        frame.add(textDescription);

        // add JButtons to the jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);

        // create an array of objects to set the row data
        Object[] row = new Object[4];


        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                row[0] = textTitle.getText();
                row[1] = textSubject.getText();
                row[2] = textDue.getText();
                row[3] = textDescription.getText();

                // add row to the model
                model.addRow(row);
            }
        });

        // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model.removeRow(i);
                }
                else{
                    System.out.println("Error");
                }
            }
        });

        // get selected row data From table to textfields
        table.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e){
                table.setSelectionBackground(new java.awt.Color(232, 57, 95));
                // i = the index of the selected row
                int i = table.getSelectedRow();

                textTitle.setText(model.getValueAt(i, 0).toString());
                textSubject.setText(model.getValueAt(i, 1).toString());
                textDue.setText(model.getValueAt(i, 2).toString());
                textDescription.setText(model.getValueAt(i, 3).toString());
            }
        });

        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();

                if(i >= 0)
                {
                    model.setValueAt(textTitle.getText(), i, 0);
                    model.setValueAt(textSubject.getText(), i, 1);
                    model.setValueAt(textDue.getText(), i, 2);
                    model.setValueAt(textDescription.getText(), i, 3);
                }
                else{
                    System.out.println("Error");
                }
            }
        });

        frame.setSize(1200,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
