/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bogdanv
 */
public class ConnectionManager {

    private static volatile ConnectionManager s_instance = null;
    private static final Object mutex = new Object();
    private Connection _connection = null;
    private Logger _logger = null;

    private ConnectionManager() {
        _logger = Logger.getLogger(ConnectionManager.class.getName());
    }

    public static ConnectionManager getInstance() {
        ConnectionManager connectionManager = ConnectionManager.s_instance;
        if (connectionManager == null) {
            synchronized (mutex) {
                connectionManager = ConnectionManager.s_instance;
                if (connectionManager == null) {
                    ConnectionManager.s_instance = connectionManager = new ConnectionManager();
                }
            }
        }
        return connectionManager;
    }

    public void connect(){
        try {
            DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
            _connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/telemetrix?user=root&password=4l7NtZUBqs");
        } catch (SQLException e) {
            _logger.log(Level.SEVERE, e.getMessage());
        } catch (Exception any) {
            _logger.log(Level.SEVERE, "Unknown exception occured $1", any.getMessage());
        }
        finally{};
    }

    public void disconnect() {
        try {
            if (_connection == null) {
                return;
            }
            _connection.close();
        } catch (SQLException e) {
            _logger.log(Level.SEVERE, e.getMessage());
        } catch (Exception any) {
            _logger.log(Level.SEVERE, "Unknown exception occured $1", any.getMessage());
        }
         finally{};
    }
}
