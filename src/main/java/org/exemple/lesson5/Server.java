package org.exemple.lesson5;

import com.fasterxml.jackson.databind.ObjectMapper;
import exemplu.Person;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    private static Logger LOGGER;

    public static void main(String[] args) {
        ThreadContext.put("fileName", Server.class.getName());
        LOGGER = Logger.getLogger(Server.class);

        try {
            ServerSocket ss = new ServerSocket(1234);
            Socket s = ss.accept();
            DataInputStream dataInputStream = new DataInputStream(s.getInputStream());
            String string = dataInputStream.readUTF();
            ObjectMapper objectMapper = new ObjectMapper();
            Set<Person> persons = new HashSet<>(Arrays.asList(objectMapper.readValue(string, Person[].class)));

            persons.forEach(p -> {
                LOGGER.info(p.getFirstName() + " " + p.getLastName());
            });
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
