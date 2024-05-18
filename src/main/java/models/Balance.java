package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "saldo")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;

    @JsonProperty("saldo")
    @Column(name = "total")
    private int total;

    @JsonProperty("limite")
    @Column(name = "_limit")
    private int limit;
}
