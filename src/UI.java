import java.util.Scanner;

public class UI {
    public static int StartMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("    ВЫБЕРИТЕ ДЕЙСТВИЕ");
        System.out.println("1 - Закодировать файл");
        System.out.println("2 - Раскодировать файл");
        System.out.println("3 - Раскодировать файл методом brut force");
        System.out.println("4 - Выход");
        int indexMenu = 0;
        do {
            if (!scanner.hasNextInt()) break;
            indexMenu = scanner.nextInt();
        }

        while (indexMenu < 1 || indexMenu > 4);
        return indexMenu;

    }

    public static void Doit(int indexM) {
        System.out.println("Введите путь к файлу: ");
        Scanner scan = new Scanner(System.in);
        String pathStr = scan.nextLine();
        pathStr = "C:/JAVA/project.txt";
        int pathCesar = 3;
        if (!(indexM == 3)) {
            System.out.println("Введите смещение для метода Цезарь : ");
            pathCesar = scan.nextInt();
        }
        String str, str1;
        switch (indexM) {
            case 1:
                str = FileInputOutput.loadStringFromFile(pathStr);
                str1 = Cesar.decrypt(str, pathCesar);
                FileInputOutput.saveStringToFile(str1, pathStr);
                break;

            case 2:
                str = FileInputOutput.loadStringFromFile(pathStr);
                str1 = Cesar.encrypt(str, pathCesar);
                FileInputOutput.saveStringToFile(str1, pathStr);

                break;
            case 3:
                str = FileInputOutput.loadStringFromFile(pathStr);
                str1 = BrutForce.decrypt(str);
                FileInputOutput.saveStringToFile(str1, pathStr);

            case 4:
                break;
        }
    }
}




