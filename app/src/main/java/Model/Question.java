package Model;

public class Question {

    private int idPergunta;
    private boolean respostaCorreta;

    public Question(int idPergunta, boolean respostaCorreta) {
        this.idPergunta = idPergunta;
        this.respostaCorreta = respostaCorreta;
    }

    public boolean isRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(boolean respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public int getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }
}
