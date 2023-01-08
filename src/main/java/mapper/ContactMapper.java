package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pojo.Contact;
import java.util.List;

public interface ContactMapper {
    @Select("select * from records")
    List<Contact> selectAll() ;

    @Insert("insert into records values(null, #{firstName},#{lastName},#{email},#{phone})")
    void add(Contact contact);

    @Update("update records set firstName = #{firstName},lastName = #{lastName},email = #{email},phone = #{phone} where id = #{id}")
    void update(Contact contact);

    void deleteByIds(@Param("ids") int[] ids);

    List<Contact> selectByCondition(Contact contact);

    void delete(int id);



}
