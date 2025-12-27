package controller;
import java.io.*;
import java.util.ArrayList;

public class FuncCarros {

    private static final String PATH = "C:\\Users\\fm\\eclipse-workspace\\Collex\\fnFiles";

    public static ArrayList<Carro> lerCarros() {
        ArrayList<Carro> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH))) {
            lista = (ArrayList<Carro>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado, criando novo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static void guardarCarros(ArrayList<Carro> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
