package repository;

import databaseConnection.DatabaseConfig;
import enums.EventStatus;
import exceptions.EventException;
import model.Event;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EventRepository implements GenericRepository<Event> {


    @Override
    public void save(Event entity) {
        String add = "INSERT INTO events (title , location , capacity , reserved_count , ticket_price , status) VALUES (?,?,?,?,?,?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(add)) {
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getLocation());
            ps.setInt(3, entity.getCapacity());
            ps.setInt(4, entity.getReservedCount());
            ps.setDouble(5, entity.getPrice());
            ps.setString(6, entity.getStatus().toString());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println(entity + " Has Been Saved Successfully");
            }
        } catch (SQLException e) {
            throw new EventException("Event Did Not Saved Successfully");
        }
    }

    @Override
    public void update(Event e) {
        String update = "UPDATE events SET title=? , location=? , capacity=? , reserved_count=? , ticket_price=? , status=? WHERE id=?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(update)){
        ps.setString(1 , e.getTitle());
        ps.setString(2 , e.getLocation());
        ps.setInt(3 , e.getCapacity());
        ps.setInt(4 , e.getReservedCount());
        ps.setDouble(5 , e.getPrice());
        ps.setString(6 , e.getStatus().toString());
        int rows2 = ps.executeUpdate();
        if (rows2 > 0 ){
            System.out.println("Event Has Been Successfully");
        }
        }catch (SQLException ex){
            throw new EventException("Event Did Not Update Successfully");
        }
    }

    @Override
    public void delete(Event e) {
        String delete = "DELETE FROM events WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement ps = connection.prepareStatement(delete);
        ){int rows3 = ps.executeUpdate();
            if (rows3 > 0){
                System.out.println("Event By Id : [" + e.getId()  + "] Has Been Deleted Successfully");
            }
        } catch (SQLException exx) {
            throw new EventException("Event Did Not Deleted Successfully!!");
        }
    }

    @Override
    public Event findById(BigInteger id) {
        String findById = "SELECT * FROM events WHERE id = ?";
        try(Connection connection = DatabaseConfig.getConnection();
            PreparedStatement ps = connection.prepareStatement(findById)) {
            ps.setObject(1 , id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                System.out.println("Event By Id : [" +rs.getObject("id") + "Has Been Found : ");

                return new Event(
                        (BigInteger) rs.getObject("id"),
                        rs.getString("title"),
                        rs.getString("location"),
                        rs.getInt("capacity"),
                        rs.getInt("reserved_count"),
                        rs.getDouble("ticket_price"),
                        EventStatus.valueOf(rs.getString("status"))
                );
            }throw new EventException("Event Not Found");

        }catch (SQLException e) {
            throw new EventException("Event Did Not Found ....");
        }
    }

    @Override
    public List<Event> findAll() {
        String findAll = "SELECT * FROM events ";
        try (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement ps = connection.prepareStatement(findAll);
        ){
            List<Event> events = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                events.add(
                        new Event(
                                (BigInteger) rs.getObject("id"),
                                rs.getString("title"),
                                rs.getString("location"),
                                rs.getInt("capacity"),
                                rs.getInt("reserved_count"),
                                rs.getDouble("ticket_price"),
                                EventStatus.valueOf(rs.getString("status"))
                        )
                );
            }
            return events ;
        }catch (SQLException e){
            throw new EventException("there is no event to show");
        }
    }
}
