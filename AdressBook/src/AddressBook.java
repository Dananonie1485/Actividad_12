import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {

    public static HashMap<String,String> hContactos = new HashMap<String,String>();

    public static void main(String args[])throws Exception {

        load();
        meniu();
    }

    public static void load()throws Exception{
        //Lectura de archivo de texto y llenado de HashMap
        File listCntArch = new File("C:\\Dana\\Trabajos\\CJ\\Códigos\\AdressBook\\contactos.csv");
        Scanner Lector = new Scanner(listCntArch);
        while (Lector.hasNextLine()) {
            String infolinea = Lector.nextLine();
            String str[] = infolinea.split(",");

            for(int i=1;i<str.length;i++){
                hContactos.put(str[0],str[1]);
            }
        }
        Lector.close();
    }

    public static void list(){
        System.out.println("✿--Contactos: ");
        for (String i : hContactos.keySet()) {
            System.out.println("{"+ i +"} : {"+ hContactos.get(i) +"}");
        }
    }

    public static void create (String Telefono, String Nombre){
        hContactos.put(Telefono,Nombre);
    }

    public static void delete (String Telefono){
        hContactos.remove(Telefono);
    }

    public static void save()throws IOException{
        FileWriter escritor = null;
        PrintWriter pw = null;

        escritor = new FileWriter("C:\\Dana\\Trabajos\\CJ\\Códigos\\AdressBook\\contactos.csv");
        pw = new PrintWriter(escritor);
        pw.print("");

        for (String i : hContactos.keySet()) {
            escritor.write(i + ", "+ hContactos.get(i) + "\n");
        }
        escritor.close();
    }

    public static void meniu () throws IOException {
        //se crea opi objeto asi que necesitamos acceso al teclado mediante systems donde podemos leer "br" es para leer lineas completas
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner leer=new Scanner(System.in);
        System.out.println("\n✿__Actividad 12__✿");
        System.out.println("\n✿---✿---✿ AGENDA DE CONTACTOS ✿---✿---✿");
        System.out.println("\nPor favor seleccione una opción ");
        System.out.println(" ✿1 Mostrar los contactos");
        System.out.println(" ✿2 Registrar un nuevo contacto");
        System.out.println(" ✿3 Eliminar un contacto");
        System.out.println(" ✿4 Salvar :) ");
        int opcion = leer.nextInt();
        System.out.println("\n");

            switch (opcion) {
                case 1:

                    System.out.println("✿ Estos son tus contactos: ");
                    list();
                    System.out.println("\n");
                    meniu();

                    break;
                case 2:

                    System.out.println("✿--Ingrese el telefono de su contacto: ");
                    String Nombre = br.readLine();
                    System.out.println("✿--Ingrese el nombre de su contacto: ");
                    String Telefono = br.readLine();
                    create(Nombre,Telefono);
                    System.out.println("\n");
                    meniu();

                    break;
                case 3:

                    System.out.println("✿--Ingrese el númerp de su contacto a ELIMINAR: ");
                    String Eliminado = br.readLine();
                    delete(Eliminado);
                    System.out.println("\n");
                    meniu();

                    break;
                case 4:
                    save();
                    meniu();
                    break;
            }

    }//fin metodo menu

} //fin de la clase