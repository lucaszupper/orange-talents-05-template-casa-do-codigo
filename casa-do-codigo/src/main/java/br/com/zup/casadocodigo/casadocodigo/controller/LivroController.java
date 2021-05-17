package br.com.zup.casadocodigo.casadocodigo.controller;

import br.com.zup.casadocodigo.casadocodigo.dto.LivroDto;
import br.com.zup.casadocodigo.casadocodigo.entidades.Livro;
import br.com.zup.casadocodigo.casadocodigo.repositorios.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @PersistenceContext
    private EntityManager manager;
    private LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LivroDto> novoLivro(@RequestBody @Valid LivroDto livroDto, UriComponentsBuilder builder){

        Livro livro = livroRepository.save(livroDto.toLivro(manager));
        URI uri = builder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(new LivroDto(livro));


    }
}
