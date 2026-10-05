import java.util.Scanner;

// 1. CLASE EMPLEADO
class Empleado {
    String nombre;
    int id;

    Empleado(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }
}

// 2. CLASE DEPARTAMENTO (reutilizable para cualquier departamento)
class Departamento {
    String nombre;
    String ubicacion;
    Empleado[] listaEmpleados = new Empleado[5];
    int contador = 0;

    Departamento(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    void agregarEmpleado(Empleado emp) {
        if (contador < 5) {
            listaEmpleados[contador] = emp;
            contador++;
        } else {
            System.out.println("Plantilla llena (Máximo 5)");
        }
    }
}

// 3. CLASE PRINCIPAL
public class caso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creamos los dos departamentos usando la misma clase
        Departamento depto1 = new Departamento("Sistemas", "Matriz");
        Departamento depto2 = new Departamento("Ventas", "Sucursal");

        // Agregamos empleados al departamento 1
        depto1.agregarEmpleado(new Empleado("Carlos Lopez", 10001));
        depto1.agregarEmpleado(new Empleado("Ana Martinez", 10002));
        depto1.agregarEmpleado(new Empleado("Luis Perez", 10003));
        depto1.agregarEmpleado(new Empleado("Maria Gomez", 10004));
        depto1.agregarEmpleado(new Empleado("Jorge Ramirez", 10005));

        // Agregamos empleados al departamento 2
        depto2.agregarEmpleado(new Empleado("Pedro Sanchez", 20001));
        depto2.agregarEmpleado(new Empleado("Lucia Torres", 20002));
        depto2.agregarEmpleado(new Empleado("Diego Fernandez", 20003));
        depto2.agregarEmpleado(new Empleado("Sofia Morales", 20004));
        depto2.agregarEmpleado(new Empleado("Andres Rojas", 20005));

        // --- INICIO DE LA BÚSQUEDA ---
        System.out.println("=== BÚSQUEDA DE RECURSOS HUMANOS ===");
        
        System.out.print("Ingrese el departamento a consultar: ");
        String deptoBuscar = scanner.nextLine();

        // Variable para guardar el departamento seleccionado si existe
        Departamento deptoSeleccionado = null;

        // Evaluación de condicionales con llaves cerradas correctamente
        if (deptoBuscar.equalsIgnoreCase(depto1.nombre)) {
            deptoSeleccionado = depto1;
        } else if (deptoBuscar.equalsIgnoreCase(depto2.nombre)) {
            deptoSeleccionado = depto2;
        }

        // Si se encontró el departamento, procedemos a buscar al empleado
        if (deptoSeleccionado != null) {
            System.out.println("-> Departamento encontrado en: " + deptoSeleccionado.ubicacion);

            System.out.print("Ingrese el ID del empleado (5 dígitos): ");
            int idBuscar = scanner.nextInt();

            boolean encontrado = false;

            for (int i = 0; i < deptoSeleccionado.contador; i++) {
                if (deptoSeleccionado.listaEmpleados[i].id == idBuscar) {
                    System.out.println("\n--- EMPLEADO ENCONTRADO ---");
                    System.out.println("Nombre: " + deptoSeleccionado.listaEmpleados[i].nombre);
                    System.out.println("ID: " + deptoSeleccionado.listaEmpleados[i].id);
                    System.out.println("Ubicación: " + deptoSeleccionado.ubicacion);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("El ID " + idBuscar + " no existe en este departamento.");
            }
        } else {
            System.out.println("El departamento no existe.");
        }

        scanner.close();
    }
}