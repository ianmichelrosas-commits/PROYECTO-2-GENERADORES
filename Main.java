
import javax.swing.JOptionPane;

public class Main {

    // Variables que controlan el estado de la ciudad
    static boolean ciudadEncendida = false;
    static boolean dispositivosEncendidos = false;
    static String generadorActivo = "Ninguno";

    public static void main(String[] args) {

        int opcion = 0;

        do {
            String menu = """
                    SISTEMA DE GENERADORES ELECTRICOS

                    1. Prender ciudad
                    2. Ver fallas de la ciudad
                    3. Apagar dispositivos
                    4. Salir

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
                        prenderCiudad();
                        break;

                    case 2:
                        verFallas();
                        break;

                    case 3:
                        apagarDispositivos();
                        break;

                    case 4:
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

    // OPCION 3: APAGAR DISPOSITIVOS
    public static void apagarDispositivos() {

        if (!dispositivosEncendidos) {

            JOptionPane.showMessageDialog(
                    null,
                    "No hay dispositivos encendidos."
            );

        } else {

            dispositivosEncendidos = false;

            JOptionPane.showMessageDialog(
                    null,
                    "Los dispositivos fueron apagados."
                    + "\nEl generador sigue activo."
            );
        }
    }
}
