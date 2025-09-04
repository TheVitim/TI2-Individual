package com.crudcarro;

public class Carro {
    private int id;
    private String modelo;
    private String marca;
    private int ano;
    private String cor;
    private double preco;

    // Construtor vazio
    public Carro() {}

    // Construtor com parâmetros (sem id, para inserir)
    public Carro(String modelo, String marca, int ano, String cor, double preco) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
    }

    // Construtor com id (para listar/atualizar)
    public Carro(int id, String modelo, String marca, int ano, String cor, double preco) {
        this(modelo, marca, ano, cor, preco);
        this.id = id;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    @Override
    public String toString() {
        return "Carro [id=" + id + ", modelo=" + modelo + ", marca=" + marca +
               ", ano=" + ano + ", cor=" + cor + ", preco=" + preco + "]";
    }
}
