package com.amaris.amaris.services;

import com.amaris.amaris.models.RequestUserModel;
import com.amaris.amaris.models.RequestUsersModel;
import com.amaris.amaris.models.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private Environment environment;

    @Override
    public List<UserModel> getUsersFromUrl() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        ResponseEntity<RequestUsersModel> response = restTemplate.exchange(
                environment.getProperty("url"),
                HttpMethod.GET,
                null,
                RequestUsersModel.class
        );

        List<UserModel> users = response.getBody().getData();
        List<UserModel> usersWithAnualSalary = new ArrayList<>();

        for(UserModel user: users) {
            UserModel userWithAnualSalary = new UserModel(
                    user.getId(),
                    user.getEmployee_name(),
                    user.getEmployee_salary(),
                    user.getEmployee_age(),
                    user.getProfile_image()
            );
            usersWithAnualSalary.add(userWithAnualSalary);
        }
        return usersWithAnualSalary;
    }

    @Override
    public UserModel getUserFromUrl(int id) {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        ResponseEntity<RequestUserModel> response = restTemplate.exchange(
                environment.getProperty("url") + id,
                HttpMethod.GET,
                null,
                RequestUserModel.class
        );

        UserModel user = response.getBody().getData();

        return new UserModel(
                user.getId(),
                user.getEmployee_name(),
                user.getEmployee_salary(),
                user.getEmployee_age(),
                user.getProfile_image()
        );
    }
}
