/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Anuli
 */
public class ChamadoLivros {
    private int id;
    private String titulo,autor,genero,isbn,ano_publicacao,editora,num_paginas,idioma,lido,preco,data_do_cadastro,estoque_fisico;

    public String getEstoque_fisico() {
        return estoque_fisico;
    }

    public void setEstoque_fisico(String estoque_fisico) {
        this.estoque_fisico = estoque_fisico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(String ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getNum_paginas() {
        return num_paginas;
    }

    public void setNum_paginas(String num_paginas) {
        this.num_paginas = num_paginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getLido() {
        return lido;
    }

    public void setLido(String lido) {
        this.lido = lido;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getData_do_cadastro() {
        return data_do_cadastro;
    }

    public void setData_do_cadastro(String data_do_cadastro) {
        this.data_do_cadastro = data_do_cadastro;
    }
    
}
