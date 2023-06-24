/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService
public class CalculadoraResource {
    @WebMethod
    public int add(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return a + b;
    }

    @WebMethod
    public int sub(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return a - b;
    }

    @WebMethod
    public int mul(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return a * b;
    }

    @WebMethod
    public double div(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return (double) a / b;
    }
}

