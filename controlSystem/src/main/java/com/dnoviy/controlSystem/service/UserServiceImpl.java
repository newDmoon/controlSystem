package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.Person;
import com.dnoviy.controlSystem.entity.User;
import com.dnoviy.controlSystem.repository.PersonRepository;
import com.dnoviy.controlSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    public UserServiceImpl(UserRepository userRepository, PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    @Override
    public List<User> getAllUsers() {
        CurrentUserInfoService currentUserInfoService = new CurrentUserInfoService();
        List<User> users = userRepository.findAll();
        users.remove(userRepository.findByUsername(currentUserInfoService.getCurrentUsername()).get());
        return users;
    }

    @Override
    public User deleteUser(Long id) {
        User userToDelete = userRepository.findById(id).get();
        userRepository.delete(userToDelete);
        return userToDelete;
    }

    @Override
    public User getOneUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updatePersonInfo(User userToUpdate) {
        CurrentUserInfoService currentUserInfoService = new CurrentUserInfoService();
        User user = userRepository.findByUsername(
                currentUserInfoService.getCurrentUsername())
                .get();
        if (user.getPerson() == null) {
            user.setPerson(new Person());
        }
        user.getPerson().setAge(userToUpdate.getPerson().getAge());
        user.getPerson().setPhoneNumber(userToUpdate.getPerson().getPhoneNumber());
        user.getPerson().setSecondName(userToUpdate.getPerson().getSecondName());
        user.getPerson().setFirstName(userToUpdate.getPerson().getFirstName());
        userRepository.save(user);
        return user;
    }

    @Override
    public Person getPersonDetails(Long id) {
        return userRepository.findById(id).get().getPerson();
    }
}
