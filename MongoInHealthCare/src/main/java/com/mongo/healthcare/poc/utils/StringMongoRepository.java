package com.mongo.healthcare.poc.utils;

import java.io.Serializable;
import java.util.List;

/**
 * StringMongoRepository is to save generic String to Mongo. Use this when a
 * generic string (json) is to be saved without convert it to a domain object
 * first
 * 
 * @author Ravi Reddy [{@link MailTo ravireddy76@gmail.com}]
 * @Date-Time 10:23:45 October 18, 2013 CST
 * @CopyRight (C) All rights reserved to Ravi Reddy POC World Inc. It's Illegal
 *            to reproduce this code.
 */
public interface StringMongoRepository {

	
	/**
	 * Saves the string entity to the collection passed
	 * 
	 * @param entity
	 *            The string (json) to be saved
	 * @param collectionName
	 *            The collection to be saved to
	 * @return The entity saved returned back
	 */
	public String save(String entity, String collectionName) throws Exception;

	
	/**
	 * Find all docs from the collection
	 * 
	 * @param collectionName
	 *            The collection to be retrieved
	 * @return List of all docs
	 */
	public List<String> findAll(String collectionName);

	
	/**
	 * Find one doc from the collection
	 * 
	 * @param id
	 *            The id of the collection
	 * @param collectionName
	 *            The collection to be retrieved
	 * @return The doc matching the id
	 */
	public String findOne(Serializable id, String collectionName);

	
	/**
	 * Delete the entity
	 * 
	 * @param entity
	 *            The entity to be deleted
	 * @param collectionName
	 *            The collection from which the doc is to be deleted
	 */
	public void delete(String entity, String collectionName);

	
	/**
	 * Searches the collection for a name value pair match. and returns the set
	 * of fields specified
	 * 
	 * @param name
	 * @param value
	 * @param fields
	 *            - a set of strings containing fully qualified field names
	 * @param collectionName
	 * @return
	 */
	public String findByNameValue(String name, Serializable value,
			String[] fields, String collectionName);

	
	/**
	 * Searches the collection for a name value pair match. and returns the set
	 * of fields specified
	 * 
	 * @param name
	 * @param value
	 * @param fields
	 *            - a comma separated list of fully qualified field names
	 * @param collectionName
	 * @return
	 */
	public String findByNameValue(String name, Serializable value,
			String fields, String collectionName);

}
