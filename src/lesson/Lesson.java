package lesson;
import java.util.Scanner;

public class Lesson {

    private String username = "Anar";
    private String parol = "123Anar";
    private int[] crediLimit = {2350, 3500, 6200, 5400};
    private String[] users = {"Anar", "Aysel", "Hesen", "Elnur"};

    public static void main(String[] args) {

        Lesson main = new Lesson();
        main.logIn(main.parol, main.username,main.users, main.crediLimit);
    }

    public void logIn(String parol, String username,String[] users,int[] crediLimit ) {
        System.out.println("istifadeci adinizi daxil edin");
        byte chekin =0;
        while (true) {
            Scanner sc = new Scanner(System.in);
            String chek = sc.nextLine();

            if (username.equals(chek)) {
                System.out.println("parolnuzu daxil edin");
                String password = sc.nextLine();
                if (parol.equals(password)) {
                    chekin++;
                    System.out.println("xos gelniniz!");
                    lookUsers(users, crediLimit);
                }
                else System.out.println("parolunuz duzgun deyil");

            } else {
                System.out.println("istfadeci adiniz duzgun deyil");
                chekin++;
            }
            if(chekin == 3){
                System.exit(3);
            }
        }
    }


    public void lookUsers(String[] users, int[] crediLimit) {
        for (int i = 0; i < users.length; i++) {
            System.out.println((i + 1) + "." + users[i] + crediLimit[i] + " AZN");
        }
        prosseing();
    }

   public void prosseing(){
       Scanner nm = new Scanner(System.in);
       while (true) {
           byte number = nm.nextByte();
           if (number < users.length) {
               System.out.println(users[number - 1] + crediLimit[number - 1]);
               System.out.println("ne qeder mebleg istiyirsiz?");
               int fiat = nm.nextInt();
               if(fiat<crediLimit[number-1]){
                   int newfiat = crediLimit[number - 1] - fiat;
                   System.out.println("sizin " + newfiat + " mebleginiz qaldi");
               }
              else System.out.println("limiti asdiniz!");

           }
           else System.out.println("bele istfadeci yoxdur");
           System.out.println("sistemden cixmaq ucun q duymesini secin ");
           Scanner exit = new Scanner(System.in);
           String quit = exit.nextLine();
           if(quit.equals("q")) System.exit(0);
       }

   }
}
