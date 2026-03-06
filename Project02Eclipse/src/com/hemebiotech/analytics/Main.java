package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Entry point of the symptom analytics application.
 * 
 * This class orchestrates the workflow: reading symptoms from a source,
 * counting their occurrences, sorting them alphabetically, and writing the
 * results to a file.
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Start symptom analysis...");
		ISymptomReader reader = new ReadSymptomDataFromFile("resources/symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("resources/result.out");

		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

		// Read symptoms
		List<String> symptomsList = counter.getSymptoms();
		System.out.println("Symptoms reading finished.");
		System.out.println("Total symptoms read: " + symptomsList.size());

		// Count symptoms
		Map<String, Integer> symptomsCounter = counter.countSymptoms(symptomsList);
		System.out.println("Symptoms counting finished.");
		System.out.println("Different symptoms: " + symptomsCounter.size());

		// Sort symptoms
		Map<String, Integer> symptomsSorted = counter.sortSymptoms(symptomsCounter);
		System.out.println("Symptoms sorting finished.");

		// write symptoms to file
		counter.writeSymptoms(symptomsSorted);
		System.out.println("Results written to file: resources/result.out");

		System.out.println("Analysis finished.");

	}

}
