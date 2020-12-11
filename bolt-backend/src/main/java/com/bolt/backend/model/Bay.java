package com.bolt.backend.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 * The Bay class is a data model that is supposed to represent a bay within the Home Depot store. It contains the
 * properties to identify how much work it takes to service the bay. This is as well known as the domain object
 */

@Data //Generates all the boilerplate that is normally associated with simple POJOs (Plain Old Java Objects)
@Entity //Specifies that the class is an entity. This annotation is applied to the entity class.
public class Bay {
    private String bay; // the bay number
    private String traffic; // how much customer traffic occurs around the bay
    private int time; // time given to finish the bay
    private String lastServiced; // how long ago was the bay last serviced.
    private @Id @GeneratedValue Long id; // bay key identifier
    // Each entity bean will have a primary key, which you annotate on the class with the @Id annotation.
    // The @GeneratedValue consider the entry point for primary key generation, it provides
    // the specification of generation strategies for the values of primary keys.

    public Bay(){}

    // Bay constructor
    public Bay(String bay, String traffic, int time, String lastServiced){
        this.bay = bay;
        this.traffic = traffic;
        this.time = time;
        this.lastServiced = lastServiced;
    }

}
