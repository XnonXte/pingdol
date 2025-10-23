/*
 * Game overview: 
 * Permainan Pingdol (Tic Tac Toe).
 * Pemain mulai dari X.
 * Saat mulai, user 1 dan 2 memasukan namanya.
 *
 * Game logic:
 * User menggunakan WASD untuk memilih baris dan kolom.
 * Untuk setiap langkah, program menentukan apakah ada yang selesai (vertikal, horizontal, dan diagonal).
 * Jika ditemukan pemenang, program selesai dan menampilkan nama pemenang.
 * Jika seri, maka program mengulang kembali. 
 */

// Bagi tugas, Johan dan Dewo logika.
// Quddus dan Latif inputnya.

import java.util.Scanner;

public class Pingdol {
    public static void main(String[] args) {
        System.out.println("===================");
        System.out.println("PROGRAM PINGDOL");
        System.out.println("===================");
        System.out.println("DIBUAT OLEH:");
        System.out.println("- MOHAMMAD ABDUL QUDDUS SALAM");
        System.out.println("- JOHANNES SEBASTIAN TAMPUBOLON");
        System.out.println("- MOHAMMAD ABDUL QUDDUS SALAM");
        System.out.println("- REZA ABDUL LATIF");

    }

    public static int[] input() {
        Scanner scan = new Scanner(System.in);
        char inputChar = scan.nextLine().toLowerCase().charAt(0);
        int baris = 0;
        int kolom = 0;
        while (true) {
            if (inputChar != 'a' && inputChar != 'w' && inputChar != 's' && inputChar != 'd') {
                System.out.println("Gunakan WASD untuk memilih kotak!");
                continue;
            }
            switch (inputChar) {
                case 'w':
                    System.out.println();
                    break;
                case 'a':
                    System.out.println();
                    break;
                case 's':
                    System.out.println();
                    break;
                case 'd':
                    System.out.println();
                    continue;
            }
        }
    }

    public static void logic(String[] args) {
        char[][] matrix;
        matrix = new char[3][3];

        // dewo
        if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]) {
            if (matrix[0][0] == 'x') {
                System.out.println("Selamat player 1 menang");
            } else {
                System.out.println("selamat player 2 menang");
            }
        } else if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0]) {
            if (matrix[0][2] == 'x') {
                System.out.println("Selamat player 1 menang");
            } else {
                System.out.println("selamat player 2 menang");
            }
        } else if (matrix[1][0] == matrix[1][1] && matrix[1][2] == matrix[2][0]) {
            if (matrix[1][2] == 'x') {
                System.out.println("Selamat player 1 menang");
            } else {
                System.out.println("selamat player 2 menang");
            }
        } else if (matrix[2][0] == matrix[2][1] && matrix[2][1] == matrix[2][2]) {
            if (matrix[2][2] == 'x') {
                System.out.println("Selamat player 1 menang");
            } else {
                System.out.println("selamat player 2 menang");
            }

        }
        // johan
        else if (matrix[0][0] == matrix[1][0] && matrix[1][0] == matrix[2][0]) {
            if (matrix[0][0] == 'x') {
                System.out.println("Selamat player 1 menang");
            } else {
                System.out.println("selamat player 2 menang");
            }
        } else if (matrix[0][1] == matrix[1][1] && matrix[1][1] == matrix[2][1]) {
            if (matrix[0][1] == 'x') {
                System.out.println("Selamat player 1 menang");
            } else {
                System.out.println("selamat player 2 menang");
            }
        } else if (matrix[0][2] == matrix[1][2] && matrix[1][2] == matrix[2][2]) {
            if (matrix[0][2] == 'x') {
                System.out.println("Selamat player 1 menang");
            } else {
                System.out.println("selamat player 2 menang");
            }
        } else if (matrix[0][0] == matrix[0][1] && matrix[0][1] == matrix[0][2]) {
            if (matrix[0][0] == 'x') {
                System.out.println("Selamat player 1 menang");
            } else {
                System.out.println("selamat player 2 menang");
            }
        }
    }
}