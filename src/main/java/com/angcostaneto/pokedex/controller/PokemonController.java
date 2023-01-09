package com.angcostaneto.pokedex.controller;

import com.angcostaneto.pokedex.model.Pokemon;
import com.angcostaneto.pokedex.model.PokemonEvent;
import com.angcostaneto.pokedex.repository.PokedexRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Collections;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private final PokedexRepository repository;

    public PokemonController(PokedexRepository repository) {
        this.repository = repository;
    }

    /**
     * Metodo flux é um fluxo de chamados
     */
    @GetMapping
    public Flux<Pokemon> getAllPokemons() {
        return this.repository.findAll();
    }

    /**
     * Metodos mono é usado para retornar apenas um registro
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Pokemon>> getPokemon(@PathVariable String id) {
        return this.repository.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Pokemon> savePokemon(@RequestBody Pokemon pokemon) {
        return this.repository.save(pokemon);
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<Pokemon>> updatePokemon(@PathVariable(value="id") String id, @RequestBody Pokemon pokemon) {
        return this.repository.findById(id)
                .flatMap(existingPokemon -> {
                    existingPokemon.setNome(pokemon.getNome());
                    existingPokemon.setCategoria(pokemon.getCategoria());
                    existingPokemon.setHabilidade(pokemon.getHabilidade());
                    existingPokemon.setPeso(pokemon.getPeso());
                    return this.repository.save(existingPokemon);
                })
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<ResponseEntity<Void>> deletePokemon(@PathVariable(value="id") String id) {
        return this.repository.findById(id)
                .flatMap(existingPokemon -> {
                    return this.repository.delete(existingPokemon)
                            .then(
                                    Mono.just(ResponseEntity.ok().<Void>build()));
                })
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public Mono<Void> deleteAllPokemons() {
        return this.repository.deleteAll();
    }

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<PokemonEvent> getPokemonEvents() {
        return Flux.interval(Duration.ofSeconds(5))
                .map(val ->
                        new PokemonEvent(val, "Product Event")
                );
    }
}
