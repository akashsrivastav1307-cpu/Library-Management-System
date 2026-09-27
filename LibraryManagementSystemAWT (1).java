import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean issued;
    

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getId() 
    {
        return id;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issueBook() {
        this.issued = true;
    }

    public void returnBook() {
        this.issued = false;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Issued: " + (issued ? "Yes" : "No");
    }
}

class LibraryManagementSystem extends Frame implements ActionListener {

    private ArrayList<Book> library = new ArrayList<>();
    private TextField idField, titleField, authorField;
    private TextArea displayArea;
    Font f = new Font("Serif",Font.BOLD,24);

    public LibraryManagementSystem() 
    {
        setFont(f);
        setTitle("Library Management System");
        setSize(500, 400);
        setBackground(Color.YELLOW);
        setLayout(new FlowLayout());
        Label idLabel = new Label("Book ID:");
        idField = new TextField(10);
        add(idLabel);
        add(idField);
        Label titleLabel = new Label("Book Title:");
        titleField = new TextField(20);
        add(titleLabel);
        add(titleField);
        Label authorLabel = new Label("Author:");
        authorField = new TextField(20);
        add(authorLabel);
        add(authorField);
        Button addButton = new Button("Add Book");
        Button issueButton = new Button("Issue Book");
        Button returnButton = new Button("Return Book");
        Button viewButton = new Button("View Books");
        Button exitButton = new Button("Exit");
        add(addButton);
        add(issueButton);
        add(returnButton);
        add(viewButton);
        add(exitButton);
        addButton.addActionListener(this);
        issueButton.addActionListener(this);
        returnButton.addActionListener(this);
        viewButton.addActionListener(this);
        exitButton.addActionListener(this);
        displayArea = new TextArea(10, 40);
        displayArea.setEditable(false);
        add(displayArea);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case "Add Book":
                addBook();
                break;
            case "Issue Book":
                issueBook();
                break;
            case "Return Book":
                returnBook();
                break;
            case "View Books":
                viewBooks();
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }

    private void addBook() {
        int id = Integer.parseInt(idField.getText());
        String title = titleField.getText();
        String author = authorField.getText();

        Book book = new Book(id, title, author);
        library.add(book);

        displayArea.setText("Book added: " + book + "\n");
        clearFields();
    }

    private void issueBook() {
        int id = Integer.parseInt(idField.getText());

        for (Book book : library) {
            if (book.getId() == id && !book.isIssued()) {
                book.issueBook();
                displayArea.setText("Book issued: " + book + "\n");
                return;
            }
        }
        displayArea.setText("Book not found or already issued.\n");
    }

    private void returnBook() {
        int id = Integer.parseInt(idField.getText());

        for (Book book : library) {
            if (book.getId() == id && book.isIssued()) {
                book.returnBook();
                displayArea.setText("Book returned: " + book + "\n");
                return;
            }
        }
        displayArea.setText("Book not found or not issued.\n");
    }

    private void viewBooks() {
        if (library.isEmpty()) {
            displayArea.setText("No books available in the library.\n");
        } else {
            StringBuilder sb = new StringBuilder("Books in the Library:\n");
            for (Book book : library) {
                sb.append(book).append("\n");
            }
            displayArea.setText(sb.toString());
        }
    }

    private void clearFields() {
        idField.setText("");
        titleField.setText("");
        authorField.setText("");
    }
    public static void main(String[] args) {
        new LibraryManagementSystem();
    }
} 
