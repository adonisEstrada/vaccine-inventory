package com.adonis.vaccine.presentation.presenter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PermissionPresenter {
    private UUID id;
    private String name;
    private String domainAction;
}
