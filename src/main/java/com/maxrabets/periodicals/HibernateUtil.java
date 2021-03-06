package com.maxrabets.periodicals;

import java.util.HashMap;
import java.util.Map;
 
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.maxrabets.periodicals.entity.User;
 
public class HibernateUtil {
 
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
 
    public static SessionFactory getSessionFactory() {
        //?????????? ?????????. ???? ??????? ??? - ???????, ???? ???? ?????? ??????????
        if (sessionFactory == null) {
            try {
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
 
                //??????????? ????????? ??? ????????
                //??? ???, ??? ?????????? ?????? ???? ?????? ????? ???????? ???? DRIVER, DIALECT ? ????? URL ????? ???????? ??? ????? ????
                Map<String, String> settings = new HashMap<String, String>();
                settings.put(Environment.DRIVER, "org.h2.Driver");
                settings.put(Environment.URL, "jdbc:h2:tcp://localhost/~/periodicals");
                settings.put(Environment.USER, "sa");
                settings.put(Environment.PASS, "123");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect\r\n");
                
//                settings.put(Environment.DRIVER, "org.h2.Driver");
//                settings.put(Environment.URL, "postgres://aavhhsiklbrwfg:1eda962a7f8c886b109892e39ea02d05eb6d1b66cd956956849feebcf8ce200e@ec2-54-228-250-82.eu-west-1.compute.amazonaws.com:5432/d5vi6eq0pve0gl?sslmode=require");
//                settings.put(Environment.USER, "aavhhsiklbrwfg");
//                settings.put(Environment.PASS, "1eda962a7f8c886b109892e39ea02d05eb6d1b66cd956956849feebcf8ce200e");
//                settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect\r\n");
 
                registryBuilder.applySettings(settings);
 
                registry = registryBuilder.build();
 
                MetadataSources sources = new MetadataSources(registry);
                sources.addAnnotatedClass(User.class);
                Metadata metadata = sources.getMetadataBuilder().build();
 
                sessionFactory = metadata.getSessionFactoryBuilder().build();
 
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }
 
    public static void close() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
 
}
