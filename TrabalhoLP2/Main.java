package TrabalhoLP2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
       List<Usuario> usuarioList = new ArrayList<>();

       Usuario usuarioX = new Usuario("Manoel ");
       usuarioList.add(usuarioX);

    SistemaComunidade sistemaTeste = new SistemaComunidade();

    sistemaTeste.menuComunidades();
    Scanner escolha = new Scanner(System.in);
    int escolha1 = escolha.nextInt();
    sistemaTeste.gerenciarComunidade(escolha1, usuarioX);
    }
}
