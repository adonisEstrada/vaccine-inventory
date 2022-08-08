package com.adonis.vaccine.presentation.presenter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPresenter implements Comparable<UserPresenter> {
    private UUID id;
    private String userName;
    private String password;
    private String fullName;
    private String dni;
    @Builder.Default
    private List<RolePresenter> rolePresenters = new ArrayList<>();

    public int compareTo(UserPresenter userPresenter) {
        return this.userName.compareTo(userPresenter.userName);
    }
}
