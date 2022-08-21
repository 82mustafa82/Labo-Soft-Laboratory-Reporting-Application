package com.jpathylab.repository;
import com.jpathylab.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    public Long countByUid(Integer uid);
    public User findByUserName(String userName);
}