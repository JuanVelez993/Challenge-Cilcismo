package com.sofka.ciclismo.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cyclists")
@Data
public class Cyclist {
    @Id
    private String tagNumber;
    private String teamId;
    private String nationality;
}
