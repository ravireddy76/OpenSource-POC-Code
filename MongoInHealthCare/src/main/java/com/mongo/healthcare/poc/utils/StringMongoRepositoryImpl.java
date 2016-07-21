package com.mongo.healthcare.poc.utils;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.DocumentCallbackHandler;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoException;

public class StringMongoRepositoryImpl implements StringMongoRepository {

	private MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public String save(String entity, String collectionName) throws Exception {
		entity = verifyOrAddId(entity);
		mongoTemplate.save(entity, collectionName);
		return entity;
	}

	public List<String> findAll(String collectionName) {
		return mongoTemplate.findAll(String.class, collectionName);
	}

	public String findOne(Serializable id, String collectionName) {
		// Have to us this DocumentCallbackHandler as we using generic strings
		final String resultJson = "";
		final List<String> lst = new ArrayList<String>();
		mongoTemplate.executeQuery(query(where("_id").is(id)), collectionName,
				new DocumentCallbackHandler() {
					@Override
					public void processDocument(DBObject dbObject)
							throws MongoException, DataAccessException {
						lst.add(dbObject.toString());
						resultJson.concat(dbObject.toString());
					}
				});

		if (lst.size() > 0) {
			return lst.get(0);
		} else {
			return "";
		}
	}

	@Override
	public String findByNameValue(String name, Serializable value,
			String fields, String collectionName) {
		return findByNameValue(name, value, fields.split(","), collectionName);
	}

	@Override
	public String findByNameValue(String name, Serializable value,
			String[] fields, String collectionName) {

		// Have to use this DocumentCallbackHandler as generic strings are being
		// used
		final Query mongoQuery = query(where(name).is(value));

		for (String field : fields) {
			mongoQuery.fields().include(field);
		}

		final StringBuilder resultJson = new StringBuilder("[");

		mongoTemplate.executeQuery(mongoQuery, collectionName,
				new DocumentCallbackHandler() {
					@Override
					public void processDocument(DBObject dbObject)
							throws MongoException, DataAccessException {
						if (resultJson.length() > 1) {
							resultJson.append(",");
						}
						resultJson.append(dbObject.toString());
					}
				});

		resultJson.append("]");

		return resultJson.toString();

	}

	public void delete(String entity, final String collectionName) {
		/*
		 * Had to do this with, essentially going around mongotemplate as remove
		 * would not work without object and id
		 */
		DBCollection coll = mongoTemplate.getDb().getCollection(collectionName);
		BasicDBObject document = new BasicDBObject();
		document.put("_id", entity);
		coll.remove(document);

	}

	public long count(String collectionName) {
		return mongoTemplate.count(new Query(), collectionName);
	}

	
	/**
	 * Verifies if the json passed has an _id field and if not, adds it
	 * 
	 * @param entity
	 *            The json entity
	 */
	private String verifyOrAddId(String entity) throws Exception {
		ObjectMapper m = new ObjectMapper();
		try {
			JsonNode rootNode = m.readValue(entity, JsonNode.class);
			// check if _id was passed else add it
			if (rootNode.get("_id") == null) {
				((ObjectNode) rootNode)
						.put("_id", UUID.randomUUID().toString());
				entity = m.writeValueAsString(rootNode);
			}
			return entity;
		} catch (Exception ex) {
			throw ex;
		}
	}

}
