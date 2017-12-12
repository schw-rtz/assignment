package com.hm.assignment.groups;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;

public class Main {

	/**
	 * 
	 * @param args[0] size of groups
	 * @param args[1] file path to participants.
     *
	 * @throws FileNotFoundException when file was not found
	 * @throws IOException when io-operation fails.
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		CSVFormat format = CSVFormat.DEFAULT.withHeader( //
				Participant.NAME, //
				Participant.GENDER, //
				Participant.YEARS_OF_EXP, //
				Participant.ROLE);

		Collection<Participant> participants;
		try (CSVParser participantParser = CSVParser.parse(new FileReader(args[1]), format)) {
			participants = participantParser.getRecords().stream() //
					.filter(t -> t.getRecordNumber() != 1) // do not include header
					.map(record -> new Participant(record)) //
					.collect(Collectors.toList()); //
		}

		int sizeOfGroup = Integer.parseInt(args[0]);
		Map<String, Integer> groups = Group.distribute(sizeOfGroup, participants);

		try (CSVPrinter printer = new CSVPrinter(System.out, CSVFormat.DEFAULT.withHeader("group", "name"))) {
			groups.forEach((name, group) -> safePrintRecord(printer, name, group));
		}
	}

	private static void safePrintRecord(CSVPrinter printer, String name, Integer group) {
		try {
			printer.printRecord(Integer.toString(group), name);
		} catch (IOException e) {
			throw new RuntimeException("could not write file");
		}
	}

}
