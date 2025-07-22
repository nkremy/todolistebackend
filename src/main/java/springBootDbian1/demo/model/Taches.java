package springBootDbian1.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table
@Data
public class Taches {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;

    @NotNull
    public String description;

    public String date;

    @NotNull
    public int status;



}
