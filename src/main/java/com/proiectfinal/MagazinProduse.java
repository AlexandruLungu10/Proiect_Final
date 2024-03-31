package com.proiectfinal;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class MagazinProduse {
    public static void main(String[] args) {

        InventarProduse inventar = new InventarProduse();
        ObjectMapper mapper = JsonMethods.getDefaultMapper();
        List<Produs> listaProduseInitiala = null;
        try {
            listaProduseInitiala = Arrays.asList(mapper.readValue(new File("Produse.json"), Produs[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Produs> listaProduse = new ArrayList<>(listaProduseInitiala);
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while(running){
            System.out.println("Secrieti numarul optiunii dorite: " +
                    "1. Afisati produsele existente " +
                    "2. Adaugati un produs " +
                    "3. Stergeti un produs " +
                    "4. Modificati un produs " +
                    "5. iesiti din meniu ");
            int optiune = Integer.parseInt(scanner.nextLine());
            switch (optiune){
                case 1:
                    inventar.afisareProduse(listaProduse);
                    break;
                case 2:
                    listaProduse = inventar.adaugaProdus(listaProduse);
                    break;
                case 3:
                    listaProduse = inventar.stergeProdus(listaProduse);
                    break;
                case 4:
                    System.out.println("Ce doriti sa modificati la produs? (cantitate/pret)");
                    String optModificare = scanner.nextLine();
                    if (optModificare.equalsIgnoreCase("cantitate")){
                        listaProduse = inventar.modificaCantitate(listaProduse);
                    } else if (optModificare.equalsIgnoreCase("pret")) {
                        listaProduse = inventar.modificaPret(listaProduse);
                    } else {
                        System.out.println("Nu ati introdus o optiune valida");
                        continue;
                    }
                    break;
                case 5:
                    System.out.println("Programul se inchide! O zi placuta in continuare!");
                    System.exit(0);
                default:
                    System.out.println("Nu ati introdus o optiune valida");
                    continue;
            }
            System.out.println("Doriti sa va intoarceti la meniul anterior? (Da/Nu)");
            String raspuns = scanner.nextLine();
            if(raspuns.equalsIgnoreCase("nu")){
                System.out.println("Programul se inchide! O zi placuta in continuare!");
                running = false;
                System.exit(0);
            } else if(raspuns.equalsIgnoreCase("da")) {
                System.out.println("Ne intoarcem in meniul principal!");
                continue;
            } else {
                System.out.println("Nu ati introdus o optiune valida");
                System.exit(0);
            }
        }
    }
}

