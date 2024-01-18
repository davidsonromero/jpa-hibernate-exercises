package test.basic.oneToOne;

import infra.DAO;
import infra.DBEntity;
import model.basic.oneToOne.*;
public class NewClientSeat2 {
    public static void main(String[] args) {
        Client client = new Client();
        client.setName("Cássio Ramos");
        Seat seat = new Seat();
        seat.setNumber("1B");
        client.setSeat(seat);
        System.out.println("Client: " + client.getName());
        System.out.println("Seat: " + seat.getNumber());

        DAO<DBEntity> dao = new DAO<>();
        dao.openTransaction()
                .include(client)
                .closeTransaction()
                .closeEntityManager();
    }
}
