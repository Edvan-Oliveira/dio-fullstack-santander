package dio.gof.facade.subsistema2.cep;

public class CepApi {

    private static final CepApi instancia = new CepApi();

    private CepApi() {
    }

    public static CepApi getInstance() {
        return instancia;
    }

    public String recuperarCidade(String cep) {
        return "Araraquara";
    }

    public String recuperarEstado(String cep) {
        return "SP";
    }
}
