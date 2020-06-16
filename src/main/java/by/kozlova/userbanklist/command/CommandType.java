package by.kozlova.userbanklist.command;

import by.kozlova.userbanklist.service.GetAccountSumService;
import by.kozlova.userbanklist.service.GetRichestUserService;

public enum CommandType {
	GET_RICHEST_USER(new GetRichestUserCommand(new GetRichestUserService())),
	GET_ACCOUNTS_SUM(new GetAccountSumCommand(new GetAccountSumService()));

	private Command command;

	private CommandType(Command command) {
		this.command = command;
	}

	public Command getCommand() {
		return command;
	}

}
