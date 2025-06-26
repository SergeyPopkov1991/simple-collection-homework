package com.company;

import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> notebook = new TreeMap<>();

    public boolean isValidName(String name) {
        // Написать реализацию проверки имени , что содерит только буквы.

        return false;
    }

    public boolean isValidPhone(String phone) {
        // Проверить что содержит только цифры.(11 цифр)
        return false;
    }


    public void addContact(String name, String phone) {
        // TODO проверь корректность формата имени и телефона

        // TODO (рекомендуется написать отдельные методы для проверки является строка именем/телефоном)
        // TODO если такой номер уже есть в списке, то перезаписать имя абонента
        if(isValidName(name) && isValidPhone(phone)) {
           if(!notebook.containsKey(name)){
               Set<String> set = new HashSet<>();
               set.add(phone);
               notebook.put(name,set);
           }else {
               Set<String> strings = notebook.get(name);
               strings.add(phone);
           }

        }
    }

    public Set<String> getContactByName(String name) {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контакт не найден - вернуть пустой TreeSet

        if(!notebook.containsKey(name)){
            return new TreeSet<>();
        }
        Set<String> strings = notebook.get(name);
        String join = String.join(", ", strings);
        Set<String> set = new HashSet<>();
        set.add(name + " - " + join );
        return set;

    }

    public String getContactByPhone(String phone) {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контакт не найдены - вернуть пустую строку
        Set<Map.Entry<String, Set<String>>> entries = notebook.entrySet();
        for (Map.Entry<String, Set<String>> entry : entries) {
           if(entry.getValue().contains(phone)) {
               return entry.getKey() + " - " + String.join(", ", entry.getValue());
           }
        }
        return "";
    }

    public Set<String> getAllContacts() {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контактов нет в телефонной книге - вернуть пустой TreeSet
        return null;
    }
}
