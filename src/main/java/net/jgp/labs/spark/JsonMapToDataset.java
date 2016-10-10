package net.jgp.labs.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * A basic example of JSON map handling.
 * 
 * Note: the map is valid, but Spark does not like it
 * @author jgp
 */
public class JsonMapToDataset {

	public static void main(String[] args) {
		System.out.println("Working directory = " + System.getProperty("user.dir"));
		JsonMapToDataset app = new JsonMapToDataset();
		app.start();
	}

	private void start() {
		SparkSession spark = SparkSession.builder().appName("JSON map to Dataset").master("local").getOrCreate();

		String filename = "data/map.json";
		long start = System.currentTimeMillis();
		Dataset<Row> df = spark.read().json(filename);
		long stop = System.currentTimeMillis();
		System.out.println("Processing took " + (stop - start) + " ms");
		df.show();
		df.printSchema();
	}
}
