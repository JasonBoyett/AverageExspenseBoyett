
/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * Sept 10, 2022
 * windows 10
 */
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {// beginning of Main class
    public static void main(String[] args) throws Exception {// beginning of memory hook
        JFrame frame = new JFrame();// this JFrame will hold the GUI elements
        ArrayList<Double> list = new ArrayList<>(0);// This array list will hold the amount spent on each day

        populateList(list, getSize(list, frame), frame);// a function that populates the list based on the return of
                                                        // another function that takes the number of days from the user
        String showAverage = String.format("Your average daily expenditure is $%,.2f", averageExpenses(list, frame));// a
                                                                                                                     // formatted
                                                                                                                     // string
                                                                                                                     // that
                                                                                                                     // shows
                                                                                                                     // the
                                                                                                                     // average
                                                                                                                     // daily
                                                                                                                     // expenses
        JOptionPane displayAverage = new JOptionPane();// a JOptionPane to show the showAverage string
        displayAverage.showMessageDialog(frame, showAverage);// set the type for the above JOptionPane
        frame.add(displayAverage);// adds the JOptionPane to the frame
        System.exit(0);// exit on close
    }// end of main

    public static double averageExpenses(ArrayList<Double> list, JFrame frame) {// takes a list of doubles with days as
                                                                                // indexes and averages the doubles in
                                                                                // the list
        try {
            double total = 0;
            for (int i = 0; i < list.size(); i++) {
                total += list.get(i).doubleValue();
            }
            if (!Double.isNaN(total / list.size())) {
                return total / list.size();
            } else {
                return 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "an error occurred", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }// end of averageExpenses

    public static void populateList(ArrayList<Double> list, int size, JFrame frame) {// adds values to the list of daily
                                                                                     // expenses

        for (int i = 0; i < size; i++) {
            list.add(getValue(frame, i));
        }
    }// end of populateList

    public static int getSize(ArrayList<Double> list, JFrame frame) {// takes the number of days the user would like to
                                                                     // average over and calls an overloading method if
                                                                     // there is an error

        try {
            return Integer
                    .parseInt(JOptionPane.showInputDialog(frame, "how many days would you like to average over?", 0));
        } catch (NumberFormatException e) {
            return getSize(list, frame, "Error please enter a whole number with no letters or special characters");
        } catch (Exception e) {
            System.exit(1);
            return 0;
        }
    }// end of getSize

    public static int getSize(ArrayList<Double> list, JFrame frame, String message) {// called if the getSize method it
                                                                                     // overloads encounters an error
                                                                                     // and calls it self recursively in
                                                                                     // the case of an error

        try {
            return Integer.parseInt(JOptionPane.showInputDialog(frame, message, 0));
        } catch (NumberFormatException e) {
            return getSize(list, frame, "Error, please enter a whole number with no letters or special characters");
        } catch (Exception e) {
            System.exit(1);
            return 0;
        }
    }// end of dailyExpenses overload

    public static double getValue(JFrame frame, int dayNumber) {// takes a daily expenses from the user calls an
                                                                // overloading method if there is an error
        try {
            return Double.parseDouble(
                    JOptionPane.showInputDialog(frame, "how much did you spend on day " + (dayNumber + 1), 0.00));
        } catch (NumberFormatException e) {
            return getValue(frame, dayNumber,
                    "Error please enter a decimal number with no letters or special characters");
        } catch (Exception e) {
            System.exit(1);
            return 0;
        }
    }// end of getValue

    public static double getValue(JFrame frame, int dayNumber, String message) {// called by the getValue method it
                                                                                // overloads if it encounters an error
                                                                                // and calls itself recursively if an
                                                                                // error is encountered
        try {
            return Double.parseDouble(JOptionPane.showInputDialog(frame, message, 0.00));
        } catch (NumberFormatException e) {
            return getValue(frame, dayNumber,
                    "Error, please enter a decimal number with no letters or special characters");
        } catch (Exception e) {
            System.exit(1);
            return 0;
        }
    }// end of getValue overload

}// end of Main class