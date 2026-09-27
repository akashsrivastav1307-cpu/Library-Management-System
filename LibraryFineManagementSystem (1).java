import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryFineManagementSystem extends Frame implements ActionListener
{
    private Label bookLabel, returnDateLabel, dueDateLabel, fineLabel, daysLabel;
    private TextField bookField, daysField, fineField, fineRateField;
    private Button calculateButton, clearButton, exitButton;
    private final double FINE_RATE = 5.0;
    public LibraryFineManagementSystem() 
    {
        setTitle("Library Fine Management System");
        setLayout(new GridLayout(6, 2, 10, 10));
        bookLabel = new Label("Book Name: ");
        daysLabel = new Label("Days Overdue: ");
        fineLabel = new Label("Total Fine: ");
        fineRateField = new TextField(String.valueOf(FINE_RATE));
        fineRateField.setEditable(false);
        bookField = new TextField(20);
        daysField = new TextField(20);
        fineField = new TextField(20);
        fineField.setEditable(false);
        calculateButton = new Button("Calculate Fine");
        clearButton = new Button("Clear");
        exitButton = new Button("Exit");
        add(bookLabel); 
        add(bookField);
        add(daysLabel); 
        add(daysField);
        add(new Label("Fine Rate per Day:")); 
        add(fineRateField);
        add(fineLabel); 
        add(fineField);
        add(calculateButton); 
        add(clearButton);
        add(new Label()); 
        add(exitButton);
        calculateButton.addActionListener(this);
    }
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    int daysOverdue = Integer.parseInt(daysField.getText());
                    double totalFine = daysOverdue * FINE_RATE;
                    fineField.setText(String.valueOf(totalFine));
                }
                 catch (NumberFormatException ex) 
                 {
                 }
            }
    

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookField.setText("");
                daysField.setText("");
                fineField.setText("");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(Color.yellow);
    }

    public static void main(String[] args) {
        new LibraryFineManagementSystem();
    }
}