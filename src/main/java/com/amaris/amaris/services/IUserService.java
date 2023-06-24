package com.amaris.amaris.services;

import com.amaris.amaris.models.UserModel;

import java.util.List;

public interface IUserService {
    List<UserModel> getUsersFromUrl();

    UserModel getUserFromUrl(int id);
}
