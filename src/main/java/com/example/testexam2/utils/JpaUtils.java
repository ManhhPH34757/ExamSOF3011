package com.example.testexam2.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class JpaUtils {
    private static EntityManagerFactory factory;
    static public EntityManager getEntityManager(){ // insertable=false, updatable=false
        if (factory == null || !factory.isOpen()){
            factory = Persistence.createEntityManagerFactory("TestExam2");
        }
        return factory.createEntityManager();
    }// encrypt=true;trustServerCertificate=true;
}