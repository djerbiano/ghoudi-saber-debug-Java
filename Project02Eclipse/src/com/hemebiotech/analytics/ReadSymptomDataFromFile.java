package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads symptom data from a file.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * Constructs a reader for a file containing symptoms, one per line.
	 *
	 * @param filepath full or relative path to the input file
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Reads symptoms from the file.
	 *
	 * @return list of symptoms
	 */
	@Override
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<String>();

		if (filepath != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {

				String line;

				while ((line = reader.readLine()) != null) {
					result.add(line);
				}

			} catch (IOException e) {
				System.err.println("Error reading the file: " + filepath);
				e.printStackTrace();
			}
		}

		return result;
	}

}
