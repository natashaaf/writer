import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        welcome();
        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println("Nombre del archivo:");
                String fileName = sc.next();
                System.out.println("Texto del archivo:");
                String message = sc.next();
                writeFile(fileName, message);
                break;
            case 2:
                System.out.println("Nombre del texto que desea leer:");
                String fileName2 = sc.next();
                readFile(fileName2);
                break;
            case 3:
                System.out.println("Nombre del texto que desea borrar:");
                String fileName3 = sc.next();
                readFile(fileName3);
                break;

        }
    }

    public static void welcome() {
        System.out.println();
        System.out.println("############ Writer ############");
        System.out.println("################################");
        System.out.println("1 . Escribir en un archivo");
        System.out.println("2 . Leer un archivo");
        System.out.println("3 . Borrar un archivo");
        System.out.println("4 . Listar ficheros de un directorio");
        System.out.println("5 . Establecer directorio de trabajo");
        System.out.println("0 . Salir");
        System.out.println("################################");
    }

    public static void writeFile(String fileName, String message) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(message);
            System.out.println("Archivo" + fileName + " escrito correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir" + e.getMessage());
        }
    }

    public static void readFile(String fileName) throws IOException {
        try (FileReader reader = new FileReader(fileName)) {
            System.out.println(Files.readString(Path.of(fileName)));
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
        }
    }

    public static String deleteFile(String fileName) throws IOException {
        File file = new File(fileName);

        if (file.delete()) {
            System.out.println("Archivo eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el archivo.");
        }

        return fileName;
    }

}