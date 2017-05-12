package com.report;

import java.util.UUID;

import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.common.SolrInputDocument;

/**
 * Hello world!
 *
 */
public class SolrProducer 
{
	private final static String ZK_STRING =  "10.65.5.135:9181,10.65.5.137:9181,10.65.5.138:9181/Solr_non_prod";
	private static final String SOLR_FIELD_PREFIX = "i_";
	public void init(){

	}

	public static void main( String[] args ) {
		CloudSolrClient solr = new CloudSolrClient.Builder().withZkHost(ZK_STRING).build();
		solr.setDefaultCollection("gmp_payments.order");

		System.out.println( "Hello World!" );

		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", UUID.randomUUID());
		document.addField("i_fieldType", "Test");

		try {
			org.apache.solr.client.solrj.response.UpdateResponse response = solr.add(document);
			solr.commit();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally{
			try {
				solr.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
