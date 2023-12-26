package complexcalculator;
import javax.swing.JOptionPane; // Import the librarie JOptionPane

/**
 *
 * @author JAGT1806
 */
public class ComplexCalculator {


    public static void main(String[] args) {
        menu();
        
    }
    
    // Métodos estáticos
    
    // Menús
    public static void menu() { // Menú Principal
        int optionMenu = Integer.parseInt(JOptionPane.showInputDialog(null, """
                         Men\u00fa Principal
                           1. Forma bin\u00f3mica
                           2. Forma polar
                           0. Salir del programa
                         
                         OPCION: """));
        
        switch(optionMenu){
            case 1 -> {menuBinomic();}
            case 2 -> {menuPolar()}
            case 0 -> System.exit(0);
            default -> System.out.println("Opción Inválida");
        
        }
    }
    
    public static void menuBinomic() { // Menú binómico
        
        int optionBinomic = Integer.parseInt(JOptionPane.showInputDialog(null, """
                         Menú Bin\u00f3mico
                         1. Sumar
                         2. Restar
                         3. Multiplicar
                         4. Dividir
                         5. Polar
                         0. Regresar
                         
                         OPCIÓN: """));
        

        switch(optionBinomic) {
            case 1 -> {} 
            case 2 -> {} 
            case 3 -> {}
            case 4 -> {}
            case 0 -> {menu();} // Regresa al menu
            default -> {
                JOptionPane.showMessageDialog(null, "Opción errónea\n");
                menuBinomic(); // Se vuelve a repetir
            }
        }
        
    }
    
    public static void menuPolar() { // Menú polar
        
        int optionPolar = Integer.parseInt(JOptionPane.showInputDialog(null, """
                         Menú Polar
                         1. Multiplicar
                         2. Dividir
                         3. Potencia
                         4. Raíz
                         5. Bin/u00f3mica
                         0. Regresar
                                                   
                         OPCIÓN: """));
        

        switch(optionPolar) {
            case 1 -> {} 
            case 2 -> {} 
            case 3 -> {}
            case 4 -> {}
            case 0 -> {menu();} // Regresa al menu
            default -> {
                JOptionPane.showMessageDialog(null, "Opción errónea\n");
                menuPolar(); // Se vuelve a repetir
            }
        }
        
    }
    
}
