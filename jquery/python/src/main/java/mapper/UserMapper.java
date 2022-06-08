package mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.gender;
import pojo.User;
import java.util.List;
import java.util.Map;
public interface UserMapper {
    List<User> queryAll();
    @Select("select * from users where id = ${id}")
    User selectUserById(int id);
    //根据用户名查询，同时按照id升序
    @Select("select * from users where userName = #{username} order by id asc")
    List<User> selectUserByUsername(String username);
    //查询2000年后生日的用户
    @Select("select * from users where birthday >= '2000-01-01'")
    List<User> selectUserByBirth();
    //查询所有年龄在 20-30 岁之间的用户信息
    @Select("select * from users where birthday between '1992-03-16' and '2002-03-16'")
    List<User> selectUserAges();
    @Select("select count(case when gender = '1' then gender end) as man," +
            "count(case when gender = '2' then gender end) as woman " +
            "from users")
    List<gender> selectUserByGender();
    @Select("SELECT * FROM users LIMIT 10;")
    List<User> selectUserNum10();
    int queryByFirstName(String username);
    // User queryByFirstName(String userName);
    List<User> que(String name);
    //传入的参数的类型保持一致，第一个泛型的类型为键的类型，第二个为值的类型
    List<User> queryByUnameAndGen(Map<String, Object> umap);
    //如果传入的参数不止一个，程序无法找到相对应的参数，也就无法传值，会报错 @Param ’参数名‘ not found
    //可通过@Param注解的方式解决，其中括号里的内容即为参数名称
    List<User> queryByUnameAndGen1(@Param("userName") String userName, @Param("gender") String gender);
    //通过Java Bean 的方式传入参数，参数类型为具体的 Java Bean 类型
    List<User> queryByUnameAndGen2(User user);
    //通过混合的方式完成参数的传递，需要使用 @Param 注解标识相应的变量
    List<User> queryByUnameAndGen3(@Param("id") int id,@Param("user") User user);
    List<User> queryAll1();
    //插入一条USER 数据，返回值为int
    int insertUser(User user);
    //int insertUser1(User user);
    //int insertUser2(User user);
    //修改一条 user
    int updateUser(User user);
    //删除一条信息
    int deleteUserById(int id);
    String queryProcedure(User user);

    User queryUserAndAdd(int id);

    User queryUserAndAdd1(int id);

}

