package dev.dbstkdwls.mission3.service;

import dev.dbstkdwls.mission3.dao.UserDao;
import dev.dbstkdwls.mission3.dto.UserDto;
import dev.dbstkdwls.mission3.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    private static Logger logger = LoggerFactory.getLogger(PostService.class);
    private UserDao userDao;

    public UserService(@Autowired UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUser(UserDto userDto){
        this.userDao.createUser(userDto);
    }

    public UserDto readUser(Long id){
        UserEntity userEntity = this.userDao.readUser(id);
        UserDto userDto = new UserDto(
                userEntity.getId(),
                userEntity.getName()
        );
        return userDto;
    }

    public List<UserDto> readUserAll(){
        Iterator<UserEntity> iterator = this.userDao.readUserAll();
        List<UserDto> userDtoList = new ArrayList<>();
        while (iterator.hasNext()) {
            UserEntity userEntity = iterator.next();
            userDtoList.add(new UserDto(
                    userEntity.getId(),
                    userEntity.getName()
            ));
        }
        return userDtoList;
    }

    public void updateUser(Long id, UserDto userDto){
        this.userDao.updateUser(id,userDto);
    }

    public void deleteUser(Long id){
        this.userDao.deleteUser(id);
    }
}
