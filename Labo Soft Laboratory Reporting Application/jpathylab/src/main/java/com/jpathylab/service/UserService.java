package com.jpathylab.service;
import com.jpathylab.exception.UserNotFoundException;
import com.jpathylab.model.User;
import com.jpathylab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }
    public void save(User user) {
        repo.save(user);
    }
    public User get(Integer uid) throws UserNotFoundException {
        Optional<User> result = repo.findById(uid);
        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Could not find any users with ID" + uid);
    }

    public void delete(Integer uid) throws UserNotFoundException {
        Long count = repo.countByUid(uid);
        if(count == null || count == 0){
            throw new UserNotFoundException("Could not find any users with ID" + uid);
        }
        repo.deleteById(uid);
    }
}