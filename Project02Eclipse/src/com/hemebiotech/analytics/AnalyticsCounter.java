package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	ISymptomReader symptomReader;
	ISymptomWriter symptomWriter;
	Map<String, Integer> symptomCounts = new HashMap<>();

	public AnalyticsCounter(ISymptomReader symptomReader, ISymptomWriter symptomWriter) {
		this.symptomReader = symptomReader;
		this.symptomWriter = symptomWriter;
	}

	public List<String> getSymptoms() {
		return symptomReader.GetSymptoms();
	}

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

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}

}