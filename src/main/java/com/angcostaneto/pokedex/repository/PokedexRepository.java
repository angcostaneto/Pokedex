package com.angcostaneto.pokedex.repository;

import com.angcostaneto.pokedex.model.Pokemon;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Abstração que a classe deve implementar.
 */
public interface PokedexRepository extends ReactiveMongoRepository <Pokemon, String> {
}
