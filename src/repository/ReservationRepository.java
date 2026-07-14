package repository;

import databaseConnection.DatabaseConfig;
import enums.EventStatus;
import enums.ReservationStatus;
import exceptions.EventException;
import exceptions.ReservationException;
import model.Event;
import model.Reservation;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository implements GenericRepository<Reservation>{
    @Override
    public void save(Reservation entity) {
        String save = "INSERT INTO reservation(customer_name , customer_phone , event_id , ticket_count , reservation_date , status)VALUES(?,?,?,?,?,?)" ;
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(save);
        ){

            ps.setString(1, entity.getCustomerName());
            ps.setString(2, entity.getCustomerPhone());
            ps.setObject(3, entity.getEventId());
            ps.setInt(4, entity.getTicketCount());
            ps.setDate(5, (Date) entity.getReservationDate());
            ps.setString(6, entity.getStatus().toString());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println(entity + " Has Been Saved Successfully");
            }
        }catch (SQLException e){
            throw new ReservationException("Did not save");
        }
    }

    @Override
    public void update(Reservation e) {
        String update = "UPDATE reservation SET customer_name=? , customer_phone=? , event_id=? , ticket_count=? , reservation_date=? , status=? WHERE id=?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(update)){
            ps.setString(1 , e.getCustomerName());
            ps.setString(2 , e.getCustomerPhone());
            ps.setLong(3, e.getEventId().longValue());
            ps.setInt(4 , e.getTicketCount());
            ps.setDate(5 , (Date) e.getReservationDate());
            ps.setString(6 , e.getStatus().toString());
            int rows2 = ps.executeUpdate();
            if (rows2 > 0 ){
                System.out.println("Reservation Has Been Successfully");
            }
        }catch (SQLException ex){
            throw new ReservationException("Reservation Did Not Update Successfully");
        }
    }

    @Override
    public void delete(Reservation e) {
        String delete = "DELETE FROM reservation WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(delete);
        ){int rows3 = ps.executeUpdate();
            if (rows3 > 0){
                System.out.println("Reservation By Id : [" + e.getId()  + "] Has Been Deleted Successfully");
            }
        } catch (SQLException exx) {
            throw new EventException("Reservation Did Not Deleted Successfully!!");
        }
    }

    @Override
    public Reservation findById(BigInteger id) {
        String findById = "SELECT * FROM events WHERE id = ?";
        try(Connection connection = DatabaseConfig.getConnection();
            PreparedStatement ps = connection.prepareStatement(findById)) {
            ps.setObject(1 , id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                System.out.println("Reservation By Id : [" +rs.getInt("id") + "Has Been Found : ");

                return new Reservation(
                        (BigInteger) rs.getObject("id"),
                        rs.getString("customer_name"),
                        rs.getString("customer_phone"),
                        (BigInteger)  rs.getObject("event_id"),
                        rs.getInt("ticket_count"),
                        rs.getDate("reservation_date"),
                        ReservationStatus.valueOf(rs.getString("status"))
                );
            }throw new EventException("reservation Not Found");

        }catch (SQLException e) {
            throw new EventException("reservation Did Not Found ....");
        }
    }

    @Override
    public List<Reservation> findAll() {
        String findAll = "SELECT * FROM reservation ";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(findAll);
        ){
            List<Reservation> reservations = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                reservations.add (
                        new Reservation(
                                (BigInteger) rs.getObject("id"),
                                rs.getString("customer_name"),
                                rs.getString("customer_phone"),
                                (BigInteger)  rs.getObject("event_id"),
                                rs.getInt("ticket_count"),
                                rs.getDate("reservation_date"),
                                ReservationStatus.valueOf(rs.getString("status"))
                        )
                );
            }
            return reservations ;
        }catch (SQLException e){
            throw new EventException("there is no event to show");
        }
    }



}
