package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface for writing symptom data to a destination file
 */

public interface ISymptomWriter {

	/**
	 * Writes the symptom counts to a destination.
	 *
	 * @param symptoms map of symptom name to occurrence count
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);

}
