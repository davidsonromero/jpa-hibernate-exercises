package test.basic.oneToOne;

import infra.DAO;
import infra.DBEntity;
import model.basic.oneToOne.*;
public class NewClientSeat {
    public static void main(String[] args) {
        Client client = new Client();
        client.setName("Ronaldo Nazário de Lima");
        Seat seat = new Seat();
        seat.setNumber("4A");
        client.setSeat(seat);
        System.out.println("Client: " + client.getName());
        System.out.println("Seat: " + seat.getNumber());

        DAO<DBEntity> dao = new DAO<>();
        dao.openTransaction()
            .include(client)
            .include(seat)
            .closeTransaction()
            .closeEntityManager();
    }
}
