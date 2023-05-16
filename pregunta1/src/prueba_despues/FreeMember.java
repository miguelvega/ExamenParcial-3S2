package prueba_despues;


public class FreeMember extends Member {
    public FreeMember(String name) {
        super(name);
    }
    @Override
    public void joinTournament() {
        System.out.println("Se une al torneo");
    }

}

