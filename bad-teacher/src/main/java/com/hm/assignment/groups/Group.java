package com.hm.assignment.groups;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Preconditions;

public class Group {

	/**
	 * distribute
	 * 
	 * will distribute the given participants into groups of the given size. If
	 * there are 7 participants and the group size is 2 then there will be 3 groups
	 * of sizes 2, 2 and 3. 
	 * 
	 * @param sizeOfGroup 
	 * @param participants
	 * @return
	 */
	public static Map<String, Integer> distribute(int sizeOfGroup, Collection<Participant> participants) {
		Preconditions.checkArgument(sizeOfGroup >= 0, "Size of group needs to be positive.");
		Preconditions.checkArgument(!participants.isEmpty(), "list of participants may not be empty.");

		HashMap<String, Integer> result = new HashMap<>();

		// Well, this is not supposed to be hard coded. Please help me with this method.
		result.put("Alice", 1);
		result.put("Bob", 2);
		result.put("Charlie", 1);
		result.put("Donald", 2);
		result.put("Eric", 1);
		result.put("Fiona", 2);
		result.put("Georg", 1);
		result.put("Harriet", 2);

		return result;
	}

}
