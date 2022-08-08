package com.adonis.vaccine.service.impl;

import com.adonis.vaccine.entity.Employee;
import com.adonis.vaccine.entity.Permission;
import com.adonis.vaccine.entity.Roles;
import com.adonis.vaccine.entity.User;
import com.adonis.vaccine.presentation.presenter.PermissionPresenter;
import com.adonis.vaccine.presentation.presenter.RolePresenter;
import com.adonis.vaccine.presentation.presenter.UserPresenter;
import com.adonis.vaccine.repository.UserRepository;
import com.adonis.vaccine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserPresenter loginUser(String username, String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        if (user.isPresent()) {
            return userToPresenter(user.get());

        }
        return null;
    }

    @Override
    public UserPresenter saveUserByEmployee(Employee employee) {
        return userToPresenter(userRepository.save(User.builder()
                .id(UUID.randomUUID())
                .employee(employee)
                .username(employee.getFirstName().replaceAll(" ", "").toLowerCase().trim() + "." + employee.getLastName().replaceAll(" ", "").toLowerCase().trim())
                .password(employee.getDni())
                .build()));
    }

    private UserPresenter userToPresenter(User user) {
        List<RolePresenter> rolePresenters = new ArrayList<>();
        user.getRoles().forEach(role -> {
            rolePresenters.add(roleToPresenter(role));
        });
        return UserPresenter.builder()
                .id(user.getId())
                .userName(user.getUsername())
                .rolePresenters(rolePresenters)
                .build();

    }

    private RolePresenter roleToPresenter(Roles role) {
        List<PermissionPresenter> permissionPresenters = new ArrayList<>();
        role.getPermissions().forEach(permission -> {
            permissionPresenters.add(permissionToPresenter(permission));
        });
        return RolePresenter.builder()
                .id(role.getId())
                .name(role.getName())
                .permissionPresenters(permissionPresenters)
                .build();
    }

    private PermissionPresenter permissionToPresenter(Permission permission) {
        return PermissionPresenter.builder()
                .id(permission.getId())
                .domainAction(permission.getDomainAction())
                .name(permission.getName())
                .build();
    }


}