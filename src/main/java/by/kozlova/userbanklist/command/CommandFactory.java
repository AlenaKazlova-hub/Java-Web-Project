package by.kozlova.userbanklist.command;

//todo singleton??
public class CommandFactory {
	public static Command defineCommand(String jspCommand) throws CommandException {

		Command currentCommand = null;

		try {
			CommandType currentCommandEnum = CommandType.valueOf(jspCommand.toUpperCase());
			currentCommand = currentCommandEnum.getCommand();
		} catch (IllegalArgumentException e) {
			throw new CommandException(e);
		}
		return currentCommand;

	}
}
