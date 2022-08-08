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
    @NotNull
    private String userName;
    @NotNull
    private String password;
    @NotNull
    private String fullName;
    @NotNull
    private String dni;
    @NotNull
    private List<RolePresenter> rolePresenters = new ArrayList<>();

    public int compareTo(UserPresenter userPresenter) {
        return this.userName.compareTo(userPresenter.userName);
    }
}
