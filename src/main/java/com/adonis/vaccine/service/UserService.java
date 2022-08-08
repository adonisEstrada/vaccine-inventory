package com.adonis.vaccine.service;


import com.adonis.vaccine.entity.Employee;
import com.adonis.vaccine.presentation.presenter.UserPresenter;

public interface UserService {

    UserPresenter loginUser(String userName, String password);

    UserPresenter saveUserByEmployee(Employee employee);

}
