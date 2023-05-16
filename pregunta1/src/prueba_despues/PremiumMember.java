package prueba_despues;

public class PremiumMember extends Member implements  TournamentOrganizer{
    public PremiumMember(String nombre) {
        super(nombre);
    }

    @Override
    public void joinTournament(){
        System.out.println("Se une al torneo");

    }
    @Override
    public void organizeTournament(){
        System.out.println("Organiza torneo");
    }
}
