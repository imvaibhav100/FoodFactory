
package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Component
public class UserServices {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUser() {
		List<User> users = (List<User>) this.userRepository.findAll();
		return users;
	}

	public User getUser(int id) {
		Optional<User> optional = this.userRepository.findById(id);
		User user = optional.get();
		return user;
	}

	public User getUserByEmail(String email) {
		User user = this.userRepository.findUserByUemail(email);
		return user;
	}

	public void updateUser(User user, int id) {
		user.setU_id(id);
		this.userRepository.save(user);
	}

	public void deleteUser(int id) {
		this.userRepository.deleteById(id);
	}

	public void addUser(User user) {
		this.userRepository.save(user);
	}

	public boolean validateLoginCredentials(String email, String password) {
		List<User> users = (List<User>) this.userRepository.findAll();
		String inputEmail = email != null ? email.trim().toLowerCase() : "";
		String inputPassword = password != null ? password.trim() : "";
		// System.out.println("Input: " + inputEmail + ", " + inputPassword); // removed for security
		for (User u : users) {
			String dbEmail = u.getUemail() != null ? u.getUemail().trim().toLowerCase() : "";
			String dbPassword = u.getUpassword() != null ? u.getUpassword().trim() : "";
			// System.out.println("DB: " + dbEmail + ", " + dbPassword); // removed for security
			if (u != null && dbPassword.equals(inputPassword) && dbEmail.equals(inputEmail)) {
				System.out.println("Login matched for: " + inputEmail); // This is fine
				return true;
			}
		}
		// System.out.println("No match found for: " + inputEmail + ", " + inputPassword); // removed for security
		return false;
	}

}
