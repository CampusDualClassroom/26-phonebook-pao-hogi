package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact implements ICallActions {

    private String name;
    private String surnames;
    private String phone;
    private String code;

    public Contact(String name, String surnames, String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.code = generateCode(name, surnames);
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getPhone() {
        return phone;
    }

    public String getCode() {
        return code;
    }

    @Override
    public void callMyNumber() {
        System.out.println(this.name + " " + this.surnames + " se está llamando a sí mismo al número " + this.phone);
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println(this.name + " " + this.surnames + " está llamando al número " + number);
    }

    @Override
    public void showContactDetails() {
        System.out.println("Nombre: " + this.name);
        System.out.println("Apellidos: " + this.surnames);
        System.out.println("Teléfono: " + this.phone);
        System.out.println("Código: " + this.code);
    }


    private String generateCode(String name, String surnames) {

        String normalizedName = removeAccents(name.toLowerCase());
        String normalizedSurnames = removeAccents(surnames.toLowerCase());

        String[] surnameParts = normalizedSurnames.split(" ");
        char nameInitial = normalizedName.charAt(0);

        if (surnameParts.length == 1) {
            return nameInitial + surnameParts[0];
        }

        char firstSurnameInitial = surnameParts[0].charAt(0);

        String lastPart = surnameParts[surnameParts.length - 1];

        StringBuilder middle = new StringBuilder();
        for (int i = 1; i < surnameParts.length - 1; i++) {
            middle.append(surnameParts[i]);
        }

        return "" + nameInitial + firstSurnameInitial + middle.toString() + lastPart;
    }

    private String removeAccents(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .replaceAll("[^\\p{ASCII}]", "");
    }
}