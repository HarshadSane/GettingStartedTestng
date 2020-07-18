package app;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.routines.EmailValidator;

public class ManageUser {

	private final List<String> userStorage;

	public ManageUser() {
		userStorage = new ArrayList<String>();
	}

	public boolean addUser(String email) throws DuplicateUserException {
		if (!EmailValidator.getInstance().isValid(email)) {
			throw new IllegalArgumentException("Not a valid email");
		}

		for (final String s : userStorage) {
			if (s.equals(email)) {
				throw new DuplicateUserException("User already exists");
			}
		}
		return userStorage.add(email);
	}

	public boolean deleteUser(String email) {
		return userStorage.removeIf(u -> u.equals(email));
	}

	public String getUser(String email) {
		for (final String s : userStorage) {
			if (s.equals(email)) {
				return s;
			}
		}
		return null;
	}

}
