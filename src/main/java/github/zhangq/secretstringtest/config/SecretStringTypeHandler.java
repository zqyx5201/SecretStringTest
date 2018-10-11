package github.zhangq.secretstringtest.config;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

/**
 * @author zhangqiuyang
 * Created on 2018/8/17.
 */

@MappedTypes(value = {SecretString.class})
public class SecretStringTypeHandler implements TypeHandler<SecretString> {

    /**
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public SecretString getResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        if (value != null) {
            return new SecretString(value);
        }
        return null;
    }

    /**
     * @param rs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public SecretString getResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        if (value != null) {
            return new SecretString(value);
        }
        return null;
    }

    /**
     * @param cs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public SecretString getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        if (value != null) {
            return new SecretString(value);
        }
        return null;
    }

    /**
     * @param ps
     * @param i
     * @param parameter
     * @param arg3
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, SecretString parameter, JdbcType arg3) throws SQLException {
        String value = "";
        if (parameter != null) {
            value = parameter.toString();
        }
        ps.setString(i, value);
    }
}