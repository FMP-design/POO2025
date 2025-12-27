package controller;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

public class Carro extends ItemCollecao {
    private int ano;
    private String imagemPath;

    public Carro() {
        super();
        this.ano = 0;
        this.imagemPath = "";
    }

    public Carro(String nome, LocalDate dataAquis, double valorPago, double valorEst, int ano, String imagemPath) {
        super(nome, dataAquis, valorPago, valorEst);
        this.ano = ano;
        this.imagemPath = imagemPath;
    }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public String getImagem() { return imagemPath; }
    public void setImagem(String imagemPath) { this.imagemPath = imagemPath; }

    // Lê carros de um ficheiro TXT
    public static ArrayList<Carro> lerFicheiro(String nomeFicheiro) {
        ArrayList<Carro> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeFicheiro))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String nome = linha;
                int ano = Integer.parseInt(br.readLine());
                double valorPago = Double.parseDouble(br.readLine());
                double valorEst = Double.parseDouble(br.readLine());
                LocalDate data = LocalDate.parse(br.readLine());
                String imagem = br.readLine();
                br.readLine(); // linha vazia entre carros
                Carro c = new Carro(nome, data, valorPago, valorEst, ano, imagem);
                lista.add(c);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler ficheiro: " + e.getMessage());
        }
        return lista;
    }
}
