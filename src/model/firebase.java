/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;
import java.util.ArrayList;


public class firebase {
    
    private FirebaseDatabase firebaseDatabase;

    /**
     * inicialización de firebase.
     */
    private void initFirebase() {
        try {
            
            FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
                    .setDatabaseUrl("https://parcial2-b04a9-default-rtdb.firebaseio.com/") // 
                    // .setDatabaseUrl("https://prueba2-97bb1.firebaseio.com/")
                    .setServiceAccount(new FileInputStream(new File("C:\\Users\\FLIA ARENAS CARMONA\\Documents\\GABRIEL\\2023\\SEGUNDO SEMESTRE\\ProgramaciónOrientadaAObjetos\\claves firebase\\Parcial2.json")))
                    // .setServiceAccount(new FileInputStream(new File("/Users/nestor/Documents/pc/NetBeansProjects/firebase/src/firebase/prueba2-97bb1-firebase-adminsdk-74jjt-433b9eb033.json")))

                    .build();

            FirebaseApp.initializeApp(firebaseOptions);
            firebaseDatabase = FirebaseDatabase.getInstance();
            System.out.println("La conexión se realizo exitosamente...");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

   
    public void saveUsingPush(ArrayList<String> item) {
        if (item != null) {
        initFirebase();
        
        /* Get database reference for the specific node. */
        DatabaseReference databaseReference = firebaseDatabase.getReference("/DatosPersonales");

        /* Set the ArrayList data for the node. This reemplazará los datos existentes en "Calculadora" con los nuevos datos. */
        databaseReference.setValue(item, new DatabaseReference.CompletionListener() {

            @Override
            public void onComplete(DatabaseError de, DatabaseReference dr) {
                
            }
        });
    }
    }
    
    
    public void Actualizar(ArrayList<String> item) {
        if (item != null) {
            initFirebase();

            /* Get database reference for the specific node. */
            DatabaseReference databaseReference = firebaseDatabase.getReference("/DatosPersonales");

            databaseReference.setValue(item, new DatabaseReference.CompletionListener() {

                @Override
                public void onComplete(DatabaseError de, DatabaseReference dr) {
                    System.out.println("Datos actualizados en Firebase.");
                }
            });
        }
    }
}