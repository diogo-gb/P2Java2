package application.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="questões")
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Enunciado;
    private boolean isCorreta;
    private Set<Alternativa> Alternativa;

 public Set<Alternativa> getAlternativas() {
    return Alternativa;
}

public void setAlternativas(Set<Alternativa> alternativas) {
     this.Alternativa = alternativas;
}

public long getId() {
    return id;
}
public void setId(long id) {
    this.id = id;
}

public String getEnunciado() {
    return Enunciado;
}
public void setEnunciado(String Enunciado) {
    this.Enunciado = Enunciado;
}

public boolean getisCorreta() {
    return isCorreta;
}
public void setisCorreta(boolean isCorreta) {
    this.isCorreta = isCorreta;
}
}


