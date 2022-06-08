package pojo;

import mapper.AddressMapper;
import mapper.BillMapper;
import mapper.ProviderMapper;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MyBatisTest {
    public static <UserMappper> void main(String[] args){
        SqlSession sqlSession = null;
        try {
            //Mybatis的配置文件路径
            String configFilePath = "mybatis-config.xml";
            //创建IO流，后续以IO流的形式去读写
            Reader reader = Resources.getResourceAsReader(configFilePath);
            //构建sqlSessionFactoryBuilder类对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //通过build方法构建SqlSessionFactory
            //通过SqlSessionFactory的oienSession 方法构建SqlSession
            //SqlSession 的作用：1.获取Mapper接口 2.直接发送SQL语句执行 3.控制数据库事务
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
            sqlSession = sqlSessionFactory.openSession(true);
            //获取SQL Mapper(映射器)
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.queryAll();
            System.out.println(userList);
            System.out.println("======================");
            User user = userMapper.selectUserById(1);
            System.out.println("查询到的用户为："+ user);
            System.out.print("\n===========\n");
            //测试SqlSession 直接发送SQL的方式     这样的方式会导致错误不被提早暴露，不利于开发效率
            //创建一个变量，其值为要执行的SQL 语句的namespace+sql id（具体的方法名）代码规范
            String statement="mapper.UserMapper"+".selectUserById";
            //通过调用SqlSession 自带的方法实现直接与数据库交互，如selectOne 方法。但是使用时需要明白其使用场景，否则会报错提高学习成本
            //该方法的两参分别代表 SQL语句的数参值；该方法只适用于返回结果只有1条的场景
            //user = sqlSession.selectOne(statement,1);
            //System.out.print(user);
            List<User> list1 =  userMapper.selectUserByUsername("zhang");
            System.out.println(list1);
            System.out.println("=============================================");
            List<User> list2 =  userMapper.selectUserByBirth();
            System.out.println(list2);
            System.out.println("=============================================");
            List<User> list3 = userMapper.selectUserAges();
            System.out.println(list3);
            System.out.println("=============================================");
            List<gender> list4 = userMapper.selectUserByGender();
            System.out.println(list4);
            System.out.println("=============================================");
            List<User> list5 =  userMapper.selectUserNum10();
            System.out.println(list5);
            System.out.println("=============================================");
            String userFirstName = "zhangsan";
            int num = userMapper.queryByFirstName(userFirstName);
            System.out.println("姓" +userFirstName+"的用户个数为" + num);
            System.out.println("=============================================");
            System.out.println("================================================");
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("userName","lisi");
            map.put("gender",'2');
            userList = userMapper.queryByUnameAndGen(map);
            System.out.println(userList);
            System.out.println("================================================");
            String userName = "lisi";
            String gender = "1";
            userList = userMapper.queryByUnameAndGen1(userName,gender);
            System.out.println(userList);
            System.out.println("================================================");
            user = new User();
            userName = "lisi";
            //int gender1 = 1;
            user.setUserName(userName);
            user.setGender(Integer.parseInt(gender));
            userList = userMapper.queryByUnameAndGen2(user);
            System.out.println(userList);
            System.out.println("================================================");
            user = new User();
            userName = "lisi";
            //int gender1 = 1;
            user.setUserName(userName);
            int id = 2;
            user.setGender(Integer.parseInt(gender));
            userList = userMapper.queryByUnameAndGen3(id,user);
            System.out.println(userList);
            System.out.println("================================================");
            userList = userMapper.queryAll1();
            System.out.println(userList);
            System.out.println("==================================");
            user = new User();
            user.setSmb_id(2);
            user.setUserCode("2");
            user.setUserName("liusi");
            user.setUserpassword("123456");
            int result =userMapper.insertUser(user);
            //注意：如果是更新数据表的操作，则需要手动提交开启自动提交，如下方方式为手动提交
            //sqlSession.commit();
            System.out.println(result);
            System.out.println("==================================");
            user = new User();
            user.setId(4);
            user.setUserName("lisi");
            user.setUserpassword("123456");
            result =userMapper.updateUser(user);
            System.out.println(result);
            System.out.println("==================================");
            result =userMapper.deleteUserById(19);
            System.out.println(result);
            System.out.println("==================================");
            user = new User();
            user.setId(1);
            userMapper.queryProcedure(user);
            System.out.println(user.getUserName());
            System.out.println("==================================");
            AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
            List<Address> addressList = addressMapper.queryAll();
            for(Address address : addressList){
                System.out.println(address);
            }
            System.out.println("==================================");
            user = userMapper.queryUserAndAdd(1);
            System.out.println(user);

            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            Address address = addressMapper.queryAddressAndUser(2);
            System.out.println(address);
            //一级缓存需要保证在同一个sqlsession下

            address = addressMapper.queryAddressAndUser(1);
            System.out.println(address);
            userList = userMapper.queryAll1();
            System.out.println(userList);
            sqlSession.commit();
            System.out.println("==================================");
            //不在同一个sqlsession下但是调用方法和传入参数一致 但因为跨sqlsession所以一级缓存会失效会重新像数据库发送SQL
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            addressMapper = sqlSession1.getMapper(AddressMapper.class);
            address = addressMapper.queryAddressAndUser(1);
            System.out.println(address);
            UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
            userList = userMapper1.queryAll1();
            System.out.println(userList);


            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            ProviderMapper providerMapper = sqlSession.getMapper(ProviderMapper.class);
            List<Provider> providerList = providerMapper.queryAll();

            for (Provider provider : providerList){
                System.out.println(providerList);
            }
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            Provider provider = providerMapper.queryProAndBill(1);
            System.out.println(provider);
//          provider = providerMapper.queryProAndBill(1);
//          System.out.println(provider);
            sqlSession.commit();

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            BillMapper billMapper = sqlSession.getMapper(BillMapper.class);
            List<Bill> billList = billMapper.queryAll();
            for (Bill bill : billList){
                System.out.println(bill);

            }
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            Bill bill = billMapper.queryBillAndPro(2);
            System.out.println(bill);

            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            // 二级缓存是在 sqlSessionFactory 层面的，过程是涉及序列化和反序列化
            //不在同一个 sqlSession 中，但是调用的方法和存入的参数一致
            sqlSession1 = sqlSessionFactory.openSession(true);
            billMapper = sqlSession1.getMapper(BillMapper.class);

            //尽管调用的方法和传入的参数一致，但因为跨了 sqlSession ，所以以及缓存失败，会从新想数据库发送 sql
            bill = billMapper.queryBillAndPro(1);
            System.out.println(address);
            ProviderMapper providerMapper1 = sqlSession1.getMapper(ProviderMapper.class);

            //下面这条语句会击中二级缓存。当二级缓存开启后，会出现
            providerList = providerMapper.queryAll();
            System.out.println(providerList);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //要将需要关闭资源放在 finally 中，确保一定被关闭
            if(sqlSession !=null){
                sqlSession.close();
            }

        }



    }

}


