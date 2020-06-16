package by.kozlova.userbanklist.command;

import by.kozlova.userbanklist.service.GetAccountSumService;
import by.kozlova.userbanklist.service.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class GetAccountSumCommand implements Command {

	private GetAccountSumService getAccountSumService;

	public GetAccountSumCommand(GetAccountSumService getAccountSumService) {
		this.getAccountSumService = getAccountSumService;
	}

	@Override
	public String execute(HttpServletRequest request) throws CommandException {

		try {
			int result = getAccountSumService.getAccountSum();
			request.setAttribute("sum", result);
			return CommandConstants.PATH_TO_ACCOUNTSSUM_JSP;

		} catch (ServiceException e) {
			return CommandConstants.PATH_TO_ERROR_JSP;
		}

	}

}
