package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String args[]) throws Exception {
		Map<String, Integer> symptomCounts = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"))) {
			String line = reader.readLine();

			while (line != null) {
				System.out.println("symptom from file: " + line);
				if (line.equals("headache")) {
					headacheCount++;
					System.out.println("number of headaches: " + headacheCount);
				} else if (line.equals("rash")) {
					rashCount++;
				} else if (line.contains("pupils")) {
					pupilCount++;
				}

				line = reader.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error reading file");

		}

		// Writes symptom data
		symptomCounts.put("headache", headacheCount);
		symptomCounts.put("rash", rashCount);
		symptomCounts.put("dialated pupils", pupilCount);

		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		writer.writeSymptoms(symptomCounts);

	}
}