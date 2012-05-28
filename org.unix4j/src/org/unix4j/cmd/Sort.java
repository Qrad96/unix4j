package org.unix4j.cmd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.unix4j.AbstractCommand;
import org.unix4j.Output;

public class Sort extends AbstractCommand<Sort.Option> {
	
	public static final String NAME = "sort";
	
	public static enum Option {
		desc
	}
	
	public Sort() {
		super(NAME, false);
	}

	@Override
	protected void executeBatch() {
		final List<String> lines = new ArrayList<String>();
		while (getInput().hasMoreLines()) {
			lines.add(getInput().readLine());
		}
		Collections.sort(lines);
		final Output output = getOutput();
		if (isOptSet(Option.desc)) {
			for (int i = lines.size() - 1; i >= 0; i--) {
				output.writeLine(lines.get(i));
			}
		} else {
			for (final String line : lines) {
				output.writeLine(line);
			}
		}
	}
}
