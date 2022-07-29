package app;

import java.io.*;
import java.net.URI;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {

//        FORMAS DE CREAR UN ARCHIVO
//        File file = new File("PATH");
//        File file = new File("STRING PATH", "STRING NAME");
//        File file = new File("FILE DIR", "FILE NAME");

        String path = "D:\\Intellij projects\\Archivos\\myFile.txt";
//        String path = "D:\\Intellij projects\\Archivos";

        File myFile = new File(path);

        try{
            if (!myFile.exists()){
                System.out.println("MI ARCHIVO NO EXISTE Y PROCEDO A CREAR UNO");
                myFile.createNewFile();
                System.out.println("ARCHIVO CON EL NOMBRE : " + myFile.getName() + " CREADO CON EXITO ");
            }
            if (myFile.isDirectory()){
                File[] files = myFile.listFiles();
                for (File archivos: files) {
                    System.out.println(archivos.getName());
                }
            }else {
                System.out.println("EL NOMBRE ES : " + myFile.getName());
                System.out.println("EL PATH ES : " + myFile.getPath());
                System.out.println("EL PATH ABSOLUTO ES : " + myFile.getAbsolutePath());
                System.out.println("SE PUEDE LEER " + myFile.canRead());
                System.out.println("SE PUEDE ESCRIBIR " + myFile.canWrite());
                System.out.println("CUANTO PESA " + myFile.length());
                System.out.println("SI SE PUEDE EJECUTAR : " + myFile.canExecute());

                Date lastUpdate = new Date(myFile.lastModified());
                System.out.println("Ultima modificacion : " + lastUpdate.toString());
            }




            Persona persona = new Persona("lautaro","roldan",21);
            Persona persona2 = new Persona("asdasd","sssss",22);




            FileWriter fWriter = new FileWriter(myFile);
            BufferedWriter bWiter = new BufferedWriter(fWriter);

            if (!myFile.canWrite()){
                myFile.setWritable(true);
            }

            System.out.println("ESCRIBIENDO ARCHIVO ...");
            bWiter.write("Estoy escribiendo");
            bWiter.newLine();
            bWiter.write(":)");

            System.out.println("CERRANDO BUFFER DE ESCRITURA ...");
            bWiter.close();

            FileReader fReader = new FileReader(myFile);
            BufferedReader bReader = new BufferedReader(fReader);

            if (!myFile.canRead()){
                myFile.setReadable(true);
            }

            System.out.println("LEYENDO ARCHIVO ...");
            String line = null;
            line = bReader.readLine();
            while (line != null){
            System.out.println(line);
            line = bReader.readLine();
            }

            System.out.println("CERRANDO BUFFER DE LECTURA ...");
            bReader.close();

        }catch (IOException e){
            System.out.println("No se pudo leer/escribir el archivo : " + e.getMessage());
        }



//        File f = new File("mi_archivo.txt");
//        if (f.exists()) {
//            System.out.println("EL NOMBRE ES : " + f.getName());
//            System.out.println("EL PATH ES : " + f.getPath());
//            System.out.println("EL PATH ABSOLUTO ES : " + f.getAbsolutePath());
//            System.out.println("SE PUEDE LEER " + f.canRead());
//            System.out.println("SE PUEDE ESCRIBIR " + f.canWrite());
//            System.out.println("CUANTO PESA " + f.length());
//            System.out.println("SI SE PUEDE EJECUTAR : " + f.canExecute());
//        } else {
//            System.out.println("Fichero no existe");
//        }



//        File dir = new File("src/main/ejemplo");
//        if (dir.isDirectory()){
//            File[] ficheros = dir.listFiles();
//            for (File file : ficheros){
//                System.out.println("EL NOMBRE ES : " + file.getName());
//            }
//        }

//        PARA ESCRIBIR UN ARCHIVO

//        try {
//            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(new File("mi_archivos.txt")));
//            fileWriter.write("Hola");
//            fileWriter.write("Mundo!");
//            fileWriter.newLine();
//            fileWriter.write("Como estas?");
//            fileWriter.close();
//        }
//        catch (IOException e){
//            System.out.println("Se produjo un error al escribir en el archivo: " + e.getMessage());
//        }



//        PARA LEER UN ARCHIVO

//        if (!(new File("mi_archivos.txt")).exists()){
//            System.out.println("EL ARCHIVO NO EXISTE");
//        }
//        try{
//            BufferedReader fileReader = new BufferedReader(new FileReader(new File("mi_archivos.txt")));
//            String linea = null;
//            while ((linea = fileReader.readLine()) != null){
//                System.out.println(linea);
//            }
//            fileReader.close();
//        }
//        catch (IOException e){
//            System.out.println("Se produjo un error al leer el archivo: " + e.getMessage());
//        }

    }
}
