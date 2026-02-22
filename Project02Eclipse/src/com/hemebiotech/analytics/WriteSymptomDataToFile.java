package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Writes symptom data to a file named result.out
 * 
 */

public class WriteSymptomDataToFile implements ISymptomWriter {
	private String outputFile;

	/**
	 * 
	 * @param outputFile the full or relative path of the file to write symptom data
	 *                   into
	 */
	public WriteSymptomDataToFile(String outputFile) {
		this.outputFile = outputFile;
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try (FileWriter writer = new FileWriter(outputFile)) {
			for (String symptom : symptoms.keySet()) {
				writer.write(symptom + ": " + symptoms.get(symptom) + "\n");
			}
		} catch (IOException e) {
			System.out.println("Error writing file");
		}
	}
}