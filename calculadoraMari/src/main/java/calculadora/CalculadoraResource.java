package calculadora;

import javax.jws.WebService;

@WebService(endpointInterface = "calculadora.CalculadoraWebService")
public class CalculadoraResource implements CalculadoraWebService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public double div(int a, int b) {
        return (double) a / b;
    }
}
