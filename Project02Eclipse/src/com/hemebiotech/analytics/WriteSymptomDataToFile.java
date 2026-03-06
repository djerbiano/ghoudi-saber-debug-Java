package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Writes symptom counts to a file.
 */

public class WriteSymptomDataToFile implements ISymptomWriter {
	private String outputFile;

	/**
	 * Constructs a writer for the specified output file.
	 *
	 * @param outputFile full or relative path of the output file
	 */
	public WriteSymptomDataToFile(String outputFile) {
		this.outputFile = outputFile;
	}

	/**
	 * Writes each symptom and its count to the output file in the format "symptom:
	 * count".
	 *
	 * @param symptoms map of symptom names to their occurrence counts
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try (FileWriter writer = new FileWriter(outputFile)) {
			for (String symptom : symptoms.keySet()) {
				writer.write(symptom + ": " + symptoms.get(symptom) + "\n");
			}
		} catch (IOException e) {
			System.err.println("Error writing to file: " + outputFile);
			e.printStackTrace();
		}
	}
}