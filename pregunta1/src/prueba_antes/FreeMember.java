package prueba_antes;


public class FreeMember extends Member {
    public FreeMember(String name) {
        super(name);
    }
    @Override
    public void joinTournament() {
        System.out.println("Se une al torneo");
    }
    //Este método rompe LSP
    @Override
    public void organizeTournament() {
        System.out.println("Un FreeMember no puede organizar torneos, rompe el LSP.");
    }
}
