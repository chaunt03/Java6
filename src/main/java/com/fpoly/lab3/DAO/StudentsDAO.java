package com.fpoly.lab3.DAO;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fpoly.lab3.model.StudentMAP;
import com.fpoly.lab3.model.Students;

@Repository
public class StudentsDAO {
    RestTemplate rest = new RestTemplate();

    String url = "https://poly-java6-156b7-default-rtdb.firebaseio.com/students.json";

    private String getUrl(String key) {
        return url.replace(".json", "/" + key + ".json");
    }

    public StudentMAP findAll() {
        return rest.getForObject(url, StudentMAP.class);
    }

    public Students findByKey(String key) {
        return rest.getForObject(getUrl(key), Students.class);
    }
    
    public String create(Students data) {
    	HttpEntity<Students> entity = new HttpEntity<>(data);
    	JsonNode resp = rest.postForObject(url, entity, JsonNode.class);
    	return resp.get("name").asText();
    }
    
    public Students update(String key, Students data) {
    	HttpEntity<Students> entity = new HttpEntity<>(data);
    	rest.put(getUrl(key), entity);
    	return data;
    }
    
    public void delete(String key) {
    	rest.delete(key);
    }
}
