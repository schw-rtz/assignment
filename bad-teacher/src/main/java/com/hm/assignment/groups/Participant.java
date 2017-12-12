package com.hm.assignment.groups;

import org.apache.commons.csv.CSVRecord;

public class Participant {

	public static final String ROLE = "role";
	public static final String YEARS_OF_EXP = "years-of-exp";
	public static final String GENDER = "gender";
	public static final String NAME = "name";

	private String name;
	private Gender gender;
	private int yearsOfExp;
	private Role role;

	public Participant(CSVRecord record) {

		name = record.get(NAME);
		gender = Gender.valueOf(record.get(GENDER));
		yearsOfExp = Integer.parseInt(record.get(YEARS_OF_EXP));
		role = Role.valueOf(record.get(ROLE));

	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public int getYearsOfExp() {
		return yearsOfExp;
	}

	public Role getRole() {
		return role;
	}

}
