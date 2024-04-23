/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PersistenceJson {

    private final String fileLocation;
    private final Gson json;

    public PersistenceJson(String fileLocation) {
        this.fileLocation = fileLocation;
        this.json = new GsonBuilder().setPrettyPrinting().create();
        createFileIfNotExists();
    }

    private void createFileIfNotExists() {
        File file = new File(fileLocation);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
    }

    public TableInventory loadData() {
        try (FileReader reader = new FileReader(fileLocation)) {
            TableInventory inventory = json.fromJson(reader, TableInventory.class);
            if (inventory == null || inventory.getListProducts().isEmpty()) {
                return new TableInventory();
            }
            return inventory;
        } catch (IOException e) {
            return new TableInventory();
        }
    }

    public void saveData(TableInventory listProducts) {
        try (FileWriter file = new FileWriter(fileLocation)) {
            json.toJson(listProducts, file);
        } catch (IOException e) {
        }
    }

}