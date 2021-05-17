package br.com.zup.casadocodigo.casadocodigo.repositorios;


import br.com.zup.casadocodigo.casadocodigo.entidades.Livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {


}
