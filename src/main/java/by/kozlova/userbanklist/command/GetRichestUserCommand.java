package by.kozlova.userbanklist.command;

import by.kozlova.userbanklist.bean.User;
import by.kozlova.userbanklist.service.GetRichestUserService;
import by.kozlova.userbanklist.service.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class GetRichestUserCommand implements Command {
	private GetRichestUserService getRichestUserService;

	public GetRichestUserCommand(GetRichestUserService getRichestUserService) {
		this.getRichestUserService = getRichestUserService;
	}

	@Override
	public String execute(HttpServletRequest request) throws CommandException {
		try {
			User richestUser = getRichestUserService.getRichestUser();
			request.setAttribute("name", richestUser.getName());
			request.setAttribute("surname", richestUser.getSurname());
			return CommandConstants.PATH_TO_RICHESTUSER_JSP;

		} catch (ServiceException e) {
			return CommandConstants.PATH_TO_ERROR_JSP;
		}
	}

}
