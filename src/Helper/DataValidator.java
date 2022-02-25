/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class DataValidator {

    public static void validateEmpty(JTextField txtValue, StringBuilder sb, String msg) {
        String txt = txtValue.getText().trim();
        if (txt.length() == 0) {
            sb.append(msg).append("\n");
            txtValue.setBackground(Color.YELLOW);
            txtValue.requestFocus();
        } else {
            txtValue.setBackground(Color.WHITE);
        }
    }

    public static void validateEmpty(JTextArea txtArea, StringBuilder sb, String msg) {
        String txt = txtArea.getText().trim();
        if (txt.length() == 0) {
            sb.append(msg).append("\n");
            txtArea.setBackground(Color.YELLOW);
            txtArea.requestFocus();
        } else {
            txtArea.setBackground(Color.WHITE);
        }
    }

    public static void validateEmpty(JPasswordField txtPass, StringBuilder sb, String msg) {
        String txt = txtPass.getText().trim();
        if (txt.length() == 0) {
            sb.append(msg).append("\n");
            txtPass.setBackground(Color.YELLOW);
            txtPass.requestFocus();
        } else {
            txtPass.setBackground(Color.WHITE);
        }
    }

    public static void validateInt(JTextField txtNumber, StringBuilder sb, String msg1, String msg2) {
        String txt = txtNumber.getText().trim();
        if (txt.length() == 0) {
            sb.append(msg1).append("\n");
            txtNumber.setBackground(Color.YELLOW);
            txtNumber.requestFocus();
            return;
        } else {
            txtNumber.setBackground(Color.WHITE);
        }
        int number;
        try {
            number = Integer.parseInt(txt);
            if (number < 0) {
                sb.append(msg2).append("\n");
                txtNumber.setBackground(Color.YELLOW);
                txtNumber.requestFocus();
            } else {
                txtNumber.setBackground(Color.WHITE);
            }
        } catch (Exception e) {
            sb.append(msg2).append("\n");
            txtNumber.setBackground(Color.YELLOW);
            txtNumber.requestFocus();
        }
    }

    public static void validateDouble(JTextField txtNumber, StringBuilder sb, String msg1, String msg2) {
        String txt = txtNumber.getText().trim();
        if (txt.length() == 0) {
            sb.append(msg1).append("\n");
            txtNumber.setBackground(Color.YELLOW);
            txtNumber.requestFocus();
            return;
        } else {
            txtNumber.setBackground(Color.WHITE);
        }
        double number;
        try {
            number = Double.parseDouble(txt);
            if (number < 0) {
                sb.append(msg2).append("\n");
                txtNumber.setBackground(Color.YELLOW);
                txtNumber.requestFocus();
            } else {
                txtNumber.setBackground(Color.WHITE);
            }
        } catch (Exception e) {
            sb.append(msg2).append("\n");
            txtNumber.setBackground(Color.YELLOW);
            txtNumber.requestFocus();
        }
    }

    public static void validateDate(JTextField txtNumber, StringBuilder sb, String msg1, String msg2) {
        String txt = txtNumber.getText().trim();
        if (txt.length() == 0) {
            sb.append(msg1).append("\n");
            txtNumber.setBackground(Color.YELLOW);
            txtNumber.requestFocus();
            return;
        } else {
            txtNumber.setBackground(Color.WHITE);
        }
        try {
            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            df.setLenient(false);
            df.parse(txt);
        } catch (Exception e) {
            sb.append(msg2).append("\n");
            txtNumber.setBackground(Color.YELLOW);
            txtNumber.requestFocus();
        }
    }

    public static void validatePhone(JTextField txtNumber, StringBuilder sb, String msg, String msg1) {
        String txt = txtNumber.getText().trim();
        String phone = "^0\\d{9,10}$";
        if (txt.length() == 0) {
            sb.append(msg).append("\n");
            txtNumber.setBackground(Color.YELLOW);
            txtNumber.requestFocus();
        } else if (!txt.matches(phone)) {
            sb.append(msg1).append("\n");
            txtNumber.setBackground(Color.YELLOW);
            txtNumber.requestFocus();
        } else {
            txtNumber.setBackground(Color.WHITE);
        }
    }

    public static void validateEmail(JTextField txtEmail, StringBuilder sb, String msg, String msg1) {
        String txt = txtEmail.getText().trim();
        String email = "^[a-zA-Z]\\w{2,}@\\w{2,}(\\.\\w{2,3}){1,2}$";
        if (txt.length() == 0) {
            sb.append(msg).append("\n");
            txtEmail.setBackground(Color.YELLOW);
            txtEmail.requestFocus();
        } else if (!txt.matches(email)) {
            sb.append(msg1).append("\n");
            txtEmail.setBackground(Color.YELLOW);
            txtEmail.requestFocus();
        } else {
            txtEmail.setBackground(Color.WHITE);
        }
    }
}
