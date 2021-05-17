package br.com.zup.casadocodigo.casadocodigo.dto;

import br.com.zup.casadocodigo.casadocodigo.entidades.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaDto {
    @NotNull
    @NotBlank
    private String nome;

    public CategoriaDto(Categoria categoria){
        this.nome = categoria.getNome();
    }
    @Deprecated
    public CategoriaDto(){};

    public Categoria toCategoria(){
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
