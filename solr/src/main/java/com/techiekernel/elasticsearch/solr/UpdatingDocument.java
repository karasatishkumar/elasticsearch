package com.techiekernel.elasticsearch.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

public class UpdatingDocument {
	public static void main(String args[]) throws SolrServerException, IOException { 
	      //Preparing the Solr client 
	      String urlString = "http://localhost:8983/solr/solr_sample"; 
	      SolrClient Solr = new HttpSolrClient.Builder(urlString).build();   
	      
	      UpdateRequest updateRequest = new UpdateRequest();  
	      updateRequest.setAction( UpdateRequest.ACTION.COMMIT, false, false);    
	      SolrInputDocument myDocumentInstantlycommited = new SolrInputDocument();  
	      
	      myDocumentInstantlycommited.addField("id", "002"); 
	      myDocumentInstantlycommited.addField("name", "Rahman"); 
	      myDocumentInstantlycommited.addField("age","27"); 
	      myDocumentInstantlycommited.addField("addr","hyderabad"); 
	      
	      updateRequest.add( myDocumentInstantlycommited);  
	      UpdateResponse rsp = updateRequest.process(Solr); 
	      System.out.println("Documents Updated"); 
	   } 
}
