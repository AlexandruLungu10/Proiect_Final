package com.proiectfinal;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class InventarProduse implements GestionareProduse{

    @Override
    public void afisareProduse(List<Produs> listaProduse) {
        for (Produs produs:listaProduse) {
            System.out.println(produs.toString());
        }
    }

    @Override
    public void updateFile(List<Produs> listaProduse) {
        try {
            FileWriter writer = new FileWriter("Produse.json");
            JsonNode node = JsonMethods.toJson(listaProduse);
            String produse = JsonMethods.stringify(node);
            writer.write(produse);
            writer.flush();
            writer.close();
            System.out.println("Operatiunea a avut success!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Produs> adaugaProdus(List<Produs> listaProduse) {
        Produs produs = new Produs();
        System.out.print("Introduceti numele produsului: ");
        Scanner scanner = new Scanner(System.in);
        produs.setNumeProdus(scanner.nextLine());
        System.out.print("Introduceti cantitatea dorita: ");
        produs.setCantitateProdus(Integer.parseInt(scanner.nextLine()));
        System.out.print("Introduceti pretul produsului: ");
        produs.setPretProdus(Double.parseDouble(scanner.nextLine()));
        listaProduse.add(produs);
        updateFile(listaProduse);
        return listaProduse;
    }

    @Override
    public List<Produs> stergeProdus(List<Produs> listaProduse) {
        System.out.print("Introduceti numele produsului pe care doriti sa il stergeti: ");
        Scanner scanner = new Scanner(System.in);
        String produsSters = scanner.nextLine();
        Iterator<Produs> iterator = listaProduse.iterator();
        while (iterator.hasNext()) {
            Produs aux = iterator.next();
            if (aux.getNumeProdus().equalsIgnoreCase(produsSters)){
                iterator.remove();
            }
        }
        updateFile(listaProduse);
        return listaProduse;
    }

    @Override
    public List<Produs> modificaPret(List<Produs> listaProduse) {
        System.out.print("Introduceti numele produsului caruia doriti sa ii schimabti pretul: ");
        Scanner scanner = new Scanner(System.in);
        String produsPret = scanner.nextLine();
        System.out.print("Introduceti noul pret al produsului: ");
        double pretNou = Double.parseDouble(scanner.nextLine());
        for (Produs produs: listaProduse) {
            if(produs.getNumeProdus().equalsIgnoreCase(produsPret)){
                produs.setPretProdus(pretNou);
            }
        }
        updateFile(listaProduse);
        return listaProduse;
    }

    @Override
    public List<Produs> modificaCantitate(List<Produs> listaProduse) {
        System.out.print("Introduceti numele produsului caruia doriti sa ii schimabti cantitatea: ");
        Scanner scanner = new Scanner(System.in);
        String produsCantitate = scanner.nextLine();
        System.out.print("Introduceti noua cantitate a produsului: ");
        int cantitateNoua = Integer.parseInt(scanner.nextLine());
        for (Produs produs: listaProduse) {
            if(produs.getNumeProdus().equalsIgnoreCase(produsCantitate)){
                produs.setCantitateProdus(cantitateNoua);
            }
        }
        updateFile(listaProduse);
        return listaProduse;
    }
}
