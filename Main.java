
import java.util.Scanner;

import javax.swing.JOptionPane;
public class Main {

    // Variables que controlan el estado de la ciudad
    static boolean ciudadEncendida = false;
    static boolean dispositivosEncendidos = false;
    static String generadorActivo = "Ninguno";
    static int medidor;
    static void main(String[] args) {
        int opcion = 0;
        do {
            String menu = """
                    SISTEMA DE GENERADORES ELECTRICOS

                    1. Prender ciudad
                    2. Ver fallas de la ciudad
                    3. Salir

                    Selecciona una opcion:
                    """;

            String entrada = JOptionPane.showInputDialog(
                    null,
                    menu,
                    "MENU PRINCIPAL",
                    JOptionPane.QUESTION_MESSAGE
            );

            // Si el usuario presiona Cancelar
            if (entrada == null) {
                opcion = 4;
                break;
            }
            try {
                opcion = Integer.parseInt(entrada);
                switch (opcion) {

                    case 1:
                        formarCiudad();
                        prenderCiudad();
                        break;

                    case 2:
                        verFallas();
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(
                                null,
                                "Gracias por utilizar el sistema."
                        );
                        break;

                    default:
                        JOptionPane.showMessageDialog(
                                null,
                                "Opcion no valida. Intenta nuevamente."
                        );
                        break;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Error: debes ingresar un numero del 1 al 4."
                );
            }

        } while (opcion != 4);
    }
    //Metodo propuesto para la craciòn de la ciudad
    public static  void formarCiudad(){
        Ciudad[] ciudad = new Ciudad[25];
        int lugares = 0;
        int opcion;
        do{
            String menu[]= {"""
          Formando Ciudad
          1. Vivienda
          2. Establecimiento
          3. Corporativo
          4. Salir
          Seleccione un lugar para agregar a la ciudad
          """};
            String seleccion =  JOptionPane.showInputDialog(
                    null,
                    menu,
                    "Menu Lugar",
                    JOptionPane.QUESTION_MESSAGE
            );
            opcion = Integer.parseInt(seleccion);
            switch (opcion) {
                case 1:
                    Ciudad vivienda = new Ciudad(medidor);
                    JOptionPane.showMessageDialog(
                                null,
                                "Se creo la Vivienda"
                        );
                    vivienda.definirClima();
                    ciudad[lugares] = vivienda;
                    lugares++;
                    break;
                case 2:
                    Ciudad establecimiento = new Ciudad(medidor);
                    JOptionPane.showMessageDialog(
                                null,
                                "Se creo el Establecimiento"
                        );
                    establecimiento.definirClima();
                    ciudad[lugares] = establecimiento;
                    lugares++;
                    break;

                case 3:
                    Ciudad corporativo = new Ciudad(medidor);
                    JOptionPane.showMessageDialog(
                                null,
                                "Se creo el Corporativo"
                        );
                    corporativo.definirClima();
                    ciudad[lugares] = corporativo;
                    lugares++;
                    break;

                case 4:
                    JOptionPane.showMessageDialog(
                                null,
                                "Saliendo"
                        );
                    break;
                default: JOptionPane.showMessageDialog(
                                null,
                                "ADVERTENCIA",
                                "Opción Invalida",
                                JOptionPane.ERROR_MESSAGE
                        );
                    break;
            }
        }while(opcion != 4);

    }



    // OPCION 1: PRENDER CIUDAD
    public static void prenderCiudad() {

        if (ciudadEncendida) {
            JOptionPane.showMessageDialog(
                    null,
                    "La ciudad ya tiene energia."
            );
            return;
        }

        String[] generadores = {
                "Eolico",
                "Solar",
                "Hidroelectrico"
        };

        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona el tipo de generador:",
                "GENERADORES",
                JOptionPane.QUESTION_MESSAGE,
                null,
                generadores,
                generadores[0]
        );

        if (seleccion != null) {

            generadorActivo = seleccion;
            ciudadEncendida = true;
            dispositivosEncendidos = true;

            JOptionPane.showMessageDialog(
                    null,
                    "Generador seleccionado: " + generadorActivo
                            + "\nLa ciudad ha sido encendida."
                            + "\nLos dispositivos estan funcionando."
            );
        }
    }

    // OPCION 2: VER FALLAS
    public static void verFallas() {

        if (!ciudadEncendida) {

            JOptionPane.showMessageDialog(
                    null,
                    "La ciudad no tiene suministro electrico."
                            + "\nNo hay un generador activo."
            );

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "ESTADO DEL SISTEMA"
                            + "\nGenerador: " + generadorActivo
                            + "\nCiudad: Encendida"
                            + "\nDispositivos: "
                            + (dispositivosEncendidos
                            ? "Encendidos" : "Apagados")
                            + "\n\nNo se han simulado fallas."
            );
        }
    }


}