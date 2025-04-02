package by.itclass.model.services;

import by.itclass.model.dao.UserDao;
import by.itclass.model.entities.User;

import java.util.List;

public class UserService implements Service{
    private UserDao dao;

    public UserService() {
        dao = new  UserDao();
    }


    public User getUser(String login, String password) {
        return dao.selectUser(login, password);
    }

    public boolean addUser(User user) {
        return dao.insertUser(user);
    }
    public int getUserId(String login) {
        return dao.selectIdByLogin(login);
    }

    public List<User> getAllUsers() {
        return dao.selectAllUsers();
    }
}
