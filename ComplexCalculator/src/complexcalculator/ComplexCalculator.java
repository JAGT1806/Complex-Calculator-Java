package complexcalculator;
import javax.swing.JOptionPane; // Import the librarie JOptionPane

/**
 *
 * @author JAGT1806
 */
public class ComplexCalculator {
    // Parte binómico
    double real;
    double imaginario;
    
    // Parte polar
    double modulo;
    double angulo;

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
            case 2 -> {menuPolar();}
            case 0 -> System.exit(0);
            default -> {
                JOptionPane.showMessageDialog(null, "Opción errónea\n");
                menu();
            }
        
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
        

        ComplexCalculator z1 = new ComplexCalculator(); // Objeto principal
        ComplexCalculator z2 = new ComplexCalculator(); // Objeto secundario para opciones 1, 2, 3 y 4
        
        // Lectura de números complejos
        switch(optionBinomic) {
            case 1, 2, 3, 4 -> { 
                int i = 1;
                z1 = makeBinomic(i);// Z1 : a + bi
                i++;
                z2 = makeBinomic(i);// Z2 : c + di
            }
            case 5 ->  {
                z1 = makeBinomic(1); // z1 : a + bi
            }
            case 0 -> {
                menu(); // Regresa al menú
            }
            default -> {
                JOptionPane.showMessageDialog(null, "¡Opción errónea!");
                menuBinomic(); // Se vuelve a repetir
            }
        }
        
        ComplexCalculator z3 = new ComplexCalculator(); // Se crea el objeto Z3 que será el resultado
        
        // Aplicar operaciones
        switch(optionBinomic) {
            case 1 -> {
                JOptionPane.showMessageDialog(null, "OPERACIÓN: (" + z1.showComplexBinomic()
                + ") + (" + z2.showComplexBinomic() + ")\n");
                z3.addComplexBinomic(z1, z2);
            } case 2 -> {
                JOptionPane.showMessageDialog(null, "OPERACIÓN: (" + z1.showComplexBinomic()
                + ") + (" + z2.showComplexBinomic() + ")\n");
                z3.resComplexBinomic(z1, z2);
            } case 3 -> {
                JOptionPane.showMessageDialog(null, "OPERACIÓN: (" + z1.showComplexBinomic()
                + ") + (" + z2.showComplexBinomic() + ")\n");
                z3.mulComplexBinomic(z1, z2);
            } case 4 -> {
                JOptionPane.showMessageDialog(null, "OPERACIÓN: (" + z1.showComplexBinomic()
                + ") + (" + z2.showComplexBinomic() + ")\n");
                z3.divComplexBinomic(z1, z2);
            } case 5 -> {
                z3 = z1.toPolar();
                JOptionPane.showMessageDialog(null, "Resultado = " + z3.showComplexPolar());
                menuBinomic();
            }
        }
        
        JOptionPane.showMessageDialog(null, "Resultado = " + z3.showComplexBinomic());
        menuBinomic();
        
    }
    
    public static void menuPolar() { // Menú polar
        
        int optionPolar = Integer.parseInt(JOptionPane.showInputDialog(null, """
                         Menú Polar
                         1. Multiplicar
                         2. Dividir
                         3. Potencia
                         4. Raíz
                         5. Bin\u00f3mica
                         0. Regresar
                                                   
                         OPCIÓN: """));
        
        ComplexCalculator z1 = new ComplexCalculator(); // Objeto principal
        ComplexCalculator z2 = new ComplexCalculator(); // Objeto secundario para opciones 1 y 2
        
        // Lectura de números complejos
        switch(optionPolar) {
            case 1, 2 -> { 
                int i = 1;
                z1 = makePolar(i); // Z1 : r1 cis O1
                i++;
                z2 = makePolar(i); // Z2 : r2 cis O2
            }
            case 3, 4, 5 ->  {
                z1 = makePolar(1); // Z1 : r cis O
            }
            case 0 -> {
                menu(); // Regresa al menú
            }
            default -> {
                JOptionPane.showMessageDialog(null, "¡Opción erróneoa!");
                menuPolar(); // Se vuelve a repetir
            }
        }
        
        ComplexCalculator z3 = new ComplexCalculator();
        
        // Aplicar operaciones
        switch(optionPolar) {
            case 1 -> {
                JOptionPane.showMessageDialog(null, "OPERACIÓN: (" + z1.showComplexPolar()
                + ") * (" + z2.showComplexPolar() + ")");
                z3.mulComplexPolar(z1, z2);
            } case 2 -> {
                JOptionPane.showMessageDialog(null, "OPERACIÓN: (" + z1.showComplexPolar()
                + ") / (" + z2.showComplexPolar() + ")");
                z3.divComplexPolar(z1, z2);
            } case 3 -> {
                int exp = Integer.parseInt(JOptionPane.showInputDialog(null, "Exponente (valor entero: "));
                JOptionPane.showMessageDialog(null, "OPERACIÓN: (" + z1.showComplexPolar()
                + ") ^ " + exp); // r ^n
                z3.powComplexPolar(z1, exp);
            } case 4 -> {
                
            } case 5 -> {
                z3 = z1.toBinomic();
                JOptionPane.showMessageDialog(null, "Resultado = " + z3.showComplexBinomic());
                menuPolar();
            }
        }
        
        JOptionPane.showMessageDialog(null, "Resultado = " + z3.showComplexPolar());
        menuPolar();
        
    }
    
      // Método para crear un número complejo binómico
    public static ComplexCalculator makeBinomic(int i) {  // Complejo : a + bi
        ComplexCalculator Z = new ComplexCalculator(); // Objeto complejo
        
        Z.real = Double.parseDouble(JOptionPane.showInputDialog(null, "Z" + i + "\n" + """
                                                                                       >> Valor real: """));
        Z.imaginario = Double.parseDouble(JOptionPane.showInputDialog(null, "Z" + i + "\n" + """
                                                                                             >> Valor imaginario: """));
        
        JOptionPane.showMessageDialog(null, "Número complejo: " + Z.showComplexBinomic());
        
        return Z;
    }
    
          // Método para crear un número complejo polar
    public static ComplexCalculator makePolar(int i) { // Complejo : r cis O
        ComplexCalculator Z = new ComplexCalculator(); // Objeto complejo
        
        Z.modulo = Double.parseDouble(JOptionPane.showInputDialog(null, "Z" + i + "\n" + """
                                                                                       >> Módulo: """));
        Z.angulo = Double.parseDouble(JOptionPane.showInputDialog(null, "Z" + i + "\n" + """
                                                                                             >> Ángulo: """));
        
        JOptionPane.showMessageDialog(null, "Número complejo: " + Z.showComplexPolar());
        
        return Z;
    }
    
    // Métodos dinámicos
    
      // Muestra el número complejo de forma binómica
    public String showComplexBinomic() {
        String show = "";
        
        if (this.real != 0) { // Si el valor real no es cero
            show = show + this.real; // Salida : +-a
            if (this.imaginario != 0) { // Si el valor imaginario no es cero
                if (this.imaginario > 0) { // En caso de ser positivo
                    show = show + " + " + this.imaginario + "i"; // Salida : +-a + bi
                } else { // En caso de ser negativo
                    show = show + " - " + Math.abs(this.imaginario) + "i"; // Salida : +- a - bi
                }
            } else {
                // Si vale 0, no imprime nada
            }
        } else if (this.imaginario != 0) {
            show = show + this.imaginario + "i"; // +- bi
        } else {
            show = show + "0"; // 0
        }
        
        return show;
    }
    
      // Muestra el número complejo de forma polar
    public String showComplexPolar() {
        String show = "";
        
        show = show + this.modulo + " cis" + "(" + this.angulo + ") "; // Z : r cis(O)
        
        return show;
    }
    
      // Método para números complejos binómicos
    public ComplexCalculator addComplexBinomic(ComplexCalculator Z1, ComplexCalculator Z2) {
        this.real = Z1.real + Z2.real;
        this.imaginario = Z1.imaginario + Z2.imaginario;       
        return this;
    }
    
    public ComplexCalculator resComplexBinomic(ComplexCalculator Z1, ComplexCalculator Z2){
        this.real = Z1.real - Z2.real;
        this.imaginario = Z1.imaginario - Z2.imaginario; 
        return this;
    }
    
    public ComplexCalculator mulComplexBinomic(ComplexCalculator Z1, ComplexCalculator Z2) {
        this.real = (Z1.real * Z2.real) - (Z1.imaginario * Z2.imaginario);
        this.imaginario = (Z1.real * Z2.imaginario) + (Z1.imaginario * Z2.real);
        return this;
    }
    
    public ComplexCalculator divComplexBinomic(ComplexCalculator Z1, ComplexCalculator Z2) {
        ComplexCalculator opuesto = new ComplexCalculator();
        ComplexCalculator numerador = new ComplexCalculator();
        
        opuesto.real = Z2.real;
        opuesto.imaginario = - Z2.imaginario;
        
        double denominador;
        
        numerador.mulComplexBinomic(Z1, opuesto);
        
        denominador = Math.pow(Z2.real, 2) + Math.pow(Z2.imaginario, 2);  // c² + d²
        
        
        this.real = numerador.real / denominador;
        this.imaginario = numerador.imaginario / denominador;
        return this;
    }
    
    public ComplexCalculator toPolar() {
        this.modulo = Math.sqrt( Math.pow(this.real, 2) + Math.pow(this.imaginario, 2) ); // (a² + b²) ¹/²
        this.modulo = Math.round(this.modulo * 100.0) / 100.0; // Redonde a dos decimales
        
        this.angulo = Math.atan(this.imaginario / this.real);
        this.angulo = Math.round(Math.toDegrees(this.angulo) * 100.0) / 100.0; // Redondea a 2 decimales
        return this;
    }
    
      // Método para los complejos polares
    public ComplexCalculator mulComplexPolar(ComplexCalculator Z1, ComplexCalculator Z2) {
        this.modulo = Z1.modulo * Z2.modulo;
        this.angulo = Z1.angulo + Z2.angulo;
        return this;
    }
    
    public ComplexCalculator divComplexPolar(ComplexCalculator Z1, ComplexCalculator Z2) {
        this.modulo = Math.round( (Z1.modulo / Z2.modulo) * 100.0 ) / 100.0; // Aproximación de dos dígitos
        this.angulo = Z1.angulo - Z2.angulo;
        return this;
    }
    
    public ComplexCalculator powComplexPolar(ComplexCalculator Z1, int exp) {
        this.modulo = Math.pow(Z1.modulo, exp);
        this.angulo = Z1.angulo * exp;
        return this;
    }
    
    public ComplexCalculator toBinomic() {
        double anguloRadian = this.angulo;
        anguloRadian = Math.toRadians(anguloRadian);
        
        this.real = this.modulo * Math.cos(anguloRadian); // a = r cos O
        this.real = Math.round(this.real * 100.0) / 100.0;
        this.imaginario = this.modulo * Math.sin(anguloRadian); // b = r sin O 
        this.imaginario = Math.round(this.imaginario * 100.0) / 100.0;
        return this;
    }
}
