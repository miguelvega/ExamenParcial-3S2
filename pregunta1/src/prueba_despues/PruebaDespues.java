package prueba_despues;


import java.util.List;

public class PruebaDespues {
    public static void main(String[] args) {

        List<Member> miembros = List.of(
                new PremiumMember("Abejita Azul"),
                new VipMember("Kaperucita Feliz"),
                new FreeMember("Inspectora Motita")
        );
        for (Member member: miembros) {
            member.joinTournament();
        }

    }
}