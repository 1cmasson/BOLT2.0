package com.bolt.backend.model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * The central interface in Spring Data repository abstraction is Repository.
 * It takes the the domain class to manage as well as the id type of the domain class as type arguments.
 * This interface acts primarily as a marker interface to capture the types to work with and to help you
 * to discover interfaces that extend this one. The Repository is the interface between the Model and the Controller
 */

@RepositoryRestResource // Annotate a Repository with this to customize export mapping and rels.
public interface BayRepository extends CrudRepository<Bay,Long> {
    // @CrudRepository is the interface for generic CRUD operations on a repository for a specific type.
}
