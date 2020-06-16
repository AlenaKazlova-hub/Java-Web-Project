package by.kozlova.userbanklist.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
	String execute(HttpServletRequest request) throws CommandException;
}
