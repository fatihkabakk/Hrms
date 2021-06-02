package klinz.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import klinz.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User getById(int id);
}
