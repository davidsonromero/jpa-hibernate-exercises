package test.basic.manyToMany;

import infra.DAO;
import model.basic.manyToMany.Nephew;
import model.basic.manyToMany.Uncle;

import java.util.List;

//Using named query
public class GetUncleNephewQuery {
    public static void main(String[] args) {
        DAO<Uncle> uncleDAO = new DAO<>(Uncle.class);
        List<Uncle> uncles = uncleDAO.query("ListUncles", "name", "Bill Gates");
        for(Uncle uncle : uncles){
            System.out.println(uncle.getName());
            for(Nephew nephew : uncle.getNephews()){
                System.out.println("\t" + nephew.getName());
            }
            System.out.println("\n----------------------------------\n");
        }
    }
}
