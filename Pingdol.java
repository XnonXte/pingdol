import java.util.Scanner;

public class Pingdol {
    public static void main(String[] args) {
        // Intro permainan.
        System.out.println("=============================================");
        System.out.println("SELAMAT DATANG DI PROGRAM PINGDOL");
        System.out.println("=============================================");
        System.out.println("ANGGOTA-ANGGOTA KELOMPOK:");
        System.out.println("1. Mohammad Abdul Quddus Salam");
        System.out.println("2. Reza Abdul Latif");
        System.out.println("3. Dewo Adjie Fadhilla");
        System.out.println("4. Johannes Sebastian Tampubolon");
        Scanner scan = new Scanner(System.in);

        // Inisiasi papan.
        char[][] papan = {
                { '.', '.', '.' },
                { '.', '.', '.' },
                { '.', '.', '.' }
        };

        // Memasukan nama pemain 1 dan 2.
        System.out.println("=============================================");
        System.out.print("Masukan nama pemain 1: ");
        String pemain1 = scan.nextLine();
        System.out.print("Masukan nama pemain 2: ");
        String pemain2 = scan.nextLine();

        // Giliran pemain.
        boolean giliranPemain1 = true;

        // Game loop.
        while (true) {
            // Menggambar papan sekali.
            tampilkanPapan(papan);

            if (giliranPemain1) {
                // Jika giliran pemain 1.
                System.out.printf("Pemain %s (X) pilih petak nomor (1-9): ", pemain1);
                int nomor = scan.nextInt();
                if (nomor < 1 || nomor > 9) {
                    // Diluar pilihan di papan.
                    System.out.println("Nomor invalid!");
                    continue;
                }
                if (cekPetak(papan, nomor)) {
                    masukanPetak(papan, nomor, 'X');
                    giliranPemain1 = false;
                } else {
                    System.out.printf("Petak %d sudah terisi!", nomor);
                    continue;
                }
            } else {
                // Jika giliran pemain 2.
                System.out.printf("Pemain %s (O) pilih petak  nomor (1-9): ", pemain2);
                int nomor = scan.nextInt();
                if (nomor < 1 || nomor > 9) {
                    // Diluar pilihan di papan.
                    System.out.println("Nomor invalid!");
                    continue;
                }
                if (cekPetak(papan, nomor)) {
                    masukanPetak(papan, nomor, 'O');
                    giliranPemain1 = true;
                } else {
                    System.out.printf("Petak %d sudah terisi!", nomor);
                    continue;
                }
            }

            // Cek papan setiap langkah.
            int hasil = cekHasil(papan);

            if (hasil == 1) {
                // Jika pemain 1 menang.
                tampilkanPapan(papan);
                System.out.println("Permainan selesai!");
                System.out.printf("Pemain %s memang!\n", pemain1);
                break;
            } else if (hasil == 2) {
                // Jika pemain 2 menang.
                tampilkanPapan(papan);
                System.out.println("Permainan selesai!");
                System.out.printf("Pemain %s memang!\n", pemain2);
                break;
            } else if (cekPenuh(papan)) {
                // Jika seri.
                tampilkanPapan(papan);
                System.out.println("Permainan seri!");
                break;
            } else {
                continue;
            }
        }
        System.out.println("Terimakasih sudah bermain game ini!");
        scan.close();
    }

    static int cekHasil(char[][] papan) {
        // Cek papan, return 0 jika tidak ada yang menang, 1 jika pemain 1 menang, 2
        // jika pemain 2 memang.
        for (int i = 0; i < papan.length; i++) {
            for (int j = 0; j < papan[i].length; j++) {
                switch (papan[i][j]) {
                    case '.':
                        continue;
                    case 'X':
                        try {
                            if ((papan[i + 1][j] == 'X') && (papan[i + 2][j] == 'X')) {
                                return 1;
                            }
                        } catch (Exception e) {

                        }
                        try {
                            if ((papan[i][j + 1] == 'X') && (papan[i][j + 2] == 'X')) {
                                return 1;
                            }
                        } catch (Exception f) {

                        }
                        try {
                            if ((papan[i + 1][j + 1] == 'X') && (papan[i + 2][j + 2] == 'X')) {
                                return 1;
                            }
                        } catch (Exception g) {

                        }
                        break;
                    case 'O':
                        try {
                            if ((papan[i + 1][j] == 'O') && (papan[i + 2][j] == 'O')) {
                                return 2;
                            }
                        } catch (Exception e) {

                        }
                        try {
                            if ((papan[i][j + 1] == 'O') && (papan[i][j + 2] == 'O')) {
                                return 2;
                            }
                        } catch (Exception f) {

                        }
                        try {
                            if ((papan[i + 1][j + 1] == 'O') && (papan[i + 2][j + 2] == 'O')) {
                                return 2;
                            }
                        } catch (Exception g) {

                        }
                        break;
                }
            }
        }
        return 0;
    }

    static boolean cekPenuh(char[][] papan) {
        // Cek apakah papan sudah penuh dengan simbol.
        for (int i = 0; i < papan.length; i++) {
            for (int j = 0; j < papan[i].length; j++) {
                if (papan[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean cekPetak(char[][] papan, int nomor) {
        // Cek apakah petak sudah terisi.
        switch (nomor) {
            case 1:
                if (papan[0][0] != '.')
                    return false;
                break;
            case 2:
                if (papan[0][1] != '.')
                    return false;
                break;
            case 3:
                if (papan[0][2] != '.')
                    return false;
                break;
            case 4:
                if (papan[1][0] != '.')
                    return false;
                break;
            case 5:
                if (papan[1][1] != '.')
                    return false;
                break;
            case 6:
                if (papan[1][2] != '.')
                    return false;
                break;
            case 7:
                if (papan[2][0] != '.')
                    return false;
                break;
            case 8:
                if (papan[2][1] != '.')
                    return false;
                break;
            case 9:
                if (papan[2][2] != '.')
                    return false;
                break;
        }
        return true;
    }

    static void tampilkanPapan(char[][] papan) {
        // Algoritma menggambar papan ke terminal.
        System.out.println("\n╔═══╦═══╦═══╗");
        int cnt = 1;
        for (int i = 0; i < papan.length; i++) {
            System.out.print("║ ");
            for (int j = 0; j < papan[i].length; j++) {
                char isi = papan[i][j];
                String tampil;
                if (isi == '.') {
                    tampil = String.valueOf(cnt);
                } else if (isi == 'X') {
                    tampil = "X";
                } else {
                    tampil = "O";
                }
                System.out.print(tampil + " ║ ");
                cnt++;
            }
            System.out.println();
            if (i < 2)
                System.out.println("╠═══╬═══╬═══╣");
        }
        System.out.println("╚═══╩═══╩═══╝\n");
    }

    static void masukanPetak(char[][] papan, int nomor, char simbol) {
        // Memasukan simbol ke petak.
        switch (nomor) {
            case 1:
                papan[0][0] = simbol;
                break;
            case 2:
                papan[0][1] = simbol;
                break;
            case 3:
                papan[0][2] = simbol;
                break;
            case 4:
                papan[1][0] = simbol;
                break;
            case 5:
                papan[1][1] = simbol;
                break;
            case 6:
                papan[1][2] = simbol;
                break;
            case 7:
                papan[2][0] = simbol;
                break;
            case 8:
                papan[2][1] = simbol;
                break;
            case 9:
                papan[2][2] = simbol;
                break;
        }
    }

}