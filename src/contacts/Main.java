package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Contact [] contacts = new Contact[10];
        int count = 0;
        int menu = 0;

        while(menu != 4)
        {
            System.out.println("Введите номер действия:\n" +
                    "1. Новый контакт\n" +
                    "2. Редактировать контакт\n" +
                    "3. Удалить контакт\n" +
                    "4. Выйти");

            Scanner sc = new Scanner(System.in);
            menu = sc.nextInt();
            switch (menu)
            {
                case 1:
                    contacts[count] = create_contact(sc);
                    count++;
                    break;
                case 2:
                    System.out.println("Введите порядковый номер контакта для редактирования:");
                    int current = sc.nextInt();
                    if (contacts[current-1] != null)
                        edit_contact(contacts[current-1], sc);
                    else
                        System.out.println("Контакт не заполнен");
                    break;
                case 3:
                    System.out.println("Введите порядковый номер контакта для удаления:");
                    current = sc.nextInt();
                    if (contacts[current-1] != null) {
                        delete_contact(contacts, current-1);
                        count--;
                    }
                    else
                        System.out.println("Контакт не заполнен");

                    break;
                default:
                    break;

            }
            print_contacts(contacts);
        }


    }
    public static void print_contacts(Contact [] contacts)
    {
        for (int i = 0; i< contacts.length; i++)
        {
            if(contacts[i] != null)
                System.out.println((i+1) + ". " + contacts[i].getName() + " Номер: " + contacts[i].getValue());
            else
                System.out.println((i+1) + ". ");

        }
    }
    public static Contact[] delete_contact(Contact[] contacts, int current)
    {
        contacts[current]=null;
        while(contacts[current+1] != null && current!= 9) {

            contacts[current] = contacts[current+1];
            current++;
        }
        contacts[current]=null;
        return contacts;
    }
    public static Contact edit_contact(Contact contact,Scanner sc)
    {
        sc.nextLine();
        System.out.println("Введите новый номер телефона:");
        String value = sc.nextLine();
        System.out.println("Введите новое имя контакта:");
        String name = sc.nextLine();
        contact.setName(name);
        contact.setValue(value);
        return contact;
    }
    public static Contact create_contact(Scanner sc)
    {
        sc.nextLine();
        System.out.println("Введите номер телефона:");
        String value = sc.nextLine();
        System.out.println("Введите имя контакта:");
        String name = sc.nextLine();
        if (name != null && value != null)
            return new Contact(name, value);
        else
            return null;

    }

}
