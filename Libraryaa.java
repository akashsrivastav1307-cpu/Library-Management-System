import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class Library extends Frame implements ActionListener
{
    Label l1,l2,l3,l4,l5,l6,l7,l8;
    TextField t1,t2,t3,t4,t5,t6;
    Button b1,b2,b3,b4;
    Font f1,f2,f3,f4;
    double fine=5.00,totalfine;
    long totaldays,daysoverdue;
    public Library()
    {
        
        f1=new Font("Arial Black",Font.BOLD,50);
        f2=new Font("Serif",Font.BOLD,30);
        f3=new Font("Serif",Font.BOLD,24);
        f4=new Font("Serif",Font.BOLD,18);
        setLayout(null);
        setVisible(true);
        setBackground(Color.gray);
        setSize(1550,1000);
        setTitle("Library Billing System");
        l1=new Label("WELCOME TO LIBRARY MANAGEMENT SYSTEM");
        l1.setFont(f1);
        b1=new Button("Calculate Fine");
        b3=new Button("Clear");
        b4=new Button("Exit");
        b2=new Button("Generate Bill");
        l2=new Label("Book Name");
        l6=new Label("* Note: Fine Rate Per day = 5.00 (After one week of book issue date)");
        l3=new Label("Issue date (in format dd/mm/yyyy)");
        l4=new Label("Return date (in format dd/mm/yyyy)");
        l5=new Label("Total days");
        l7=new Label("Days Overdue");
        l8=new Label("Total fine");
        t1=new TextField(20);
        t2=new TextField(20);
        t3=new TextField(20);
        t4=new TextField(20);
        t5=new TextField(20);
        t6=new TextField(20);
        l2.setFont(f3);
        l3.setFont(f3);
        l4.setFont(f3);
        l5.setFont(f3);
        l6.setFont(f4);
        l7.setFont(f3);
        l8.setFont(f3);
        b1.setFont(f2);
        b2.setFont(f2);
        b3.setFont(f2);
        b4.setFont(f2);
        t1.setFont(f3);
        t2.setFont(f3);
        t3.setFont(f3);
        t4.setFont(f3);
        t5.setFont(f3);
        t6.setFont(f3); 
        l1.setBounds(150,10,1200,200);
        l2.setBounds(200,250,400,30);
        l3.setBounds(200,320,400,30);
        l4.setBounds(200,390,400,30);
        l5.setBounds(200,460,400,30);
        l6.setBounds(200,670,600,30);
        l7.setBounds(200,530,400,30);
        l8.setBounds(200,600,400,30);
        t1.setBounds(900,250,250,30);
        t2.setBounds(900,320,250,30);
        t3.setBounds(900,390,250,30);
        t4.setBounds(900,460,250,30);
        t5.setBounds(900,530,250,30);
        t6.setBounds(900,600,250,30);
        b2.setBounds(100,750,250,50);
        b1.setBounds(450,750,250,50);
        b3.setBounds(800,750,250,50);
        b4.setBounds(1150,750,250,50);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b1.setBackground(Color.CYAN);
	b2.setBackground(Color.yellow);
	b3.setBackground(Color.red);
	b4.setBackground(Color.green);

        
    }
        public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate date1 = LocalDate.parse(t2.getText(), formatter);
            LocalDate date2 = LocalDate.parse(t3.getText(), formatter);
            totaldays = ChronoUnit.DAYS.between(date1, date2);
            daysoverdue = (totaldays-7);
            totalfine = (fine*daysoverdue);
            t4.setText(Long.toString(totaldays));
            if(totaldays>7)
            {
            t5.setText(Long.toString(daysoverdue));
            t6.setText(Double.toString(totalfine));
            }
            else
            {
                t5.setText("No overdue");
                t6.setText("0.00");
            }
        }
         catch (Exception ex) 
        {
            t4.setText("Invalid Date");    
        }
    }
       if(e.getSource()==b2)
       {
        
       }
    if(e.getSource()==b4)  
    {
        System.exit(0);
    }
    if(e.getSource()==b3)
    {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
    }
}
}

class Libraryaa
{
    public static void main(String[] args) 
    {
        Library l=new Library();
    }
}