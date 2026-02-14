package org.example.domain;

import java.util.*;

public class DataRepository {
   Map<UUID, Publication> publications = new HashMap<>();
   Map<String, Book> booksByIsbn;
   Set<Reader> readers = new HashSet<>();
   Map<Reader, List<Publication>> loans = new HashMap<>();

//    public Map<String, Publication> getPublicationBy() {
//        return publications;
//    }
}
