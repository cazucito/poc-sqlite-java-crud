package com.cazucito.pocs.sqlitejava.m.data;

import java.util.List;
import java.util.Optional;

/**
 * Generic DAO
 * @author cazucito
 * @param <T> Entity type
 */
public interface CrudDAO<T> {
    /**
     * Create a row in the data source
     * @param entity Entity to persist in data source
     * @return Was the operation  success? 
     */
    public abstract boolean create(T entity);
    /**
     * Retrieve all entities
     * @return A <code>List</code> reference with entities references
     */
    public abstract List<T> retrieveAll(); 
    /**
     * Retrieve one entity matching with the <code>id</code> parameter
     * @param id Entity identifier 
     * @return A <code>List</code> reference with entities references
     */
    public abstract Optional<T> retrieveById(int id); 
    /**
     * Update a row in the data source
     * @param entity Entity to update in data source
     * @return Was the operation success? 
     */
    public abstract boolean update(T entity);
    /**
     * Delete one entity matching with the <code>id</code> parameter
     * @param id Entity identifier 
     * @return Was the operation success?
     */
    public abstract boolean deleteById(int id); 
    /**
     * Delete one entity matching with the <code>id</code> parameter
     * @param entity Entity to persist in data source
     * @return Was the operation  success? 
     */
    public abstract boolean delete(T entity);

}
