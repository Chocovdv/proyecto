/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author amart
 */
public class Validaciones {
    /**
     * Permite solo la entrada de números decimales en un JTextField.
     * @param evt El evento KeyEvent que desencadena la validación.
     * @param textField El JTextField en el que se realiza la validación.
     */
    public void soloDecimales(KeyEvent evt, JTextField textField) {
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && textField.getText().contains(".") && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        } else if ((car < '0' || car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }
    
    /**
     * Permite solo la entrada de texto (letras) en un JTextField.
     * @param evt El evento KeyEvent que desencadena la validación.
     */
     public void soloTexto(KeyEvent evt) {
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && (car != (char) KeyEvent.VK_BACK_SPACE) && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }
 
     /**
     * Permite solo la entrada de números enteros en un JTextField.
     * @param evt El evento KeyEvent que desencadena la validación.
     */
    public void soloNumeros(KeyEvent evt) {
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }
 
    
}
