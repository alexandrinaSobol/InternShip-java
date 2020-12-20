package org.exemple.lesson5;

import com.fasterxml.jackson.databind.ObjectMapper;
import exemplu.Person;
import lombok.Data;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.io.Serializable;
import java.io.*;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

@Data
public class Client implements Serializable {
    private static Logger LOGGER;

    public static void main(String[] args) throws IOException {
        ThreadContext.put("fileName", Client.class.getName());
        LOGGER = Logger.getLogger(Client.class);

        Person p1 = new Person("Ruslan", "Ciubotaru", 12);
        Person p2 = new Person("Ion", "Ciubotaru", 22);
        Person p3 = new Person("Vlad", "Ciubotaru", 30);

        Set<Person> person = new HashSet<>();
        person.add(p1);
        person.add(p2);
        person.add(p3);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            final String personSe = objectMapper.writeValueAsString(person);
            for (Person element : person) {
                System.out.println(element);
            }
            Socket s = new Socket("localhost", 1234);
            final boolean connected = s.isConnected();
            LOGGER.info(connected ? "connected" : "no connection");
            final OutputStream outputStream = s.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(personSe);
            dataOutputStream.flush();
            s.close();
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}