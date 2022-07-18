package com.sofka.ciclismo.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "teams")
@Data
public class Team {
    @Id
    private String teamId;
    private String teamName;
    private String country;
    private List<Cyclist> cyclists;
}
