import javax.swing.JOptionPane;

public class Main {
    // Variables compartidas por las opciones del menu.
    static Ciudad[] ciudad = new Ciudad[25];
    static int lugares = 0;
    static boolean ciudadEncendida = false;
    static boolean dispositivosEncendidos = true;
    static Generador generadorActivo = null;
    static int energiaDisponible = 0;
    static Regulador regulador = new Regulador();

    // Polimorfismo: las tres clases hijas se guardan como Generador.
    static Generador[] generadores = {
        new Solar(), new Eolico(), new Hidroelectrico()
    };

    public static void main(String[] args) {
        int opcion = 0;
        do {
            String texto = "SISTEMA DE GENERADORES ELECTRICOS\n\n"
                    + "1. Prender ciudad\n"
                    + "2. Ver fallas de la ciudad\n"
                    + "3. Apagar dispositivos\n"
                    + "4. Salir\n\n"
                    + "Selecciona una opcion:";
            String entrada = JOptionPane.showInputDialog(null, texto,
                    "MENU PRINCIPAL", JOptionPane.QUESTION_MESSAGE);
            if (entrada == null) {
                opcion = 4;
                break;
            }
            try {
                opcion = Integer.parseInt(entrada);
                switch (opcion) {
                    case 1:
                        if (lugares == 0) {
                            formarCiudad();
                        }
                        if (lugares > 0) {
                            prenderCiudad();
                        }
                        break;
                    case 2:
                        verFallas();
                        break;
                    case 3:
                        apagarDispositivos();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,
                                "Gracias por utilizar el sistema.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no valida.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Debes escribir un numero entero.");
            }
        } while (opcion != 4);
    }

    // Formar ciudad usando los archivos que ya hiciMOS.
    public static void formarCiudad() {
        int opcion = 0;
        do {
            String texto = "FORMAR CIUDAD (" + lugares + "/25)\n\n"
                    + "1. Vivienda (consume 10 unidades)\n"
                    + "2. Establecimiento (consume 20 unidades)\n"
                    + "3. Corporativo (consume 30 unidades)\n"
                    + "4. Terminar\n\n"
                    + "Selecciona el tipo de lugar:";
            String entrada = JOptionPane.showInputDialog(null, texto);
            if (entrada == null) {
                break;
            }
            try {
                opcion = Integer.parseInt(entrada);
                if (lugares == ciudad.length && opcion != 4) {
                    JOptionPane.showMessageDialog(null,
                            "La ciudad ya tiene 25 lugares. No puedes agregar mas.");
                    break;
                }
                switch (opcion) {
                    case 1:
                        ciudad[lugares] = new Vivienda(10);
                        ciudad[lugares].definirClima();
                        lugares++;
                        break;
                    case 2:
                        ciudad[lugares] = new Establecimiento(20);
                        ciudad[lugares].definirClima();
                        lugares++;
                        break;
                    case 3:
                        ciudad[lugares] = new Corporativo(30);
                        ciudad[lugares].definirClima();
                        lugares++;
                        break;
                    case 4:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no valida.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Debes escribir un numero del 1 al 4.");
            }
        } while (opcion != 4 && lugares < ciudad.length);
    }

    // FOR-EACH: revisar cada lugar para sumar su consumo.
    public static int calcularConsumo() {
        int consumo = 0;
        for (Ciudad lugar : ciudad) {
            if (lugar != null) {
                consumo += lugar.getMedidor();
            }
        }
        if (!dispositivosEncendidos) {
            consumo = consumo / 2; // Se apagan dispositivos no esenciales.
        }
        return consumo;
    }

    public static void prenderCiudad() {
        if (generadorActivo != null && generadorActivo.estaEncendido()) {
            JOptionPane.showMessageDialog(null,
                    "Ya hay un generador encendido. Revisa el estado en opcion 2.");
            return;
        }

        // FOR: construir las opciones usando un arreglo.
        String[] opciones = new String[generadores.length];
        for (int i = 0; i < generadores.length; i++) {
            opciones[i] = generadores[i].getNombre();
        }
        String seleccion = (String) JOptionPane.showInputDialog(null,
                "Selecciona el tipo de generador:", "GENERADORES",
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (seleccion == null) {
            return;
        }
        // FOR-EACH: seleccionar el objeto correspondiente.
        for (Generador generador : generadores) {
            if (generador.getNombre().equals(seleccion)) {
                generadorActivo = generador;
                break;
            }
        }
        String entrada = JOptionPane.showInputDialog(null,
                "Disponibilidad del recurso (0 a 100):\n"
                + "Solar = luz; Eolico = viento; Hidroelectrico = agua");
        if (entrada == null) {
            generadorActivo = null;
            return;
        }
        try {
            int recurso = Integer.parseInt(entrada);
            if (recurso < 0 || recurso > 100) {
                JOptionPane.showMessageDialog(null,
                        "El porcentaje debe estar entre 0 y 100.");
                generadorActivo = null;
                return;
            }
            generadorActivo.encender();
            energiaDisponible = generadorActivo.generarEnergia(recurso);
            actualizarEstado();
            JOptionPane.showMessageDialog(null,
                    generadorActivo.mostrarDatos(true) + "\n"
                    + regulador.revisar(energiaDisponible, calcularConsumo(), true));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: escribe un numero entero entre 0 y 100.");
            generadorActivo = null;
        }
    }

    public static void actualizarEstado() {
        ciudadEncendida = regulador.alcanza(energiaDisponible, calcularConsumo())
                && generadorActivo != null && generadorActivo.estaEncendido();
    }

    public static void verFallas() {
        if (generadorActivo == null) {
            JOptionPane.showMessageDialog(null,
                    "No hay generador seleccionado. Usa la opcion 1.");
        } else {
            actualizarEstado();
            String estado = ciudadEncendida ? "Encendida" : "Sin suministro suficiente";
            JOptionPane.showMessageDialog(null,
                    "ESTADO DE LA CIUDAD\n"
                    + "Lugares: " + lugares + "\n"
                    + "Ciudad: " + estado + "\n"
                    + "Dispositivos no esenciales: "
                    + (dispositivosEncendidos ? "Encendidos" : "Apagados") + "\n"
                    + regulador.revisar(energiaDisponible, calcularConsumo(), true));
        }
    }

    public static void apagarDispositivos() {
        if (generadorActivo == null) {
            JOptionPane.showMessageDialog(null,
                    "Primero agrega lugares y selecciona un generador (opcion 1).");
        } else if (!dispositivosEncendidos) {
            JOptionPane.showMessageDialog(null,
                    "Los dispositivos no esenciales ya estan apagados.");
        } else {
            dispositivosEncendidos = false;
            actualizarEstado();
            JOptionPane.showMessageDialog(null,
                    "Se apagaron dispositivos no esenciales.\n"
                    + regulador.revisar(energiaDisponible, calcularConsumo(), true));
        }
    }
}
