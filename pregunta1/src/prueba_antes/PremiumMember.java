package prueba_antes;


public class PremiumMember extends Member {
    public PremiumMember(String nombre) {
        super(nombre);
    }

    @Override
    public void joinTournament(){
        System.out.println("Se une al toreno");

    }
    @Override
    public void organizeTournament(){
        System.out.println("Organiza torneo");
    }
}
