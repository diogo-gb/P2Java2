package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="alternativas")
public class Alternativa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Texto;
    private boolean isCorreta;
    private Questao questao;

public Questao getQuestao() {
     return questao;
}

public void setQuestao(Questao questao) {
    this.questao = questao;
}

public long getId() {
    return id;
}
public void setId(long id) {
    this.id = id;
}

public String getTexto() {
    return Texto;
}
public void setTexto(String Texto) {
    this.Texto = Texto;
}

public boolean getisCorreta() {
    return isCorreta;
}
public void setisCorreta(boolean isCorreta) {
    this.isCorreta = isCorreta;
}
}

