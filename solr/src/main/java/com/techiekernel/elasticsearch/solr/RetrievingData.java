package com.techiekernel.elasticsearch.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

public class RetrievingData {
	public static void main(String args[]) throws SolrServerException, IOException  { 
	      //Preparing the Solr client 
	      String urlString = "http://localhost:8983/solr/solr_sample"; 
	      SolrClient Solr = new HttpSolrClient.Builder(urlString).build();  
	      
	      //Preparing Solr query 
	      SolrQuery query = new SolrQuery();  
	      query.setQuery("*:*");  
	   
	      //Adding the field to be retrieved 
	      query.addField("*");  
	   
	      //Executing the query 
	      QueryResponse queryResponse = Solr.query(query);  
	   
	      //Storing the results of the query 
	      SolrDocumentList docs = queryResponse.getResults();    
	      System.out.println(docs); 
	      System.out.println(docs.get(0)); 
	      System.out.println(docs.get(1)); 
	      System.out.println(docs.get(2));   
	         
	      //Saving the operations 
	      Solr.commit();         
	   } 
}
