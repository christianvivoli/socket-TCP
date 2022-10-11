package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Socket s = new Socket("localhost", 3000);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        
//!prima richiesta di messaggio
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci il messaggio:");
        String stringaUtente = tastiera.readLine();
        
        pr.println(stringaUtente);
        pr.flush();

//!messaggio riguardate l altezza
        BufferedReader tastiera2 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci il altezza:");
        String stringaUtente2 = tastiera2.readLine();
        
        pr.println(stringaUtente2);
        pr.flush();

//!messaggio riguardante il peso
        BufferedReader tastiera3 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci il peso:");
        String stringaUtente3 = tastiera3.readLine();
        
        pr.println(stringaUtente3);
        pr.flush();

//!risposta server

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String str = br.readLine();
        System.out.println("Server: " + str);
        


        s.close();
    }
}
