package ru.netology.bank.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    public static QueryRunner runner = new QueryRunner();
    private SQLHelper(){
    }

    @SneakyThrows
    private static Connection getConnect(){
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    public static DataHelper.VerificationCode getCode(){
        var codSQL = "SELECT code FROM auth_codes ORDER BY created DESC limit 1";
        try (var conn = getConnect()){
            var result = runner.query(conn, codSQL, new ScalarHandler<String>());
            return new DataHelper.VerificationCode(result);
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return null;
    }
}
