/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cliente {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String menu = JOptionPane.showInputDialog("Calculadora\n\n"
                    + "Digite (1)..Somar\n"
                    + "Digite (2)..Subtrair\n"
                    + "Digite (3)..Multiplicar\n"
                    + "Digite (4)..Dividir\n"
                    + "Digite (5)..Sair");

            if (menu.equals("5")) {
                break;
            }

            int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));
            int b = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));

            String urll = "http://localhost:8080/calculadora/";

            switch (menu) {
                case "1":
                    urll += "add/" + a + "/" + b;
                    break;
                case "2":
                    urll += "sub/" + a + "/" + b;
                    break;
                case "3":
                    urll += "mul/" + a + "/" + b;
                    break;
                case "4":
                    urll += "div/" + a + "/" + b;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    continue;
            }

            java.net.HttpURLConnection connection = null;
            try {
                URL url = new URL(urll);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String result = in.readLine();
                    in.close();
                    System.out.println(result);
                    JOptionPane.showMessageDialog(null, "Resultado: " + result);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro na chamada do Web Service: " + responseCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao executar a requisição: " + e.getMessage());
                System.out.println(urll);
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }

        }
    }
}
