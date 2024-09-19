package valentinIT.APIREST_ValentinFornes.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Audited
public class Domicilio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String calle;

    @Column
    private int numero;

    @OneToMany (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "fk_localidad")
    private Set<Localidad> localidad = new HashSet<Localidad>();

    //Metodos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Set<Localidad> getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Set<Localidad> localidad) {
        this.localidad = localidad;
    }
}
