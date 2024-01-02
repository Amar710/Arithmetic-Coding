import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ArithmeticCoding {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setTitle("Arithmetic Coding Results");

        // Create UI components
        JTextArea resultArea = new JTextArea(10, 40);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Layout using GridBagLayout
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Adding components to the frame
        frame.add(scrollPane, gbc);

        // Hide the frame intially as there is no data to display
        frame.setVisible(false);

        // Immediately process file
        processFile(resultArea, frame);
    }

    private static void processFile(JTextArea resultArea, JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                int N = Integer.parseInt(reader.readLine()); // Read the number of lines to process
                for (int i = 0; i < N; i++) {
                    String sequence = reader.readLine();
                    double[] bounds = calculateArithmeticCodingBounds(sequence);
                    resultArea.append("Sequence " + (i + 1) + ": Lower Bound: " + bounds[0] + ", Upper Bound: " + bounds[1] + "\n");
                }
                // Make the frame visible after processing is complete
                frame.setVisible(true);
            } 
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "The first line of the file is not a valid number. Please select a file with the correct format.", "Invalid File Format", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error processing file: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static double[] calculateArithmeticCodingBounds(String input) {
        double start = 0;
        double end = 1;
        double midpoint;

        for (int i = 0; i < input.length(); i++) {
            midpoint = (start + end) / 2;  // Calculate the midpoint at the start of each iteration

            if (input.charAt(i) == 'A') {
                // if input is A, the midpoint becomes the end
                end = midpoint;
                midpoint = (start + end)/2;
            } 
            
            else if (input.charAt(i) == 'B') {
                // if input is B, the start becomes the midpoint
                start = midpoint;
                midpoint = (start + end)/2;
            } 
            
            else {
                // error handling
                JOptionPane.showMessageDialog(null, "Invalid character. Only 'A' and 'B' are allowed.", "Invalid File Format", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }

        return new double[] { start, end };
    }
}
