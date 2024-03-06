package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends JFrame {

    private JTextArea inputTextArea; // Área de texto 
    private JButton analyzeButton; // Botón para iniciar el análisis del texto

    public Main() {
        setTitle("Regextrtrtr");
        setSize(400, 300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        initComponents(); 
        setLocationRelativeTo(null);
        setVisible(true); 
        System.out.println("*******************************");
    	System.out.println("*       Programa Regex        *");
    	System.out.println("*******************************");
    }

    private void initComponents() {
        Container contentPane = getContentPane(); // Obtener el panel principal de la ventana

        inputTextArea = new JTextArea(); 
        JScrollPane scrollPane = new JScrollPane(inputTextArea); 
        contentPane.add(scrollPane, BorderLayout.CENTER); 

        
 ////////////////////////////////// Evento para que el programa analize el caracter dado por el usuario       
        analyzeButton = new JButton("Analizar");
        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputTextArea.getText(); // Obtener el texto ingresado por el usuario
                String[] numericStrings = text.split("\\s+"); // Dividir el texto en palabras

                // Iterar sobre cada palabra para identificar y clasificar las cadenas numéricas
                int num = 1;
                for (String numericString : numericStrings) {
                    String result = identifyNumericString(numericString); // Identificar la cadena numérica
                    System.out.println(num +"/"+ num +"/"+numericString + " es " + result); // Imprimir el resultado en la consola
                    num++;
                }
            }
        });
        contentPane.add(analyzeButton, BorderLayout.SOUTH); 
    }
    
/////////////////////////////////////////
    private String identifyNumericString(String numericString) {
        // Matchers con las ER 
        Pattern realPattern = Pattern.compile("\\b\\d+[,.]\\d+\\b"); 
        Pattern naturalPattern = Pattern.compile("\\b\\d+\\b");
        Pattern exponentialPattern = Pattern.compile("\\b\\d+[,.]\\d+E\\d+\\b"); 
        Pattern percentagePattern = Pattern.compile("\\b\\d+\\b%"); 

        // Crear matchers
        Matcher realMatcher = realPattern.matcher(numericString);
        Matcher naturalMatcher = naturalPattern.matcher(numericString);
        Matcher exponentialMatcher = exponentialPattern.matcher(numericString);
        Matcher percentageMatcher = percentagePattern.matcher(numericString);

        // Comprobar si la cadena numérica coincide con algun matcher
        if (realMatcher.matches()) {
            return "Real";
        } else if (naturalMatcher.matches()) {
            return "Natural";
        } else if (exponentialMatcher.matches()) {
            return "Exponencial";
        } else if (percentageMatcher.matches()) {
            return "Porcentaje";
        } else {
            return "Invalido";
        }
    }

    

    public static void main(String[] args) {
        new Main();
    }
    
}

