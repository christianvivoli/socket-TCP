package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server in ascolto sulla porta 3000");
        Socket s = ss.accept();
        System.out.println("Client connesso");

//?primo messaggio ricevuto
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String str = br.readLine();
        System.out.println("Client: " + str);

//?messagio riguardante l altezza

        InputStreamReader in2 = new InputStreamReader(s.getInputStream());
        BufferedReader br2 = new BufferedReader(in2);
        String strgAltezza = br2.readLine();
        float altezza= Float.valueOf(strgAltezza);

//?messaggio riguardante il peso 

        InputStreamReader in3 = new InputStreamReader(s.getInputStream());
        BufferedReader br3 = new BufferedReader(in3);
        String strgPeso = br3.readLine();
        float peso= Float.valueOf(strgPeso);

       //*prova funziona  System.out.println(peso/(altezza*altezza));

//? mettere il risultato bmi
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("il bmi è: "+ peso/(altezza*altezza));
        pr.flush();


        s.close();
        ss.close();

    }
}
