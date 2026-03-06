package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * AnalyticsCounter is responsible for counting and sorting symptoms. It uses an
 * ISymptomReader to read symptoms and an ISymptomWriter to write the results.
 */
public class AnalyticsCounter {
	ISymptomReader symptomReader;
	ISymptomWriter symptomWriter;
	Map<String, Integer> symptomCounts = new HashMap<>();

	/**
	 * Constructs an AnalyticsCounter with a given reader and writer.
	 *
	 * @param symptomReader reader used to obtain symptoms
	 * @param symptomWriter writer used to output symptom counts
	 */
	public AnalyticsCounter(ISymptomReader symptomReader, ISymptomWriter symptomWriter) {
		this.symptomReader = symptomReader;
		this.symptomWriter = symptomWriter;
	}

	/**
	 * Reads symptoms from the reader.
	 *
	 * @return list of symptoms
	 */
	public List<String> getSymptoms() {
		return symptomReader.getSymptoms();
	}

	/**
	 * Counts occurrences of each symptom in a list.
	 *
	 * @param symptoms list of symptoms to count
	 * @return map of symptom name to its occurrence count
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		for (String oneSymptom : symptoms) {
			if (!symptomCounts.containsKey(oneSymptom)) {
				symptomCounts.put(oneSymptom, 1);
			} else {
				symptomCounts.put(oneSymptom, symptomCounts.get(oneSymptom) + 1);
			}
		}
		return symptomCounts;

	}

	/**
	 * Sorts the symptom counts alphabetically by symptom name.
	 *
	 * @param symptoms map of symptom counts
	 * @return new sorted map
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	/**
	 * Writes symptom counts to the writer.
	 *
	 * @param symptoms map of symptom counts to write
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}

}