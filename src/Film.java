import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Film {
    static List<String> filmler = new ArrayList<>(Arrays.asList("JOKER", "INCEPTION", "PIYANIST", "GREENMILE", "LEON", "GODFATHER", "JURASSICPARK", "TITANIC"));
    static   Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("lutfen 1 ile " +filmler.size() +" arasinda bir deger giriniz");
        int index = scan.nextInt()-1;
        filmiBul(filmler,index);

    }

    private static void filmiBul(List<String> filmler, int index) {

        int kelimeHarfSayisi = filmler.get(index).length();
        int tahmin = kelimeHarfSayisi * 2;
        String film = filmler.get(index);
        int filmKarakterSayisi=film.length();
        System.out.println("Sectiginiz filmin karakter sayisi "+filmKarakterSayisi);
        System.out.println("tahmin hakkiniz " + tahmin);
        String[] arr = film.split("");
        char harf = ' ';
        String karakter = "";

        StringBuilder tamamlananFilmAdi = new StringBuilder(film.replaceAll("\\w", "-"));
        System.out.println(tamamlananFilmAdi.toString());



        while (tahmin > 0) {
            System.out.println("Lutfen bir harf giriniz");
            harf = scan.next().toUpperCase().charAt(0);
            karakter += harf;
            if(tamamlananFilmAdi.toString().contains(karakter)){
                System.out.println("Bu harfi daha once girdiniz ,baska bir harf giriniz");
            } else if (film.contains(karakter)) {
                System.out.println("Dogru tahmin");
                System.out.println("Kalan tahmin hakkiniz " + tahmin);
                for (int i = 0; i < tamamlananFilmAdi.length(); i++) {
                    if (arr[i].equals(karakter)) {
                        tamamlananFilmAdi.setCharAt(i, harf);
                    }
                }
                System.out.println(tamamlananFilmAdi.toString());

                if (tamamlananFilmAdi.toString().equals(film)) {
                    System.out.println("Film " + film);
                    System.out.println("Kazandiniz");
                    break;
                } }
            else {
                System.out.println("Yanlis tahmin");
                System.out.println("Kalan tahmin hakkiniz " + (tahmin - 1));
                tahmin--;
            }
            karakter = "";
        }
        if (tahmin == 0) {
            System.out.println("Kaybettiniz");
            System.out.println("Filmin adi "+film);

        }



    }


}




