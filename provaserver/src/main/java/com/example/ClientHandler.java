package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {

    Socket s;

    public ClientHandler(Socket s){
        this.s=s;
    } 

    public void run(){

        try {
            
        System.out.println("Client connesso");

        // per parlare
        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);
          
        // per ascoltare
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        System.out.println(br.readLine()); // ricevo: Eccomi
        pr.println("Dammi il tuo peso"); // invio messaggio
        String peso = br.readLine(); // ricevo: il peso
        System.out.println("peso ricevuto");
        pr.println("Dammi l'altezza"); // invio messaggio
        String altezza = br.readLine(); // ricevo: l'altezza
        System.out.println("altezza ricevuta");

        Double bmi = Double.valueOf(peso) / (Double.valueOf(altezza) * Double.valueOf(altezza));
        pr.println(bmi); // invio il bmi
        
        System.out.println(br.readLine()); // leggo il saluto finale e lo metto in console
    
            s.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
      
    }

}
