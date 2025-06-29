package com.company;

import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> notebook = new TreeMap<>();

   /* public Map<String, Set<String>> getNotebook() {
        return notebook;
    }

    public void setNotebook(Map<String, Set<String>> notebook) {
        this.notebook = notebook;
    }*/

    public boolean containsName(String name) {
        return notebook.containsKey(name);
    }

    public boolean isValidName(String name) {
        // Написать реализацию проверки имени , что содерит только буквы.


        return name.matches("^[a-zA-Zа-яА-ЯёЁ]+$");
    }

    public boolean isValidPhone(String phone) {
        // Проверить что содержит только цифры.

        return phone.matches("^\\d{11}$");
    }


    public void addContact(String name, String phone) {
        // TODO проверь корректность формата имени и телефона

        // TODO (рекомендуется написать отдельные методы для проверки является строка именем/телефоном)
        // TODO если такой номер уже есть в списке, то перезаписать имя абонента
        if (isValidName(name) && isValidPhone(phone)) {
            for (Map.Entry<String, Set<String>> entry : notebook.entrySet()) {
                entry.getValue().remove(phone);
                if (entry.getValue().isEmpty()){
                    notebook.remove(entry.getKey());
                }
            }
            if (!notebook.containsKey(name)) {
                Set<String> set = new HashSet<>();
                set.add(phone);
                notebook.put(name, set);
            } else {
                Set<String> strings = notebook.get(name);
                strings.add(phone);
            }

        }
    }

    public Set<String> getContactByName(String name) {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контакт не найден - вернуть пустой TreeSet

        if (!notebook.containsKey(name)) {
            return new TreeSet<>();
        }
        Set<String> strings = notebook.get(name);
        String join = String.join(", ", strings);
        Set<String> set = new HashSet<>();
        set.add(name + " - " + join);
        return set;

    }

    public String getContactByPhone(String phone) {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контакт не найдены - вернуть пустую строку
        Set<Map.Entry<String, Set<String>>> entries = notebook.entrySet();
        for (Map.Entry<String, Set<String>> entry : entries) {
            if (entry.getValue().contains(phone)) {
                return entry.getKey() + " - " + String.join(", ", entry.getValue());
            }
        }
        return "";
    }

    public Set<String> getAllContacts() {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контактов нет в телефонной книге - вернуть пустой TreeSet
        if (notebook.isEmpty()) return new TreeSet<>();
        Set<String> contacts = new HashSet<>();
        Set<Map.Entry<String, Set<String>>> entries = notebook.entrySet();
        for (Map.Entry<String, Set<String>> entry : entries) {
            contacts.add(entry.getKey() + " - " + String.join(", ", entry.getValue()));
        }

        return contacts;
    }
}
