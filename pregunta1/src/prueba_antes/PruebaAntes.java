package prueba_antes;


import java.util.List;

public class PruebaAntes {
    public static void main(String[] args) {
        List<Member> miembros = List.of(
                new PremiumMember("Abejita Azul"),
                new VipMember("Kaperucita Feliz"),
                new FreeMember("Inspectora Motita")
        );
        for (Member member: miembros) {
            member.organizeTournament();
        }


    }
}
