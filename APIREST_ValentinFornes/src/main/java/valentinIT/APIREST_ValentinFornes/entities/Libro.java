package valentinIT.APIREST_ValentinFornes.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Libro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Audited
public class Libro implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private int fecha;

    @Column
    private String genero;

    @Column
    private int paginas;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "fk_persona")
    private Persona persona;

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "AutorLibro",
                joinColumns = @JoinColumn(name = "autor_id"),
                inverseJoinColumns = @JoinColumn(name = "libro_id"))
    private Set<Autor> autor = new HashSet<Autor>();

    //Metodos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Set<Autor> getAutor() {
        return autor;
    }

    public void setAutor(Set<Autor> autor) {
        this.autor = autor;
    }
}
