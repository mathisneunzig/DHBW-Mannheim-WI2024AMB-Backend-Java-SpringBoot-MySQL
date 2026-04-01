package de.mathisneunzig.demo.entities;

/**
 * Exam types for completion of courses.
 */
public enum ExamType {
	ASSIGNMENT("AS", "Assignment"),
	CONTINUOUS_ASSESSMENT("CA", "Continuous Assessment"),
	CASE_ANALYSIS("FA", "Case analysis"),
	WRITTEN_EXAM("K", "Written exam"),
	COMBINED_MODULE_EXAM("KM", "Combined module exam"),
	LAB_PRACTICAL("LP", "Lab practical"),
	ORAL_EXAM("MP", "Oral exam"),
	PORTFOLIO("PF", "Portfolio"),
	PRESENTATION("P", "Presentation"),
	PROJECT_WORK("PA", "Project work"),
	PROJECT_REPORT_WITHOUT_PRESENTATION("PB", "Project report without presentation"),
	PROJECT_REPORT_WITH_PRESENTATION("PBP", "Project report with presentation"),
	REPORT("R", "Report"),
	SEMINAR_PAPER_WITHOUT_PRESENTATION("SE", "Seminar paper without presentation"),
	SEMINAR_PAPER_WITH_PRESENTATION("SEP", "Seminar paper with presentation"),
	SIMULATION("SIM", "Simulation"),
	SOFTWARE_PROJECT("SP", "Software Project"),
	UNGRADED_ASSESSMENT("UL", "Ungraded assessment"),
	BACHELOR_THESIS("B", "Bachelor thesis");

	private final String code;
	private final String label;

	ExamType(String code, String label) {
		this.code = code;
		this.label = label;
	}

	public String getCode() {
		return code;
	}

	public String getLabel() {
		return label;
	}
}
