package itat.zttc.shop.typehandler;

import itat.zttc.shop.model.OrderStatus;
import itat.zttc.shop.model.ProductStatus;
import itat.zttc.shop.model.UserTypeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * since 2015/6/10.
 */
@MappedTypes(value = {OrderStatus.class,
        ProductStatus.class,
        UserTypeEnum.class})
public class EnumCodeTypeHandler extends BaseTypeHandler<Enum<?>> {

    private Method code;
    private Method codeOf;

    public EnumCodeTypeHandler(Class<Enum<?>> clz) {
        Method[] declaredMethods = clz.getDeclaredMethods();
        try {
            code = clz.getMethod("code");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            codeOf = clz.getMethod("codeOf", int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (!Modifier.isStatic(codeOf.getModifiers())) {
            throw new RuntimeException("codeOf is not static");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Enum<?> parameter,
                                    JdbcType jdbcType) throws SQLException {
        ps.setInt(i, code(parameter));
    }

    @Override
    public Enum<?> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return codeOf(rs.getInt(columnName));
    }

    @Override
    public Enum<?> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return codeOf(rs.getInt(columnIndex));
    }

    @Override
    public Enum<?> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return codeOf(cs.getInt(columnIndex));
    }

    private int code(Enum<?> oj) {
        try {
            return (Integer) code.invoke(oj);
        } catch (Exception e) {
            throw new RuntimeException("not found code " + oj);
        }
    }

    private Enum<?> codeOf(int cd) {
        try {
            return (Enum<?>) codeOf.invoke(null, cd);
        } catch (Exception e) {
            throw new RuntimeException("not found codeOf " + cd);
        }
    }
}
