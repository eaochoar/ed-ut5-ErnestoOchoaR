import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TiempoTranscurrido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita la fecha inicial al usuario
        System.out.println("Ingrese la fecha en formato YYYY-MM-DD HH:mm:ss (por ejemplo, 2023-11-14 15:30:00):");
        String fechaIngresada = scanner.nextLine();

        // Formatea la entrada del usuario
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            // Parsea la fecha ingresada
            LocalDateTime fechaInicial = LocalDateTime.parse(fechaIngresada, formatter);

            // Obtiene la fecha y hora actuales
            LocalDateTime fechaActual = LocalDateTime.now();

            // Calcula la diferencia entre las fechas
            Duration duracion = Duration.between(fechaInicial, fechaActual);

            // Extrae los días, horas y minutos
            long dias = duracion.toDays();
            long horas = duracion.toHours() % 24;
            long minutos = duracion.toMinutes() % 60;

            // Muestra el resultado
            System.out.println("Desde la fecha ingresada han transcurrido:");
            System.out.println(dias + " días, " + horas + " horas, " + minutos + " minutos.");
        } catch (Exception e) {
            System.out.println("Formato de fecha incorrecto. Por favor, inténtelo de nuevo.");
        }

        scanner.close();
    }
}
