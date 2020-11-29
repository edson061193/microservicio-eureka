package com.edsonsuarez.apirestmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "socio")
public class Socio {
    @Id
    private @NonNull String id;
    private @NonNull String dni;
    private @NonNull String apaterno;
    private @NonNull String amaterno;
    private @NonNull String nombres;
    private @NonNull String correo;
    private @NonNull String telefono;
    private @NonNull String estado;
    private @NonNull String menbresia;

}
