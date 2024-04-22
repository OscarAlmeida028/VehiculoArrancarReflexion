import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear un array de nombres de las subclases de Vehiculo
        // Volador no se encuentra
        String[] nombresSubclases = new String[]{"Maritimo", "Terrestre", "Volador"};

        // Crear una lista para almacenar las instancias de los vehículos
        List<Vehiculo> vehiculos = new ArrayList<>();


        for (String nombre : nombresSubclases) {
            try {
                Class<?> vehiculoClass = Class.forName(nombre);
                Vehiculo vehiculo = (Vehiculo) vehiculoClass.newInstance();
                vehiculos.add(vehiculo);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Arrancar todos los vehículos
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.arrancar();
        }
    }
}